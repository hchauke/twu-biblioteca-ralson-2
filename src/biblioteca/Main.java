package biblioteca;

import biblioteca.model.UserAccount;
import biblioteca.businessLogic.extend.ConsoleService;
import biblioteca.businessLogic.extend.LibraryService;
import biblioteca.businessLogic.extend.MenuService;

public class Main {

    public static void main(String[] args) {

        ConsoleService consoleService = new ConsoleService();
        consoleService.printMessage("Hint: Login credentials  \n[ Library id: 100-0001, password : 123456, role: CUSTOMER ]\n" + "[ Library id: 100-0002, password: 123456, role: LIBRARIAN ]\n");
        consoleService.welcomeMessage();

        LoginService loginService = new LoginService();
        UserAccount loginUser = loginService.loginManager(consoleService, 5);

        while(loginUser != null) {
            MenuService menuService = LibraryRoleMenus.generateMenuServiceByRole(loginUser.getRole());
            LibraryService libraryService = new LibraryService(loginUser, menuService, consoleService);
            libraryService.run();
            consoleService.welcomeMessage();
            loginUser = loginService.loginManager(consoleService, 5);
        }

    }
}
