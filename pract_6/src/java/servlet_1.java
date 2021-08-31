/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ISHAN
 */
public class servlet_1 extends HttpServlet{
    
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{  
  
        res.setContentType("text/html");  
        PrintWriter out = res.getWriter();  
          
        String name=req.getParameter("name");  
        String age=req.getParameter("age");
        String emailid=req.getParameter("emailid");
        String phoneno=req.getParameter("phoneno");
          
        String jdbcurl = "jdbc:derby://localhost:1527/pract_6";
        String driverclassname = "org.apache.derby.jdbc.ClientDriver";
        String username = "Ishan";
        String password = "Ishan";
           
        try{
            Class cls = Class.forName(driverclassname);
            // returns the name and package of the class
            System.out.println("Class found = " + cls.getName());
            System.out.println("Package = " + cls.getPackage());
        }
        catch(ClassNotFoundException ex) {
            System.out.println(ex.toString());
        }
        
        try{
            Connection con = DriverManager.getConnection(jdbcurl,username,password);
            Statement st = con.createStatement();
            String sqlquery =  "SELECT * FROM prac_6 WHERE EMAIL='"+emailid+"'";
            java.sql.ResultSet rs = (java.sql.ResultSet)st.executeQuery(sqlquery);
            int j=0;

            while(rs.next()){
                j++;
            }

            if(j==0){
                sqlquery =  "INSERT INTO prac_6 VALUES ('" + emailid +"','" + name +"','" + phoneno +"','" + age +"')";
                st.execute(sqlquery);
                
                HttpSession session=req.getSession();  
                session.setAttribute("uname",name);
                
                RequestDispatcher rd1 = req.getRequestDispatcher("/servlet_2");
                rd1.forward(req,res);
                //out.print("<a href='servlet_2'>show_data</a>");  
            }
            else{
                RequestDispatcher rd2 = req.getRequestDispatcher("index.html");
                out.println("<h1>You are already registered</h1>");
                rd2.include(req,res);
            }
        } 
        catch (SQLException ex) {
            out.println(""+ex+"");
            Logger.getLogger(servlet_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
