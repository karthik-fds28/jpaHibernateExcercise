package com.excercise.jpaHibernateExcercise.dao;

import com.excercise.jpaHibernateExcercise.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerDaoImpl {

    @Autowired
    CustomerDao customerDao;

    @Transactional
    public void insertData(Customer customer) {
        customerDao.save(customer);
    }

    public List<Customer> getCustomers() {
        List<Customer> all = customerDao.findAll();
        return all;
    }
}

