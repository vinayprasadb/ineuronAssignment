import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Preparedstatment {

	public static void main(String[] args) throws SQLException {
		
		
	
		Connection connection =	JdbcUtil.getConnection();
		Scanner scanner=new Scanner(System.in);
		PreparedStatement pstm=null;
		ResultSet resultSet=null;		
		int option=0;
		while(option!=5)
	{
		System.out.println("Select the operation");
		System.out.println("-------------------");
		System.out.println("1. select");
		System.out.println("2. insert ");
		System.out.println("3. update");
		System.out.println("4. Delete");
		System.out.println("5. Exit");
		System.out.println("-------------------");
		System.out.println("Enter your choice");
		
		option=scanner.nextInt();
		
		if(option==1)
		{
			if(connection!=null)
			{
				String sqlSelect="select * from student";
			    pstm = connection.prepareStatement(sqlSelect);
				
				if(pstm!=null)
				{
					resultSet=pstm.executeQuery();
					System.out.println("Sid"+"\t"+"Sname"+"\t"+"Suject"+"\t"+"marks");
					while (resultSet.next()) {
						
					System.out.println(resultSet.getInt("Sid")+"\t"+resultSet.getString("Sname")+"\t"+resultSet.getString("Subject")+"\t"+resultSet.getInt("Marks")+"\t");
				}
					
					JdbcUtil.closeResource(resultSet, pstm, null);
			}
			
				
				
				
		
			}
			
			
		}
		else
		if(option==2)
		{
			
			if(connection!=null)
			{
				String sqlinsert="insert into student (Sname,Subject,Marks) values (?,?,?)";
				 pstm = connection.prepareStatement(sqlinsert);
				 
				 if(pstm!=null)
				 {
					System.out.println("enter name");
					String name= scanner.next();
					System.out.println("enter subject");
				    String  subject  = scanner.next();
					System.out.println("enter marks");
					int   marks= scanner.nextInt();
					pstm.setString(1, name);
					pstm.setString(2, subject);
					pstm.setInt(3, marks);
					int n=pstm.executeUpdate();
					System.out.println("Number of rows updated:"+n);
				 }
				 JdbcUtil.closeResource(null, pstm, null);
			}
									
		}
		else
		if(option==3)
		{
			if(connection!=null)
			{
				String sql="update student set marks=? where sid=?";
				pstm=connection.prepareStatement(sql);
				
				if(pstm!=null)
				{
					System.out.println("enter Sid");
					int   sid= scanner.nextInt();
					System.out.println("enter marks");
					int   marks= scanner.nextInt();
					pstm.setInt(1, marks);
					pstm.setInt(2, sid);
					int n=pstm.executeUpdate();
					if(n>0)
					{
						System.out.println("Number of rows updated:"+n);
					}
					else 
					{
						System.out.println("Invalid Sid");
					}
					
				
					}
					
					
					
				}
			      JdbcUtil.closeResource(null, pstm, null);
				}
		else if(option==4)
		{
				if(connection!=null)
				{
					System.out.println("enter Sid");
					int   sid= scanner.nextInt();
					String sql="delete from student where sid=?";
					pstm=connection.prepareStatement(sql);
					if(pstm!=null)
					{
						pstm.setInt(1, sid);
						int n=pstm.executeUpdate();
						
					
					if(n>0)
					{
						System.out.println("Number of rows updated:"+n);
					}
					else 
					{
						System.out.println("Invalid Sid");
					}
				}
					JdbcUtil.closeResource(null, pstm, null);	
				}
		}else {
			{
				JdbcUtil.closeResource(resultSet, pstm, connection);
			}
		}
			
		}
	    

	}

}

