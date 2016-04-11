import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 the OrderCalculator class creates the GUI for the Ice Cream Order application
 * @author ionutopris
 *
 */
public class OrderCalculator extends JFrame 
{
	
	private FlavorPanel flavor; // flavor panel
	private ExtrasPanel extras;  // extras panel
	private JPanel buttonPanel;   // to hold the buttons
	private JButton restoreButton;  // to restore the previous saved componenets
	private JButton saveButton;  // to save a choice
	private JButton calcButton;  // to calculate the cost
	private final double TAX_RATE = 0.06; // Sales tax rate
	
	/**
	 	Constructor
	 */
	
	public OrderCalculator()
	{
		// display the title as the name entered
		String input;
		input = JOptionPane.showInputDialog("What is your first and last name?");
		setTitle(input);
		// specify the action for the close button
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// create a FlowLayout manager
		setLayout(new FlowLayout());
		// create the custom panels
		flavor = new FlavorPanel();
		extras = new ExtrasPanel();
		// create the button panel
		BuildButtonPanel();
		// create a title for the border
		buttonPanel.setBorder(BorderFactory.createTitledBorder("Process"));
		// add the components to the content pane
		add(flavor);
		add(extras);
		add(buttonPanel);
		// pack the contents of the window and display it
		pack();
		setVisible(true);
	}
	
	/**
	 the BuildButtonPanel builds the button panel
	 */
		
		private void BuildButtonPanel()
		{
			buttonPanel = new JPanel();
			
			restoreButton = new JButton("Restore");
			saveButton = new JButton("Save");
			calcButton = new JButton("Calcuculate Cost");
			
			
			restoreButton.addActionListener(new RestoreButtonListener());
			saveButton.addActionListener(new SaveButtonListener());
			calcButton.addActionListener(new CalcButtonListener());
			
			buttonPanel.add(restoreButton);
			buttonPanel.add(saveButton);
			buttonPanel.add(calcButton);
		}
	/**
	 private inner class that handles the event when the user clicks on the Calculate button
	 * @author ionutopris
	 *
	 */
			
			private class CalcButtonListener implements ActionListener
			{
				public void actionPerformed(ActionEvent e)
				{
					double subtotal, tax, total;
					
					subtotal= flavor.getFlavorCost() + extras.getExtrasCost();
					
					tax= subtotal *TAX_RATE;
					
					total= subtotal + tax;
					
					DecimalFormat dollar = new DecimalFormat("0.00");
					
					JOptionPane.showMessageDialog(null, "Cost: " 
							+ dollar.format(subtotal) + "\n" +
							"Tax: " + dollar.format(tax) + "\n" +
							"Total: " + dollar.format(total));
					
				}
			}
			
			/**
			 private inner class that handles the event when the user clicks the Save button
			 * @author ionutopris
			 */
			
			private class SaveButtonListener  implements ActionListener 
			{
				public void actionPerformed(ActionEvent e) 
				{
					try {
						flavor.writeFlavortoFile();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						extras.writeExtrastoFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
						
				}
			}
			
			/**
			 private inner class that handles the event when the user clicks the Restore button
			 * @author ionutopris
			 *
			 */
			
			private class RestoreButtonListener implements ActionListener
			
			{
				public void actionPerformed(ActionEvent e)
				{
					try {
						flavor.restoreFlavor();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						extras.restoreExtras();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				
				
			}
		/**
		 main method
		 * @param args
		 */
	
	
	public static void main(String[] args) throws IOException
	{
		new OrderCalculator();
		
	}


}
