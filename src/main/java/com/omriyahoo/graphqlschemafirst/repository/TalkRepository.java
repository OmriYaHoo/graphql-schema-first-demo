package com.omriyahoo.graphqlschemafirst.repository;

import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long> {

}
