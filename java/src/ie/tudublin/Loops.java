package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{	
	public int x, y;

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

		//lines();

		//circles();

		//rainbow();

		//rainbowCircles();

		//grid();

		//pyramid();

		//rainbowCircles2();

		checkers();
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

	// public void rainbowCircles2()
	// {
	// 	int colour = 0;
		
		// for(x = 0; x < 500; x += 50)
		// {
		// 	for(y = 0; y < 500; y += 50)
		// 	{
		// 		fill(colour, 255, 255);
		// 		ellipse(25 + x, 25 + y, 50, 50);
		// 		colour += 25;
		// 	}
		// 	colour -= 242;	
		// }
	// }

	public void checkers()
	{
		for(x = 0; x < 500; x += 25)
		{
			for(y = 0; y < 500; y += 25)
			{
				if(y % 10 == 5)
				{
					fill(10, 255, 255);
					rect(x, y, 25, 25);
				}
				else
				{
					fill(15, 255, 255);
					rect(x, y, 25, 25);
				}
			}
		}
	}
}
