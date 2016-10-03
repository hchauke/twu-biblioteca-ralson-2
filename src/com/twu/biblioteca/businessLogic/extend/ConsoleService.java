package com.twu.biblioteca.businessLogic.extend;

import com.twu.biblioteca.model.Menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ConsoleService {

    private final BufferedReader bufferedReader;

    public ConsoleService() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void welcomeMessage() {
        System.out.println("\n===============Welcome to the Biblioteca!===============\n");
    }

    public void goodByeMessage() {
        System.out.println("\n===============Thank you for using the Biblioteca! Bye!===============\n");
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public int chooseOption() {
        String input = inputWithPrompt("Please choose an option from above: ");
        if(input != null) {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public void printMenuPrompt(List<Menu> menus) {
        System.out.println();
        int size = menus.size();
        for (int index = 0; index < size; ++index) {
            System.out.print((index+1) + "." + menus.get(index).getUserChoice());
            if (index == size - 1) {
                System.out.println();
            } else {
                System.out.print("      ");
            }
        }
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public String inputWithPrompt(String prompt) {
        System.out.print(prompt);
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
