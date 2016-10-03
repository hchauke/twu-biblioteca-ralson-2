package biblioteca;


import biblioteca.enumeration.MenuTab;
import biblioteca.enumeration.Role;
import biblioteca.model.Menu;
import biblioteca.businessLogic.extend.BookService;
import biblioteca.businessLogic.ItemService;
import biblioteca.businessLogic.extend.MenuService;
import biblioteca.businessLogic.extend.MovieService;

public class LibraryRoleMenus {

    public static MenuService generateMenuServiceByRole(Role role) {

        MenuService menuService = new MenuService();
        ItemService bookService = new BookService();
        ItemService movieService = new MovieService();

        menuService.registerMainMenu(new Menu("List Books", MenuTab.LIST_ITEMS), bookService);
        menuService.registerMainMenu(new Menu("List Movies", MenuTab.LIST_ITEMS), movieService);

        switch (role) {
            case CUSTOMER:
                menuService.registerMainMenu(new Menu("Checkout Book", MenuTab.CHECKOUT_ITEM), bookService);
                menuService.registerMainMenu(new Menu("Checkout Movie", MenuTab.CHECKOUT_ITEM), movieService);
                menuService.registerMainMenu(new Menu("Return Book", MenuTab.RETURN_ITEM), bookService);
                menuService.registerMainMenu(new Menu("Return Movie", MenuTab.RETURN_ITEM), movieService);
                break;
            case LIBRARIAN:
                menuService.registerMainMenu(new Menu("Who Checked Books", MenuTab.LIST_CHECKED), bookService);
                menuService.registerMainMenu(new Menu("Who Checked Movies", MenuTab.LIST_CHECKED), movieService);
                break;
            default: break;
        }

        menuService.registerMainMenu(new Menu("My Profile", MenuTab.DISPLAY_PROFILE), null);
        menuService.registerMainMenu(new Menu("Quit", MenuTab.QUIT), null);

        return menuService;
    }
}
