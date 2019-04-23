package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.TransactionEntity;

public class Transaction {
	private int trans_id;
	public int getTrans_Id() {
		return this.trans_id;
	}
	public Transaction setTrans_Id(int trans_id) {
		this.trans_id = trans_id;
		return this;
	}

	private UUID product_id;
	public UUID getProduct_Id() {
		return this.product_id;
	}
	public Transaction setProduct_Id(UUID product_id) {
		this.product_id = product_id;
		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public Transaction setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	private int sub_total;
	public int getSub_total() {
		return this.sub_total;
	}
	public Transaction setSub_total(int sub_total) {
		this.sub_total = sub_total;
		return this;
	}
	
	private int total;
	public int getTotal() {
		return this.total;
	}
	public Transaction setTotal(int total) {
		this.total = total;
		return this;
	}

	private int items;
	public int getItems() {
		return this.items;
	}
	public Transaction setItems(int items) {
		this.items = items;
		return this;
	}

	private boolean returnType;
	public boolean getReturn() {
		return this.returnType;
	}
	public Transaction setReturn(boolean returnType) {
		this.returnType = returnType;
		return this;
	}

	private UUID return_id;
	public UUID getReturn_Id() {
		return this.return_id;
	}
	public Transaction setReturn_Id(UUID return_id) {
		this.return_id = return_id;
		return this;
	}

	private String employee_id;
	public String getEmployee_Id() {
		return this.employee_id;
	}
	public Transaction setEmployee_Id(String employee_id) {
		this.employee_id = employee_id;
		return this;
	}

	public Transaction() {
		this.trans_id = -1;
		this.product_id = new UUID(0, 0);
		this.quantity = -1;
		this.sub_total = -1;
		this.total = -1;
		this.items = -1;
		this.returnType = false;
		this.return_id = new UUID(0,0);
		this.employee_id = "";
	}
	
	public Transaction(TransactionEntity transactionEntity) {
		this.trans_id = transactionEntity.getTrans_Id();
		this.total = transactionEntity.getTotal();
		this.items = transactionEntity.getItems();
		this.returnType = transactionEntity.getReturn();
		this.return_id = transactionEntity.getReturn_Id();
		this.employee_id = transactionEntity.getEmployee_Id();
	}
}
