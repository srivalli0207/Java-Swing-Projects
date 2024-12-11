package homework2;

// Name: Srivalli Kakumani
// Homework: #2
// Due: March 06, 2024
// Course: cs-2450-01-sp24
//
// Description: Create a Java Swing application PizzariaOrderApp that display:
//              1. Defaults (start up and Reset):
//                 a. Medium
//                 b. No Toppings
//                 c. Bottom Message (BM): Ready to take order!
//              2. When Order is pushed, display on BM:
//                 “size and toppings-list”
//                 and output order to the console as:
//                 size (8, 10, or 12)
//                 toppings-1
//                 toppings-2 ...

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PizzariaOrderApp 
{
	private JFrame frame;
	private JCheckBox pineappleCheckBox, blackOlivesCheckBox, pepperoniCheckBox, jalapenoCheckBox, noToppingsCheckBox;
	private JRadioButton smallRadioButton, mediumRadioButton, largeRadioButton;
	private JButton orderButton, resetButton;
	private JLabel bottomMessageLabel;
	
	public PizzariaOrderApp()
	{
		frame = new JFrame("Kakumani's Pizzeria");

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel sizePanel = new JPanel();
        sizePanel.setLayout(new BoxLayout(sizePanel, BoxLayout.Y_AXIS));
        JLabel sizeLabel = createTitledLabel("Size");
        sizePanel.add(sizeLabel);

        smallRadioButton = new JRadioButton("Small (8 in.)");
        mediumRadioButton = new JRadioButton("Medium (10 in.)");
        largeRadioButton = new JRadioButton("Large (12 in.)");
        
        ButtonGroup sizeButtonGroup = new ButtonGroup();
        sizeButtonGroup.add(smallRadioButton);
        sizeButtonGroup.add(mediumRadioButton);
        sizeButtonGroup.add(largeRadioButton);

        mediumRadioButton.setSelected(true);

        sizePanel.add(smallRadioButton);
        sizePanel.add(mediumRadioButton);
        sizePanel.add(largeRadioButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        buttonPanel.add(Box.createVerticalStrut(35));
        
        orderButton = new JButton("Order");
        resetButton = new JButton("Reset");

        orderButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        orderButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                orderPizza();
            }
        });

        resetButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                resetPizza();
            }
        });

        buttonPanel.add(orderButton);
        buttonPanel.add(Box.createVerticalStrut(20));
        buttonPanel.add(resetButton);

        JPanel toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new BoxLayout(toppingsPanel, BoxLayout.Y_AXIS));

        JLabel toppingsLabel = createTitledLabel("Toppings");
        toppingsPanel.add(toppingsLabel);

        pineappleCheckBox = new JCheckBox("Pineapple");
        blackOlivesCheckBox = new JCheckBox("Black Olives");
        pepperoniCheckBox = new JCheckBox("Pepperoni");
        jalapenoCheckBox = new JCheckBox("Jalapeno");
        noToppingsCheckBox = new JCheckBox("No Toppings");
        
        noToppingsCheckBox.setSelected(true);

        toppingsPanel.add(pineappleCheckBox);
        toppingsPanel.add(blackOlivesCheckBox);
        toppingsPanel.add(pepperoniCheckBox);
        toppingsPanel.add(jalapenoCheckBox);
        toppingsPanel.add(noToppingsCheckBox);
        
        bottomMessageLabel = new JLabel("Ready to take order!");
        bottomMessageLabel.setHorizontalAlignment(JLabel.CENTER);

        mainPanel.add(sizePanel, BorderLayout.WEST);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(toppingsPanel, BorderLayout.EAST);
        mainPanel.add(bottomMessageLabel, BorderLayout.SOUTH);

        frame.add(mainPanel);

        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
	
	private JLabel createTitledLabel(String title) 
	{
        JLabel label = new JLabel(title);
        label.setFont(label.getFont().deriveFont(Font.BOLD)); 
        label.setHorizontalAlignment(JLabel.CENTER); 
        label.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        return label;
    }

    private void orderPizza() 
    {
        StringBuilder toppingsList = new StringBuilder();

        StringBuilder size = new StringBuilder();
        
        if (smallRadioButton.isSelected()) 
        {
            size.append("8 in.");
        }
        if (mediumRadioButton.isSelected()) 
        {
            size.append("10 in.");
        }
        if (largeRadioButton.isSelected()) 
        {
            size.append("12 in.");
        }

        if (pineappleCheckBox.isSelected()) 
        {
            toppingsList.append("Pineapple, ");
        }
        if (blackOlivesCheckBox.isSelected()) 
        {
            toppingsList.append("Black Olives, ");
        }
        if (pepperoniCheckBox.isSelected()) 
        {
            toppingsList.append("Pepperoni, ");
        }
        if (jalapenoCheckBox.isSelected()) 
        {
            toppingsList.append("Jalapeno, ");
        }
        if (noToppingsCheckBox.isSelected()) 
        {
            toppingsList.append("No Toppings");
        }
        
        if (toppingsList.length() > 0 && toppingsList.charAt(toppingsList.length() - 2) == ',') 
        {
            toppingsList.deleteCharAt(toppingsList.length() - 2);
        }

        String message;
        if (toppingsList.length() > 0) 
        {
        	
            message = size.toString() + " with " + toppingsList.toString();
        } 
        else 
        {
            message = size.toString() + " with No Toppings";
        }
        
        bottomMessageLabel.setText(message);

    }

    private void resetPizza() 
    {
        smallRadioButton.setSelected(false);
        mediumRadioButton.setSelected(false);
        largeRadioButton.setSelected(false);
        pineappleCheckBox.setSelected(false);
        blackOlivesCheckBox.setSelected(false);
        pepperoniCheckBox.setSelected(false);
        jalapenoCheckBox.setSelected(false);
        noToppingsCheckBox.setSelected(true);
        bottomMessageLabel.setText("Ready to take order!");
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new PizzariaOrderApp());
    }

}
