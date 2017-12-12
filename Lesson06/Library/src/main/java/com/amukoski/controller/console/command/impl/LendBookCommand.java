package com.amukoski.controller.console.command.impl;

import com.amukoski.controller.console.command.Command;
import com.amukoski.controller.console.inputreader.InputReader;
import com.amukoski.model.Book;
import com.amukoski.model.Member;
import com.amukoski.repository.BookRepository;
import com.amukoski.repository.MemberRepository;
import com.amukoski.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(5) // only for menu view
@Component
public class LendBookCommand implements Command {

    private MemberService memberService;
    private InputReader inputReader;

    @Autowired
    public LendBookCommand(MemberService memberService, InputReader inputReader) {
        this.memberService = memberService;
        this.inputReader = inputReader;
    }

    @Override
    public String commandName() {
        return "Lend Book";
    }

    @Override
    public void execute() {
        Long memberId = Long.valueOf(inputReader.readFromInput("Member[id]:"));
        Long bookId = Long.valueOf(inputReader.readFromInput("Book[id]:"));

        Member member = memberService.addBook(memberId, bookId);

        if (member != null) {
            System.out.println("Lending book: successful");
        } else {
            System.out.println("Member or Book doesn't exist!");
        }
    }
}
