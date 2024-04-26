package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Person3 {
    @Id
    private Long id;
    private String name;
    private int age;
    private BigInteger age2;

    public Person3(Long id, String name, int age, BigInteger age2) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.age2 = age2;
    }

    public Person3() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
