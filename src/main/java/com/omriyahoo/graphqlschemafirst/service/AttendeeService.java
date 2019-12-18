package com.omriyahoo.graphqlschemafirst.service;

import com.omriyahoo.graphqlschemafirst.pojo.Attendee;
import com.omriyahoo.graphqlschemafirst.pojo.AttendeeTalk;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.repository.AttendeeRepository;
import com.omriyahoo.graphqlschemafirst.repository.AttendeeTalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendeeService {

    @Autowired
    private AttendeeRepository attendeeRepository;

    @Autowired
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<Attendee> findAll() {
        return attendeeRepository.findAll();
    }

    public List<Attendee> findAllAttendiesForTalk(Talk talk) {
        List<AttendeeTalk> at = attendeeTalkRepository.findAllByTalkId(talk.getId());

        return at.stream()
                .map(e -> attendeeRepository.findById(e.getAttendeeId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Attendee save(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }
}
