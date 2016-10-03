package com.twu.biblioteca;

import com.twu.biblioteca.enumeration.MenuTab;
import com.twu.biblioteca.enumeration.Role;
import com.twu.biblioteca.model.Menu;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryFactoryTest {
    @Test
    public void should_be_able_generate_menu_service_by_role_of_customer() {
        MenuService menuService = LibraryRoleMenus.generateMenuServiceByRole(Role.CUSTOMER);
        List<Menu> menus = menuService.listMainMenus();
        assertTrue(menus.size() > 7);
        Assert.assertEquals(menus.get(2).getMenuTab(), MenuTab.CHECKOUT_ITEM);
    }

    @Test
    public void should_be_able_generate_menu_service_by_role_of_librarian() {
        MenuService menuService = LibraryRoleMenus.generateMenuServiceByRole(Role.LIBRARIAN);
        List<Menu> menus = menuService.listMainMenus();
        assertTrue(menus.size() > 5);
        Assert.assertEquals(menus.get(2).getMenuTab(), MenuTab.LIST_CHECKED);
    }

    @Test
    public void should_be_able_to_generate_menu_service_by_role_of_undefine() {
        MenuService menuService = LibraryRoleMenus.generateMenuServiceByRole(Role.UNDEFINE);
        List<Menu> menus = menuService.listMainMenus();
        assertTrue(menus.size() < 5);
    }
}
