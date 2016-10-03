package com.twu.biblioteca.service;

import com.twu.biblioteca.businessLogic.extend.ConsoleService;
import com.twu.biblioteca.model.Menu;
import com.twu.biblioteca.enumeration.MenuTab;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConsoleServiceTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private ConsoleService consoleService;
    private ConsoleServiceMock consoleServiceMock;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        consoleService = new ConsoleService();
        consoleServiceMock = new ConsoleServiceMock();
    }

    @After
    public void tearDown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testShowWelcomeMessage() {
        consoleService.welcomeMessage();
        assertEquals(outContent.toString(), "\n===============Welcome to the Biblioteca!===============\n\n");
    }

    @Test
    public void testPrintGoodByeMessage() {
        consoleService.goodByeMessage();
        assertEquals(outContent.toString(), "\n===============Thank you for using the Biblioteca! Bye!===============\n\n");
    }

    @Test
    public void testPrintErrorMessage() {
        String message = "This is an error message.";
        consoleService.printError(message);
        assertEquals(errContent.toString(), message + "\n");
    }

    @Test
    public void testPrintMessage() {
        String message = "This is a message.";
        consoleService.printMessage(message);
        assertEquals(outContent.toString(), message + "\n");
    }

    @Test
    public void testChoseAnOptionMenu() {
        consoleServiceMock.setInputBuffer("1");
        int option = consoleServiceMock.chooseOption();
        assertEquals(option, 1);
    }

    @Test
    public void testInvalidWhenInputIsNull() {
        consoleServiceMock.setInputBuffer(null);
        int option = consoleServiceMock.chooseOption();
        assertEquals(option, 0);
    }

    @Test
    public void testIfInputIsNotIntegerAndReturnValidMenuTab() {
        consoleServiceMock.setInputBuffer("buffer");
        int option = consoleServiceMock.chooseOption();
        assertEquals(option, 0);
    }

    @Test
    public void it_shouldBeAbleToPrintMenuUserChoice() {
        List<Menu> menus = new ArrayList<Menu>(Arrays.asList(
                new Menu("List Books", MenuTab.LIST_ITEMS),
                new Menu("Checkout Book", MenuTab.CHECKOUT_ITEM),
                new Menu("Quit", MenuTab.QUIT)
        ));
        consoleService.printMenuPrompt(menus);
        assertEquals(outContent.toString(), "\n1.List Books      2.Checkout Book      3.Quit\n");
    }

    @Test
    public void it_shouldInputNothingWithUserChoice() throws IOException {
        String prompt = "please input: ";
        consoleService.getBufferedReader().close();
        String input = consoleService.inputWithPrompt(prompt);
        assertEquals(outContent.toString(), prompt);
        assertNull(input);
    }

    class ConsoleServiceMock extends ConsoleService {
        private String inputBuffer;
        public String inputWithPrompt(String prompt){
            return inputBuffer;
        }

        public void setInputBuffer(String inputBuffer) {
            this.inputBuffer = inputBuffer;
        }
    }
}
