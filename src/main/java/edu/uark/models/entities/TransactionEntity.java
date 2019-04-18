package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.*;
import java.util.UUID;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.TransactionFieldNames;

public class TransactionEntity extends BaseEntity<TransactionEntity> 
{
    @Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		//record.put(TransactionFieldNames.TRANS_ID, this.trans_id);		
		return record;
    }
    
    public Transaction synchronize(Transaction apiTransaction) {
		this.setTrans_Id(apiTransaction.getTrans_Id());
		
		
		apiTransaction.setTrans_Id(this.getId());
		//apiTransaction.setCreatedOn(this.getCreatedOn());
		
		return apiTransaction;
	}

	private UUID trans_id;
	public UUID getTrans_Id() {
		return this.trans_id;
	}
	public TransactionEntity setTrans_Id(UUID Trans_Id) {
		if (!(this.trans_id == Trans_Id)) {
			this.trans_id = Trans_Id;
			this.propertyChanged(TransactionFieldNames.TRANS_ID);
		}

		return this;
	}

	private UUID product_id;
	public UUID getProduct_Id() {
		return this.product_id;
	}
	public TransactionEntity setProduct_Id(UUID product_id) {
		if (!(this.product_id == product_id))
		{
			this.product_id = product_id;
			this.propertyChanged(TransactionFieldNames.PRODUCT_ID);
		}


		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public TransactionEntity setQuantity(int quantity) {
		if (!(this.quantity == quantity)) {
			this.quantity = quantity;
			this.propertyChanged(TransactionFieldNames.QUANTITY);
		}

		return this;
	}

	private int sub_total;
	public int getSub_total() {
		return this.sub_total;
	}
	public TransactionEntity setSub_total(int sub_total) {
		if (!(this.sub_total == sub_total)) {
			this.sub_total = sub_total;
			this.propertyChanged(TransactionFieldNames.SUB_TOTAL);
		}

		return this;
	}
	
	private int total;
	public int getTotal() {
		return this.total;
	}
	public TransactionEntity setTotal(int total) {
		if (!(this.total == total)) {
			this.total = total;
			this.propertyChanged(TransactionFieldNames.TOTAL);
		}

		return this;
	}

	private int items;
	public int getItems() {
		return this.items;
	}
	public TransactionEntity setItems(int items) {
		if (!(this.items == items)) {
			this.items = items;
			this.propertyChanged(TransactionFieldNames.ITEMS);
		}

		return this;
	}

	private boolean returnType;
	public boolean getReturn() {
		return this.returnType;
	}
	public TransactionEntity setReturn(boolean returnType) {
		if (!(this.returnType == returnType)) {
			this.returnType = returnType;
			this.propertyChanged(TransactionFieldNames.RETURNTYPE);
		}

		return this;
	}

	private UUID return_id;
	public UUID getReturn_Id() {
		return this.return_id;
	}
	public TransactionEntity setReturn_Id(UUID return_id) {
		if (!(this.return_id == return_id)) {
			this.return_id = return_id;
			this.propertyChanged(TransactionFieldNames.RETURN_ID);
		}

		return this;
	}

	private String employee_id;
	public String getEmployee_Id() {
		return this.employee_id;
	}
	public TransactionEntity setEmployee_Id(String employee_id) {
		if (!(this.employee_id == employee_id)) {
			this.employee_id = employee_id;
			this.propertyChanged(TransactionFieldNames.EMPLOYEE_ID);
		}

		return this;
	}
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);
		
		this.trans_id = new UUID(0,0);
		
	}
	
	public TransactionEntity(Transaction apiTransaction) {
		super(DatabaseTable.TRANSACTION);
		
		this.trans_id = apiTransaction.getTrans_Id();
		
	}
}