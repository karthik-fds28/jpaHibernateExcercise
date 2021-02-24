package com.excercise.jpaHibernateExcercise.model;


import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_Seq")
    @SequenceGenerator(name = "book_Seq", initialValue = 1, sequenceName = "book_sequence", allocationSize = 10)
    private Long bookId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "STUDENT_ID", referencedColumnName = "id")
    private Student student;

    public Book() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
