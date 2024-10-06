package GUI_AddressBook;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class Addres_Book {
    private JButton edit;
    private JButton search;
    private JButton add;
    private JTextField fieldname;
    private JTextField fieldnumber;
    private JPanel main;
    private JButton delete;
    private JTable table1;
    private DefaultTableModel tableModel;

    String names [] = new String[999];
    int phone_number [] = new int[999];
    int contactCount = 0; // Contador para los contactos

    public Addres_Book()
    {
        // Inicializar el modelo de la tabla
        tableModel = new DefaultTableModel(new String[]{"Name", "Phone Number"}, 0);
        table1.setModel(tableModel); // Asignar el modelo a la tabla

        add.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {add();}});

        edit.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {edit();}});

        search.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {search();}});

        delete.addActionListener(new ActionListener() {@Override public void actionPerformed(ActionEvent e) {delete();}});
    }

    public void add(){

        if(fieldname.getText().length()>50 || fieldnumber.getText().length()>10)
        {
            JOptionPane.showMessageDialog(null,"- Character limit in “Name” 50\n- Character limit in “Number” 10");
        }
        else {
            names[contactCount]= fieldname.getText();
            phone_number[contactCount] = Integer.parseInt(fieldnumber.getText());

            // Agregar la nueva fila al modelo de la tabla
            tableModel.addRow(new Object[]{names[contactCount], phone_number[contactCount]});

            // Incrementar el contador de contactos
            contactCount++;

            fieldname.setText("");
            fieldnumber.setText("");
        }
    }


    public void edit(){
        int option = Integer.parseInt(JOptionPane.showInputDialog(null,"What do you want edit?\n1. Name\n2. Phone Number"));
        switch (option) {

            case 1:
                int positionName = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the position of the Name"));
                String newName = JOptionPane.showInputDialog(null, "Enter the new Name");
                names[positionName] = newName;

                // Actualizar el modelo de la tabla
                tableModel.setValueAt(newName, positionName, 0);
                break;

            case 2:
                int positionNumber = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the position of the Name"));
                String newNumber = JOptionPane.showInputDialog(null, "Enter the new Name");
                names[positionNumber] = newNumber;

                // Actualizar el modelo de la tabla
                tableModel.setValueAt(newNumber, positionNumber, 1);
                break;
        }
    }

    public void search(){

        int op = Integer.parseInt(JOptionPane.showInputDialog(" 1. Name \n 2. Phone Number"));

        switch (op){

            case 1:
                boolean found = false;
                String searchName = (JOptionPane.showInputDialog(null, "Enter the Name"));

                for (int i = 0; i < names.length ; i++) {
                    if (names[i] != null && names[i].equalsIgnoreCase(searchName)) { // equalsIgnoreCase() solo funciona con String, no se puede usar para comparar valores numéricos.
                        JOptionPane.showMessageDialog(null, "Name: " + names[i] + "\nPhone Number: " + phone_number[i]);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Name not found");
                }
                break;

            case 2:
                boolean found1 = false;
                int searchNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the Number"));

                for (int i = 0; i < phone_number.length ; i++) {
                    if (phone_number[i] ==(searchNum)) { // == para comparación de enteros
                        JOptionPane.showMessageDialog(null, "Name: " + names[i] + "\nPhone Number: " + phone_number[i]);
                        found1 = true;
                        break;
                    }
                }
                if (!found1) {
                    JOptionPane.showMessageDialog(null, "Phone Number not found");
                }
                break;


        }
    }

    public void delete(){

        int position = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the position of the contact to delete (starting from 0)"));

        if (position < 0 || position >= contactCount) {
            JOptionPane.showMessageDialog(null, "Invalid position!"); // Validar posición
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this contact?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            // Eliminar de los arrays
            for (int i = position; i < contactCount - 1; i++) {
                names[i] = names[i + 1];
                phone_number[i] = phone_number[i + 1];
            }

            names[contactCount - 1] = null;
            phone_number[contactCount - 1] = 0;

            tableModel.removeRow(position);

            contactCount--;
            JOptionPane.showMessageDialog(null, "Contact deleted successfully!");
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Address Book");
        frame.setContentPane(new Addres_Book().main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(480, 380);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
