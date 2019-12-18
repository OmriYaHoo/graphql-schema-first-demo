package com.omriyahoo.graphqlschemafirst.service;

import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import com.omriyahoo.graphqlschemafirst.pojo.SpeakerTalk;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.repository.SpeakerRepository;
import com.omriyahoo.graphqlschemafirst.repository.SpeakerTalkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    private final SpeakerRepository speakerRepository;

    private final SpeakerTalkRepository speakerTalkRepository;

    public SpeakerService(SpeakerRepository speakerRepository, SpeakerTalkRepository speakerTalkRepository) {
        this.speakerRepository = speakerRepository;
        this.speakerTalkRepository = speakerTalkRepository;
    }

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
