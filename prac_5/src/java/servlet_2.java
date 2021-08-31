/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

/**
 *
 * @author ISHAN
 */
public class servlet_2 implements Servlet {
        
    ServletConfig config=null;  
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config=config;
        System.out.println("servlet is initialized"); 
    }

    @Override
    public ServletConfig getServletConfig() {
        return config; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = res.getWriter()) {
            
            String uname = req.getParameter("Username");
            String psw = req.getParameter("psw");
            String psw1 = req.getParameter("psw1");
            
            if(uname=="" || psw=="" || psw1==""){
                out.println("<h1>Please fill all the fields!</h1>");
            }
            else if(psw.compareTo(psw1)!=0){
                out.println("<h1>Enter same password in both fields</h1>");
            }
            else{
                
                String jdbcurl = "jdbc:derby://localhost:1527/prac_5";
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
                
                try {
                    
                    System.out.println(uname);
                    Connection con = DriverManager.getConnection(jdbcurl,username,password);
                    Statement st = con.createStatement();
                    String sqlquery =  "SELECT * FROM prac_5 WHERE USERNAME='"+uname+"' and PASSWORD='"+psw+"'";
                    java.sql.ResultSet rs = (java.sql.ResultSet)st.executeQuery(sqlquery);
                    int j=0;
                    
                    while(rs.next()){
                        j++;
                    }
                        
                    if(j!=0){
                        RequestDispatcher rd1 = req.getRequestDispatcher("index.html");
                        out.println("<h2>You are already registered</h2>");
                        out.println("<h2>Please LogIn</h2>");
                        rd1.forward(req,res);
                    }
                    else{
                        
                        sqlquery =  "INSERT INTO prac_5 VALUES ('" + uname +"','" + psw +"')";
                        int rs1 = st.executeUpdate(sqlquery);
                        
                        RequestDispatcher rd2 = req.getRequestDispatcher("index.html");
                        
                        out.println("<h2>You are registered</h2>");
                        out.println("<h2>Please LgIn</h2>");
                        
                        rd2.include(req, res);
                    }
                } 
                catch (SQLException ex) {
                    out.println(""+ex+"");
                    Logger.getLogger(servlet_1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String getServletInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
