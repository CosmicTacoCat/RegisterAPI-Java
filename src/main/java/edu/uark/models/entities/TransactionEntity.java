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
		this.First_Name = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.Last_Name = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.Employee_Id = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
		this.Active = rs.getString(EmployeeFieldNames.ACTIVE);
		this.Title = rs.getString(EmployeeFieldNames.TITLE);
		this.Manager = rs.getString(EmployeeFieldNames.MANAGER);
		this.Password = rs.getString(EmployeeFieldNames.PASSWORD);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.FIRST_NAME, this.First_Name);
		record.put(EmployeeFieldNames.LAST_NAME, this.Last_Name);
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.Employee_Id);
		record.put(EmployeeFieldNames.ACTIVE, this.Active);
		record.put(EmployeeFieldNames.TITLE, this.Title);
		record.put(EmployeeFieldNames.MANAGER, this.Manager);
		record.put(EmployeeFieldNames.PASSWORD, this.Password);
		
		return record;
    }
    
    
}