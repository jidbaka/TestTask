package com.testtask.repository;

import com.testtask.entity.Students;
import com.testtask.entity.StudentsGroup;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsGroupRepository extends CrudRepository<StudentsGroup, Integer> {
    StudentsGroup findByNumberGroup (String numberGroup);

}
