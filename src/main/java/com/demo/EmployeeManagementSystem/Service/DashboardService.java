package demo.EmployeeManagementSystem.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.EmployeeManagementSystem.DAO.EmployeeDao;
import demo.EmployeeManagementSystem.DAO.LogDao;
import demo.EmployeeManagementSystem.Model.Log;
import demo.EmployeeManagementSystem.Wrapper.LogWrapper;

@Service
public class DashboardService {
	@Autowired
	EmployeeDao empdao;
	
	@Autowired
	LogDao logdao;
	public long totalEmployees() {
		// TODO Auto-generated method stub
		
		return empdao.count();
	}
	public List<LogWrapper> recentActivity() {
		// TODO Auto-generated method stub
		List<Log> log=logdao.findAll();
		List<Log> lastFiveLogs;

		// Check if the list has fewer than 5 elements
		if (log.size() <= 5) {
		    lastFiveLogs = log;
		} else {
		    lastFiveLogs = log.subList(log.size() - 5, log.size());
		}
		
		List<LogWrapper> recentLog = new ArrayList<>();

		for (Log recent : lastFiveLogs) {
			recentLog.add(new LogWrapper(recent.getTimestamp().toLocalDateTime(), recent.getDetails()));
		}
		System.out.println(recentLog);
		return recentLog;
	}
	
}
