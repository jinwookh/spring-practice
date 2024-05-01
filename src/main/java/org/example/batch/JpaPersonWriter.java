package org.example.batch;

import org.example.model.Person;
import org.example.model.Person3;
import org.example.model.PersonApplyStudent;
import org.example.model.school.Department;
import org.example.model.school.Student;
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
    private EntityManager em;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private Person3Repository person3Repository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional
    public void write(List<? extends Person> persons) throws Exception {

        Person person = personRepository.findById(1L).get();
        Student student = studentRepository.getById(1L);

        PersonApplyStudent personApplyStudent = new PersonApplyStudent(student, person);
        em.persist(personApplyStudent);
    }
}
