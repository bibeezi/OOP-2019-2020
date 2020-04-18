package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{
    // Arraylist can grow and shrink
    // Generic
    ArrayList<Star> stars = new ArrayList<Star>(); 

    int selected1 = -1;
    int selected2 = -1;

    float border = 50; 

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

        if(selected1 != -1 && selected2 == -1)
        {
            Star star1 = stars.get(selected1);

            stroke(255, 255, 0);
            line(star1.getxG(), star1.getyG(), mouseX, mouseY);
        }
        else if(selected1 != -1 && selected2 != -1)
        {
            Star star1 = stars.get(selected1);
            Star star2 = stars.get(selected2);

            stroke(255, 255, 0);
            line(star1.getxG(), star1.getyG(), star2.getxG(), star2.getyG());

            float distance = dist(star1.getxG(), star1.getyG(), star1.getzG(),
                              star2.getxG(), star2.getyG(), star2.getzG());

            fill(255);
            text("Distance from " + star1.getDisplayName() +
            " to " + star2.getDisplayName() + " is " + distance +
            " parsecs ", border, height - 25);
        }
    }

    public void loadData()
    {
        Table t = loadTable("HabHYG15ly.csv", "header");

        for(TableRow tr : t.rows())
        {
            Star s = new Star(tr);
            
            stars.add(s);
        }
    }

    public void printStars()
    {
        for(Star s:stars)
        {
            println(s);
        }
    }

    public void drawStars()
    {
        for(Star s: stars)
        {
            s.render(this);
        }
    }

    public void drawGrid()
    {
        float border = width * 0.05f;

        stroke(0, 0, 255);
        textAlign(CENTER, CENTER);
        for(int i = -5 ; i <= 5 ; i ++)
        {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);    
            
            fill(255);
            text(i, x, border / 2);
            text(i, border / 2, x);
        }
    }

    public void mousePressed()
    {
        for (int i = 0; i < stars.size(); i++)
        {
            Star star = stars.get(i);

            if(dist(mouseX, mouseY, star.getxG(), star.getyG()) < star.getAbsMag() / 2 )
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
