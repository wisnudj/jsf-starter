package com.github.jsfstarter.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.jsfstarter.dao.StudentDao;
import com.github.jsfstarter.model.Student;

import org.jdbi.v3.core.Jdbi;
import org.slf4j.Logger;

@Named
@ApplicationScoped
public class StudentService {
    @Inject    
    private Jdbi jdbi;

    @Inject
    private Logger log;

    public List<Student> findAll() {
        return jdbi.onDemand(StudentDao.class).getAllStudent();
    }
}
