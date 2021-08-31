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

public class practical2A {
    
    static JButton jb1,jb2,jb3,jb4;
    static JLabel jl1;
    static int counter=0;
    
    public static void main(String[] args){
            
        System.out.println(counter);
        
        if(counter==10){
            System.exit(0);
        }
        
        JFrame jf=new JFrame("Practicla 2 A");
        jf.setSize(300,400);
        
        System.out.println("here1");
        jb1=new JButton("click here");
        jb2=new JButton("do not click here");
        jb3=new JButton("do not click here");
        jb4=new JButton("do not click here");
        
        jl1=new JLabel("Not click yet");
        
        jf.add(jb1,BorderLayout.NORTH);
        jf.add(jb2,BorderLayout.SOUTH);
        jf.add(jb3,BorderLayout.WEST);
        jf.add(jb4,BorderLayout.EAST);
        
        jf.add(jl1,BorderLayout.CENTER);
        
        System.out.println("here2");
        
        jb4.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                if(counter==10)
                    System.exit(0);
                
                if(jb4.getActionCommand().equals("click here")){
                    
                    counter++;
                    jl1.setText("good job");
                    int i=(int)((Math.random())*4);
                    System.out.println("In jb4:"+i+",counter:"+counter);
                    
                    if(i==0){
                        jb1.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==2){
                        jb2.setText("click here");
                        jb1.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==3){
                        jb3.setText("click here");
                        jb2.setText("do not click here");
                        jb1.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else{
                        jb4.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb1.setText("do not click here");
                    }
                }
                else{
                    jl1.setText("wrong button has been clicked");
                }
            }
            
            
        } );
        jb1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                
                if(counter==10)
                    System.exit(0);
                
                if(jb1.getActionCommand().equals("click here")){
                    
                    counter++;
                    jl1.setText("good job");
                    int i=(int)((Math.random())*4);
                    System.out.println("In jb4:"+i+",counter:"+counter);
                    
                    if(i==0){
                        jb1.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==2){
                        jb2.setText("click here");
                        jb1.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==3){
                        jb3.setText("click here");
                        jb2.setText("do not click here");
                        jb1.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else{
                        jb4.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb1.setText("do not click here");
                    }
                }
                else{
                    jl1.setText("wrong button has been clicked");
                }
            }
            
            
        } );
        jb2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                   
                if(counter==10)
                    System.exit(0);
                
                if(jb2.getActionCommand().equals("click here")){
                    
                    counter++;
                    jl1.setText("good job");
                    int i=(int)((Math.random())*4);
                    System.out.println("In jb4:"+i+",counter:"+counter);
                    
                    if(i==0){
                        jb1.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==2){
                        jb2.setText("click here");
                        jb1.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==3){
                        jb3.setText("click here");
                        jb2.setText("do not click here");
                        jb1.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else{
                        jb4.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb1.setText("do not click here");
                    }
                }
                else{
                    jl1.setText("wrong button has been clicked");
                }
            }
            
            
        } );
        jb3.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); 
                   
                if(counter==10)
                    System.exit(0);
                
                if(jb3.getActionCommand().equals("click here")){
                    
                    counter++;
                    jl1.setText("good job");
                    int i=(int)((Math.random())*4);
                    System.out.println("In jb4:"+i+",counter:"+counter);
                    
                    if(i==0){
                        jb1.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==2){
                        jb2.setText("click here");
                        jb1.setText("do not click here");
                        jb3.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else if(i==3){
                        jb3.setText("click here");
                        jb2.setText("do not click here");
                        jb1.setText("do not click here");
                        jb4.setText("do not click here");
                    }
                    else{
                        jb4.setText("click here");
                        jb2.setText("do not click here");
                        jb3.setText("do not click here");
                        jb1.setText("do not click here");
                    }
                }
                else{
                    jl1.setText("wrong button has been clicked");
                }
            }
            
            
        } );
        
        System.out.println("Finished");
        jf.setVisible(true);
    }
}
