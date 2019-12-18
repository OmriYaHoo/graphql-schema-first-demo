package com.omriyahoo.graphqlschemafirst.repository;

import com.omriyahoo.graphqlschemafirst.pojo.SpeakerTalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakerTalkRepository extends JpaRepository<SpeakerTalk, Long> {

    List<SpeakerTalk> findAllBySpeakerId(Long speakerId);

    List<SpeakerTalk> findAllByTalkId(Long talkId);

}
