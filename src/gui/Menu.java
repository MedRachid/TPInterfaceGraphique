package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu implements ActionListener {
    private MainView mainview;

    private JButton listButton;
    private JButton addEmploye;

    public Menu(MainView viewManager){

        this.mainview = viewManager;

        this.mainview.panel = new JPanel();

        this.mainview.panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.addEmploye = new JButton("Add Employee");
        this.addEmploye.addActionListener(this);
        this.listButton = new JButton("List of Employee");
        this.listButton.addActionListener(this);



        this.mainview.panel.add(this.addEmploye);
        this.mainview.panel.add(this.listButton);

    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.listButton){
            this.mainview.displayList();
        }

        else if(event.getSource() == this.addEmploye){
            this.mainview.display();
        }
    }


}

