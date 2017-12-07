package com.amukoski.controller;

import com.amukoski.view.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LibraryController {

    private Menu menu;

    @Autowired
    public LibraryController(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        try (Scanner input = new Scanner(System.in)) {
            while (true) {
                menu.showMenu();
                menu.selectMenuItem(input.nextInt());
            }
        }
    }

}
