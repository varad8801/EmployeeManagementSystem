package demo.EmployeeManagementSystem.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import demo.EmployeeManagementSystem.Model.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
	List<Employee> findByempName(String empName);
	
}
