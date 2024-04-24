package org.example.model.school;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name", length=50)
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    @ManyToMany
    public Set<ClassRoom> classRooms = new HashSet<>();
}
