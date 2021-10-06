package poc1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;



public class Filereader {
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
FileInputStream f = new FileInputStream("C:\\Users\\m.ramalingam\\Desktop\\project\\poc_2\\input2.txt");
DataInputStream in = new DataInputStream(f);

BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine;
ArrayList list = new ArrayList();
while ((strLine = br.readLine()) != null) {
list.add(strLine);
}
Iterator itr;
for (itr = list.iterator(); itr.hasNext(); ) {
String str = itr.next().toString();
String[] spliting = str.split("\t");
String stuId = "", fullName = "", lastName = "", deptID = "", joinDate = "", stuDob = "", phoneNo = "", stuEmail = "";
for (int i = 0; i <= 8; i++) {
stuId = spliting[0];
fullName = spliting[1];
lastName = spliting[2];
deptID = spliting[3];
joinDate = spliting[4];
stuDob = spliting[5];
phoneNo = spliting[6];
stuEmail = spliting[7];

}



myRs = Stmnt1.executeQuery("select * from department_1");
while(myRs.next()){
	
if(deptID.equals(myRs.getString("departmentname"))){
deptID = new String(myRs.getString("Departmentid"));
}
}
int k = Stmnt1.executeUpdate("insert into student_1(studentid, fullName, lastName, Departmentid, JoiningDate,studentDob, mobileNo, email) values('" + stuId + "','" + fullName + "','" + lastName + "','" + deptID + "','" + joinDate + "','"+ stuDob +"','"+ phoneNo +"','"+ stuEmail +"')");
System.out.println(fullName +" inserted into db");



}
}
catch (Exception e) {
System.out.println(e);
}



}
}