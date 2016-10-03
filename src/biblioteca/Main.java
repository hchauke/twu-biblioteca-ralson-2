package biblioteca;

import biblioteca.model.UserAccount;
import biblioteca.service.AccountService;
import biblioteca.service.ConsoleService;
import biblioteca.service.LibraryService;
import biblioteca.service.MenuService;

public class Main {

    public static void main(String[] args) {

        ConsoleService consoleService = new ConsoleService();
        consoleService.printMessage("Hint: Login credentials  \n[ Library id: 100-0001, password : 123456, role: CUSTOMER ]\n" + "[ Library id: 100-0002, password: 123456, role: LIBRARIAN ]\n");
        consoleService.showWelcome();

        AccountService accountService = new AccountService();
        UserAccount loginUser = accountService.loginManager(consoleService, 5);

        while(loginUser != null) {
            MenuService menuService = LibraryFactory.generateMenuServiceByRole(loginUser.getRole());
            LibraryService libraryService = new LibraryService(loginUser, menuService, consoleService);
            libraryService.run();
            consoleService.showWelcome();
            loginUser = accountService.loginManager(consoleService, 5);
        }

    }
}
