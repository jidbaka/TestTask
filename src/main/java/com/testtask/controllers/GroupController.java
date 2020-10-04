package com.testtask.controllers;

import com.testtask.entity.Students;
import com.testtask.entity.StudentsGroup;
import com.testtask.repository.StudentsGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GroupController {
    @Autowired
    private StudentsGroupRepository studentsGroupRepository;

    @GetMapping
    public String page (Map<String,Object> model){
        Iterable<StudentsGroup> studentsGroup =studentsGroupRepository.findAll();
        model.put("studentsGroup" , studentsGroup);
        return "main";
    }


}
