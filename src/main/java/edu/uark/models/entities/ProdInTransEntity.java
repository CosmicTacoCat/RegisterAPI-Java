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
import edu.uark.models.entities.fieldnames.ProdInTransFieldNames;

public class ProdInTransEntity extends BaseEntity<ProdInTransEntity> 
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
	public ProdInTransEntity setTrans_Id(UUID Trans_Id) {
		if (!(this.trans_id == Trans_Id)) {
			this.trans_id = Trans_Id;
			this.propertyChanged(ProdInTransFieldNames.TRANS_ID);
		}

		return this;
	}

	private UUID product_id;
	public UUID getProduct_Id() {
		return this.product_id;
	}
	public ProdInTransEntity setProduct_Id(UUID product_id) {
		if (!(this.product_id == product_id))
		{
			this.product_id = product_id;
			this.propertyChanged(ProdInTransFieldNames.PRODUCT_ID);
		}


		return this;
	}

	private int quantity;
	public int getQuantity() {
		return this.quantity;
	}
	public ProdInTransEntity setQuantity(int quantity) {
		if (!(this.quantity == quantity)) {
			this.quantity = quantity;
			this.propertyChanged(ProdInTransFieldNames.QUANTITY);
		}

		return this;
	}

	private int sub_total;
	public int getSub_total() {
		return this.sub_total;
	}
	public ProdInTransEntity setSub_total(int sub_total) {
		if (!(this.sub_total == sub_total)) {
			this.sub_total = sub_total;
			this.propertyChanged(ProdInTransFieldNames.SUB_TOTAL);
		}

		return this;
	}
	
	public ProdInTransEntity() {
		super(DatabaseTable.PRODUCT_IN_TRANSACTION);
		
		this.trans_id = new UUID(0,0);
		
	}
	
	public ProdInTransEntity(Transaction apiTransaction) {
		super(DatabaseTable.PRODUCT_IN_TRANSACTION);
		
		this.trans_id = apiTransaction.getTrans_Id();
		
	}
}