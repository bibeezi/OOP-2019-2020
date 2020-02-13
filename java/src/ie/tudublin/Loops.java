package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public int x, y;
	float offset = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		colorMode(HSB);
	}

	
	public void keyPressed()
	{

	}	


	public void draw()
	{	
		//background(200,200,200);	
		background(0);

		//lines();
		//linesSol();

		//circles();

		//rainbow();

		//rainbowCircles();
		//rainbowCirclesSol();

		//grid();

		//pyramid();

		//rainbowCircles2();
		//rainbowCircles2Sol(); //NOT FINISHED

		checkers();

		//gridSol();
	}

	public void lines()
	{
		strokeWeight(2);

		for(x = 0; x <= 500; x += 20)
		{
			stroke(0,0,0);
			line(250,250, x, 0);
			line(250,250, x, 500);
		}
		for(y = 0; y <= 500; y += 20)
		{
			stroke(0,0,0);
			line(250,250, 500, y);
			line (250, 250, 0, y);
		}
	}

	//week 3 tutorial 13/02/2020
	public void linesSol()
	{
		stroke(255);

		//int numLines = 100
		// Using the mouse's x axis to determine
		// the number of lines
		int numLines = (int)((mouseX / (float)width) * 30);
		
		// value of gap is 3 because numLines is an integer
		// casting is needed
		float gap = width / (float)numLines;
	
		for(int i = 0; i <= numLines; i++)
		{
			float x = i * gap;
			line(x, 0, width - x, height);
			line(0, x, width, height - x);
		}
	}

	public void circles()
	{
		for(x = 0; x < 1000 ; x += 50)
		{
			ellipse(0 + x, 250, 50, 50);
		}
	}

	public void rainbow()
	{
		noStroke();
		for(x = 0; x < 330; x += 20)
		{
			fill(x, 255, 255);
			rect(y, 0, 50, 500);
			y = y + 50;
		}
	}

	public void rainbowCircles()
	{
		noStroke();
		y = 25;
		for(x = 0; x < 330; x += 20)
		{
			fill(x, 255, 255);
			ellipse(y, 250, 50, 50);
			y = y + 50;
		}
	}

	//week 3 tutorial 13/02/2020
	public void rainbowCirclesSol()
	{
		int numCircles = (int) (20 * (mouseX / (float)width));
		float w = width / (float)numCircles;
		// 2.0 is a double 
		// 2.0f is a floating point 
		float radius = w / 2.0f;

		colorMode(HSB);

		float cGap = 255 / (float)numCircles;

		noStroke();

		for(int i = 0; i < numCircles; i++)
		{
			float x = radius + (i * w);
			fill(cGap * i, 255, 255);
			ellipse(x, height / 2, w, w);
		}
	}

	public void grid()
	{
		background(0);
		stroke(57, 255, 20);
		for(x = 50 ; x <= 450; x += 50)
		{
			line(x, 50, x, 450);
			line(50, x, 450, x);
		}
	}

	//week 3 tutorial 13/02/2020
	public void gridSol()
	{
		float gap = width * 0.1f;

		colorMode(RGB);
		stroke(0, 255, 0);
		textAlign(CENTER, CENTER);
		
		for(int i = -5; i <= 5; i++)
		{
			float x = map(i, -5, 5, gap, width - gap);
			float halfGap = gap / 2.0f;
			line(x, gap, x, height - gap);
			line(gap, x, width - gap, x);
			fill(255); // white
			text(i, x, halfGap);
			text(i, halfGap, x);
		}
	}

	public void pyramid()
	{
		int width = 100;
		int counter;
		int x = 100;
		int y = 100;

		for(counter = 0; counter < 5; counter++)
		{
			//tlx tly w h
			rect(x, y, width, 20);
			width -= 20;
			x += 10;
			y += 20;
		}
	}

	public void rainbowCircles2()
	{
		int colour = 0;
		int shift = 0;
		noStroke();
		
		for(x = 0; x < 500; x += 50)
		{
			for(y = 0; y < 500; y += 50)
			{
				fill(colour, 255, 255);
				ellipse(25 + x, 25 + y, 50, 50);
				colour = colour + 10;
			}
			colour = 0;
			colour = colour + shift;
			shift = shift + 10;
		}
	}

	//week 3 tutorial 13/02/2020
	public void rainbowCircles2Sol()
	{
		int numCircles = (int) (20 * (mouseX / (float)width));
		float w = width / (float)numCircles;
		// 2.0 is a double 
		// 2.0f is a floating point 
		float radius = w / 2.0f;

		colorMode(HSB);

		float cGap = 255 / (float)(numCircles * numCircles);

		noStroke();

		for(int j = 0; j < numCircles; j++)
		{
			for(int i = 0; i < numCircles; i++)
			{
				float x = radius + (i * w);
				fill(cGap * i, 255, 255);
				ellipse(x, height / 2, w, w);
			}
		}
	}

	public void checkers()
	{
		int counter = 2;

		for(x = 0; x < 500; x += 25)
		{
			for(y = 0; y < 500; y += 25)
			{
				if(counter % 2 == 0)
				{
					fill(10, 255, 255);
					rect(x, y, 25, 25);
				}
				else
				{
					fill(15, 255, 255);
					rect(x, y, 25, 25);
				}
				counter += 1;
			}
			counter += 1;
		}
	}
}
