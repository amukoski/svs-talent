package com.amukoski.view;

import com.amukoski.controller.console.command.Command;
import com.amukoski.security.exception.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {

    private List<Command> commands;

    @Autowired
    public Menu(List<Command> commands) {
        this.commands = commands;
    }

    public void showMenu() {
        System.out.println("-Menu------------------------");
        for (int i = 0; i < commands.size(); i++) {
            System.out.printf(" %d: %s\n", i + 1, commands.get(i));
        }
        System.out.println("-----------------------------");
    }

    public void selectMenuItem(Integer choice) {
        if (choice >= 1 && choice <= commands.size()) {
            Command command = commands.get(choice - 1);

            try {
                command.execute();
            } catch (AuthenticationException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }
}
