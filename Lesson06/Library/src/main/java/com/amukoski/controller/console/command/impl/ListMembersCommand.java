package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4) // only for menu view
@Component
public class ListMembersCommand implements Command {

    private MemberService memberService;

    @Autowired
    public ListMembersCommand(MemberService memberService) {
        this.memberService = memberService;
    }

    @Override
    public String commandName() {
        return "List Members";
    }

    @Override
    public void execute() {
        System.out.println("-Members---------------------");
        memberService.listMembers().forEach(System.out::println);
        System.out.println("-----------------------------");
    }
}
