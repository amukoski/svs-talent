package com.amukoski.command.impl;

import com.amukoski.command.Command;
import com.amukoski.model.Member;
import com.amukoski.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(2) // only for menu view
@Component
public class RegisterMemberCommand implements Command {

    private MemberRepository memberRepository;

    @Autowired
    public RegisterMemberCommand(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public String commandName() {
        return "Register Member";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Member[firstname]:");
        String firstName = scanner.nextLine();
        System.out.print("Member[lastname]:");
        String lastName = scanner.nextLine();

        Member savedMember = memberRepository.save(new Member(firstName, lastName));
        System.out.println("Saved: " + savedMember);
    }
}
