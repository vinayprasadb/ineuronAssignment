import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.text.*;
public class JdbcDate {

	public static void main(String[] args) throws SQLException 
	{
		// TODO Auto-generated method stub
			PreparedStatement pstm=null;
			ResultSet resultSet=null;
			int option=0;
			Scanner scanner=new Scanner(System.in);
			Connection connection= JdbcUtil.getConnection();
			
			System.out.println("enter your choice");
			
			
		
			
			
		while(option!=3)	  
		{
			System.out.println("1- select");
			System.out.println("2- insert");
			System.out.println("3- Exit");
			option=scanner.nextInt();
			 
			if(option==1)
			{
				try {
					
					if(connection!=null)
					{
						String sqlselect="select * from professor";
						pstm = connection.prepareStatement(sqlselect);
						resultSet=pstm.executeQuery();
						
					     
					     
					     System.out.println("NAME"+"\t"+"Address"+"\t"+"DOB"+"\t"+"DOJ"+"\t"+"DOM");
					     if(resultSet.next())
					     {
					    	 
					    	 
					    	 SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MM-yyyy");
						     String dob =simpleDateFormat.format(resultSet.getDate(4));
						     
						     SimpleDateFormat simpleDateFormat1= new SimpleDateFormat("MM-dd-yyyy");
						     String doj =simpleDateFormat.format(resultSet.getDate(5));
						     
						     
						     SimpleDateFormat simpleDateFormat2= new SimpleDateFormat("yyyy-MM-dd");
						     String dom =simpleDateFormat.format(resultSet.getDate(6));
					    	 System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3)+"\t"+dob+"\t"+doj+"\t"+dom);
					     }
					    
					    
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					JdbcUtil.closeResource(resultSet, pstm, null);
				}
			}
			else 
			
			if(option==2)
			{
				try {
					
					  
					  System.out.println("Enter the details");
					  
					  System.out.println("Enter the Name");
					  
					  String name =scanner.next();
					  
					  System.out.println("Enter the Address");
					  
					  String address =scanner.next();
					  
					  System.out.println("Enter the Gender");
					  
					  String gender =scanner.next();
					  
					  System.out.println("Enter the DOB-(dd-MM-yyyy)");
					  
					  String DOB =scanner.next();
					  
					  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
					  
					  java.util.Date udate=sdf.parse(DOB);
					  
					  Long timeLong= udate.getTime();
					  
					  java.sql.Date dobDate= new java.sql.Date(timeLong);
					  
					  System.out.println("Enter the DOJ-(MM-dd-yyyy)");
					  
					  String DOJ =scanner.next();
					  
					  SimpleDateFormat sdf2=new SimpleDateFormat("MM-dd-yyyy"); 
					  
					  java.util.Date uDate2= sdf2.parse(DOJ);
					  
					  Long time2= uDate2.getTime();
					  
					  java.sql.Date dojDate =new java.sql.Date(time2);
					  
					  System.out.println("Enter the DOM-(yyyy-MM-dd)");
					  
					  String DOM =scanner.next();
					  
					  java.sql.Date domDate = java.sql.Date.valueOf(DOM);
					  
					 
					  String sql="insert into professor (Name,Address,Gender,DOJ,DOB,DOM) values(?,?,?,?,?,?)";
					  
					  if(connection!=null)
					  {
						  pstm=connection.prepareStatement(sql);
						  
						  if(pstm!=null)
						  {
							  pstm.setString(1, name);
							  pstm.setString(2, address);
							  pstm.setString(3, gender);
							  pstm.setDate(4, dojDate);
							  pstm.setDate(5, dobDate);
							  pstm.setDate(6, dobDate);
							  
							 Integer nInteger = pstm.executeUpdate();
							 
							 System.out.println("Numbaer of rows updated:"+nInteger);
							  
						  }
					  }
					  
					  
					  
					
				} catch (Exception e) {
					System.out.println("CHECK THEDATE FORMATS");
					option=2;
				}
				finally {
					
					JdbcUtil.closeResource(resultSet, pstm, null);
				}
			}else
			if(option==3)
			{
				System.out.println("Thank you for using application");
				JdbcUtil.closeResource(resultSet, pstm, connection);
				
			}
			else 
			{
				System.out.println("enter valid option");
			}
		}	
			
			
			
			
			
			
			

	}

}
