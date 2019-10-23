package com.codecool;

public class App {
    static{
        System.out.println("Multi-threaded app started");
    }

    public static void main( String[] args ) {
        Controller controller = new Controller();
        controller.run();
    }
}
