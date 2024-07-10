package demo.EmployeeManagementSystem.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.EmployeeManagementSystem.DAO.EmployeeDao;
import demo.EmployeeManagementSystem.Model.Employee;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao empdao;
	@Autowired
	LogService logser;
	
	
	public List<Employee> allEmployees() {
		
		
		try {
			return (List<Employee>) empdao.findAll();
		} catch (Exception e) {
			
			return new ArrayList<>(); 
		}
	}
	public Optional<Employee> getempById(int empId) {
        try {
            return empdao.findById(empId);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty(); // Return an empty Optional or handle the error accordingly
        }
    }
	
	public List<Employee> getempByName(String empName) {
		
		
		return empdao.findByempName(empName) ;
	}
	
	
	public String addEmployee(List<Employee> employee) {
        try {
            empdao.saveAll(employee);
            logser.insertLog(new Timestamp(System.currentTimeMillis()), employee.size()+" Employee Inserted");
            return "Added " + employee.size() + " employees";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error adding employees"; // Handle the error accordingly
        }
    }

	public String updateEmployees(List<Employee> employees) {
	    try {
	        for (Employee employee : employees) {
	            // Check if the employee exists in the database
	            if (empdao.existsById(employee.getEmpId())) {
	                // Update the employee record
	                empdao.save(employee);
	                logser.insertLog(new Timestamp(System.currentTimeMillis()), "Employee with id "+employee.getEmpId()+"  Updated");

	            } else {
	                // If the employee does not exist, return a message or handle the case
	                return "Employee with ID " + employee.getEmpId() + " does not exist";
	            }
	        }
            //logser.insertLog(new Timestamp(System.currentTimeMillis()), employees.size()+" Employee Updated");

	        return "Updated " + employees.size() + " employees";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error updating employees"; // Handle the error accordingly
	    }
	}

    public String deleteEmployees(int empId) {
        try {
        	//Optional<Employee> emp_to_del= empdao.findById(empId);
            
                empdao.deleteById(empId);
                
                logser.insertLog(new Timestamp(System.currentTimeMillis()), "Employee with Id "+empId+" Deleted");

            return "Deleted " + empId;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting employees"; // Handle the error accordingly
        }
    }

}
