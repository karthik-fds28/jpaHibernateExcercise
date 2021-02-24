package com.excercise.jpaHibernateExcercise.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cou_Seq")
    @SequenceGenerator(name = "cou_Seq", initialValue = 1, sequenceName = "Course_seq", allocationSize = 10)
    private Long id;

    private String name;

    private String author;

    @ManyToMany(mappedBy = "courseList")
    private List<Student> studentList = new ArrayList<>();


    public Course() {
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudentList(Student student) {
        this.studentList.add(student);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
