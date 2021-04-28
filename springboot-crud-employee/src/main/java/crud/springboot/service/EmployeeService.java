package crud.springboot.service;

import java.util.List;

import crud.springboot.entity.Employee;

public interface EmployeeService {
	
  public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
	

}
