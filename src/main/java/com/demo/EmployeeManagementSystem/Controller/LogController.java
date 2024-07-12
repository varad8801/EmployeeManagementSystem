package demo.EmployeeManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.EmployeeManagementSystem.Model.Log;
import demo.EmployeeManagementSystem.Service.LogService;


@Controller
@RequestMapping("log")
public class LogController {
	
	@Autowired
	LogService logser;
	@GetMapping("getlogs")
	//@ResponseBody
	public List<Log> getlogs(){
		System.out.println(logser.getlogs());
		return logser.getlogs();
	}
	
}
