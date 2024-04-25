package org.example.batch;

import org.example.model.Person;
import org.example.model.Person2;
import org.example.model.school.*;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

@Component
public class JpaPersonWriter implements ItemWriter<Person> {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void write(List<? extends Person> persons) throws Exception {
        Person2 person2 = new Person2("hello", 20, BigInteger.ONE, Date.valueOf(LocalDate.now()), Calendar.getInstance(), BigDecimal.ONE, Time.valueOf(LocalTime.now()));
        Student student = new Student("hello");
        ClassRoom classRoom = new ClassRoom(2L, "history");
        SeniorJunior seniorJunior = new SeniorJunior("hello");

        entityManager.persist(seniorJunior);
        entityManager.flush();
        ClassRoomId id = new ClassRoomId(seniorJunior);
        ClassRoom2 classRoom2 = new ClassRoom2("bye", id);
        entityManager.persist(classRoom2);

    }
}
