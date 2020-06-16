package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
    // Arraylist can grow and shrink
    // Generic < >
    // Declare a global ArrayList of Star objects
    ArrayList<Star> stars = new ArrayList<Star>(); 

    int selected1 = -1;
    int selected2 = -1;

    // Start with a blank sketch, Set the drawing window size to be 800 x 800
    public void settings()
    {
        size(800, 800);
    }


    public void setup()
    {
        loadData();
        //printStars();
    }


    public void draw()
    {
        background(0);
        drawGrid();
        drawStars();

        float border = width * 0.05f;

        if(selected1 != -1 && selected2 == -1)
        {
            Star star1 = stars.get(selected1);

            float x = map(star1.getxG(), -5, 5, border, width - border);
            float y = map(star1.getyG(), -5, 5, border, height - border);

            stroke(255, 255, 0);
            line(x, y, mouseX, mouseY);
        }
        else if(selected1 != -1 && selected2 != -1)
        {
            Star star1 = stars.get(selected1);
            Star star2 = stars.get(selected2);

            float x1 = map(star1.getxG(), -5, 5, border, width - border);
            float y1 = map(star1.getyG(), -5, 5, border, height - border);
            float x2  = map(star2.getxG(), -5, 5, border, width - border);
            float y2 = map(star2.getyG(), -5, 5, border, height - border);

            stroke(255, 255, 0);
            line(x1, y1, x2, y2);

            float distance = dist(star1.getxG(), star1.getyG(), star1.getzG(),
                              star2.getxG(), star2.getyG(), star2.getzG());

            fill(255);
            text("Distance from " + star1.getDisplayName() +
            " to " + star2.getDisplayName() + " is " + distance +
            " parsecs ", border, height - 25);
        }
    }


    //Write a method called loadData that loads the data 
    // from the file and populates the ArrayList.
    //Call this from setup
    public void loadData()
    {
        Table t = loadTable("HabHYG15ly.csv", "header");

        for(TableRow tr : t.rows())
        {
            Star s = new Star(tr);
            
            stars.add(s);
        }
    }


    //Write a method called printStars that prints the contents
    // of the ArrayList after it has been loaded.
    //You should make a toString method on the Star class to help you do this. 
    //Call this from setup after you load the data to make sure it
    // gets loaded correctly 
    public void printStars()
    {
        for(Star s:stars)
        {
            println(s);
        }
    }


    // Write code to plot the stars onto the grid.
    //For each star you should:
    // Use the star's Xg and Yg values.
    // Ignore the Zg value when drawing the Star 
    public void drawStars()
    {
        for(Star s: stars)
        {
            s.render(this);
        }
    }


    //Write code to draw the purple gridlines with labels.
    //You should leave a 50 pixel border around the outside of the 
    // drawing window.
    //These gridlines go from -5 parsecs to 5 parsecs on the x and y axis.
    public void drawGrid()
    {
        float border = width * 0.05f;

        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = -5 ; i <= 5 ; i ++)
        {
            // map(value, start1, stop1, start2, stop2)
            float x = map(i, -5, 5, border, width - border);

            // line(x1, y1, x2, y2)
            line(x, border, x, height - border);
            line(border, x, width - border, x);    
            
            fill(255);
            // text(c, x, y)
            text(i, x, border / 2);
            text(i, border / 2, x);
        }
    }


    //Write code so that you can: 
    //Click inside a single star and draw a yellow line to the mouse.
    //You can add a mousePressed method to your sketch 
    //This method will get called when the mouse is pressed
    //Use mouseX and mouseY to determine the mouse coordinates 
    //You should print the text: Distance from STAR1 to STAR2 is XX parsecs 
    //At the bottom if the screen, Replace STAR1 with the
    // first clicked star name and STAR2 with the 
    // second clicked star name. You should calculate the
    // distance the two stars using the dist method in processing. 
    //Use the star's Xg, Yg, Zg values to calculate the distance 
    public void mousePressed()
    {
        float border = width * 0.05f;

        for (int i = 0; i < stars.size(); i++) //why is everything in a for loop?
        {
            Star star = stars.get(i);

            float x = map(star.getxG(), -5, 5, border, width - border);
            float y = map(star.getyG(), -5, 5, border, height - border);

            if(dist(mouseX, mouseY, x, y) < star.getAbsMag() / 2 ) //what is this calculating?
            {
                if(selected1 == -1)
                {
                    selected1 = i;
                }
                else if(selected2 == -1)
                {
                    selected2 = i;
                }
                else
                {
                    selected1 = i;
                    selected2 = -1;
                }
            }
        }
    }
}
