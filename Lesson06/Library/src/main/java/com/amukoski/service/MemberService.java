package com.amukoski.service;

import com.amukoski.model.Member;

import java.util.List;

public interface MemberService {
    List<Member> listMembers();

    Member createMember(Member member);

    Member updateMember(Member member);

    Boolean deleteMember(Long id);

    Member addBook(Long memberId, Long bookId);
}
