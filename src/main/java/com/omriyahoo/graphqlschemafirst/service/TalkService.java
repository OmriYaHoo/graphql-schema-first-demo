package com.omriyahoo.graphqlschemafirst.service;

import com.omriyahoo.graphqlschemafirst.pojo.*;
import com.omriyahoo.graphqlschemafirst.repository.AttendeeTalkRepository;
import com.omriyahoo.graphqlschemafirst.repository.SpeakerTalkRepository;
import com.omriyahoo.graphqlschemafirst.repository.TalkRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TalkService {

    @Resource
    private TalkRepository talkRepository;

    @Resource
    private SpeakerTalkRepository speakerTalkRepository;

    @Resource
    private AttendeeTalkRepository attendeeTalkRepository;

    public List<Talk> findAll() {
        return talkRepository.findAll();
    }

    public List<Talk> findAllTalksBySpeaker(Speaker speaker) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllBySpeakerId(speaker.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Talk> findAllTAlksByAttendee(Attendee attendee) {
        List<AttendeeTalk> st = attendeeTalkRepository.findAllByAttendeeId(attendee.getId());

        return st.stream()
                .map(e -> talkRepository.findById(e.getTalkId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

    }
}
