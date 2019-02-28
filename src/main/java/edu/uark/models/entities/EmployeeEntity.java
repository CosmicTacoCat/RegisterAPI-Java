package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.*;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {

	public static DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.First_Name = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.Last_Name = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.Employee_Id = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
		this.Active = rs.getString(EmployeeFieldNames.ACTIVE);
		this.Title = rs.getString(EmployeeFieldNames.TITLE);
		this.Manager = rs.getString(EmployeeFieldNames.MANAGER);
		this.Password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.Created = LocalDateTime.parse(rs.getString(EmployeeFieldNames.CREATED),format);
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
		record.put(EmployeeFieldNames.CREATED, this.Created);
		
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
		return this;
	}
		private String Employee_Id;
	public String getEmployee_Id() {
		return this.Employee_Id;
	}
	public EmployeeEntity setEmployee_Id(String Employee_Id) {
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
	
	private String Manager;
	public String getManager() {
		return this.Manager;
	}
	public EmployeeEntity setManager(String Manager) {
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

	private LocalDateTime Created;
	public String getCreated() {
		return this.Created;
	}
	public LocalDateTime setCreated(LocalDateTime Created) {
		if(!StringUtils.equals(this.Created, Created))
		return this.Created;
	}
	
	
	public Employee synchronize(Employee apiEmployee) {
		this.setFirst_Name(apiEmployee.getFirst_Name());
		this.setLast_Name(apiEmployee.getLast_Name());
		this.setEmployee_Id(apiEmployee.getEmployee_Id());
		this.setActive(apiEmployee.getActive());
		this.setTitle(apiEmployee.getTitle());
		this.setManager(apiEmployee.getManager());
		this.setPassword(apiEmployee.getPassword());
		apiEmployee.setId(this.getId());
		this.setCreated(apiEmployee.getCreated());
		
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
