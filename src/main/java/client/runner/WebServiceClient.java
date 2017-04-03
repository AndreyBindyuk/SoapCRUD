package client.runner;

import client.runner.menu.MenuService;
import client.runner.menu.impl.MenuOperationsImpl;

import java.io.*;

public class WebServiceClient {

    public static void main(String[] args) throws IOException {
        MenuService menuService = new MenuOperationsImpl();
        menuService.menuOperations();
    }
}
