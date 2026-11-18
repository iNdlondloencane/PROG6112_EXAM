package question2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import static java.nio.file.StandardOpenOption.*;

public class Question2 extends JFrame implements ActionListener {

    // Labels
    private JLabel nameLabel = new JLabel("Customer Name:");
    private JLabel productLabel = new JLabel("Select Product:");
    private JLabel priceLabel = new JLabel("Enter Price:");

    // Text boxes
    private JTextField nameField = new JTextField(15);
    private JTextField priceField = new JTextField(15);

    // Combo box with the three mattresses
    private String[] products = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    private JComboBox<String> productBox = new JComboBox<String>(products);

    // Process button
    private JButton processButton = new JButton("PROCESS");

    // Menu bar, menus and menu items
    private JMenuBar menuBar = new JMenuBar();
    private JMenu fileMenu = new JMenu("File");
    private JMenu toolsMenu = new JMenu("Edit");
    private JMenuItem exitItem = new JMenuItem("Exit");
    private JMenuItem processItem = new JMenuItem("Process");
    private JMenuItem clearItem = new JMenuItem("Clear");

    // Constructors building the form
    public Question2() {
        super("Product App");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // GridLayout with 4 rows and 2 columns
        setLayout(new GridLayout(4, 2, 10, 10));

        // Adds the components to the form
        add(nameLabel);
        add(nameField);
        add(productLabel);
        add(productBox);
        add(priceLabel);
        add(priceField);
        add(new JLabel(""));
        add(processButton);

        // Adds the menu items to the menus and the menus to the menu bar
        fileMenu.add(exitItem);
        toolsMenu.add(processItem);
        toolsMenu.add(clearItem);
        menuBar.add(fileMenu);
        menuBar.add(toolsMenu);
        setJMenuBar(menuBar);

        // Registers the listeners
        processButton.addActionListener(this);
        processItem.addActionListener(this);
        clearItem.addActionListener(this);
        exitItem.addActionListener(this);
    }

    // Created to runs when the button or a menu item is clicked
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == processButton || source == processItem) {
            ProcessSale();
        } else if (source == clearItem) {
            ClearForm();
        } else if (source == exitItem) {
            System.exit(0);
        }
    }

    // Gets the input, does the calculations, shows the message and saves the file
    private void ProcessSale() {
        String customerName = nameField.getText();
        String productName = (String) productBox.getSelectedItem();
        double price;

        // This Stops the program from crashing if the price is not a number
        try {
            price = Double.parseDouble(priceField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a valid price");
            return;
        }

        // Create the calculation object
        ProductCalculations calculations = new ProductCalculations(price);

        double vat = calculations.GetVat();
        double commission = calculations.GetCommission();
        double total = calculations.GetTotal();

        // Text for the message box
        String output = "Customer Name: " + customerName + "\n"
                + "Product: " + productName + "\n"
                + "VAT: R " + vat + "\n"
                + "COMMISSION: R " + commission + "\n"
                + "TOTAL: R " + total;

        JOptionPane.showMessageDialog(null, output);

        SaveToFile(customerName, productName, vat, commission, total);
    }

    // Saves the information to the file data.txt
    private void SaveToFile(String customerName, String productName,
            double vat, double commission, double total) {

        Path file = Paths.get("data.txt");

        try {
            OutputStream output = new BufferedOutputStream(Files.newOutputStream(file, CREATE, APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));

            writer.write("DATA LOG");
            writer.newLine();
            writer.write("****************************************");
            writer.newLine();
            writer.write("Customer Name: " + customerName);
            writer.newLine();
            writer.write("Product: " + productName);
            writer.newLine();
            writer.write("VAT: R " + vat);
            writer.newLine();
            writer.write("COMMISSION: R " + commission);
            writer.newLine();
            writer.write("TOTAL: R " + total);
            writer.newLine();
            writer.write("****************************************");
            writer.newLine();

            writer.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Message: " + e);
        }
    }

    // Clears the text boxes and sets the combo box to the first item
    private void ClearForm() {
        nameField.setText("");
        priceField.setText("");
        productBox.setSelectedIndex(0);
    }

    // Main method creates the form and shows it
    public static void main(String[] args) {
        Question2 frame = new Question2();
        frame.setVisible(true);
    }
}
