package com.excercise.jpaHibernateExcercise.model;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "add_seq")
    @SequenceGenerator(name = "add_seq", sequenceName = "address_seq", initialValue = 1, allocationSize = 10)
    private Long incrementId;

    private String doorNo;

    private String streetName;

    private String city;

    private long pinCode;

    @OneToOne(mappedBy = "address")
    private Student student;


    public Address() {
    }


    public Address(String doorNo, String streetName, String city, long pinCode) {
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.city = city;
        this.pinCode = pinCode;
    }

    public Long getIncrementId() {
        return incrementId;
    }

    public void setIncrementId(Long incrementId) {
        this.incrementId = incrementId;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPinCode() {
        return pinCode;
    }

    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
