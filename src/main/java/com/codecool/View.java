package com.codecool;

import java.util.Scanner;

public class View {

    public String[] askUserForInput() {
        Scanner scan = new Scanner(System.in);
        String[] userInput = scan.nextLine().split(" ");
        return userInput;
    }

    public void displayWrongUserInputMessage() {
        System.out.println("Wrong user input, " +
                "please provide correct input" +
                "\n \"start\" + [timer_name] " +
                "\n \"stop\" + [timer_name] " +
                "\n \"check\" + [timer_name] " +
                "\n \"checkAll\" " +
                "\n or \"exit\" to finish app");
    }


}
