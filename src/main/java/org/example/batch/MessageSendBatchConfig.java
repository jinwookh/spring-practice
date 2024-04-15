package org.example.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.*;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MessageSendBatchConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;;

    @Bean
    @JobScope
    public Step awsSnsSendStep() {
        return stepBuilderFactory.get("awsSnsSendStep")
                .tasklet(awsSnsSendTasklet())
                .build();
    }

    @Bean
    @StepScope
    public AwsSnsSendTasklet awsSnsSendTasklet() {
        return new AwsSnsSendTasklet();
    }

    @Bean
    public Job awsSnsSendJob(Step awsSnsSendStep) {
        return jobBuilderFactory.get("messageSendJob")
                .incrementer(new RunIdIncrementer())
                .start(awsSnsSendStep)
                .build();
    }
}
