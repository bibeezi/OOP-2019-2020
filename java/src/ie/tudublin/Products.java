package ie.tudublin;

import processing.data.TableRow;

public class Products
{
    private String name;
    private float price;

    //constructor
    public Products(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    //constructor chaining
    // calling a constructor from another constructor
    // the constructor below calls the constructor above
    public Products(TableRow tr)
    {
        this(tr.getString("Name"), tr.getFloat("Price"));
    }

    //getters and setters are for private fields
    // using them can allow other files to access them.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products [name=" + name + ", price=" + price + "]";
    }


}