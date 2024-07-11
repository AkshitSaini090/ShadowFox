import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inventorymanagementsystem {
    private JFrame frame;
    private JTable table;
    private InventoryModel model;

    public InventoryManagementSystem() {
        frame = new JFrame("Inventory Management System");
        model = new InventoryModel();

        frame.setLayout(new BorderLayout());

        // Table
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Buttons
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        frame.add(panel, BorderLayout.SOUTH);

        // Button Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InventoryItem item = new InventoryItem();
                if (showItemDialog(item)) {
                    model.addItem(item);
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    InventoryItem item = model.getItem(selectedRow);
                    if (showItemDialog(item)) {
                        model.updateItem(selectedRow, item);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to update.");
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    model.removeItem(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a row to delete.");
                }
            }
        });

        // Frame settings
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private boolean showItemDialog(InventoryItem item) {
        JTextField nameField = new JTextField(10);
        JTextField quantityField = new JTextField(10);
        JTextField priceField = new JTextField(10);

        if (item != null) {
            nameField.setText(item.getName());
            quantityField.setText(String.valueOf(item.getQuantity()));
            priceField.setText(String.valueOf(item.getPrice()));
        }

        JPanel panel = new JPanel();
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);

        int result = JOptionPane.showConfirmDialog(null, panel, 
                 "Item Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            item.setName(nameField.getText());
            item.setQuantity(Integer.parseInt(quantityField.getText()));
            item.setPrice(Double.parseDouble(priceField.getText()));
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        new Inventorymanagementsystem();
    }
}
