package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.EmployeeBO;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String  GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN(?,?,?) ORDER BY JOB";
	private DataSource ds;

	public EmployeeDAOImpl(DataSource ds) {

		this.ds = ds;
	}

	@Override
	public List<EmployeeBO> findEmpsByDesg(String desg1, String desg2, String desg3) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<EmployeeBO> listBO=null;
		EmployeeBO bo=null;
		try {
			//get Pooled JDBC con object
			con=ds.getConnection();
			//create PreparedStatement object
			ps=con.prepareStatement(GET_EMPS_BY_DESG);
			//set values to Query params
			ps.setString(1,desg1);
			ps.setString(2,desg2);
			ps.setString(3,desg3);
			//execute the Query
			rs=ps.executeQuery();
			//copy ResultSet obj records  ListBO obj
			listBO=new ArrayList();
			while(rs.next()) {
				//copy each record  to BO 
				bo=new EmployeeBO();
				bo.setEno(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setDesg(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				//add bo to listBO
				listBO.add(bo);
			}
		}
		catch(Exception e) {
			throw e;
		}
		finally {
			//close jdbc objs
			try {
				if(rs!=null)
					rs.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(ps!=null)
					ps.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
			try {
				if(con!=null)
					con.close();
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			
		}//finally
      return listBO;
	}//method
	
}//class
