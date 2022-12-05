import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcApp2 
{
	public static void main(String args[]) throws SQLException
	{
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
		
		Scanner scanner=new Scanner(System.in);
		option=scanner.nextInt();
		
		if(option==1)
		{
			Connection connection=null;
			Statement statement=null;
			ResultSet resultSet=null;
			try
			{
				
					String url ="jdbc:mysql://localhost:3306/School";
					String usr ="root";
					String  password = "Root@123";
					connection=DriverManager.getConnection(url,usr,password);
					if(connection!=null)
					{
						 statement = connection.createStatement();
						 if(statement!=null)
							{
								String sql="select * from Student";
								resultSet =	statement.executeQuery(sql);
								if(resultSet!=null)
								{
									
									System.out.println("Sid"+"    "+"sname"+"    "+"Sub"+"    "+"marks");
									while (resultSet.next()) {
									int sid	=resultSet.getInt("Sid");
								    String name = resultSet.getString("Sname");
									String sub =resultSet.getString("Subject");
									int marks =	resultSet.getInt("Marks");
									
									System.out.println(sid+"     "+name+"    "+sub+"    "+marks);
										
									}
								}
							}
					}
				
				
	}catch (Exception e) {
				e.printStackTrace();
			}
			
			finally {
				resultSet.close();
				statement.close();
				connection.close();
			}
		}else 
			if(option==2)
			{
				
						
				Connection connection=null;
				Statement statement=null;
			
				try
				{
					
						String url ="jdbc:mysql://localhost:3306/School";
						String usr ="root";
						String  password = "Root@123";
						connection=DriverManager.getConnection(url,usr,password);
						if(connection!=null)
						{
							 statement = connection.createStatement();
							 if(statement!=null)
								{
								 
								    String name="";
								    String subject ="";
								    int marks=0;
								    System.out.println("enter name");
								    name= scanner.next();
								    System.out.println("enter subject");
								    subject  = scanner.next();
								    System.out.println("enter marks");
								    marks= scanner.nextInt();
								    name="'"+name+"'";
								    subject="'"+subject+"'";
								    String sql = String.format("insert into student(Sname,subject,Marks) values(%s,%s,%d)",name,subject,marks);
									int n=statement.executeUpdate(sql);								
									System.out.println("Number of rows updated:"+n);
									
									}
								}
						
					
					
		} catch (Exception e) {
					e.printStackTrace();
				}
				
				finally {
					
					statement.close();
					connection.close();
				}
					
					
		 
			}
			else 
				if(option==3)
				{
					Connection connection=null;
					Statement statement=null;
					
					try
					{
						
							String url ="jdbc:mysql://localhost:3306/School";
							String usr ="root";
							String  password = "Root@123";
							connection=DriverManager.getConnection(url,usr,password);
							if(connection!=null)
							{
								 statement = connection.createStatement();
								 if(statement!=null)
									{
									    System.out.println("enter sid");
									    int sid= scanner.nextInt();
									    System.out.println("enter marks");
									    int marks= scanner.nextInt();
										String sql=String.format("update student set marks=%d where sid=%s",marks,sid);
										int n=statement.executeUpdate(sql);
										System.out.println("Number of rows updated:"+n);
										
										}
									}
							}
						
						
			catch (Exception e) {
						e.printStackTrace();
					}
					
					finally {
						//resultSet.close();
						statement.close();
						connection.close();
					}
				}else 
					if(option==4)
					{
						Connection connection=null;
						Statement statement=null;
						
						try
						{
							
								String url ="jdbc:mysql://localhost:3306/School";
								String usr ="root";
								String  password = "Root@123";
								connection=DriverManager.getConnection(url,usr,password);
								if(connection!=null)
								{
									 statement = connection.createStatement();
									 if(statement!=null)
										{
										    System.out.println("enter sid");
										    int sid= scanner.nextInt();
										   
											String sql=String.format("delete from student where sid=%d",sid);
											int n=statement.executeUpdate(sql);
											System.out.println("Number of rows updated:"+n);
											
											}
										}
								}
							
							
				catch (Exception e) {
							e.printStackTrace();
						}
						
						finally {
							
							statement.close();
							connection.close();
						}
					}
		
		
		else
			if(option ==5)
		{
			
				System.out.println("Thank you....... for using the application ");
			
		}else {
			System.out.println("invalid option");
		}
		
	}
		
	}

}
