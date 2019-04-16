package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.*;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Transaction;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;

public class TransactionEntity extends BaseEntity<TransactionEntity> 
{
    @Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		//this.First_Name = rs.getString(EmployeeFieldNames.FIRST_NAME);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		//record.put(EmployeeFieldNames.FIRST_NAME, this.First_Name);		
		return record;
    }
    
    public Transaction synchronize(Transaction apiTransaction) {
		//this.setFirst_Name(apiEmployee.getFirst_Name());
		
		
		//apiEmployee.setId(this.getId());
		//apiEmployee.setCreatedOn(this.getCreatedOn());
		
		return apiTransaction;
	}
	
	public TransactionEntity() {
		super(DatabaseTable.TRANSACTION);
		
		//this.First_Name = StringUtils.EMPTY;
		
	}
	
	public TransactionEntity(Transaction apiEmployee) {
		super(DatabaseTable.TRANSACTION);
		
		//this.First_Name = apiEmployee.getFirst_Name();
		
	}
}