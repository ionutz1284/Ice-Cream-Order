import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
/**
 the ExtrasPanel class allows the user to select the extras for the ice cream
 * @author ionutopris
 */
public class ExtrasPanel extends JPanel
{
	//this constant is used to hold the cost of each extra
	public final double EXTRAS_COST= 0.25;
	
	private JCheckBox nuts;   // to select nuts
	private JCheckBox cherries;   // to select cherries
	
	/**
	 Constructor
	 */
	
	public ExtrasPanel()
	{
		
		// create check boxes
		nuts = new JCheckBox("Nuts");
		cherries = new JCheckBox("Cherries");
		// add border around the panel
		setBorder(BorderFactory.createTitledBorder("Extras"));;
		// add the check boxes to the panel
		add(nuts);
		add(cherries);
		
		/**
		 the getExtrasCost method 
		 @return The cost of extras selected
		 */
		
	}
	public double getExtrasCost()
	{
		double extrascost= 0.0;
		
		if(nuts.isSelected())
			extrascost += EXTRAS_COST;
		if(cherries.isSelected())
			extrascost += EXTRAS_COST;
		
		return extrascost;
		
	}
	
	/**
	the writeExtrastoFile method
	 * @throws IOException
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
		
			outputFile.close();
			outputFile.flush();
	}
	
	/**
	 the restoreExtras method
	 * @throws IOException
	 */
	
	public void restoreExtras() throws IOException
	{
		File file = new File("icecream.txt");
		Scanner inputfile = new Scanner(file);
		String input = "";
		while(inputfile.hasNext())
				
			input = inputfile.nextLine();	
			if(input=="With Nuts")
				nuts.doClick();
		    if(input == "With cherries")
				cherries.doClick();
			inputfile.close();
	}

}
