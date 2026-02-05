package in.scalive.empmgmt.pojo;

public class EmpPojo {
	private int empNo;
	private String empName;
	private double empsal;
	private int deptno;
	
	@Override
	public String toString() {
		return "EmpPojo [empNo=" + empNo + ", empName=" + empName + ", empsal=" + empsal + ", deptno=" + deptno + "]";
	}
	
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpsal() {
		return empsal;
	}
	public void setEmpsal(double empsal) {
		this.empsal = empsal;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	
}
