package gui;

import better.domain.Employee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Table implements ActionListener{

    private MainView viewManager;

    private JButton returnButton;
    private JButton addEmploye;

    public Table(MainView viewManager){

        this.viewManager = viewManager;
        this.viewManager.panel = new JPanel(new BorderLayout());

        ArrayList <Employee> listEmployee = this.viewManager.personnel.getEmployees();

        Object[][] data = new Object[listEmployee.size()+2][];

        int i = 0 ;
        int total =0;
        for (Employee e : listEmployee){
            data[i]= (new Object[]{
                    e.getPosition(),
                    e.getName(),
                    e.getAge(),
                    e.getEntryYear(),
                    e.calculerSalaire()
            }); i++;
            total += e.calculerSalaire();
        }

        data[i] = new Object[]{"Le salaire moyen est", "", "", "", this.viewManager.personnel.salaireMoyen(listEmployee)};
        i++;
        data[i] = new Object[]{"Total des salaires", "", "", "", total};
        String[] entetes = {"Jobs", "Employee", "Age", "Year Entry", "Salary"};
        JTable table = new JTable( data, entetes);



        this.returnButton = new JButton("Back to Menu ");
        this.returnButton.addActionListener(this);

        this.addEmploye = new JButton("Add Employee");
        this.addEmploye.addActionListener(this);

        this.viewManager.panel.add(table.getTableHeader(),BorderLayout.NORTH);
        this.viewManager.panel.add(table, BorderLayout.CENTER);


        this.viewManager.panel.add(this.addEmploye, BorderLayout.SOUTH);
        this.viewManager.panel.add(this.returnButton, BorderLayout.SOUTH);


    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.returnButton){
            this.viewManager.displayMenu();
        }

        else if(event.getSource() == this.addEmploye){
            this.viewManager.display();
        }
    }

}

