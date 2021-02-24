package com.excercise.jpaHibernateExcercise.controller;


import com.excercise.jpaHibernateExcercise.dao.CourseRepo;
import com.excercise.jpaHibernateExcercise.dao.CustomerDaoImpl;
import com.excercise.jpaHibernateExcercise.dao.StudentRepo;
import com.excercise.jpaHibernateExcercise.model.Course;
import com.excercise.jpaHibernateExcercise.model.Customer;
import com.excercise.jpaHibernateExcercise.model.Student;
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

}
