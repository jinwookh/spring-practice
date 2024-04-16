package org.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Person2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private BigInteger age2;
    private Date hello;
    private Calendar calendar;
    private BigDecimal bigDecimal;
    private Time time;

    public Person2(String name, int age, BigInteger age2, Date hello, Calendar calendar, BigDecimal bigDecimal, Time time) {
        this.name = name;
        this.age = age;
        this.age2 = age2;
        this.hello = hello;
        this.calendar = calendar;
        this.bigDecimal = bigDecimal;
        this.time = time;
    }

    public Person2() {

    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public BigInteger getAge2() {
        return age2;
    }

    public Date getHello() {
        return hello;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }
}
