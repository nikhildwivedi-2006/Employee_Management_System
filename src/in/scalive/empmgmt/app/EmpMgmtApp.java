package in.scalive.empmgmt.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import in.scalive.empmgmt.dao.EmpDao;
import in.scalive.empmgmt.dbutil.DBConnection;
import in.scalive.empmgmt.pojo.EmpPojo;

public class EmpMgmtApp {
	
	static  Scanner kb = new Scanner (System.in);
	
	public static void main(String[] args) {
		
		
		System.out.println("welcome to Employee Management App");
		int choice;
		do {
			System.out.println(" Select an operation");
			System.out.println("1.Add Emp\n2.Search Emp\n3.View All\n4.Delete Emp By Id\n5.Delete Emp by name\n6.update Emp\n7.Quit  ");
			
			choice = kb.nextInt();
			switch(choice ) {
			case 1->  addEmp();
			case 2->  searchEmp();
			case 3->  viewAllEmp();
			case 4->  deleteById();
			case 5->  deleteByName();
			case 6->  updateEmp();
			case 7-> {
				System.out.println("Thank you for using the app ");
				DBConnection.closeConnection();
			}
			
			default ->System.out.println("wrong option . Try again ");
			
			}
		}
		while(choice !=7);
		}
	  public static void addEmp() {
		System.out.println("Enter Empno :");
		int eno = kb.nextInt();
		
		System.out.println("Enter ename : ");
		String ename = kb.next();
		
		System.out.println("Enter sal : ");
		double sal = kb.nextDouble();
		
		System.out.println("Enter deptno ");
		int deptno = kb.nextInt();
		
		EmpPojo  emp = new EmpPojo();
		emp.setEmpNo(eno);
		emp.setEmpName(ename);
		emp.setEmpsal(sal);
		emp.setDeptno(deptno);
		
		try {
			boolean res = EmpDao.addEmp(emp);
			if(res)
				System.out.println("Record added : ");
			
			else {
				System.out.println("Record not added ");
			}
			
		}
		catch(SQLException ex) {
			System.out.println("Error in adding records "+ex.getMessage());
		}
		
	}
	  public static void searchEmp() {
		  System.out.println("Enter empno whose rec is to be searched : ");
		  int eno = kb.nextInt();
		  try {
			 EmpPojo emp = EmpDao.searchEmpById(eno);
			 System.out.println(emp);
		  }catch(SQLException ex) {
			   System.out.println("Error in searching rec: "+ ex.getMessage());
		  }
	  }
	  
	  public static void viewAllEmp() {
		  try {
			  List<EmpPojo> empList = EmpDao.getAllemployees();
			  if(empList.isEmpty()) {
				  System.out.println("No records to display ");
			  }else {
				  for(EmpPojo emp:empList) {
					  System.out.println(emp);
				  }
			  }
		  }catch(SQLException ex) {
			  System.out.println("Error in display records : "+ex.getMessage());
		  }
	  }
	  public static void deleteById() {
		  System.out.println("Enter Empno to be deleted : ");
		  int eno = kb.nextInt();
		  try {
			  boolean res = EmpDao.deleteEmp(eno);
			  if(res)
				  System.out.println("Record Deleted : ");
			  else
				  System.out.println("Record not deleted ");
		  }catch(SQLException ex) {
			  System.out.println("Error in deleting  rec : "+ex.getMessage());
		  }
	  }
	  
	  public static void deleteByName() {
		  System.out.println("Enter Ename to be deleted : ");
		   String ename  = kb.next();
		  try {
			  boolean res = EmpDao.deleteEmp(ename);
			  if(res)
				  System.out.println("Record Deleted : ");
			  else
				  System.out.println("Record not deleted ");
		  }catch(SQLException ex) {
			  System.out.println("Error in deleting rec : "+ex.getMessage());
		  }
	  }
	  
	  public static void updateEmp() {
		  
		  System.out.println("Enter Empno to be updated : ");
		  int eno = kb.nextInt();
		    
		System.out.println("Enter ename to be updated  : ");
		String ename = kb.next();
			
		System.out.println("Enter sal to be updated  : ");
		double sal = kb.nextDouble();
				
		System.out.println("Enter deptno to be updated : ");
		int deptno = kb.nextInt();
		
		EmpPojo  emp = new EmpPojo();
		emp.setEmpName(ename);
		emp.setEmpsal(sal);
		emp.setDeptno(deptno);

		
		  try {
			  boolean res = EmpDao.updateEmp(eno , emp);
			  if(res)
				  System.out.println("Record updated : ");
			  else
				  System.out.println("Record not update ");
		  }catch(SQLException ex) {
			  System.out.println("Error in updating rec : "+ex.getMessage());
		  }
	  }
}
