package poc1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class delete {

	public static void main(String[] args) {
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			String dbUrl = "jdbc:mysql://localhost:3306/pos_1";
			String user = "root";
			String pass = "maith15@10";

			Connection myConn = null;


			Connection conn = DriverManager.getConnection(dbUrl, user, pass);
			ResultSet myRs = null;
			Statement Stmnt1 = conn.createStatement();
			FileInputStream del = new FileInputStream("C:\\Users\\m.ramalingam\\Desktop\\project\\poc_2\\deletestudent.txt");
			DataInputStream in = new DataInputStream(del);

			BufferedReader br1 = new BufferedReader(new InputStreamReader(in));
			String strLine;
			ArrayList token = new ArrayList();
			while ((strLine = br1.readLine()) != null) {
			token.add(strLine);
			}
			Iterator itr;
			for (itr = token.iterator(); itr.hasNext(); ) {
			String str = itr.next().toString();
			String[] spliting = str.split("\t");
			String idNo = null;
			for (int i = 0; i <= 8; i++) {
			idNo = spliting[0];
			}
			myRs = Stmnt1.executeQuery("select * from student_1");
			while(myRs.next()){
				if (idNo.equals(myRs.getString("studentid"))) {
					int m = Stmnt1.executeUpdate("delete from student_1 where studentid=35");
					int n = Stmnt1.executeUpdate("delete from student_1 where studentid=45");
					// int m = Stmnt1.executeUpdate("select student_1.studentId, student_1.fullName, student_1.lastName ,student_1.departmentId, department_1.departmentName, student_1.joiningDate, student_1.studentDob, student_1.mobileNo, student_1. email from student_1 inner join department_1 on student_1.departmentId=department_1.departmentId");
					//int n = Stmnt1.executeUpdate( "select student_1.departmentId , department_1.departmentName , count(student_1.departmentId) as department_1 from student_1 left join  department_1.departmentId=student_1.departmentId GROUP BY departmentId ");
				}
				
			/*if(idNo.equals(myRs.getString("departmentname"))){
			idNo = new String(myRs.getString("Departmentid"));
			}*/
			}
			/*int k = Stmnt1.executeUpdate("insert into student_1(studentid, fullName, lastName, Departmentid, JoiningDate,studentDob, mobileNo, email) values('" + stuId + "','" + fullName + "','" + lastName + "','" + deptID + "','" + joinDate + "','"+ stuDob +"','"+ phoneNo +"','"+ stuEmail +"')");
			System.out.println(fullName +" inserted into db");
			FileInputStream del = new FileInputStream("C:\\Users\\m.ramalingam\\Desktop\\project\\poc_2\\deletestudent.txt");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(new DataInputStream(del)));
			String value;
			ArrayList<String> mty = new ArrayList();
			while ((value = br1.readLine()) != null) {
				mty.add(value);
			}*/



			}System.out.println( "deleted row 35 and 45" );
			}
			catch (Exception e) {
			System.out.println(e);
			} 


		
			} 
		
		
		
		
	
	}


