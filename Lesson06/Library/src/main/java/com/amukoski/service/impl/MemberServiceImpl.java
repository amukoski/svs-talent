package com.amukoski.service.impl;

import com.amukoski.model.Book;
import com.amukoski.model.Member;
import com.amukoski.repository.BookRepository;
import com.amukoski.repository.MemberRepository;
import com.amukoski.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;
    private BookRepository bookRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Member> listMembers() {
        return (List<Member>) memberRepository.findAll();
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Boolean deleteMember(Long id) {
        memberRepository.delete(id);
        return memberRepository.exists(id);
    }

    @Override
    public Member addBook(Long memberId, Long bookId) {
        Member member = memberRepository.findOne(memberId);
        Book book = bookRepository.findOne(bookId);

        if (member == null || book == null) {
            return null;
        }

        member.getBooks().add(book);
        return memberRepository.save(member);
    }
}
