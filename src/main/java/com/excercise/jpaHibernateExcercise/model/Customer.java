package com.excercise.jpaHibernateExcercise.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Customer {

    //http://www.oracle.com/technetwork/middleware/ias/id-generation-083058.html
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
    //IF WE HAVE TRIGGER WE DONT NEED BELOW ANNOTATION DEFINITION-> it fecilitates us to perform efficient way if we dont use trigger to generate sequences
    //allocationSize is the same size should be defined that is defined in db side sequence INCREMENT_BY key respective value
    @SequenceGenerator(sequenceName = "customer_seq", initialValue = 1, allocationSize = 10, name = "CUST_SEQ")
    Long id;

    String name;
    String email;

    //@Temporal(TemporalType.DATE)
    @Column(name = "CREATED_DATE")
    Date date;

    public Customer(String name, String email, Date date) {
        this.name = name;
        this.email = email;
        this.date = date;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
