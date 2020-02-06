package ie.tudublin;

public class Main
{
    // public void helloProcessing()
	// {
	// 	String[] a = {"MAIN"};
    //     processing.core.PApplet.runSketch( a, new HelloProcessing());
	// }
    // public static void main(String[] arg)
    // {
    //     System.out.println("Hello world!");

    //     Animal misty = new Dog(); // Polymorphism
    //     misty.setName("Misty");
    //     System.out.println(misty.getName());  
    //     misty.speak();  
    //     Cat topcat = new Cat();
    //     topcat.speak();

    //     Main main = new Main();
	// 	main.helloProcessing();
        
    // }

    public void bugZap()
    {
        String[] a = {"MAIN"};

        processing.core.PApplet.runSketch( a, new BugZap() );
    }

    public static void main(String[] arg)
    {
        Main main = new Main();
        main.bugZap();
    }
}