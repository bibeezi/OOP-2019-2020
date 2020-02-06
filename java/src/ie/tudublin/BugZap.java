package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{
    float playerX = 10;
    float playerY = 10;
    float playerWidth = 3;

    public void settings()
	{
        size(500, 500);
    }

	public void setup() {
        //playerX = width;
        // playerY = height;
    }
    
    public void draw() {
        drawPlayer(playerX, playerY, playerWidth);
    }

    public void drawPlayer(float x, float y, float w)
    {
        //float h = w * 0.5f;

        fill(255);
        rect(x, y + (height - 50), x + 2, y + (height - 50));
    }

    public void keyPressed()
    {
        if(keyCode == LEFT)
        {
            System.out.println("Left arrow pressed");
             
        }
        if(keyCode == RIGHT)
        {
            System.out.println("Right arrow pressed");
            drawPlayer(playerX + 10, playerY, playerWidth); 
        }
        if(key == ' ')
        {
            System.out.println("SPACE key is pressed");
        }
    }
}