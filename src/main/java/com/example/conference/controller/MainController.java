package com.example.conference.controller;

import com.example.conference.model.Room;
import com.example.conference.model.Schedule;
import com.example.conference.model.Talk;
import com.example.conference.model.User;
import com.example.conference.reposiroty.ScheduleRepository;
import com.example.conference.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ScheduleRepository scheduleRepository;


    @GetMapping("/main")
    public String getSchedule(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)principal;
        List<Schedule> schedules = new ArrayList<>();
        Schedule schedule = new Schedule();
        Talk talk = new Talk();
        talk.setName("О всяком");
        schedule.setDate(new Date());
        schedule.setRoom(new Room());
        schedule.setTalk(talk);
        schedules.add(schedule);
        schedules.addAll(scheduleRepository.findAll());
        model.addAttribute("schedules",schedules);
        model.addAttribute("currUser",user.getUsername());
        return "main";
    }
}