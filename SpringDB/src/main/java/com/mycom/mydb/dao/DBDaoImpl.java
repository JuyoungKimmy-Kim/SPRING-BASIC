package com.mycom.mydb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mydb.dto.EmpDto;

@Repository
public class DBDaoImpl implements DBDao {
	@Autowired
	DataSource dataSource;

	@Override
	public EmpDto empDetail(int employeeId) {
		EmpDto dto=null;
		
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			con=dataSource.getConnection();
			StringBuilder sb=new StringBuilder ();
			sb.append(" select employeeId, first_name, last_name, email, hiredate ")
			.append(" from emp where employeeId = ? ");
			
			pstmt=con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				dto=new EmpDto();
				dto.setEmployeeId(rs.getInt("employeeId"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hiredate"));
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!= null) {rs.close();}
				if (pstmt!= null) {pstmt.close();}
				if (con!= null) {con.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
}
