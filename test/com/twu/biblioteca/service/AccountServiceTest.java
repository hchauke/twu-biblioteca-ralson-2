package com.twu.biblioteca.service;

import com.twu.biblioteca.LoginService;
import com.twu.biblioteca.businessLogic.extend.ConsoleService;
import com.twu.biblioteca.model.UserAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountServiceTest {
    private LoginService loginService;

    @Before
    public void setUp() {
        loginService = new LoginService();
    }

    @Test
    public void should_be_able_to_login() {
        boolean isLogin = loginService.login("100-0001", "123456");
        assertTrue(isLogin);
    }

    @Test
    public void should_not_login_when_password_is_incorrect() {
        boolean isLogin = loginService.login("100-0001", "654321");
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_when_user_id_not_exists() {
        boolean isLogin = loginService.login("xxx-xxxx", "123456");
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_when_user_id_or_password_is_null() {
        boolean isLogin = loginService.login("100-0001", null);
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_when_user_id_is_null() {
        boolean isLogin = loginService.login(null, "123456");
        assertFalse(isLogin);
    }

    @Test
    public void should_not_login_from_console_when_attempts_used_out() {
        UserAccount loginUser = loginService.loginManager(new ConsoleServiceMockAgain(), 5);
        assertNull(loginUser);
    }

    class ConsoleServiceMock extends ConsoleService {
        public String inputWithPrompt(String prompt) {
            if(prompt == "Please input login id: ") {
                return "111-1111";
            }
            if (prompt == "Please input login password: ") {
                return "123456";
            }
            return prompt;
        }

        public void printMessage(String message) {
        }

        public void printError(String error) {
        }
    }

    class ConsoleServiceMockAgain extends ConsoleServiceMock {
        public String inputWithPrompt(String prompt) {
            return prompt;
        }
    }
}
