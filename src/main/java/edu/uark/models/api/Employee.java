package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private UUID record_id;
	public UUID getId() {
		return this.record_id;
	}
	public Employee setId(UUID record_id) {
		this.record_id = record_id;
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
	
	private LocalDateTime created;
	public LocalDateTime getCreated() {
		return this.created;
	}
	public Employee setCreated(LocalDateTime created) {
		this.created = created;
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
		this.record_id = new UUID(0, 0);
		this.created = LocalDateTime.now();
	}
	
	public Employee(EmployeeEntity EmployeeEntity) {
		this.record_id = EmployeeEntity.getId();
		this.created = EmployeeEntity.getCreated();
		this.first_name = EmployeeEntity.getFirst_Name();
		this.last_name = EmployeeEntity.getLast_Name();
		this.employee_id = EmployeeEntity.getEmployee_Id();
		this.active = EmployeeEntity.getActive();
		this.title = EmployeeEntity.getTitle();
		this.manager = EmployeeEntity.getManager();
		this.password = EmployeeEntity.getPassword();
	}
}
