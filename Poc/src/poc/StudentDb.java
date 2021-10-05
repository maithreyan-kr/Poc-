package poc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.Scanner;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;


public class StudentDb {
	
	String path = "\\Users\\m.ramalingam\\Desktop\\project\\POC\\input.txt";
	
	int studentId;
	String studentFirstName;
	String studentLastName;
	int depatmentId;
	String joiningDate;
	String studentDob;
	BigInteger mobileNum ;
	String studentEmail;
	

	public void readFile() {
		try (Scanner sc = new Scanner( new File(this.path))) {
			
			studentFirstName = "";
			studentLastName = "";
			joiningDate = "";
			studentDob = "";
			studentEmail = "";
			
			while (sc.hasNextLine()) {
				String line;
				line = sc.nextLine();
				String[] rowData;
				rowData = line.split("\t");
				for (int i=0; i<rowData.length; i++) {
					System.out.println(rowData[i] + " ");
				}
				System.out.println();
				
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/poc","root","maith15@10");
					
					PreparedStatement psmt = con.prepareStatement("INSERT INTO STUDENT values(?,?,?,?,?,?,?,?)");
					psmt.setInt(1, Integer.parseInt(rowData[0]));
					psmt.setString(2, rowData[1]);
					psmt.setString(3, rowData[2]);
					//psmt.setString(4, rowData[3]);
					//psmt.setInt(4, 1);
  			        psmt.setInt(4, Integer.parseInt(rowData[3]));
					
					//int deptId = obj.getDepartmentId(deptName);
					//psmt.setInt(4, deptId);
					
					psmt.setDate(5, Date.valueOf(LocalDate.now()));
					psmt.setDate(6, Date.valueOf(LocalDate.now()));
					//psmt.setInt(7, Integer.parseInt(rowData[6]));
					psmt.setBigDecimal(7, new BigDecimal(rowData[6]));
					psmt.setString(8, rowData[7]);
					
					int i = psmt.executeUpdate();
					System.out.println(i + "records inserted");
					con.setAutoCommit(false);
					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
