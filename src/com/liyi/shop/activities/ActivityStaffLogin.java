package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.liyi.shop.model.Admin;
import com.liyi.shop.model.Staff;


public class ActivityStaffLogin extends JFrame{
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private Staff s ;
	public ActivityStaffLogin() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Staff Login");
		setSize(400, 420);
		setLocationRelativeTo(null);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
	
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(55, 152, 81, 23);
		lblEmail.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			char[] pass = passwordField.getPassword();
			String password = new String(pass);
			System.out.println(Staff.staffs.size());
			if(Staff.loginS(textFieldEmail.getText(), password) != null ) {
				if(Staff.loginS(textFieldEmail.getText(), password).getRole() == 2) {
					new ActivityAdminCustomer(Staff.loginS(textFieldEmail.getText(), password));
					dispose();
				}else {
					new ActivityManageWomen(Staff.loginS(textFieldEmail.getText(), password));
				
				}
			}else {
					
					JOptionPane.showMessageDialog(null,"Your password or email is wrong");
				}
			}
		});
		btnLogin.setBounds(239, 266, 75, 33);
		btnLogin.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		Color custom = new Color(236, 64, 122);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(custom);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(55, 195, 81, 23);
		lblPassword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(165, 151, 148, 23);
		textFieldEmail.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		textFieldEmail.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 195, 148, 23);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().setLayout(null);
		getContentPane().add(lblEmail);
		getContentPane().add(textFieldEmail);
		getContentPane().add(lblPassword);
		getContentPane().add(passwordField);
		getContentPane().add(btnLogin);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon("C:\\Users\\addme\\Desktop\\Untitled-12.png"));
		lblTitle.setBounds(100, 11, 180, 119);
		getContentPane().add(lblTitle);
		
		JLabel lblPrevious = new JLabel("New label");
		lblPrevious.setIcon(new ImageIcon("C:\\Users\\addme\\Downloads\\keyboard_arrow_left_grey_192x192.png"));
		lblPrevious.setBounds(6, 162, 39, 33);
		getContentPane().add(lblPrevious);
		
		JLabel lblFPassword = new JLabel("Forgot Password?");
		lblFPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblFPassword.setForeground(Color.BLUE);
		lblFPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFPassword.setBounds(210, 241, 103, 14);
		getContentPane().add(lblFPassword);
		lblPrevious.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				new ActivityCustomerLogin();
				dispose();
			}
		});
		passwordField.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogin.doClick();
				
			}
		});
		setVisible(true);
		
		}
}
