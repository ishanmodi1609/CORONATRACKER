/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p4;
import java.sql.*;
import java.sql.SQLException;
/**
 *
 * @author ISHAN
 */
public class prac_4 {
    
    public Connection connection() throws ClassNotFoundException, SQLException{
        String url="jdbc:derby://localhost:1527/Practical_3";
        String driverClass="org.apache.derby.jdbc.ClientDriver";
        String username="Practical_3";
        String password="Practical_3";
       
        Class.forName(driverClass);
        Connection con= DriverManager.getConnection(url,username,password);
        return con;
    }
   
    public void prepare_statement() throws ClassNotFoundException, SQLException{
         
        Connection con=null;
        con=connection();
       
        ResultSet rs=null;
       
        
        PreparedStatement pst=con.prepareStatement("insert into STUDENT VALUES(?,?,?,?,?,?)");
            
        pst.setString(1,"18BCE128");
        pst.setString(2,"Dhruvit");
        pst.setString(3,"9601354847");
        pst.setString(4,"Rajkot");
        pst.setString(5,"5");
        pst.setString(6,"C");
        
        pst.executeUpdate();
        System.out.println("\nDATA SUCCESSFULLY ENTERED WITH PREPARED STATEMENT");
           
        pst=con.prepareStatement("UPDATE STUDENT SET NAME=? WHERE ROLLNO=?");
          
        pst.setString(1,"18BCE123");
        pst.setString(2,"John Wick");
        int a=pst.executeUpdate();
        
        System.out.println("\nDATA SUCCESSFULLY UPDATED WITH PREPARED STATEMENT");
           
        pst=con.prepareStatement("DELETE FROM STUDENT WHERE NAME=? OR ROLLNO=?");
        pst.setString(1,"18BCE128");
        pst.setString(2,"Baba Yaga");
        pst.executeUpdate();
        System.out.println("\nDATA SUCCESSFULLY DELETED WITH PREPARED STATEMENT");
    }
    
    public void callable_statement() throws ClassNotFoundException, SQLException{
        
        Connection con=null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demosql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
        
        CallableStatement cst=con.prepareCall("{call simple()}");
        
        Boolean hasR=cst.execute();
        
        if(hasR){
            System.out.println("Only fetching data from data-base without any argument");
            ResultSet rs=cst.getResultSet();
            while(rs.next()){
                System.out.println(rs.getString("NAME"));
            }
       
        }
        
        cst.close();
        
        cst=con.prepareCall("{call simple1(?)}");
        cst.setInt(1,50);
        hasR=cst.execute();
        if(hasR){
            System.out.println("callable statement with only input argument");
            ResultSet rs=cst.getResultSet();
            while(rs.next()){
                System.out.println(rs.getString("NAME"));
            }
       
        }
        cst.close();
        
        cst=con.prepareCall("{call simple2(?,?)}");
        cst.setInt(1,40);
       
        cst.registerOutParameter(2,java.sql.Types.INTEGER);
        hasR=cst.execute();
        
        if(hasR){
            int cnt=cst.getInt(2);
            System.out.println("TOTAL COUNT WITH ID 40 is "+cnt);
            System.out.println("SIMPLE CALLABLE STATEMENT 1 ARGUMENTS and 1 RETURN VALUE:-");
            ResultSet rs=cst.getResultSet();
            while(rs.next()){
                System.out.println(rs.getString("NAME")+" "+rs.getInt("ID"));
            }
       
        }
        cst.close();
    }
    
    prac_4() throws ClassNotFoundException, SQLException{
        
        prepare_statement();
        callable_statement();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        new prac_4();
    }
}
