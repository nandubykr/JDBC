import java.sql.*;
import java.util.Scanner;

public class NoOfRowsInCol {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Enter the name of Database:");
		String database=sc.nextLine();
		System.out.println("Connecting to "+database+"..");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"","root","root");
		System.out.println("Connection Established.");
		Statement st=con.createStatement();
		System.out.println("Enter the Table name:");
		String table=sc.nextLine();
		System.out.println("Enter the column name:");
		String column=sc.nextLine();
		ResultSet rs=st.executeQuery("SELECT "+column+" FROM "+table+"");
		int count=0;
		System.out.println("The values stored in "+column+": ");
		while (rs.next()) {
			String  id= rs.getString(column);
			count++;
			System.out.println(id);
			}
		System.out.println("Total no of records: "+count);
		rs.close();
		st.close();
		con.close();
		sc.close();
	}

}
