package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{	
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
	}

	/*
	public void draw() {
		background(0, 0, 255);
		stroke(255, 0, 0);
		fill(255, 255, 0);
		line(10, 10, 100, 100);		// x1, y1, x2, y2
		point(50, 50); // x, y
		ellipse(100, 200, 50, 150); // cx, cy, w, h
		fill(0, 255, 0);
		rect(50, 10, 100, 200); // tlx, tly, w, h
		triangle(10, 10, 100, 90, 200, 200); // vertices	
	}	
	*/

	int x = 0; // 4 bytes
	
	public void draw()
	{	
		
		// background(0);
		// noStroke();
		// fill(255);
		// ellipse(x, mouseY, 50, 50);		
		// x ++;

		// Monday class

		// background(0);
		// background(255);
		// background(0, 255, 0); // rgb values

		// stroke(0, 0, 255);
		// fill(0, 255, 255);

		// // line(x1, y1, x2, x2)
		// line(10, 10, 100, 100);

		// // point(x, y);
		// point(50, 50);

		// noStroke();
		// // ellipse(cx, cy, w, h);
		// ellipse(100, 200, 100, 50);

		// fill(255, 0, 0);
		// // rect(tlx, tly, w, h)
		// rect(70, 150, 90, 10);

		// // triangle(x1, y1, x2, y2, x3, y3);
		// triangle(150, 90, 200, 100, 100, 250);

		noStroke();
		background(255, 0, 0);

		fill(255, 255, 0);
		ellipse(250, 300, 400, 400);

		fill(0, 255, 255);
		triangle(450, 450, 250, 50, 60, 450);

		fill(200, 200, 200);
		ellipse(250, 250, 170, 100);

		//mouse x
		//mouse y
		//colorMode(MSB)
	}
}
