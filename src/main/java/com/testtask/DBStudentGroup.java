package com.testtask;

import com.testtask.entity.StudentsGroup;
import com.testtask.repository.StudentsGroupRepository;

public class DBStudentGroup{
    private StudentsGroupRepository studentsGroupRepository;

    public void createDB (String globalNumberGroup) {
        StudentsGroup studentsGroup = new StudentsGroup(globalNumberGroup,0);
       // StudentsGroup studentsGroups = studentsGroupRepository.findByNumberGroup(globalNumberGroup);
       // int count = studentsGroups.getCount();
       // studentsGroups.setCount(count + 1);
    }
}
