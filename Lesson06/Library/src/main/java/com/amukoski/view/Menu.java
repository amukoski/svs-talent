package com.amukoski.view;

import com.amukoski.controller.console.command.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Menu {

    private List<Command> commandList;

    @Autowired
    public Menu(List<Command> commandList) {
        this.commandList = commandList;
    }

    public void showMenu() {
        System.out.println("-Menu------------------------");
        for (int i = 0; i < commandList.size(); i++) {
            System.out.printf(" %d: %s\n", i + 1, commandList.get(i).commandName());
        }
        System.out.println("-----------------------------");
    }

    public void selectMenuItem(Integer choice) {
        if (choice >= 1 && choice <= commandList.size()) {
            Command command = commandList.get(choice - 1);
            command.execute();
        }
    }
}
