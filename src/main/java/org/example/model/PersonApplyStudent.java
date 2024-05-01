package org.example.model;

import org.example.model.school.Student;

import javax.persistence.*;

@Entity
@Table(name="\"personApplyStudent\"")
public class PersonApplyStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Person person;

    public PersonApplyStudent(Student student, Person person) {
        this.student = student;
        this.person = person;
    }

    public PersonApplyStudent() {

    }

    public Long getId() {
        return id;
    }
}
