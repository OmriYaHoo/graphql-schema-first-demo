package com.omriyahoo.graphqlschemafirst.service;

import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import com.omriyahoo.graphqlschemafirst.pojo.SpeakerTalk;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.repository.SpeakerRepository;
import com.omriyahoo.graphqlschemafirst.repository.SpeakerTalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    @Autowired
    private SpeakerRepository speakerRepository;

    @Autowired
    private SpeakerTalkRepository speakerTalkRepository;

    public List<Speaker> findAll() {
        return speakerRepository.findAll();
    }

    public List<Speaker> findAllSpeakersForTalk(Talk talk) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllByTalkId(talk.getId());

        return st.stream()
                .map(e -> speakerRepository.findById(e.getSpeakerId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Speaker save(Speaker speaker) {
        return speakerRepository.save(speaker);
    }
}
