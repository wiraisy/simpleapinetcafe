package com.task.netcafe.boom.model;

public class Transaction {
    private Long id;
    private MainItem item;
    private Double quantity;
    private Double Subtotal;

    public Transaction() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MainItem getItem() {
		return item;
	}

	public void setItem(MainItem item) {
		this.item = item;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return Subtotal;
	}

	public void setSubtotal(Double subtotal) {
		Subtotal = subtotal;
	}

    
}