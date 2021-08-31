/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3;

/**
 *
 * @author ISHAN
 */

import java.sql.*;

public class database {
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String jdbcurl = "jdbc:derby://localhost:1527/Ishan";
        String driverclassname = "org.apache.derby.jdbc.ClientDriver";
        String username = "ishan_modi";
        String password = "Ishan";
        String sqlquery = "SELECT * FROM Register";
        try{
            Class cls = Class.forName(driverclassname);
         // returns the name and package of the class
         System.out.println("Class found = " + cls.getName());
         System.out.println("Package = " + cls.getPackage());
        }
        catch(ClassNotFoundException ex) {
         System.out.println(ex.toString());
      }
        Connection con = DriverManager.getConnection(jdbcurl, username, password);
        Statement st = con.createStatement();
       ResultSet rs = st.executeQuery(sqlquery);
        while(rs.next())
        {
            System.out.println(rs.getInt("RollNo")+"..."+rs.getString("Name"));
        }
        con.close();
        
    }
}
