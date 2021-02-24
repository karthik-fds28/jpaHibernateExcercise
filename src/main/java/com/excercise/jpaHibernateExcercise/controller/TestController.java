package com.excercise.jpaHibernateExcercise.controller;


import com.excercise.jpaHibernateExcercise.dao.*;
import com.excercise.jpaHibernateExcercise.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    CustomerDaoImpl customerDaoImpl;

    @Autowired
    CourseRepo courseRepo;

    @Autowired
    StudentRepo studentRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    BookRepo bookRepo;

    @PostMapping(value = "/saveCustomer")
    public void inserData(@RequestBody Customer customer) {

        customerDaoImpl.insertData(customer);

    }

    @GetMapping(value = "/getCustomers")
    public List<Customer> getCustomers() {
        return customerDaoImpl.getCustomers();
    }


    @GetMapping(value = "/postStudentAndCourseData")
    @Transactional
    public void addStudentAndCourse() {

        Student student = new Student();
        student.setName("Karthik");
        student.setAge(25);

        Course course = new Course();
        course.setAuthor("chethan bagath");
        course.setName("3 idiots");

        Course course2 = new Course();
        course2.setAuthor("chethan bagath");
        course2.setName("Girl Friend");


        student.addCourseList(course);
        student.addCourseList(course2);
        course.addStudentList(student);

        courseRepo.save(course);
        courseRepo.save(course2);
        studentRepo.save(student);
    }


    @GetMapping("/one-one-mapping-test")
    @Transactional
    public void oneToOneMappingTest() {

        Student student = new Student();
        student.setName("Karthik");
        student.setAge(25);


        //String doorNo, String streetName, String city, long pinCode
        Address address = new Address("1-5-6a", "westernstreet", "eluru", 534001);

        student.setAddress(address);

        Course course = new Course();
        course.setAuthor("chethan bagath");
        course.setName("3 idiots");

        Course course2 = new Course();
        course2.setAuthor("chethan bagath");
        course2.setName("Girl Friend");


        student.addCourseList(course);
        student.addCourseList(course2);
        course.addStudentList(student);

        addressRepo.save(address);
        courseRepo.save(course);
        courseRepo.save(course2);
        studentRepo.save(student);
    }

    @GetMapping("/one-many-mapping-test")
    @Transactional
    public void oneToManyMappingTest() {

        Student student = new Student();
        student.setName("Karthik");
        student.setAge(25);

        Book book1 = new Book();
        book1.setName("new1");
        book1.setStudent(student);

        Book book2 = new Book();
        book2.setName("new2");
        book2.setStudent(student);


        //String doorNo, String streetName, String city, long pinCode
        Address address = new Address("1-5-6a", "westernstreet", "eluru", 534001);

        student.setAddress(address);

        Course course = new Course();
        course.setAuthor("chethan bagath");
        course.setName("3 idiots");

        Course course2 = new Course();
        course2.setAuthor("chethan bagath");
        course2.setName("Girl Friend");


        student.addCourseList(course);
        student.addCourseList(course2);
        course.addStudentList(student);


        bookRepo.save(book1);
        bookRepo.save(book2);
        addressRepo.save(address);
        courseRepo.save(course);
        courseRepo.save(course2);
        studentRepo.save(student);
    }

}
