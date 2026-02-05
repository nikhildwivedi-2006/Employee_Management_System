package in.scalive.empmgmt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.scalive.empmgmt.dbutil.DBConnection;
import in.scalive.empmgmt.pojo.EmpPojo;

public class EmpDao {
	
	public static  boolean addEmp(EmpPojo e) throws SQLException{
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("insert into emp values (?,?,?,?)");
		ps.setInt(1, e.getEmpNo());
		ps.setString(2, e.getEmpName());
		ps.setDouble(3,  e.getEmpsal());
        ps.setInt(4, e.getDeptno());
        int count = ps.executeUpdate(); 
        return count ==1;
	}
	public static EmpPojo searchEmpById(int empId) throws SQLException{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from emp where empno = ?");
		ps.setInt(1,  empId);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			EmpPojo e = new EmpPojo();
			e.setEmpNo(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setEmpsal(rs.getDouble(3));
			e.setDeptno(rs.getInt(4));
			return e;
		}
		return null;
	}
	
	public static List <EmpPojo> getAllemployees() throws SQLException{
		Connection conn = DBConnection.getConnection();
		Statement st = conn.createStatement();
		List  <EmpPojo> empList  = new ArrayList<>();
		ResultSet rs = st.executeQuery("Select * from emp ");
		
		while (rs.next()) {
			EmpPojo e = new EmpPojo();
			e.setEmpNo(rs.getInt(1));
			e.setEmpName(rs.getString(2));
			e.setEmpsal(rs.getDouble(3));
			e.setDeptno(rs.getInt(4));
			empList.add(e);
		}
		return empList; 
	}
	
	public static boolean deleteEmp(int id)throws SQLException{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("Delete from emp where empno = ?");
		ps.setInt(1,  id);
		int rowEffected = ps.executeUpdate();
		return rowEffected>0;
	}
	
	public static boolean deleteEmp(String name) throws SQLException{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("Delete from emp where ename = ?");
		ps.setString(1,  name);
		int rowEffected = ps.executeUpdate();
		return rowEffected>0;
	}
	
	public static boolean updateEmp(int id , EmpPojo e) throws SQLException{
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement("update emp set ename = ? ,sal =? , deptno = ? where empno = ?");
		ps.setString(1,  e.getEmpName());
		ps.setDouble(2,  e.getEmpsal());
		ps.setInt(3, e.getDeptno());
		ps.setInt(4, id);
		
		int rowEffected = ps.executeUpdate();
		return rowEffected>0;

	}
}
