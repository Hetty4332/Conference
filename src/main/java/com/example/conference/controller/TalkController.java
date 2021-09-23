package com.example.conference.controller;

import com.example.conference.model.Talk;
import com.example.conference.model.User;
import com.example.conference.reposiroty.TalkRepository;
import com.example.conference.reposiroty.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TalkController {

    @Autowired
    private TalkRepository talkRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/talks/{login}")
    public String getTalks(Model model, @PathVariable("login") String login) {
        List<Talk> talks = new ArrayList<>();
        talks.addAll(talkRepository.findAll());
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)principal;
        model.addAttribute("currUser",user.getUsername());
        model.addAttribute("talks", talks);
        model.addAttribute("talk", new Talk());
        return "talks";
    }

    @PostMapping("/talks/{login}")
    public String addTalk(@ModelAttribute("talk") Talk talk,@PathVariable("login") String login)
    {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)principal;
        talk.getUsers().add(userRepository.findByUsername(user.getUsername()));
        talkRepository.save(talk);
        return "talks";
    }

}
