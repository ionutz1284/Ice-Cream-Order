import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
public class ExtrasPanel extends JPanel
{
	public final double EXTRAS_COST= 0.25;
	
	private JCheckBox nuts;
	private JCheckBox cherries;
	
	public ExtrasPanel()
	{
		
		
		nuts = new JCheckBox("Nuts");
		cherries = new JCheckBox("Cherries");
		
		setBorder(BorderFactory.createTitledBorder("Extras"));;
		
		add(nuts);
		add(cherries);
		
		
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
