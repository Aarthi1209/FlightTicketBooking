package flight;
import hotel.management.system.Reception;
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;	

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Booking extends JFrame {
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1,t2,t3,t4,t5,t6,r1;
      
        JComboBox comboBox;
        
        Choice c1,cn,c2;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking frame = new Booking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Booking() throws SQLException {
		
                setBounds(530, 200, 850, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("flight/1.jpg"));
                Image i3 = i1.getImage().getScaledInstance(300, 400,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(480,10,300,500);
                add(l1);
                JLabel lblName = new JLabel("BOOKING");
		lblName.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		lblName.setBounds(118, 5, 260, 53);
		contentPane.add(lblName);
		
                JLabel lblTim1 = new JLabel("Name :");
		lblTim1.setBounds(35, 50, 200, 14);
		contentPane.add(lblTim1);
                
                t1 = new JTextField();
		t1.setBounds(271, 50, 150, 20);
		contentPane.add(t1);
		t1.setColumns(10);
                
                JLabel lblTime1 = new JLabel("CustomerId :");
		lblTime1.setBounds(35, 100, 200, 14);
		contentPane.add(lblTime1);
                
                t2 = new JTextField();
		t2.setBounds(271, 100, 150, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Flight Number");
		lblNewLabel.setBounds(35, 150, 200, 14);
		contentPane.add(lblNewLabel);
                
                c1 = new Choice();
                try{
                    flight.conn c = new flight.conn();
                    ResultSet rs = c.s.executeQuery("select * from addflight");
                    while(rs.next()){
                        c1.add(rs.getString("flightnumber"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(271, 150, 150, 20);
		contentPane.add(c1);
                
    
                JLabel lblFood = new JLabel("Arrival place");
		lblFood.setBounds(35, 200, 200, 14);
		contentPane.add(lblFood);
                
                cn = new Choice();
                try{
                    flight.conn c = new flight.conn();
                    ResultSet rs = c.s.executeQuery("select * from addflight");
                    while(rs.next()){
                        cn.add(rs.getString("arrivalplace"));    
                    }
                }catch(Exception e){ }
                cn.setBounds(271, 200, 150, 20);
		contentPane.add(cn);
              
		JLabel lblName_1 = new JLabel("Depature Place:");
		lblName_1.setBounds(35, 250, 200, 14);
		contentPane.add(lblName_1);
		
                   c2 = new Choice();
                try{
                    flight.conn c = new flight.conn();
                    ResultSet rs = c.s.executeQuery("select * from addflight");
                    while(rs.next()){
                        c2.add(rs.getString("arrivalplace"));    
                    }
                }catch(Exception e){ }
                c2.setBounds(271, 250, 150, 20);
		contentPane.add(c2);
		

                
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(35, 300, 200, 14);
		contentPane.add(lblDate);
                
                r1 = new JTextField();
		r1.setBounds(271, 300, 150, 20);
		contentPane.add(r1);
		r1.setColumns(10);
                
                
                JLabel lblTime = new JLabel("Time :");
		lblTime.setBounds(35, 350, 200, 14);
		contentPane.add(lblTime);
                
                t5 = new JTextField();
		t5.setBounds(271, 350, 150, 20);
		contentPane.add(t5);
		t5.setColumns(10);
                
                JLabel lblAmount = new JLabel("Price :");
		lblAmount.setBounds(35, 400, 200, 14);
		contentPane.add(lblAmount);
                
                t4 = new JTextField();
		t4.setBounds(271, 400, 150, 20);
		contentPane.add(t4);
		t4.setColumns(10);
                t4.addKeyListener(new KeyAdapter() {
                   
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') || (caracter > '9'))
                        && (caracter != '\b')) {
                    e.consume();
                }
            }
        });
        

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            flight.conn c = new flight.conn();
                            String radio = null;
                            
                            
                            String s3 = c1.getSelectedItem();
                            String s4 = cn.getSelectedItem();
                            String s5 = c2.getSelectedItem();
                          
                            try{
	    			
	    			String s1 =  t1.getText();
                      
	    			String s2 =  t2.getText();
	    			String s6 =  r1.getText();
                                String s7 =  t4.getText();
                                
                                String s8 =  t5.getText();
                                
                                String q1 = "insert into booking values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                              
                                c.s.executeUpdate(q1);
                               
	    			JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
                                new Dashboard2().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
		    		catch(NumberFormatException s){
		    			JOptionPane.showMessageDialog(null, "Please enter a valid Number");
			}
			}
		});
		btnNewButton.setBounds(100, 470, 120, 30);
                btnNewButton.setBackground(Color.BLACK);
                btnNewButton.setForeground(Color.WHITE);
		contentPane.add(btnNewButton);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            new Dashboard2().setVisible(true);
                            setVisible(false);
			}
		}); 
		btnExit.setBounds(260, 470, 120, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                getContentPane().setBackground(Color.WHITE);
	}
}
