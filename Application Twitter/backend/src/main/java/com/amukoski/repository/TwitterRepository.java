package com.amukoski.repository;

import com.amukoski.model.Twitter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TwitterRepository extends CrudRepository<Twitter, Long> {
    Twitter findByEmail(String email);
    List<Twitter> findByEmailContaining(String email);
}
