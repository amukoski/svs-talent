package com.amukoski.repository;

import com.amukoski.model.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
