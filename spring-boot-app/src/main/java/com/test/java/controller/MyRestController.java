package com.test.java.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.java.listener.KafkaConsumer;
import com.test.java.model.TransDetails;


@RestController
@RequestMapping("/transDetails")
public class MyRestController {
    @Autowired
    private KafkaConsumer consumer;

    @GetMapping(path = "/findTransDetailsByAccountNumber/{accountNumber}")
    public TransDetails getTransDetailsByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return consumer.getTransDetailsByAccountNumber(accountNumber);
    }
    
    @GetMapping(path = "/findTransDetailsByType/{type}")
    public TransDetails getTransDetailsByType(@PathVariable("type") String type) {
        return consumer.getTransDetailsByType(type);
    }

    @GetMapping(path = "/findTransDetailsAccByTSRange/{accountNumber}/{firstDate}/{secondDate}")
    public List<TransDetails> getTransDetailsAccByTSRange(@PathVariable("accountNumber") String accountNumber, @PathVariable("firstDate") String firstDate, @PathVariable("secondDate") String secondDate) {
        return consumer.getTransDetailsAccByTSRange(accountNumber, dateConvertor(firstDate), dateConvertor(secondDate));
    }
    
    @GetMapping(path = "/findTransDetailsAccByTSRangeAndType/{accountNumber}/{firstDate}/{secondDate}/{type}")
    public List<TransDetails> getTransDetailsAccByTSRangeAndType(@PathVariable("accountNumber") String accountNumber, @PathVariable("firstDate") String firstDate, @PathVariable("secondDate") String secondDate, @PathVariable("type") String type) {
        return consumer.getTransDetailsAccByTSRangeAndType(accountNumber, type, dateConvertor(firstDate), dateConvertor(secondDate));
    }
    
    @GetMapping("/all")
    public List<TransDetails> getAll(){
    	return consumer.findAll();
    }
    
    public Date dateConvertor(String dateInString) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//      String dateInString = "2021-01-22";
        Date date =null;
        try {
        	date = formatter.parse(dateInString);
            return date;
        } catch (Exception e) {e.printStackTrace();}
        return date;
    }
}