package com.codecool;

public class Controller {

    View view;

    public Controller() {
        this.view = new View();
    }

    void run() {
        String option;
        boolean isRunning = true;

        while (isRunning) {
            option = view.askUserForInput()[0];
            switch (option) {
                case "start":
                    break;
                case "stop":
                    break;
                case "check":
                    break;
                case "checkAll":
                    break;
                case "exit":
                    isRunning = false;
                    break;
                default:
                    view.displayWrongUserInputMessage();
            }
        }
    }
}
