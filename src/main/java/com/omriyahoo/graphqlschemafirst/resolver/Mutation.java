package com.omriyahoo.graphqlschemafirst.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import com.omriyahoo.graphqlschemafirst.pojo.SpeakerInput;
import com.omriyahoo.graphqlschemafirst.service.SpeakerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Mutation implements GraphQLMutationResolver {

    @Resource
    private SpeakerService speakerService;

    public Speaker addSpeaker(SpeakerInput si) {
        Speaker speaker = new Speaker();
        speaker.setName(si.getName());
        speaker.setTwitter(si.getTwitter());

        return speakerService.save(speaker);
    }

}
