package com.testtask.repository;

import com.testtask.entity.Students;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentsRepository extends CrudRepository<Students, Integer> {
    List<Students> findByNumberGroup (Sort sort , String numberGroup);

    List<Students> findByNumberGroup (String numberGroup);

    List<Students> findByOrderByNameAsc();

}
