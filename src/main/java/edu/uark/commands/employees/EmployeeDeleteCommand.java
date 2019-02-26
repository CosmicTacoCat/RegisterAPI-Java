package edu.uark.commands.employees;

import java.util.UUID;

import edu.uark.commands.VoidCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeDeleteCommand implements VoidCommandInterface {
	@Override
	public void execute() {
		EmployeeEntity employeeEntity = this.employeeRepository.get(this.recordId);
		if (employeeEntity == null) { //No record with the associated record ID exists in the database.
			throw new NotFoundException("Product");
		}

		employeeEntity.delete();
	}

	//Properties
	private UUID recordId;
	public UUID getRecordId() {
		return this.recordId;
	}
	public EmployeeDeleteCommand setRecordId(UUID recordId) {
		this.recordId = recordId;
		return this;
	}

	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeDeleteCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.eroductRepository = eroductRepository;
		return this;
	}

	public EmployeeDeleteCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}
