package com.amukoski.controller.web;

import com.amukoski.model.Member;
import com.amukoski.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> listMembers() {
        return memberService.listMembers();
    }

    @PostMapping
    public Member registerMember(@RequestBody Member member) {
        return memberService.createMember(member);
    }

    @PostMapping("{memberId}/books/{bookId}")
    public Member lendBook(@PathVariable("memberId") Long memberId, @PathVariable("bookId") Long bookId) {
        return memberService.addBook(memberId, bookId);
    }
}
