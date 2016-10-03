package com.twu.biblioteca.domain;

import com.twu.biblioteca.enumeration.MenuTab;
import com.twu.biblioteca.model.Menu;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void should_be_able_to_get_prompt_and_action() {
        Menu menu = new Menu("List Books", MenuTab.LIST_ITEMS);

        assertEquals(menu.getUserChoice(), "List Books");
    }

}