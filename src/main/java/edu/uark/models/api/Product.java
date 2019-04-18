package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.ProductEntity;

//Need to create an Employee class like this product one

public class Product {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Product setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String lookupCode;
	public String getLookupCode() {
		return this.lookupCode;
	}
	public Product setLookupCode(String lookupCode) {
		this.lookupCode = lookupCode;
		return this;
	}
	
	private int count;
	public int getCount() {
		return this.count;
	}
	public Product setCount(int count) {
		this.count = count;
		return this;
	}

	private int price;
	public int getPrice() {
		return this.price;
	}
	public Product setPrice(int price) {
		this.price = price;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Product setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public Product() {
		this.count = -1;
		this.price = -1;
		this.lookupCode = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
	}
	
	public Product(ProductEntity productEntity) {
		this.id = productEntity.getId();
		this.count = productEntity.getCount();
		this.price = productEntity.getPrice();
		this.createdOn = productEntity.getCreatedOn();
		this.lookupCode = productEntity.getLookupCode();
	}
}
