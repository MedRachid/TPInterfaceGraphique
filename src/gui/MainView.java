package gui;

import better.service.Personnel;

import javax.swing.*;
import java.awt.*;

public class MainView {

        private Window window;
        private Menu dashboard;
        private Table listEmploye;
        private AddEmployee addEmploye;
        public JPanel panel;
        public Personnel personnel;


        public MainView (Window window){

            this.window = window;
            this.personnel = new Personnel();

        }

        public void displayMenu(){
            this.dashboard = new Menu(this);
            this.window.getContentPane().removeAll();
            this.window.setContentPane(this.panel);
            this.window.revalidate();
            this.window.repaint();
        }

        public void displayList(){

            this.window.getContentPane().removeAll();
            this.listEmploye = new Table(this);
            this.window.setContentPane(this.panel);
            this.window.revalidate();
            this.window.repaint();
        }

        public void display(){
            this.addEmploye = new AddEmployee(this);
            this.window.getContentPane().setLayout(new FlowLayout());
            this.window.getContentPane().add(new JScrollPane());
            this.window.setContentPane(this.panel);
            this.window.setVisible(true);
        }
    }
