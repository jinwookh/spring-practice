package org.example.model.school;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ClassRoomId implements Serializable {

    @Column(name = "class_room_id")
    private Long classRoomId;

    @ManyToOne
    @JoinColumn(name = "senior_junior_id", insertable = false, updatable = false)
    private SeniorJunior seniorJunior;

    public ClassRoomId(SeniorJunior seniorJunior) {
        this.seniorJunior = seniorJunior;
    }

    public ClassRoomId() {
    }
}
