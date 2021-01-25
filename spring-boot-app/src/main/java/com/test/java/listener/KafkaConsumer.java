package com.test.java.listener;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.test.java.model.TransDetails;
import com.test.java.repo.TransDetailsRepository;



@Service
public class KafkaConsumer {
    @Autowired
    TransDetailsRepository transDetailsRepository;

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }

    @KafkaListener(topics = "Kafka_Example_json", groupId = "group_json", containerFactory = "transDetailsKafkaListenerFactory")
    public void consumeJson(TransDetails transDetails) {
        System.out.println("Consumed JSON message: " + transDetails);
        transDetailsRepository.save(transDetails);
    }

    public TransDetails getTransDetailsByAccountNumber(String accountNumber) {
        return transDetailsRepository.findByAccountNumber(accountNumber);
    }
    
    public TransDetails getTransDetailsByType(String type) {
        return transDetailsRepository.findTopByType(type);
    }


    public List<TransDetails> getTransDetailsAccByTSRangeAndType(String accountNumber, String type, Date firstDate, Date secondDate) {
        return transDetailsRepository.findInTransTSRangeAndType(accountNumber, type, firstDate, secondDate);
    }
    
    public List<TransDetails> getTransDetailsAccByTSRange(String accountNumber, Date firstDate, Date secondDate) {
        return transDetailsRepository.findAccInTransTSRange(accountNumber, firstDate, secondDate);
    }
    
    public List<TransDetails> findAll(){
    	return transDetailsRepository.findAll();
    }
}