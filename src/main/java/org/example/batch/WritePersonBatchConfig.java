package org.example.batch;

import org.example.model.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class WritePersonBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;;

    @Bean
    public ItemReader<Person> personReader() {
        return new ListItemReader<>(Arrays.asList(
                new Person("Alice", 30, BigInteger.ONE),
                new Person("Bob", 35, BigInteger.ONE),
                new Person("Charlie", 25, BigInteger.ONE)
        ));
    }

    @Bean
    public ItemProcessor<Person, Person> personProcessor() {
        return person -> person;
    }

    @Bean
    public JpaPersonWriter personWriter() {
        return new JpaPersonWriter();
    }

    @Bean
    @JobScope
    public Step writePersonStep(ItemReader<Person> personReader,
                     ItemProcessor<Person, Person> personProcessor,
                     JpaPersonWriter personWriter) {
        return stepBuilderFactory.get("step")
                .<Person, Person>chunk(10)
                .reader(personReader)
                .processor(personProcessor)
                .writer(personWriter)
                .build();
    }

    @Bean
    public Job writePersonJob(Step writePersonStep) {
        return jobBuilderFactory.get("personWriteJob")
                .incrementer(new RunIdIncrementer())
                .start(writePersonStep)
                .build();
    }
}
