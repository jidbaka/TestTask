package com.testtask.controllers;

import com.testtask.entity.Students;
import com.testtask.entity.StudentsGroup;
import com.testtask.repository.StudentsGroupRepository;
import com.testtask.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Controller
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private  StudentsGroupRepository studentsGroupRepository;

    public String globalNumberGroup;

    @PostMapping("/groupPage")
    public String editGroup (@RequestParam String numberGroup, Map<String,Object> model, Model modelName){
        globalNumberGroup = numberGroup;
        StudentsGroup studentsGroup = studentsGroupRepository.findByNumberGroup(globalNumberGroup);
        if (studentsGroup == null) {
            studentsGroup = new StudentsGroup(globalNumberGroup, 0);
            studentsGroupRepository.save(studentsGroup);
        }
        Iterable<Students> student = studentsRepository.findByNumberGroup(Sort.by(Sort.Direction.ASC ,"name"), numberGroup);
        //student = studentsRepository.findByOrderByNameAsc();
        modelName.addAttribute("globalNumberGroup" , globalNumberGroup);
        model.put("students" , student);


        return "groupPage";
    }

    @PostMapping("/groupPage/add")
    public String add (@RequestParam String name, Map<String , Object> model, Model modelName){

        Date date = new Date();
        String dateString = new SimpleDateFormat("dd/MM/yyyy").format(date);
        Students students = new Students(name,dateString,globalNumberGroup);
        studentsRepository.save(students);
        Iterable<Students> student = studentsRepository.findByNumberGroup(Sort.by(Sort.Direction.ASC ,"name"), globalNumberGroup);

        StudentsGroup studentsGroups = studentsGroupRepository.findByNumberGroup(globalNumberGroup);
        int count =studentsGroups.getCount();
        studentsGroups.setCount(count+1);
        studentsGroupRepository.save(studentsGroups);
        modelName.addAttribute("globalNumberGroup" , globalNumberGroup);
        model.put("students" , student);

        return "groupPage";
    }

    @PostMapping("/groupPage/delete")
    public String delete (@RequestParam String id, Map<String , Object> model, Model modelName){

        Students students;
        Iterable<Students> student = studentsRepository.findByNumberGroup(Sort.by(Sort.Direction.ASC ,"name"), globalNumberGroup);
        student = studentsRepository.findByOrderByNameAsc();
        int numberId = Integer.parseInt(id);
        studentsRepository.deleteById(numberId);
       editGroup(globalNumberGroup ,model , modelName);

        StudentsGroup studentsGroups = studentsGroupRepository.findByNumberGroup(globalNumberGroup);
        int count =studentsRepository.findByNumberGroup(globalNumberGroup).size();
        studentsGroups.setCount(count);
        studentsGroupRepository.save(studentsGroups);

        return "groupPage";
    }
}