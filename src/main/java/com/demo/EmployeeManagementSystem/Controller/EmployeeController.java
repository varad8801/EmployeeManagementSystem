package demo.EmployeeManagementSystem.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.EmployeeManagementSystem.Model.Employee;
import demo.EmployeeManagementSystem.Service.EmployeeService;

@RestController
@RequestMapping("employee")
public class EmployeeController {
	@Autowired
	EmployeeService empser;
	@GetMapping("allEmployees")
	//@ResponseBody
	public List<Employee> allEmployees(){
		//System.out.println(empser.allEmployees());
		return empser.allEmployees();
	}
	
	@GetMapping("getempById")
	//@ResponseBody
	public Optional<Employee> getempById(@RequestBody Map<String, String> request){
		int empId = Integer.parseInt( request.get("empId"));
		return empser.getempById(empId);
	}
	
	@GetMapping("getempByName")
	//@ResponseBody
	public List<Employee> getempByName(@RequestBody Map<String, String> request){
		String empName = request.get("empName");
		return empser.getempByName(empName);
	}
	
	
	@PostMapping("add")
	public String addEmployee(@RequestBody List<Employee> employees) {
		System.out.println(">>"+employees);
		return empser.addEmployee(employees);
	}  
	
	@PutMapping("update")
	public String updateEmployees(@RequestBody List<Employee> employees) {
		return empser.updateEmployees(employees);
	}
	
	@DeleteMapping("delete")
	public String deleteEmployees(@RequestBody Map<String, String> request) {
		int empId = Integer.parseInt( request.get("empId"));
		return empser.deleteEmployees(empId);
	}
	
	
	
	
}
