package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		
	}

	public void loops1()
	{
		stroke(255);
		int numLines = (int) (30 * (mouseX / (float) width)) ;
		float gap = width / (float) numLines;
		for(int i = 0 ; i <= numLines ; i ++)
		{
			float x = i * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height -x);
		}
	}

	float offset = 0;

	public void loops2()
	{
		int numCircles  = (int) (20 * (mouseX / (float) width)) ;
		// make a variable for hardcoded (magic) numbers
		// mouseX and width is an integer
		// 2.0f is a floating point constant
		// compile error: can't convert a float to an integer

		float w = width / (float) numCircles;
		float radius = w / 2.0f;
		colorMode(HSB);
		// Hue Saturation Brightness
		
		float cGap = 255 / (float) (numCircles * numCircles);
		// 255 / numCircles * numCircles is the colorspace

		noStroke();

		for(int j = 0 ; j < numCircles ; j ++)
		{		
			for(int i = 0 ; i < numCircles ; i ++)
			{
				float x = radius + (i * w);
				float y = radius + (j * w);
				float c = (cGap * i * j + offset) % 255;
				// range of mod = 0 - 254

				fill(c, 255, 255);
				ellipse(x, y, w, w);
			}
		}
		offset += mouseY / 250.0f;
		// magic number - 250.0f;
	}

	public void loops3()
	{
		float gap = width * 0.1f;
		float halfGap = gap / 2.0f;
		colorMode(RGB);
		stroke(0, 255, 0);
		textAlign(CENTER, CENTER);
		for(int i = -5 ; i <=5 ; i ++)
		{
			float x = map(i, -5, 5, gap, width -gap);				
			line(x, gap, x, height - gap);
			line(gap, x, width - gap, x);
			fill(255);
			text(i, x, halfGap);
			text(i, halfGap, x);
			
		}
	}

	
	public void keyPressed()
	{
		if (key == ' ')
		{
			
		}
	}	


	public void draw()
	{	
		background(0);		
		colorMode(HSB);
		//loops1();

		loops2();

		//loops3();
	}
}
