import menu.MenuService;
import menu.impl.MenuOperationsImpl;

import java.io.IOException;

/**
 * Created by Andrey_Bindyuk on 4/19/2017.
 */
public class Runner {
    public static void main(String[] args) throws IOException {
        MenuService menuService = new MenuOperationsImpl();
        menuService.menuOperations();
    }
}
