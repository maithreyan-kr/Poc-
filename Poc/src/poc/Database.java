package poc;

public class Database {

	public static void main(String[] args) {
		StudentDb student = new StudentDb();
		 Department dept  = new Department();
		//DepartmentTb department = new DepartmentTb();
		/*try {
			//department.getDepartment();
			student.readFile();
			
		}catch (Exception e) {
			System.out.println(e);
		}*/
		 try {
             
             student.readFile();
             dept.department();
             }catch (Exception e) {
             System.out.println(e);
             }
		

	}

}
