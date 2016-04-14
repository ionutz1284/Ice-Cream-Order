import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
public class ExtrasPanel extends JPanel
{
	//this constant holds the extra cost 
	public final double EXTRAS_COST= 0.25;
	
	private JCheckBox nuts; // to select nuts
	private JCheckBox cherries;  // to select cherries
	/*
	 The Constructor
	 */
	
	public ExtrasPanel()
	{
		
		// create the check boxes
		nuts = new JCheckBox("Nuts");
		cherries = new JCheckBox("Cherries");
		//add a border around the panel
		setBorder(BorderFactory.createTitledBorder("Extras"));;
		// add the check boxes to the panel
		add(nuts);
		add(cherries);	
	}
	/*
	 method for returning the extra cost
	 @return the extra cost of the extras
	 */
	public double getExtrasCost()
	{
		double extrascost= 0.0;
		
		if(nuts.isSelected())
			extrascost += EXTRAS_COST;
		if(cherries.isSelected())
			extrascost += EXTRAS_COST;
		
		return extrascost;
	}
	
	/*
	 Method that write the extra cost to file
	 */
	public void writeExtrastoFile() throws IOException
	{
		FileWriter fwriter = new FileWriter("icecream.txt", true);
		PrintWriter outputFile = new PrintWriter (fwriter);
		if(nuts.isSelected())
			outputFile.println("With Nuts");
		else
			outputFile.println("Without Nuts");
		if (cherries.isSelected())
			outputFile.println("With cherries");
		else
			outputFile.println("Without cherries");
		outputFile.println();
		outputFile.close();
		outputFile.flush();
	}

	/*
	 method that reads the extra cost from file
	 */
	public void restoreExtras() throws IOException
	{
		File file = new File("icecream.txt");
		Scanner inputfile = new Scanner(file);
		String input = inputfile.nextLine();
		while(inputfile.hasNext())
		{
			if(input.equalsIgnoreCase("With Nuts"))
			{
				nuts.doClick();
				input = inputfile.nextLine();
			}
			if(input.equalsIgnoreCase("With cherries"))
			{
				cherries.doClick();
				
			}
				input = inputfile.nextLine();
			
					
			
		}
			inputfile.close();
	}

}
