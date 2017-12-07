package com.amukoski.command.impl;

import com.amukoski.command.Command;
import com.amukoski.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(4) // only for menu view
@Component
public class ListMembersCommand implements Command {

    private MemberRepository memberRepository;

    @Autowired
    public ListMembersCommand(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String commandName() {
        return "List Members";
    }

    @Override
    public void execute() {
        System.out.println("-Members---------------------");
        memberRepository.findAll().forEach(System.out::println);
        System.out.println("-----------------------------");
    }
}
