package edu.uark.commands.employees;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeByEmployeeIdQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.employee_id)) {
			throw new UnprocessableEntityException("Employee ID");
		}

		EmployeeEntity employeeEntity = this.employeeRepository.byEmployee_Id(this.employee_id);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Employee");
		}
	}

	//Properties
	private String employee_id;
	public String getEmployee_Id() {
		return this.employee_id;
	}
	public EmployeeByEmployeeIdQuery setEmployee_Id(String employee_id) {
		this.employee_id = employee_id;
		return this;
	}

	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeByEmployeeIdQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}

	public EmployeeByEmployeeIdQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
