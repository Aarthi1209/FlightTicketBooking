
package flight;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddFlight extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2;
    Choice c1;

    public static void main(String[] args) {
        new AddFlight().setVisible(true);
    }


    public AddFlight() {
        setSize(1400,1000);
	contentPane = new JPanel();
	setContentPane(contentPane);
	contentPane.setLayout(null);
        
        ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("flight/7.jpg"));
                Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l15 = new JLabel(i2);
                l15.setBounds(700,70,550,500);
                add(l15);
        
        JLabel l10 = new JLabel("ADD FLIGHTS");
        l10.setFont(new Font("Tahoma", Font.BOLD, 25));
	l10.setBounds(250, 70, 200, 100);
	contentPane.add(l10);
        
	
        
	JLabel l1 = new JLabel("Flight Number");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("Tahoma", Font.BOLD, 16));
	l1.setBounds(100, 200, 200, 30);
	contentPane.add(l1);
        
        
        t1 = new JTextField();
	t1.setBounds(400, 200, 200, 30);
	contentPane.add(t1);
        t1.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
        

	JLabel l2 = new JLabel("Arrival Place");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("Tahoma", Font.BOLD, 16));
	l2.setBounds(100, 250, 200, 30);
	contentPane.add(l2);
        
        t2 = new JTextField();
	t2.setBounds(400, 250, 200, 30);
	contentPane.add(t2);
        t2.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
               if(Character.isDigit(ch)){
                t4.setText("");
                JOptionPane.showMessageDialog(null, "Enter Alphabet Only !");
                                     }
                                            }
        });
        
        


	JLabel l3 = new JLabel("Depature Place");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("Tahoma", Font.BOLD, 16));
	l3.setBounds(100, 300, 200, 30);
	contentPane.add(l3);
        
         t3 = new JTextField();
	t3.setBounds(400, 300, 200, 30);
	contentPane.add(t3);
        t3.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if(Character.isDigit(ch)){
                t4.setText("");
                JOptionPane.showMessageDialog(null, "Enter Alphabet Only !");
                                     }
                                            }
        });
	JLabel l4 = new JLabel("Date");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("Tahoma", Font.BOLD, 16));
	l4.setBounds(100, 350, 200, 30);
	contentPane.add(l4);
        
        t4 = new JTextField();
	t4.setBounds(400, 350, 200, 30);
	contentPane.add(t4);
        

        JLabel l5 = new JLabel("Time");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("Tahoma", Font.BOLD, 16));
	l5.setBounds(100, 400, 200, 30);
	contentPane.add(l5);

        t5 = new JTextField();
	t5.setBounds(400, 400, 200, 30);
	contentPane.add(t5);
        
        JLabel l6 = new JLabel("Price");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("Tahoma", Font.BOLD, 16));
	l6.setBounds(100, 450, 200, 30);
	contentPane.add(l6);

        t6 = new JTextField();
	t6.setBounds(400, 450, 200, 30);
	contentPane.add(t6);
        
	b1 = new JButton("Add");
	b1.addActionListener(this);
	b1.setBounds(150, 521, 111, 33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
	contentPane.add(b1);

	b2 = new JButton("Back");
	b2.addActionListener(this);
	b2.setBounds(400, 521, 111, 33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
	contentPane.add(b2);

	
        contentPane.setBackground(Color.WHITE);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            
            if(ae.getSource() == b1){
                try{
                flight.conn c = new flight.conn();
                String fn = t1.getText();
                 String ap = t2.getText();
                  String dp = t3.getText();
                   String date = t4.getText();
                    
                   String time = t5.getText();
                   String price = t6.getText();
                String str = "INSERT INTO addflight values( '"+fn+"', '"+ap+"', '"+dp+"','"+date+"', '"+time+"','"+price+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Flight Successfully Added");
                this.setVisible(false);
               
                }catch(Exception ee){
                    System.out.println(ee);
                }
            }
            else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }catch(Exception eee){
            
        }
    }
}
