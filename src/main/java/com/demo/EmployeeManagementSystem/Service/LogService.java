package demo.EmployeeManagementSystem.Service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.EmployeeManagementSystem.DAO.LogDao;
import demo.EmployeeManagementSystem.Model.Log;

@Service
public class LogService {
	@Autowired
	LogDao logdao;
	public List<Log> getlogs() {
		
		return logdao.findAll();
	}
	
	public int insertLog(Timestamp timestamp,String details) {
		//System.out.println(">>>>>>>>>>>>>>>"+details);
		Log log=new Log();
		log.setTimestamp(timestamp);
		log.setDetails(details);
		
		return logdao.insertLog(log);
	}
	
	
}
