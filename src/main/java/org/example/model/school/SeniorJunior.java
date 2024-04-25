package org.example.model.school;

import javax.persistence.*;

@Entity
public class SeniorJunior {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="senior_junior_id")
    private Long id;

    @Column(name="name", length=50)
    private String name;

    public SeniorJunior(String name) {
        this.name = name;
    }

    public SeniorJunior() {

    }
}
