/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p2A;

/**
 *
 * @author ISHAN
 */

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class practical2B  implements ActionListener,Runnable{
    
    int hour,minute,second,milisecond;
    boolean on;
    String display="";
    JLabel jb1,disp;
    JButton j1,j2;
    
    practical2B(){
        
        hour=0;minute=0;second=0;milisecond=0;
       
        JFrame jf=new JFrame("Practical 2B");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new FlowLayout());
        
        display="00:00:00:000";
        disp=new JLabel(display);
        
        j1=new JButton("start");
        j2=new JButton("reset");
        //jb1=new JLabel("click on sthe start button to stop")
        
        jf.add(j1);
        jf.add(j2);
        jf.add(disp);
        
        on=false;
        new Thread((Runnable)this,"practical2B").start(); 
         
        j1.addActionListener(this);
        j2.addActionListener(this);
        
        jf.setVisible(true);
    }
    
    public void update(){
        
        milisecond++;
        
        if(milisecond==1000){
            
            second++;
            
            if(second==60){
                
                minute++;
                
                if(minute==60){
                    
                    hour++;
                    
                    minute=0;
                }
                
                second=0;
            }
            milisecond=0;
        }
        
        System.out.println("update_h:"+hour+",minute:"+minute+",second:"+second);  
    }
    
    public void update_label(){
        
        display="";
        
        System.out.println("label_h:"+hour+",minute:"+minute+",second:"+second);  
        
        display=hour+":"+minute+":"+second+":"+milisecond;
        
        disp.setText(display);
    }
    public static void main(String args[]){
       new practical2B(); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getSource()==j1){
            
            String s1=j1.getText();
            
                if(s1=="start"){
                    on=true;
                    new Thread((Runnable) this, "practical2B").start();
                    j1.setText("stop");
                }    
                else{
                    on=false;
                    j1.setText("start");

                    System.out.println("here1    "+"s:"+s1);
                }
        }
        else if(e.getSource()==j2){
            System.out.println("here2");
            hour=0;minute=0;second=0;milisecond=0;
            update_label();
        }
    }

    @Override
    public void run() {
        while(on == true)
        {
            try{  
                //Thread.sleep(1000);
                update();
                update_label();
            }
            catch(Exception e1)
            {
               System.out.println(e1);
            }
        }
    }

    private void println(int hour, String a_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void println(int hour, String a_, int minute, String a_0, int second, String a_1, int milisecond) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
