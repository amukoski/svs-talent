package com.amukoski.command.impl;

import com.amukoski.command.Command;
import com.amukoski.model.Book;
import com.amukoski.model.Member;
import com.amukoski.repository.BookRepository;
import com.amukoski.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Order(5) // only for menu view
@Component
public class LendBookCommand implements Command {

    private MemberRepository memberRepository;
    private BookRepository bookRepository;

    @Autowired
    public LendBookCommand(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public String commandName() {
        return "Lend Book";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Member[id]:");
        Long memberId = scanner.nextLong();
        System.out.print("Book[id]:");
        Long bookId = scanner.nextLong();

        Member member = memberRepository.findOne(memberId);
        Book book = bookRepository.findOne(bookId);

        if (member != null && book != null) {
            member.getBooks().add(book);
            memberRepository.save(member);

            System.out.println("Lending book: successful");
        } else {
            System.out.println("Member or Book doesn't exist!");
        }
    }
}
