package org.example.batch;

import org.example.model.Person;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class JpaPersonWriter implements ItemWriter<Person> {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void write(List<? extends Person> persons) throws Exception {
        for (Person person : persons) {
            entityManager.persist(person);
        }
    }
}
