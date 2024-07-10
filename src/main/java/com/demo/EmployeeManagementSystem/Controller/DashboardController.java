package demo.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.EmployeeManagementSystem.Service.DashboardService;
import demo.EmployeeManagementSystem.Wrapper.LogWrapper;

@RestController
@RequestMapping("dashboard")
public class DashboardController {
	@Autowired
	DashboardService dashser;
	@GetMapping("totalEmployees")
	@ResponseBody
	public long totalEmployees(){
		//System.out.println(empser.allEmployees());
		return dashser.totalEmployees();
	}
	
	@GetMapping("recentActivity")
	@ResponseBody
	public List<LogWrapper> recentActivity(){
		//System.out.println(empser.allEmployees());
		return dashser.recentActivity();
	}
	

	
}
