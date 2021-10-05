package poc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;


public class DepartmentTb {

	public void getDepartment() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc","root","maith15@10");
			
			PreparedStatement psmt = con.prepareStatement("SELEXT * FROM DEPARTMENT");
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getInt(1), rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
	}
	public int getDepartmentId(String deptName) {
		for (Entry<Integer,String> entry : map.entrySet()) {
			if (entry.getValue().equalsIgnoreCase(deptName)) {
				
			}
		}
		return 0;
		
	}

}
