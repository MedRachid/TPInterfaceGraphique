package gui;

import javax.swing.*;

public class Window extends JFrame {
    public Window() {

        this.setTitle("Employee List");
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
