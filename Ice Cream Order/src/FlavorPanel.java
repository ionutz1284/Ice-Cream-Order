import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;


public class FlavorPanel extends JPanel
/**
 The FlavorPanel class allows the user to select a vanilla, chocolate, or strawberry favored ice cream
 */
{
	// this constant is used to indicate the cost of a flavor
	public final double FLAVOR_COST= 2.25;
	
	private JRadioButton vanilla;  // to select vanilla
	private JRadioButton chocolate;   // to select chocolate
	private JRadioButton strawberry;   // to select strawberry
	private ButtonGroup bg;     // radio button group
	/**
	 the constructor
	 */
	public FlavorPanel()
	{
		// create a grid layout with
		// one raw and three columns
		setLayout(new GridLayout(1,3));
		// create the radio buttons
		vanilla= new JRadioButton("Vanilla", true);
		chocolate= new JRadioButton("Chocolate");
		strawberry= new JRadioButton("Strawberry");
		// group the radio buttons
		bg= new ButtonGroup();
		bg.add(vanilla);
		bg.add(chocolate);
		bg.add(strawberry);
		// Add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Icecream Flavor"));
		// add the radio buttons to the panel
		add(vanilla);
		add(chocolate);
		add(strawberry);
		/**
		 getFlavorCost method
		 @return The cost of the flavorcost
		 */
	}
	public double getFlavorCost()
	{
		double flavorcost;
		flavorcost = FLAVOR_COST;
		return flavorcost;	
	}
	
	/**
	 writeFlavortoFile method write the flavor to the file
	 */
	public void writeFlavortoFile() throws IOException
	{
		clearFile();  // calls the clear() method to clear the file before writing to it
		FileWriter fwriter1 = new FileWriter("icecream.txt", true);
		PrintWriter outputFile = new PrintWriter (fwriter1);
		if(vanilla.isSelected())
			outputFile.println("Vanilla");
		else if (chocolate.isSelected())
			outputFile.println("Chocolate");
		else if(strawberry.isSelected())
			outputFile.println("Strawberry");
		outputFile.close();		
	}
	
	/*
	 method the clears the file 
	 */
	public static void clearFile() throws IOException
	{
		FileWriter fwriter = new FileWriter("icecream.txt", false);
		PrintWriter outputFile = new PrintWriter (fwriter,false);
		outputFile.flush();
		outputFile.close();
	}
	
	/**
	 restore FlavoretoFile method
	 */
	public void restoreFlavor() throws IOException
	{
		File file = new File("icecream.txt");
		Scanner inputfile = new Scanner(file);
		String input = inputfile.nextLine();
		
			if(input.equalsIgnoreCase("Vanilla"))
			{
				vanilla.doClick();
			}
				else if(input.equalsIgnoreCase("Chocolate"))
			{
				
				chocolate.doClick();
			}
			
			else if(input.equalsIgnoreCase("Strawberry"))
			{
				strawberry.doClick();
			}
				inputfile.close();
			
	}
}
