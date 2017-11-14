package gui;

import better.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;


public class AddEmployee implements ActionListener{
    private MainView mainview;
    private JButton backButton;
    private JButton AddButton;

    private String[] jobList = {
            "Manutentionnaire",
            "Manutentionnaire à risque",
            "Technicien",
            "Technicien à risque",
            "Représentant"

    };

    private JComboBox <String> Jobs;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField age;
    private JTextField year;
    private JTextField base;


    public AddEmployee(MainView viewManager){

        this.mainview = viewManager;
        this.mainview.panel = new JPanel();
        this.Jobs = new JComboBox<>(this.jobList);
        this.firstname = new JTextField();
        this.lastname = new JTextField();
        this.age = new JTextField();
        this.year = new JTextField();
        this.base = new JTextField();


        this.mainview.panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        this.backButton = new JButton("Back To Menu ");
        this.backButton.addActionListener(this);

        this.AddButton = new JButton("Add");
        this.AddButton.addActionListener(this);

        BoxLayout boxLayout = new BoxLayout(this.mainview.panel, BoxLayout.Y_AXIS);
        this.mainview.panel.setLayout(boxLayout);

        this.mainview.panel.add(new JLabel("Jobs"));
        this.mainview.panel.add(this.Jobs);

        this.mainview.panel.add(new JLabel("Firstname"));
        this.mainview.panel.add(this.firstname);

        this.mainview.panel.add(new JLabel("Lastname"));
        this.mainview.panel.add(this.lastname);

        this.mainview.panel.add(new JLabel("Age"));
        this.mainview.panel.add(this.age);

        this.mainview.panel.add(new JLabel("Entry year"));
        this.mainview.panel.add(this.year);

        this.mainview.panel.add(new JLabel("Base"));
        this.mainview.panel.add(this.base);

        this.mainview.panel.add(this.AddButton);
        this.mainview.panel.add(this.backButton);


    }

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == this.backButton){
            this.mainview.displayMenu();
        }

        else if(event.getSource() == this.AddButton){

            String jobs = String.valueOf(this.Jobs.getSelectedItem());
            String lastname = this.firstname.getText();
            String firstname = this.lastname.getText();
            int age = parseInt(this.age.getText());
            String year = String.valueOf(this.year.getText());
            int base = parseInt(this.base.getText());

            Employee e;

            switch (jobs){
                case  ("Manutentionnaire"):
                    e = new Manutentionnaire(firstname,lastname, age, year,base);
                    break;

                case  ("Manutentionnaire à risque"):
                    e = new ManutARisque(firstname,lastname, age, year,base);
                    break;

                case  ("Technicien"):
                    e = new Technicien(firstname,lastname, age, year,base);
                    break;

                case  ("Technicien à risque"):
                    e = new TechnARisque(firstname, lastname, age, year,base);
                    break;

                case  ("Représentant"):
                    e = new Representant(firstname,  lastname, age, year, base);
                    break;

                default:
                    e = null;
                    break;


            }
            if (e != null ){
                this.mainview.personnel.ajouterEmploye(e);
                this.mainview.displayMenu();
            }

        }
    }


}
