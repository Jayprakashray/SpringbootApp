package com.test.java.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TransDetails {
    @Id
    private String transId;
    private String accountNumber;
    private Date transactionTs;
    private String type;
    private Double amount;
    private Date lastUpdateTimestamp;
    
    public TransDetails(String accountNumber, Date transactionTs, String type, Double amount, Date lastUpdateTimestamp) {
        super();
        this.accountNumber = accountNumber;
        this.transactionTs = transactionTs;
        this.type = type;
        this.amount = amount;
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public TransDetails() {
        super();
    }

    
    public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getTransactionTs() {
		return transactionTs;
	}

	public void setTransactionTs(Date transactionTs) {
		this.transactionTs = transactionTs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getLastUpdateTimestamp() {
		return lastUpdateTimestamp;
	}

	public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
		this.lastUpdateTimestamp = lastUpdateTimestamp;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	@Override
    public String toString() {
        return "TransDetails [accountNumber=" + accountNumber + ", type=" + type + ", amount=" + amount + "]";
    }
}