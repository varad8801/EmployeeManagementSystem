package demo.EmployeeManagementSystem.Wrapper;

public class EmployeeWrapper {
	private int empId;
	private String empName;
	private String empDesignation;
	private String empDepartment;
	private String empEmailId;
	private long phNo;
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
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	public EmployeeWrapper(int empId, String empName, String empDesignation, String empDepartment, String empEmailId,
			long phNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDesignation = empDesignation;
		this.empDepartment = empDepartment;
		this.empEmailId = empEmailId;
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		return "EmployeeWrapper [empId=" + empId + ", empName=" + empName + ", empDesignation=" + empDesignation
				+ ", empDepartment=" + empDepartment + ", empEmailId=" + empEmailId + ", phNo=" + phNo + "]";
	}
}
