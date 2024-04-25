package org.example.model.school;

import javax.persistence.*;

@Entity
public class ClassRoom2 {
    @EmbeddedId
    private ClassRoomId id;

    @Column(name = "class_room_name")
    private String classRoomName;


    public ClassRoom2(String classRoomName, ClassRoomId classRoomId) {
        this.classRoomName = classRoomName;
        this.id = classRoomId;
    }

    public ClassRoom2() {

    }
}
