package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.First_Name = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.Last_Name = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.Employee_Id = rs.getInt(EmployeeFieldNames.EMPLOUEE_ID);
		this.Active = rs.getString(EmployeeFieldNames.ACTIVE);
		this.Title = rs.getString(EmployeeFieldNames.TITLE);
		this.Manager = rs.getInt(EmployeeFieldNames.MANAGER);
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

	private String First_Name;
	public String getFirst_Name() {
		return this.First_Name;
	}
	public EmployeeEntity setFirst_Name(String First_Name) {
		if (!StringUtils.equals(this.First_Name, First_Name)) {
			this.First_Name = First_Name;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}
		
		return this;
	}

	private String Last_Name;
	public String getLast_name(){
		return this.Last_Name;
	}
	public EmployeeEntity setLast_Name(String Last_Name){
		if (!StringUtils.equals(this.Last_Name, Last_Name)){
			this.Last_Name = Last_Name;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}
		
		private int Employee_Id;
	public int getEmployee_Id() {
		return this.Employee_Id;
	}
	public EmployeeEntity setEmployee_Id(int Employee_Id) {
		if (!StringUtils.equals(this.Employee_Id, Employee_Id)) {
			this.Employee_Id = Employee_Id;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}
	
		private String Active;
	public String getActive() {
		return this.Active;
	}
	public EmployeeEntity setActive(String Active) {
		if (!StringUtils.equals(this.Active, Active)) {
			this.Active = Active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}
		
		return this;
	}
	
		private String Title;
	public String getTitle() {
		return this.Title;
	}
	public EmployeeEntity setTitle(String Title) {
		if (!StringUtils.equals(this.Title, Title)) {
			this.Title = Title;
			this.propertyChanged(EmployeeFieldNames.TITLE);
		}
		
		return this;
	}
	
		private int Manager;
	public int getManager() {
		return this.Manager;
	}
	public EmployeeEntity setManager(int Manager) {
		if (!StringUtils.equals(this.Manager, Manager)) {
			this.Manager = Manager;
			this.propertyChanged(EmployeeFieldNames.MANAGER);
		}
		
		return this;
	}
	
	private String Password;
	public String getPassword() {
		return this.Password;
	}
	public EmployeeEntity setPassword(String Password) {
		if (!StringUtils.equals(this.Password, Password)) {
			this.Password = Password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		
		return this;
	}
	
	
	public Employee synchronize(Employee apiEmployee) {
		this.setFirst_Name(apiEmployee.getFirst_Name());
		this.setLast_Name(apiEmployee.getLast_name());
		this.setEmployee_Id(apiEmployee.getEmployee_Id());
		this.setActive(apiEmployee.getActive());
		this.setTitle(apiEmployee.getTitle());
		this.setManager(apiEmployee.getManager());
		this.setPassword(apiEmployee.getPassword());
		apiEmployee.setId(this.getId());
		apiEmployee.setCreated(this.getCreated());
		
		return apiEmployee;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.Employee);
		
		this.First_Name = StringUtils.EMPTY;
		this.Last_Name = StringUtils.EMPTY;
		this.Employee_Id = StringUtils.EMPTY;
		this.Active = StringUtils.EMPTY;
		this.Title = StringUtils.EMPTY;
		this.Manager = StringUtils.EMPTY;
		this.Password = StringUtils.EMPTY;
	}
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.Employee);
		
		this.First_Name = apiEmployee.getFirst_Name();
		this.Last_Name = apiEmployee.getLast_name();
		this.Employee_Id = apiEmployee.getEmployee_Id();
		this.Active = apiEmployee.getActive();
		this.Title = apiEmployee.getTitle();
		this.Manager = apiEmployee.getManager();
		this.Password = apiEmployee.getPassword();
	}
}
