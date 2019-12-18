package com.omriyahoo.graphqlschemafirst.service;

import com.omriyahoo.graphqlschemafirst.pojo.Attendee;
import com.omriyahoo.graphqlschemafirst.pojo.AttendeeTalk;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.repository.AttendeeRepository;
import com.omriyahoo.graphqlschemafirst.repository.AttendeeTalkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    private final AttendeeTalkRepository attendeeTalkRepository;

    public AttendeeService(AttendeeRepository attendeeRepository, AttendeeTalkRepository attendeeTalkRepository) {
        this.attendeeRepository = attendeeRepository;
        this.attendeeTalkRepository = attendeeTalkRepository;
    }

    public List<Attendee> findAll() {
        return attendeeRepository.findAll();
    }

    public List<Attendee> findAllAttendeesForTalk(Talk talk) {
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
