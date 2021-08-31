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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
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
public class servlet_2 extends HttpServlet {
    
    private int counter; 
    @Override
    
    public void init(){    
        counter = 0; 
    } 
 
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{  
          
        counter++;
        System.out.println("In serlet_2");
        res.setContentType("text/html");  
        PrintWriter out = res.getWriter();  
          
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
            String sqlquery =  "SELECT * FROM prac_6";
            java.sql.ResultSet rs = (java.sql.ResultSet)st.executeQuery(sqlquery);
            
            out.println("<table border=1>");
            out.println("<tr>");
            
            /*ResultSetMetaData rsMetaData = rs.getMetaData();
            
            for (int i=1; i<=4;i++) {
                out.println("<th>");
                out.println(rsMetaData.getColumnName(i));
            }
            
            out.println("</tr>");
            
            while (rs.next()) {
                out.println("<tr>");
                for (int i=1; i<=4; i++) {
                    out.println("<td>");
                    out.println(rs.getString(i));
                }
                out.println("</tr>");
            }
            out.println("</table>");*/

            out.println("<br>");out.println("<br>");
            out.println("<br>");out.println("<br>");
            
            HttpSession session = req.getSession(true);
            String uname = (String)session.getAttribute("uname");
            
            out.println("<p>Session attribute:"+uname+"</p>");
            
            out.println("<br>");out.println("<br>");
            
            String id = session.getId();
            
            out.println("<p>Session id:"+id+"</p>");
            
            out.println("<br>");out.println("<br>");
            
            ServletContext ctx=getServletContext();  
            int total=(Integer)ctx.getAttribute("totalusers");  
            int current=(Integer)ctx.getAttribute("currentusers");  
        
            out.println("<p>total users:"+current+"</p>");
            
            out.println("<br>");out.println("<br>");
            
            out.println("<p>current users:"+total+"</p>");
            //out.println("<p>Active Sessions:"+v+"</p>");
            
            res.setIntHeader("Refresh",7); 
        } 
        catch (SQLException ex) {
            out.println(""+ex+"");
            Logger.getLogger(servlet_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
