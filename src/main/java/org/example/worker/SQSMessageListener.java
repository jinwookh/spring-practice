package org.example.worker;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQSMessageListener {
    @Autowired
    private AmazonSQS amazonSQS;

    private final String queueUrl = "";

    @Scheduled(fixedRate = 10000)
    public void pollMessages() {
        List<Message> messages = amazonSQS.receiveMessage(queueUrl).getMessages();
        for(Message message : messages) {
            System.out.println("Received message: " + message.getBody());
            amazonSQS.deleteMessage(queueUrl, message.getReceiptHandle());
        }
    }
}
