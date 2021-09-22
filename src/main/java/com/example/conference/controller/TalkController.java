package com.example.conference.controller;

import com.example.conference.model.Room;
import com.example.conference.model.Schedule;
import com.example.conference.model.Talk;
import com.example.conference.reposiroty.TalkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TalkController {

    @Autowired
    private TalkRepository talkRepository;
    @GetMapping("/talks/{id}")
    public String getSchedule(Model model, @PathVariable("id") Long id) {
        List<Talk> talks = new ArrayList<>();
        talks.addAll(talkRepository.findAll());
        model.addAttribute("talks", talks);
        return "talks";
    }

}
