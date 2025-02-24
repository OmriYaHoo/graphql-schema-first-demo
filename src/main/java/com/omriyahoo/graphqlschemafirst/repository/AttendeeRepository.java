package com.omriyahoo.graphqlschemafirst.repository;

import com.omriyahoo.graphqlschemafirst.pojo.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
