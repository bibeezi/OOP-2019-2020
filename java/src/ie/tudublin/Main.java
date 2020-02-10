package ie.tudublin;

public class Main
{

    public void airSeaBattle()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new AirSeaBattle());
	}
    
    public static void main(String[] arg)
    {
        /*
        System.out.println("Hello world!");

        Animal misty = new Dog(); // Polymorphism
        misty.setName("Misty");
        System.out.println(misty.getName());  
        misty.speak();  
        Cat topcat = new Cat();
        topcat.speak();
        */

        Main main = new Main();
		main.airSeaBattle();
        
    }
}