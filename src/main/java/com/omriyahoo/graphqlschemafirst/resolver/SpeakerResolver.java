package com.omriyahoo.graphqlschemafirst.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.service.TalkService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SpeakerResolver implements GraphQLResolver<Speaker> {

    @Resource
    private TalkService talkService;

    public List<Talk> talks(Speaker speaker) {
        return talkService.findAllTalksBySpeaker(speaker);
    }
}
