package com.consumer.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

 

import java.util.ArrayList;
import java.util.List;

 

@Component
public class TopicConsumer {
    
    private final List<String> messages = new ArrayList<>();

 

    @KafkaListener(topics = "BoatData", groupId = "kafka-sandbox")
    public void listen(String message) {
        
        synchronized (messages) {
            messages.add(message);
        }
    }

 

    public List<String> getMessages() {
        return messages;
    }
    

 

}
 