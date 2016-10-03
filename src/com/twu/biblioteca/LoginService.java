package com.twu.biblioteca;


import com.twu.biblioteca.businessLogic.extend.ConsoleService;
import com.twu.biblioteca.library.LibraryManager;
import com.twu.biblioteca.model.UserAccount;

public class LoginService {

    private UserAccount loginUser;

    public boolean login(String loginId, String password) {
        if (loginId == null || loginId.isEmpty() || password == null || password.isEmpty()) {
            return false;
        }
        loginUser = LibraryManager.findUserAccount(loginId, password);
        return loginUser != null;
    }

    public UserAccount loginManager(ConsoleService consoleService, int attempts) {
        boolean isLogin = false;
        while (!isLogin) {

            String loginId = consoleService.inputWithPrompt("Please input login id: ");
            String password = consoleService.inputWithPrompt("Please input login password: ");
            isLogin = login(loginId, password);

            if(!isLogin) {
                consoleService.printError("Login Failed! Please check your id and password.");
                if(attempts <= 0) {
                    consoleService.printError("=======Try too many! Login Aborted!=======");
                    return null;
                }
                consoleService.inputWithPrompt("");
                --attempts;
            }
        }
        consoleService.printMessage("Login Successfully!\n");
        consoleService.printMessage(loginUser.getUserProfile());
        return loginUser;
    }
}
