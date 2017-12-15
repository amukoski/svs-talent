package com.amukoski.repository;

import com.amukoski.model.Tweet;
import com.amukoski.model.Twitter;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface TweetRepository extends CrudRepository<Tweet, Long> {
    List<Tweet> findAll(Sort sort);

    List<Tweet> findAllByTwitter_Id(Long id);

    List<Tweet> findAllByTwitterIn(Collection<Twitter> twitters, Sort sort);
}
