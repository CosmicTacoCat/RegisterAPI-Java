package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employees.EmployeeByEmployeeIdQuery;
import edu.uark.commands.employees.EmployeeCreateCommand;
import edu.uark.commands.employees.EmployeeDeleteCommand;
import edu.uark.commands.employees.EmployeeLoginCommand;
import edu.uark.commands.employees.EmployeeQuery;
import edu.uark.commands.employees.EmployeeUpdateCommand;
import edu.uark.commands.employees.EmployeesQuery;
import edu.uark.models.api.Employee;
import edu.uark.models.api.EmployeeLogin;

@RestController
@RequestMapping(value = "/employee")

//Might need to use this as a reference when creating the existing employee search.
public class EmployeeRestController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		return (new EmployeesQuery()).execute();
	}

	@RequestMapping(value = "/{recordId}", method = RequestMethod.GET)
	public Employee getEmployee(@PathVariable UUID recordId) {
		return (new EmployeeQuery()).
			setRecordId(recordId).
			execute();
	}

	@RequestMapping(value = "/byEmployee_Id/{Employee_Id}", method = RequestMethod.GET)
	public Employee getEmployeeByEmployeeId(@PathVariable String employee_id) {
		return (new EmployeeByEmployeeIdQuery()).
			setEmployee_Id(employee_id).
			execute();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee employee) {
		return (new EmployeeCreateCommand()).
			setApiEmployee(employee).
			execute();
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Employee EmployeeLogin (@RequestBody EmployeeLogin employeeLogin) {
		return (new EmployeeLoginCommand()).
			setApiEmployeeLogin(employeeLogin).
			execute();
	}

	@RequestMapping(value = "/{recordId}", method = RequestMethod.PUT)
	public Employee updateEmployee(@PathVariable UUID recordId, @RequestBody Employee employee) {
		return (new EmployeeUpdateCommand()).
			setRecordId(recordId).
			setApiEmployee(employee).
			execute();
	}

	@RequestMapping(value = "/{recordId}", method = RequestMethod.DELETE)
	public void deleteEmployee(@PathVariable UUID recordId) {
		(new EmployeeDeleteCommand()).
			setRecordId(recordId).
			execute();
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}
