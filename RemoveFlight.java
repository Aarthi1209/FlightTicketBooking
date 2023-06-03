
package flight;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.EventQueue;


import java.sql.*;	
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.*;
import java.awt.event.ActionEvent;

public class RemoveFlight extends JFrame{
	Connection conn = null;
	PreparedStatement pst = null;
	private JPanel contentPane;
	private JTextField t1;
        Choice c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveFlight frame = new RemoveFlight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close(){
		this.dispose();
	}

	
	public RemoveFlight() throws SQLException {
		//conn = Javaconnect.getDBConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(530, 200, 800, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
                
                ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("flight/2.jpg"));
                Image i3 = i1.getImage().getScaledInstance(400, 225,Image.SCALE_DEFAULT);
                ImageIcon i2 = new ImageIcon(i3);
                JLabel l1 = new JLabel(i2);
                l1.setBounds(300,0,500,225);
                add(l1);
		
		JLabel lblCheckOut = new JLabel("Check Out ");
		lblCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCheckOut.setBounds(70, 11, 140, 35);
		contentPane.add(lblCheckOut);
		
		JLabel lblName = new JLabel("Flight Number :");
		lblName.setBounds(20, 85, 80, 14);
		contentPane.add(lblName);
                
                c1 = new Choice();
                try{
                    flight.conn c = new flight.conn();
                    ResultSet rs = c.s.executeQuery("select * from addflight");
                    while(rs.next()){
                        c1.add(rs.getString("flightnumber"));    
                    }
                }catch(Exception e){ }
                c1.setBounds(130, 82, 150, 20);
		contentPane.add(c1);
                
                ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
                Image i5 = i4.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
                ImageIcon i6 = new ImageIcon(i5);
                JButton l2 = new JButton(i6);
                l2.setBounds(290,82,20,20);
                add(l2);
                
                l2.addActionListener(new ActionListener(){
                    
                    public void actionPerformed(ActionEvent ae){
                        System.out.println("Hi");
                        try{
                            
                            flight.conn c = new flight.conn();
                            String number = c1.getSelectedItem();
                            ResultSet rs = c.s.executeQuery("select * from addflight where number = "+number);
                            
                            if(rs.next()){
                                System.out.println("clicked");
                                t1.setText(rs.getString("flightnumber"));    
                            }
                        }catch(Exception e){ }
                    }
                });

		
		
                
                
           	
                
		JButton btnCheckOut = new JButton("RemoveFlight");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                String id = c1.getSelectedItem();
                                //String s1 = t1.getText();
				String deleteSQL = "Delete from addflight where flightnumber = "+id;
                              //  String q2 = "update addflight set availability = 'Available' where roomnumber = "+s1;         
				flight.conn c = new flight.conn();

	    		try{
	    			c.s.executeUpdate(deleteSQL);
	    			//c.s.executeUpdate(q2);
	    			JOptionPane.showMessageDialog(null, "flight removed Successful");
	    			new Dashboard().setVisible(true);
                                setVisible(false);
	    		}catch(SQLException e1){
	    			System.out.println(e1.getMessage());
	    		}
			}
		});
		btnCheckOut.setBounds(50, 150, 150, 30);
                btnCheckOut.setBackground(Color.BLACK);
                btnCheckOut.setForeground(Color.WHITE);
		contentPane.add(btnCheckOut);
		
		JButton btnExit = new JButton("Back");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Dashboard().setVisible(true);
                                setVisible(false);
			}
		});
		btnExit.setBounds(200, 150, 150, 30);
                btnExit.setBackground(Color.BLACK);
                btnExit.setForeground(Color.WHITE);
		contentPane.add(btnExit);
                
                
                getContentPane().setBackground(Color.WHITE);
	}

}
