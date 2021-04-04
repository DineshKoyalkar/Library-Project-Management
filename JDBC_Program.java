import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class JDBC
{
	public static void main(String[] args)throws ClassNotFoundException, SQLException
	{
		
		// register the Driver class
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver found");
		
		//create a connection
		Connection con = DriverManager.getConnection("jdbc:mysql://sql6.freemysqlhosting.net/sql6400624","sql6400624","djZTpQeLFb");
		//System.out.println("Connection established");
		
		//create statement
		Statement st = con.createStatement();
		
		System.out.println("----------------------------------------------------------------");
		System.out.println("   List of Digital Books(these are books with BookType = 1)");
		System.out.println("----------------------------------------------------------------");
		ResultSet rs= st.executeQuery("select * from Books where BookType = 1");
		while(rs.next())
		{
			System.out.println(rs.getString(1)+" "+rs.getInt(3));
		}
		
		
		System.out.println("-----------------------------------------------------");
		System.out.println("   All books sorted in alphabetical order A-Z");
		System.out.println("-----------------------------------------------------");
		ResultSet rs2= st.executeQuery("select * from Books order by BookName asc");
		while(rs2.next())
		{
			System.out.println(rs2.getString(1));
		}
		
		
		System.out.println("-------------------------------------------------- ");
		System.out.println("   Authors with name starting with “C” ");
		System.out.println("-------------------------------------------------- ");
		ResultSet rs3= st.executeQuery("select * from Books WHERE Author LIKE 'C%' ORDER BY Author");
		while(rs3.next())
		{
			System.out.println(rs3.getString(2));
		}
		rs3.close();
		st.close();
	}
}

