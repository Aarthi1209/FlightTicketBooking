
package flight;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class front extends JFrame implements ActionListener{

        JLabel l1;
        JButton b1,b2;
        
        public front() {
		
                setSize(1400,1000);          // setContentPane(300,300,1366,390);   frame size
                setLayout(null);
                setLocation(300,300);

		l1 = new JLabel("");
                b1 = new JButton("User");
                
                b1.setBackground(Color.WHITE);
                b1.setForeground(Color.BLACK);
				
                b2 = new JButton("Admin");
                
                b2.setBackground(Color.WHITE);
                b2.setForeground(Color.BLACK);
				
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("flight/4.jpg"));
                Image i3 = i1.getImage().getScaledInstance(1400, 900,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                l1 = new JLabel(i2);
                
                JLabel lid=new JLabel("FLIGHT TICKET BOOKING SYSTEM");
                lid.setBounds(200,60,1500,100);
                lid.setFont(new Font("timesroman",Font.BOLD,55));
                lid.setForeground(Color.white);
                l1.add(lid);
                
                b1.setBounds(970,350,150,50);
                b2.setBounds(270,350,150,50);
		l1.setBounds(0, 0, 1400, 900);
                
                
                l1.add(b1);
		add(l1);
                l1.add(b2);
		add(l1);
 
                b1.addActionListener(this);
                setVisible(true);
                
                b2.addActionListener(this);
                setVisible(true);
                
                while(true){
                        lid.setVisible(false); // lid =  j label
                    try{
                        Thread.sleep(500); //1000 = 1 second
                    }catch(Exception e){} 
                        lid.setVisible(true);
                    try{
                        Thread.sleep(500);
                    }catch(Exception e){}
                }
               
	}
        
       public void actionPerformed(ActionEvent ae){
                new Login().setVisible(true);
                this.setVisible(false);
                
        }
               
        
        public static void main(String[] args) {
               front window = new front();
               window.setVisible(true);
               //new front();
	}
}
