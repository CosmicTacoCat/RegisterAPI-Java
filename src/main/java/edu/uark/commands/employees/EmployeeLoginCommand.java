package edu.uark.commands.employees;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeLogin;
import edu.uark.commands.employees.EmployeeLoginCommand;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeLoginCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		// //Validations
		// if (StringUtils.isBlank(this.apiEmployee.getEmployee_Id())) {
		// 	throw new UnprocessableEntityException("Employee ID");
		// }

		EmployeeEntity employeeEntity = this.employeeRepository.byEmployee_Id(this.apiEmployeeLogin.getEmployee_Id());
		if (employeeEntity != null) {
			throw new ConflictException("Employee ID"); //Employee ID already defined for another employee.
		}

		if(employeeEntity.getPassword() == this.apiEmployeeLogin.getPassword())
			return new Employee(employeeEntity);
		else
			throw new NotFoundException("Employee Login");

	}

	//Properties
	private EmployeeLogin apiEmployeeLogin;
	public EmployeeLogin getApiEmployeeLogin() {
		return this.apiEmployeeLogin;
	}
	public EmployeeLoginCommand setApiEmployee(EmployeeLogin apiEmployeeLogin) {
		this.apiEmployeeLogin = apiEmployeeLogin;
		return this;
	}

	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeLoginCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}

	public EmployeeLoginCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}
