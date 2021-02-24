package com.excercise.jpaHibernateExcercise.dao;

import com.excercise.jpaHibernateExcercise.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {

}
