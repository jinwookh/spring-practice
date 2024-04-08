package org.example.batch;

import org.example.Person;
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

import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;;

    @Bean
    public ItemReader<Person> reader() {
        return new ListItemReader<>(Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 35),
                new Person("Charlie", 25)
        ));
    }

    @Bean
    public ItemProcessor<Person, Person> processor() {
        return person -> person;
    }

    @Bean
    public JpaPersonWriter writer() {
        return new JpaPersonWriter();
    }

    @Bean
    @JobScope
    public Step step(ItemReader<Person> reader,
                     ItemProcessor<Person, Person> processor,
                     JpaPersonWriter writer) {
        return stepBuilderFactory.get("step")
                .<Person, Person>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("job")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }
}
