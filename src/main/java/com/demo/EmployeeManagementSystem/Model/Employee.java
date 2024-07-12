package demo.EmployeeManagementSystem.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	private String empName;
	private String empDesignation;
	private String empDepartment;
	private String empEmailId;
	private long phNo;
	@OneToOne(cascade = CascadeType.ALL)
	private EmpDetails empDetails; 
	//@ManyToOne(cascade = CascadeType.ALL)
	private int managerId ;
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public EmpDetails getEmpDetails() {
		return empDetails;
	}
	public void setEmpDetails(EmpDetails empDetails) {
		this.empDetails = empDetails;
	}
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public int getmanagerId () {
		return managerId ;
	}
	public void setmanager (int managerId ) {
		this.managerId  = managerId ;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", empDepartment=" + empDepartment + ", empEmailId=" + empEmailId + ", phNo=" + phNo + ", empDetails="
				+ empDetails + ", managerId =" + managerId  + "]";
	}
	
	
}


