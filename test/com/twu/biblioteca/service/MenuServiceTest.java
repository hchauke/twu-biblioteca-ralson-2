package com.twu.biblioteca.service;

import com.twu.biblioteca.MenuService;
import com.twu.biblioteca.businessLogic.ItemService;
import com.twu.biblioteca.businessLogic.extend.BookService;
import com.twu.biblioteca.enumeration.MenuTab;
import com.twu.biblioteca.model.Menu;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MenuServiceTest {

    private MenuService menuService;
    private Menu listBooksMenu;
    private Menu quitMenu;
    private BookService bookService;

    @Before
    public void setUp() {
        menuService = new MenuService();
        listBooksMenu = new Menu("List Books", MenuTab.LIST_ITEMS);
        quitMenu = new Menu("Quit", MenuTab.QUIT);

        bookService = new BookService();
        menuService.registerMainMenu(listBooksMenu, bookService);
        menuService.registerMainMenu(quitMenu, null);
    }

    @Test
    public void should_be_able_to_get_main_menu() {
        List<Menu> menus = menuService.listMainMenus();

        assertFalse(menus.isEmpty());
        assertTrue(menus.contains(listBooksMenu));
        assertTrue(menus.contains(quitMenu));
    }

    @Test
    public void should_be_able_to_get_item_service() {
        ItemService itemService = menuService.getItemService(listBooksMenu);
        assertEquals(itemService, bookService);
    }

    @Test
    public void should_not_be_able_to_get_item_service() {
        ItemService itemService = menuService.getItemService(quitMenu);
        assertNull(itemService);
    }
}
