package biblioteca.model;

import biblioteca.enumeration.MenuTab;

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
