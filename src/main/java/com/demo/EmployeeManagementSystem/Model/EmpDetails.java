package demo.EmployeeManagementSystem.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmpDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private Date empDOJ;
	private Date empDOB;
	private String empAddress;
	private long emergencyContact;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Date getEmpDOJ() {
		return empDOJ;
	}
	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}
	public Date getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(Date empDOB) {
		this.empDOB = empDOB;
	}
	
	
	
	public long getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(long emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "EmpDetails [Id=" + Id + ", empDOJ=" + empDOJ + ", empDOB=" + empDOB + ", empAddress=" + empAddress
				+ ", emergencyContact=" + emergencyContact + "]";
	}
	
	
	
	
	

}
