import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {


		
		private JdbcUtil()
		{
			
		}
			
		
		
		 static	Connection getConnection() throws SQLException
		{
			 String url="jdbc:mysql://localhost:3306/School";
			 String usr="root";
			 String psw="Root@123";
			Connection connection =DriverManager.getConnection(url,usr,psw);
			
			return connection;
		}
		 
		 
		 static  void closeResource(ResultSet resultSet,Statement statement, Connection connection) throws SQLException
		 {
			 if(resultSet!=null)
			 {
				 resultSet.close();
			 }
			 
			 if(statement!=null)
			 {
				 statement.close();
			 }
			 
			 if(connection!=null)
			 {
				 connection.close();
			 }
			 
		 }
	

	

}

