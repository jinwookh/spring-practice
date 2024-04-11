package org.example.batch;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AwsSnsSendTasklet implements Tasklet {

    @Autowired
    AmazonSNS amazonSNS;

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {


        PublishRequest publishRequest = new PublishRequest("arn:aws:sns:ap-northeast-2:872091133958:test-sns", "hello");
        amazonSNS.publish(publishRequest);
        System.out.println("amazonSns sent");
        return RepeatStatus.FINISHED;
    }
}
