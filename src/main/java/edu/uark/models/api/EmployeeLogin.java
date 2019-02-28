package edu.uark.models.api;

import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;

public class Employee {
	private String employee_id;
	public String getEmployee_Id() {
		return this.employee_id;
	}
	public Employee setEmployee_Id(String employee_id) {
		this.employee_id = employee_id;
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

	public Employee() {
		this.employee_id = "";
		this.password = "";
	}

	public Employee(EmployeeEntity EmployeeEntity) {
		this.employee_id = EmployeeEntity.getEmployee_Id();
		this.password = EmployeeEntity.getPassword();
	}
}
