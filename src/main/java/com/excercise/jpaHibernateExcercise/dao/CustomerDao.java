package com.excercise.jpaHibernateExcercise.dao;

import com.excercise.jpaHibernateExcercise.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {


}
