package com.omriyahoo.graphqlschemafirst.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.omriyahoo.graphqlschemafirst.pojo.Attendee;
import com.omriyahoo.graphqlschemafirst.pojo.Human;
import com.omriyahoo.graphqlschemafirst.pojo.Speaker;
import com.omriyahoo.graphqlschemafirst.pojo.Talk;
import com.omriyahoo.graphqlschemafirst.service.AttendeeService;
import com.omriyahoo.graphqlschemafirst.service.SpeakerService;
import com.omriyahoo.graphqlschemafirst.service.TalkService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {

    @Resource
    private AttendeeService attendeeService;
    @Resource
    private SpeakerService speakerService;
    @Resource
    private TalkService talkService;

    public List<Talk> allTalks() {
        return talkService.findAll();
    }

    public List<Speaker> allSpeakers() {
        return speakerService.findAll();
    }

    public List<Attendee> allAttendees() {
        return attendeeService.findAll();
    }


    public List<Object> allPeople() {
        List<Attendee> attendees = attendeeService.findAll();
        List people = speakerService.findAll();

        people.addAll(attendees);
        return people;
    }

    public List<Human> allHumans() {
        List<Attendee> attendees = attendeeService.findAll();
        List people = speakerService.findAll();

        people.addAll(attendees);
        return people;
    }

}
