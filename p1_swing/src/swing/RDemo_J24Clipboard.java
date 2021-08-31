/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing;


import java.awt.GridLayout;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author ME95
 */
public class RDemo_J24Clipboard {
    
    RDemo_J24Clipboard(){
        JFrame jf = new JFrame("Clipboard & Window Example");
        //JWindow iw = new JWindow(jf);
        
        jf.setSize(100,100);
        jf.setLayout(new GridLayout());
        //iw.setVisible(true);
     //System.out.println(iw.getLayout());
       
        JTextField jtf = new JTextField();
        jf.add(jtf);
        
        JTextArea jta = new JTextArea(5, 2);
        jf.add(jta);
        
        Clipboard clip = jf.getToolkit().getSystemClipboard();
        
        jtf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                
                StringSelection ssdata = new StringSelection(jtf.getText());
                clip.setContents(ssdata, ssdata);
                 String data="";
                Transferable t = clip.getContents(ssdata);
                
                try {
                     data = (String) t.getTransferData(DataFlavor.stringFlavor);
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(RDemo_J24Clipboard.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(RDemo_J24Clipboard.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                jta.setText(data);
                
                
            }
        });
   
   
        
        
        
        jf.setVisible(true);        
    }

    public static void main(String[] args) {
        new RDemo_J24Clipboard();
    }
}

