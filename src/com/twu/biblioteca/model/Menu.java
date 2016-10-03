package com.twu.biblioteca.model;

import com.twu.biblioteca.enumeration.MenuTab;

public class Menu {

    private String userChoice;
    private MenuTab menuTab;

    public Menu(String userChoice, MenuTab menuTab) {
        this.userChoice = userChoice;
        this.menuTab = menuTab;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public MenuTab getMenuTab() {
        return menuTab;
    }
}
