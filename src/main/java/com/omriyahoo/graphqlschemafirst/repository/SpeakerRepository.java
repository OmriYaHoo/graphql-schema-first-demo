package com.omriyahoo.graphqlschemafirst.repository;

import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
