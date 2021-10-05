package poc;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
		 
public class Department {
	String path ="\\Users\\m.ramalingam\\Desktop\\project\\POC\\dept.txt";
		    int Id;
		    String departName;
		    
		    public void department() throws FileNotFoundException {
		        try (Scanner sc = new Scanner( new File(this.path))) {
		            departName = "";
		            
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
		                PreparedStatement psmt = con.prepareStatement("INSERT INTO department values(?,?)");
		                psmt.setInt(1, Integer.parseInt(rowData[0]));
		                psmt.setString(2, rowData[1]);
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


