package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private UUID id;
	public UUID getId() {
		return this.id;
	}
	public Employee setId(UUID id) {
		this.id = id;
		return this;
	}
	
	private String first_name;
	public String getFirst_Name() {
		return this.first_name;
	}
	public Employee setFirst_Name(String first_name) {
		this.first_name = first_name;
		return this;
	}
	
	private String last_name;
	public String getLast_Name() {
		return this.last_name;
	}
	public Employee setLast_Name(String last_name) {
		this.last_name = last_name;
		return this;
	}
	
	private String employee_id;
	public String getEmployee_Id() {
		return this.employee_id;
	}
	public Employee setEmployee_Id(String employee_id) {
		this.employee_id = employee_id;
		return this;
	}
	
	private String active;
	public String getActive() {
		return this.active;
	}
	public Employee setActive(String active) {
		this.active = active;
		return this;
	}
	
	private String title;
	public String getTitle() {
		return this.title;
	}
	public Employee setTitle(String title) {
		this.title = title;
		return this;
	}
	
	private String manager;
	public String getManager() {
		return this.manager;
	}
	public Employee setManager(String manager) {
		this.manager = manager;
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}

	public Employee() {
		
		this.first_name = "";
		this.last_name = "";
		this.employee_id = "";
		this.active = "";
		this.title = "";
		this.manager = "";
		this.password = "";
		this.id = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.id = employeeEntity.getId();
		this.createdOn = employeeEntity.getCreatedOn();
		this.first_name = employeeEntity.getFirst_Name();
		this.last_name = employeeEntity.getLast_Name();
		this.employee_id = employeeEntity.getEmployee_Id();
		this.active = employeeEntity.getActive();
		this.title = employeeEntity.getTitle();
		this.manager = employeeEntity.getManager();
		this.password = employeeEntity.getPassword();
	}
}

