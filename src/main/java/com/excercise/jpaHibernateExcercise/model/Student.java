package com.excercise.jpaHibernateExcercise.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_seq")
    @SequenceGenerator(name = "stu_seq", sequenceName = "student_seq", initialValue = 1, allocationSize = 10)
    private Long id;

    private String name;

    private int age;

    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "INCREMENTID")
    private Address address;

    @ManyToMany
    @JoinTable(name = "Student_Course",
            joinColumns = @JoinColumn(name = "Student_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id")
    )
    private List<Course> courseList = new ArrayList<>();

    @OneToMany(mappedBy = "bookId")
    private List<Book> booksList = new ArrayList<>();

    public List<Course> getCourseList() {
        return courseList;
    }

    public void addCourseList(Course course) {
        this.courseList.add(course);
    }

    public Student() {
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
