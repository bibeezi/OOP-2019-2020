package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Cafe extends PApplet
{
    //"templating"/generics
    // passing the type as a parameter
    // uses angle brackets < >

    //ArrayLists are arrays that can grow and shrink
    ArrayList<Products> products = new ArrayList<Products>();
    ArrayList<Products> bill = new ArrayList<Products>();

    float border;
    float left;
    float w;
    float h;

    public void settings()
    {
        size (800, 600);

        border = width * 0.1f;
        left = width * 0.05f;
        
        w = width * 0.3f;
        h = height * 0.1f;
    }
    
    public void setup()
    {
        loadData();
        //printProducts();
    }

    public void draw()
    {
        displayProducts();
        drawBill();
    }

    public void loadData()
    {
        Table table = loadTable("cafe.csv", "header");

        //'foreach' loop
        // returns a collection (like an arraylist)
        for(TableRow row : table.rows())
        {
            Products p = new Products(row);

            products.add(p);
        }
    }

    //just prints all products
    public void printProducts()
    {
        for(Products p : products)
        {
            System.out.println(p);
        }
    }

    public void displayProducts()
    {
        for(int i = 0; i < products.size(); i++)
        {
            Products p = products.get(i);

            float y = map(i, 0, products.size(), border, height - border);

            fill(255);
            rect(left, y, w, h);

            fill(0);
            textAlign(LEFT, CENTER);
            text(p.getName(), left + 10, y + ( h/2 ));

            textAlign(RIGHT, CENTER);
            //nf(num, pad left, pad right)
            // in this case, 2 decimal digits
            text(nf(p.getPrice(), 0, 2), left + w - 10, y + ( h/2 ));
        }
    }

    public void mousePressed()
    {
        for(int i = 0; i < products.size(); i++)
        {
            float y = map(i, 0, products.size(), border, height - border);

            if(mouseX > left && mouseX < left + w && 
               mouseY > y && mouseY < y + h)
            {
                bill.add(products.get(i));
                break;
            }
        }
    }

    public void drawBill()
    {
        float billLeft = (width / 2) + 50;
        float billHeight = height * 0.8f;

        float y = border + 50;

        float total = 0;

        stroke(0);
        fill(255);
        rect(billLeft, border, w, billHeight);

        for(int i = 0; i < bill.size(); i++)
        {
            Products p = bill.get(i);

            fill(0);
            textAlign(LEFT, CENTER);
            text(p.getName(), billLeft + 10, y);

            textAlign(RIGHT, CENTER);
            text(nf(p.getPrice(), 0, 2), billLeft + w - 10, y);

            y += 30;

            total += p.getPrice();
        }

        fill(0);

        textAlign(LEFT, CENTER);
        text("Total : ", billLeft + 10, y);

        textAlign(RIGHT, CENTER);
        text(nf(total, 0, 2), billLeft + w - 10, y);
    }
}