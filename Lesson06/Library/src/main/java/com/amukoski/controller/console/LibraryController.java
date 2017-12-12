package com.amukoski.controller.console;

import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryController {

    private Menu menu;
    private InputReader inputReader;

    @Autowired
    public LibraryController(Menu menu, InputReader inputReader) {
        this.menu = menu;
        this.inputReader = inputReader;
    }

    public void run() {
        while (true) {
            menu.showMenu();
            Integer choice = Integer.valueOf(inputReader.readFromInput("Select command:"));
            menu.selectMenuItem(choice);
        }
    }

}
