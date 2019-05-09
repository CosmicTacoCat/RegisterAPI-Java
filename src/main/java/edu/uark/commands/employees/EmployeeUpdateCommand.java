package edu.uark.commands.employees;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeUpdateCommand implements ResultCommandInterface<Employee> { 
	@Override
	public Employee execute() {
		//Validations
		if (StringUtils.isBlank(this.apiEmployee.getEmployee_Id())) {
			throw new UnprocessableEntityException("lookupcode");
		}

		EmployeeEntity employeeEntity = this.employeeRepository.get(this.recordId);
		if (employeeEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Employee");
		}

		this.apiEmployee = employeeEntity.synchronize(this.apiEmployee); //Synchronize any incoming changes for UPDATE to the database.

		employeeEntity.save(); //Write, via an UPDATE, any changes to the database.

		return this.apiEmployee;
	}

	//Properties
	private UUID recordId;
	public UUID getrecordId() {
		return this.recordId;
	}
	public EmployeeUpdateCommand setRecordId(UUID recordId) {
		this.recordId = recordId;
		return this;
	}

	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeUpdateCommand setApiEmployee(Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}

	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeUpdateCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}

	public EmployeeUpdateCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}
