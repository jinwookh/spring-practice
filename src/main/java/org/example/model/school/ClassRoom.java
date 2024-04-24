package org.example.model.school;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long teacherId;

    @Column(nullable = false, length=50)
    private String className;

    @ManyToMany(mappedBy = "classRooms")
    public Set<Student> students = new HashSet<>();

    public ClassRoom(Long teacherId, String className) {
        this.teacherId = teacherId;
        this.className = className;
    }

    public ClassRoom() {

    }
}
