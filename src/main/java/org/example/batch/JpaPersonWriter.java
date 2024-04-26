package org.example.batch;

import org.example.model.Person;
import org.example.model.Person3;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;

@Component
public class JpaPersonWriter implements ItemWriter<Person> {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private Person3Repository person3Repository;

    @Override
    @Transactional
    public void write(List<? extends Person> persons) throws Exception {

        Person person = personRepository.findById(1L).get();
        update(person);
        System.out.println("hello");

        Person3 person3 = new Person3(3L, "hello", 40, BigInteger.ONE);
        person3Repository.save(person3);
        System.out.println("processing");

        Person person2 = new Person("hello", 40, BigInteger.ONE);
        personRepository.save(person2);
        System.out.println("bye");

    }

    public void update(Person person) {
        person.setAge(100);
    }
}
