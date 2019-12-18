package com.omriyahoo.graphqlschemafirst.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.service.SpeakerService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class TalkResolver implements GraphQLResolver<Talk> {

    @Resource
    private SpeakerService speakerService;

    public List<Speaker> speakers(Talk talk) {
        return speakerService.findAllSpeakersForTalk(talk);
    }

}
