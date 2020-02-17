package ie.tudublin;

import processing.core.PApplet;
import java.util.Arrays;

public class Array extends PApplet
{
	// syntax for arrays
	// allocate array
	//float[] rainfall = new float[12];

	// to hardcode constant values in array
	float[] rainFall = {45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58};
	// rainFall numbers are integers
	// 58.0 is a double constant
	// double has 8 bytes, float has 4 bytes
	// lose precision when double is put into a float
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

	

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		for(int i = 0; i < rainFall.length; i++)
		{
			// pApplet - only println();
			println(months[i] + "\t" + rainFall[i]);
		}

		// iterates and prints all the elements of the array
		// no index however
		for(float f : rainFall)
		{
			println(f);
		}

		for(String s : months)
		{
			println(s);
		}

		//minRainfall();
		//maxRainfall();
		//minMax();
		//drawBarChart();
		drawBarChart2();
	}

	

	float offset = 0;

	
	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		//background(0);		
		colorMode(HSB);	
	}

	public void minRainfall()
	{
		float min = rainFall[0];

		for(int i = 0; i <= rainFall.length - 2; i++)
		{
			int j = i + 1;

			if(min > rainFall[j])
			{
				min = rainFall[j];
			}
		}

		println("Minimum rainfall is : " + min);
	}

	public void maxRainfall()
	{
		float max = rainFall[0];

		for(int i = 0; i <= rainFall.length - 2; i++)
		{
			int j = i + 1;

			if(max < rainFall[j])
			{
				max = rainFall[j];
			}
		}

		println("Maximum rainfall is : " + max);
	}

	//using indexes
	public void minMax()
	{
		int minIndex = 0;

		for(int i = 1; i < rainFall.length; i++)
		{
			if(rainFall[i] < rainFall[minIndex])
			{
				minIndex = i;
			}
		}

		println(months[minIndex] + "had the minimum rainfall of " + rainFall[minIndex] );

		int maxIndex = 0;

		for(int i = 1; i < rainFall.length; i++)
		{
			if(rainFall[i] > rainFall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println(months[maxIndex] + "had the maximum rainfall of " + rainFall[maxIndex] );
	}

	void drawBarChart()
	{
		colorMode(HSB);

		stroke(0);
		line(100, 100, 100, 400);
		line(100, 400, 400, 400);

		float height = -rainFall[0];
		int width = 20;
		int x = 100;
		int y = 400;
		int colour = 21;

		for(int i = 0; i < rainFall.length -1; i++)
		{
			noStroke();
			fill(colour, 255, 255);
			rect(x, y, width, height);

			x += 20;
			height = 0;
			height -= rainFall[i+1];
			colour += 21;
		}
	}

	void drawBarChart2()
	{
		float w = width / (float)rainFall.length;
		float cGap = 255 / (float)rainFall.length;

		noStroke();
		colorMode(HSB);

		for(int i = 0; i < rainFall.length; i++)
		{
			float x = i * w;
			fill(i * cGap, 255, 255);
			rect(x, height, w, 2.5f * -rainFall[i]);
		}
	}
}
