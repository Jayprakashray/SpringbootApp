package com.test.java.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.java.model.TransDetails;

@Repository
public interface TransDetailsRepository extends MongoRepository<TransDetails, String>{	
	TransDetails findByAccountNumber(String accountnumber);
	TransDetails findTopByType(String type);
	
    @Query("{'accountNumber' : ?0 ,'transactionTs' : { $gte: ?1, $lte: ?2 }}")
    List<TransDetails> findAccInTransTSRange(String accountNumber, Date firstDate, Date secondDate);
    
	@Query("{'accountNumber' : ?0 , 'type' : ?1, 'transactionTs' : { $gte: ?2, $lte: ?3 }}")
    List<TransDetails> findInTransTSRangeAndType(String accountNumber, String type, Date firstDate, Date secondDate);
    
    List<TransDetails> findAll();
}