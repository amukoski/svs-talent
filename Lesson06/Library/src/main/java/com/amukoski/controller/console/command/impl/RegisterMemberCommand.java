package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.model.Member;
import com.amukoski.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2) // only for menu view
@Component
public class RegisterMemberCommand implements Command {

    private MemberService memberService;
    private InputReader inputReader;

    @Autowired
    public RegisterMemberCommand(MemberService memberService, InputReader inputReader) {
        this.memberService = memberService;
        this.inputReader = inputReader;
    }

    @Override
    public String commandName() {
        return "Register Member";
    }

    @Override
    public void execute() {
        String firstName = inputReader.readFromInput("Member[firstname]:");
        String lastName = inputReader.readFromInput("Member[lastname]:");

        Member savedMember = memberService.createMember(new Member(firstName, lastName));
        System.out.println("Saved: " + savedMember);
    }
}
