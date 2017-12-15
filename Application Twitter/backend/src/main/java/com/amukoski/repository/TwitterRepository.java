package com.amukoski.repository;

import com.amukoski.model.Twitter;
import org.springframework.data.repository.CrudRepository;

public interface TwitterRepository extends CrudRepository<Twitter, Long> {
    Twitter findByEmail(String email);
}
