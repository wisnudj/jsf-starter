package com.github.jsfstarter.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.jsfstarter.model.Student;
import com.github.jsfstarter.service.StudentService;

import org.omnifaces.cdi.ViewScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("helloBean")
@ViewScoped
public class HelloBean implements Serializable {
    private List<Student> students;

    @Inject
    private StudentService studentService;

    @PostConstruct
    public void init() {
        students = studentService.findAll();
    }

    public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
