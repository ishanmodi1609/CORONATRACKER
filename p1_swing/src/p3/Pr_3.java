package P3;

import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class Pr_3 {
    
    Pr_3() throws SQLException{
        
        //JMenuBar menubar = new JMenuBar("MenuBar");
        JMenuBar mb=new JMenuBar();  
        JMenu menu = new JMenu("Select your choice");
        
        JMenuItem insert = new JMenuItem("Insert");
        JMenuItem view = new JMenuItem("View");
        JMenuItem update = new JMenuItem("Update");
        
        JFrame jf = new JFrame("Student data");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        jf.setSize(600,600);
        
        menu.add(insert);menu.add(view);menu.add(update);
        mb.add(menu);
        
        jf.add(mb);
        
        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                JFrame form = new JFrame("Student data");
                form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                form.setSize(600,600);
                
                form.setLayout(new FlowLayout(FlowLayout.LEADING));
                
                JLabel rollno = new JLabel("Enter your rollno:");
                JLabel name = new JLabel("Enter your fullname:");
                JLabel phone_no = new JLabel("Enter your phoneno:");
                JLabel address = new JLabel("Enter your address:");
                JLabel semester = new JLabel("Enter your semester:");
                JLabel lanuage = new JLabel("Enter your language:");
                
                JTextField name_field = new JTextField("Enter your name:");
                JTextField rollno_field = new JTextField("Enter your rollno:");
                JTextField phoneno_field = new JTextField("Enter your phone_no:");
                JTextField address_field = new JTextField("Enter your address:");
                
                String []sem = {"1","2","3","4","5","6","7","8"};
                
                JComboBox semester_select = new JComboBox(sem);
                
                form.add(name);form.add(name_field);
                form.add(rollno);form.add(rollno_field);
                form.add(address);form.add(address_field);
                form.add(phone_no);form.add(phoneno_field);
                form.add(semester);form.add(semester_select);
                
                ButtonGroup cbg = new ButtonGroup(); 
                
                JCheckBox java = new JCheckBox("Java");
                JCheckBox Python = new JCheckBox("Python");
                JCheckBox C = new JCheckBox("C");
                JCheckBox C__ = new JCheckBox("C++");
                JCheckBox C_ = new JCheckBox("C#");
                JCheckBox RUBY = new JCheckBox("RUBY");
                
                cbg.add(java);cbg.add(Python);cbg.add(C);
                cbg.add(C__);cbg.add(C_);cbg.add(RUBY);
                
                form.add(lanuage);
                form.add(java);form.add(Python);form.add(C);
                form.add(C__);form.add(C_);form.add(RUBY);
                
                JButton submit = new JButton("Submit");
                
                form.add(submit);
                
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        
                        String s1=name_field.getText(),s2=rollno_field.getText(),s3=address_field.getText();
                        String s4=phoneno_field.getText();
                        
                        String s_1="Enter your name:",s_2="Enter your rollno:",s_3="Enter your phone_no:",s_4="Enter your address:";
                        
                        String c1="";
                        
                        if(java.isSelected())
                            c1="Java";
                        if(Python.isSelected())
                            c1="Python";
                        if(C__.isSelected())
                            c1="C";
                        if(C_.isSelected())
                            c1="C++";
                        if(C.isSelected())
                            c1="C#";
                        if(RUBY.isSelected())
                            c1="RUBY";
                        
                        String sem_select = (String) semester_select.getSelectedItem();
                        
                        System.out.print("here");
                        if(s1.matches(s_1) || s2.matches(s_2) || s3.matches(s_3) || s4.matches(s_4) || c1.matches("")){
                            JOptionPane.showMessageDialog(form,"Please field all the data");           
                        }
                        else{
                                            
                            String query = "insert into STUDENT(ROLLNO,NAME,PHONE_NO,ADDRESS,SEMESTER,LANGUAGE)"
                                    + "values('"+s2+"','"+s1+"','"+s4+"','"+s3+"','"+sem_select+"','"+c1+"')";
                            try {
                                String jdbcurl = "jdbc:derby://localhost:1527/Practical_3";
                                String driverclassname = "org.apache.derby.jdbc.ClientDriver";
                                String username = "Practical_3";
                                String password = "Practical_3";

                                Connection con = DriverManager.getConnection(jdbcurl, username, password);

                                Statement st = con.createStatement();
                                System.out.println(st);
                                st.execute(query);
                                System.out.println("Executed sucessfully.");
                            } catch (SQLException ex) {
                                Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                                                                                  
                    }
                });
                        
                form.setVisible(true);
            }
        });
        
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("In view");
                JFrame jf2 = new JFrame("Record");
                jf2.setSize(600,600);
                jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf2.setLayout(new FlowLayout());

                String[] cols = {"ROLLNO","NAME","PHONE_NO","ADDRESS","SEMESTER","LANGUAGE"};

                DefaultTableModel dtm = new DefaultTableModel(cols, 0);
                JTable tbl = new JTable(dtm);

                TableColumnModel columnmodel = tbl.getColumnModel();
                columnmodel.setColumnSelectionAllowed(false);
                columnmodel.getColumn(0).setPreferredWidth(300);
                columnmodel.getColumn(1).setPreferredWidth(300);
                columnmodel.getColumn(2).setPreferredWidth(300);
                columnmodel.getColumn(3).setPreferredWidth(300);
                columnmodel.getColumn(4).setPreferredWidth(300);
                columnmodel.getColumn(5).setPreferredWidth(300);


                //Set a height of row 30
                tbl.setRowHeight(30);
                dtm.addRow(cols);

                Connection con = null;
                Statement st = null,st1=null;
                ResultSet rs1 = null;
                Integer rs = 0;

                String q1 = "SELECT * FROM STUDENT";

                String jdbcurl = "jdbc:derby://localhost:1527/Practical_3"; 
                String driverclassname = "org.apache.derby.jdbc.ClientDriver";
                String username = "Practical_3";
                String password = "Practical_3";

                try {
                    con = DriverManager.getConnection(jdbcurl, username, password);
                    st = con.createStatement();
                    st1 = con.createStatement();
                    rs1 = st1.executeQuery(q1);

                    // Add those retrieve information to the Row of the table
                    int j=1;
                    while(rs1.next())
                    {
                        dtm.addRow(new Object[]{j, (String) rs1.getString("ROLLNO"), (String)rs1.getString("NAME"), (String)rs1.getString("PHONE_NO"), (String) rs1.getString("ADDRESS"), (String) rs1.getString("SEMESTER"), (String) rs1.getString("LANGUAGE")});
                        j++;
                    }
                    con.close();

                } catch (SQLException ex) {
                    Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                }

                tbl.setFillsViewportHeight(true);

                tbl.setGridColor(Color.BLACK);
                tbl.setForeground(Color.BLACK);
                tbl.setFont(new Font("Serif", Font.BOLD, 15));
                tbl.setBackground(Color.LIGHT_GRAY);
                tbl.setRowSelectionAllowed(true);
                tbl.enableInputMethods(false);
                tbl.setEnabled(false);

                jf2.add(tbl);
                JLabel jl = new JLabel();
                jf2.add(jl);
                JLabel jl1 = new JLabel();
                jf2.add(jl1);

                //For now I just made JButton for update

                jf2.setVisible(true);

            }
        });
        
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                //JFrame jf3 = new JFrame("Upadte Frame");
                //jf3.setSize(600,600);
                //jf3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                JTextField R_no = new JTextField();
                Object[] message = {
                    "Enter Roll Number:", R_no,
                };
                    
                int option = JOptionPane.showConfirmDialog(jf, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
                
                if (option == JOptionPane.OK_OPTION)
                {
                    String te = R_no.getText();
                    
                    JFrame form = new JFrame("Update-Form-1");
                    form.setSize(600,600);
                    form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    form.setLayout(new FlowLayout());
                    
                    JLabel name = new JLabel("Enter your fullname:");
                    JLabel phone_no = new JLabel("Enter your phoneno:");
                    JLabel address = new JLabel("Enter your address:");
                    JLabel semester = new JLabel("Enter your semester:");
                    JLabel lanuage = new JLabel("Enter your language:");
                    JTextField name_field = new JTextField("Enter your name:");
                    JTextField phoneno_field = new JTextField("Enter your phone_no:");
                    JTextField address_field = new JTextField("Enter your address:");
                
                    String []sem = {"1","2","3","4","5","6","7","8"};
                
                    JComboBox semester_select = new JComboBox(sem);
                
                    form.add(name);form.add(name_field);
                    form.add(address);form.add(address_field);
                    form.add(phone_no);form.add(phoneno_field);
                    form.add(semester);form.add(semester_select);

                    ButtonGroup cbg = new ButtonGroup(); 

                    JCheckBox java = new JCheckBox("Java");
                    JCheckBox Python = new JCheckBox("Python");
                    JCheckBox C = new JCheckBox("C");
                    JCheckBox C__ = new JCheckBox("C++");
                    JCheckBox C_ = new JCheckBox("C#");
                    JCheckBox RUBY = new JCheckBox("RUBY");

                    cbg.add(java);cbg.add(Python);cbg.add(C);
                    cbg.add(C__);cbg.add(C_);cbg.add(RUBY);

                    form.add(lanuage);
                    form.add(java);form.add(Python);form.add(C);
                    form.add(C__);form.add(C_);form.add(RUBY);

                    JButton submit = new JButton("Update");

                    form.add(submit);  
                    
                    submit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            String jdbcurl = "jdbc:derby://localhost:1527/Practical_3"; 
                            String driverclassname = "org.apache.derby.jdbc.ClientDriver";
                            String username = "Practical_3";
                            String password = "Practical_3";
                            
                            String s1=name_field.getText();
                            
                            if(!s1.matches("Enter your name:")){
                                try {
                                    Connection con= DriverManager.getConnection(jdbcurl, username, password);
                                    Statement st = con.createStatement();
                                    String q1 = "UPDATE PRACTICAL_3.STUDENT SET Name='"+s1+"'  WHERE Rollno='"+te+"' ";
                                    st.executeUpdate(q1);
                               } catch (SQLException ex) {
                                    Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            s1=phoneno_field.getText();
                            
                            if(!s1.matches("Enter your phone_no:")){
                                try {
                                    Connection con= DriverManager.getConnection(jdbcurl, username, password);
                                    Statement st = con.createStatement();
                                    String q1 = "UPDATE PRACTICAL_3.STUDENT SET PHONE_NO='"+s1+"'  WHERE Rollno='"+te+"' ";
                                    st.executeUpdate(q1);
                               } catch (SQLException ex) {
                                    Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            s1=address_field.getText();
                            
                            if(!s1.matches("Enter your address:")){
                                try {
                                    Connection con= DriverManager.getConnection(jdbcurl, username, password);
                                    Statement st = con.createStatement();
                                    String q1 = "UPDATE PRACTICAL_3.STUDENT SET ADDRESS='"+s1+"'  WHERE Rollno='"+te+"' ";
                                    st.executeUpdate(q1);
                               } catch (SQLException ex) {
                                    Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                            String c1="";
                        
                            if(java.isSelected())
                                c1="Java";
                            if(Python.isSelected())
                                c1="Python";
                            if(C__.isSelected())
                                c1="C";
                            if(C_.isSelected())
                                c1="C++";
                            if(C.isSelected())
                                c1="C#";
                            if(RUBY.isSelected())
                                c1="RUBY";

                            String sem_select = (String) semester_select.getSelectedItem();
                            
                            try {
                                Connection con= DriverManager.getConnection(jdbcurl, username, password);
                                Statement st = con.createStatement();
                                String q1 = "UPDATE PRACTICAL_3.STUDENT SET LANGUAGE='"+c1+"'  WHERE Rollno='"+te+"' ";
                                st.executeUpdate(q1);
                            } catch (SQLException ex) {
                                Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            try {
                                Connection con= DriverManager.getConnection(jdbcurl, username, password);
                                Statement st = con.createStatement();
                                String q1 = "UPDATE PRACTICAL_3.STUDENT SET SEMESTER='"+sem_select+"'  WHERE Rollno='"+te+"' ";
                                st.executeUpdate(q1);
                            } catch (SQLException ex) {
                                Logger.getLogger(Pr_3.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                    
                    form.setVisible(true);
                }
                   
                //jf3.setVisible(true);
            }
        });
        
        jf.revalidate();
        jf.setVisible(true);
        
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        new Pr_3();
    }
}