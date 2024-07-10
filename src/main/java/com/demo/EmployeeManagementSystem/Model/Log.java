package demo.EmployeeManagementSystem.Model;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;
@Component
public class Log {
	
	private long id ;
	private Timestamp timestamp;
	private String Details;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	@Override
	public String toString() {
		return "LogModel [id=" + id + ", timestamp=" + timestamp + ", Details=" + Details + "]";
	}
	
	
}
