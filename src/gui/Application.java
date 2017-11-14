package gui;

public class Application {

    public static void main(String[] args) {

        Window window = new Window();
        MainView viewManager = new MainView(window);


        viewManager.displayMenu();
    }

}


