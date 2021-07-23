package com.task.netcafe.boom.model;

import java.util.ArrayList;
import java.util.List;

public class TotalPay {

    private Long id;

    private List<Transaction> bucket = new ArrayList<>();

    private Double total_price;
    
    private Double payment;
    
    private Double change;
     
    public TotalPay(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Transaction> getBucket() {
		return bucket;
	}

	public void setBucket(List<Transaction> bucket) {
		this.bucket = bucket;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public Double getPayment() {
		return payment;
	}

	public void setPayment(Double payment) {
		this.payment = payment;
	}

	public Double getChange() {
		return change;
	}

	public void setChange(Double change) {
		this.change = change;
	}

	
    
}
