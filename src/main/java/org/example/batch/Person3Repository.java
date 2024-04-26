package org.example.batch;

import org.example.model.Person;
import org.example.model.Person3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Person3Repository extends JpaRepository<Person3, Long> {

}
