package com.github.jsfstarter.dao;

import java.util.List;

import com.github.jsfstarter.model.Student;

import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;

public interface StudentDao {
    @SqlQuery("SELECT * FROM student")
    @RegisterBeanMapper(Student.class)
    List<Student> getAllStudent();
}
