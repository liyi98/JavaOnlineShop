package com.liyi.shop.activities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.liyi.shop.model.Customer;
import com.liyi.shop.small.activity.SignUpPage;


public class ActivityCustomerLogin extends JFrame {
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JLabel lblSignUp;
	private JButton btnLogin;
	private JLabel lblTitle;
	private char[] password;
	private String pass1;
	
	public ActivityCustomerLogin() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(400, 420);
		setLocationRelativeTo(null);
	
	Color bk = new Color(255, 205, 210);
	getContentPane().setBackground(bk);
	setTitle("Login");
	setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
	
	
	JLabel lblEmail = new JLabel("Email:");
	lblEmail.setBounds(55, 152, 81, 23);
	lblEmail.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
	
	btnLogin= new JButton("Login");
	btnLogin.setBounds(239, 266, 75, 33);
	btnLogin.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
	Color custom = new Color(236, 64, 122);
	btnLogin.setForeground(Color.WHITE);
	btnLogin.setBackground(custom);
	btnLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			password = passwordField.getPassword();
			pass1 = new String(password);
				if(Customer.loginC(textFieldEmail.getText(),pass1) != false) {
					dispose();
					new ActivityHomePage();
				}else {
					JOptionPane.showMessageDialog(null,"Your password or email is wrong");
				}
			
		
		}
	});
	
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
	
	lblTitle = new JLabel("");
	lblTitle.setIcon(new ImageIcon("C:\\Users\\addme\\Desktop\\Untitled-12.png"));
	lblTitle.setBounds(100, 11, 180, 119);
	getContentPane().add(lblTitle);
	
	JLabel lblNext = new JLabel("");
	lblNext.setIcon(new ImageIcon("C:\\Users\\addme\\Desktop\\keyboard_arrow_right_grey_192x192.png"));
	lblNext.setBounds(338, 162, 46, 37);
	getContentPane().add(lblNext);
	
	JLabel lblFPassword = new JLabel("Forgot Password?");
	lblFPassword.setHorizontalAlignment(SwingConstants.LEFT);
	lblFPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblFPassword.setForeground(Color.BLUE);
	lblFPassword.setBounds(210, 241, 103, 14);
	getContentPane().add(lblFPassword);
	lblFPassword.addMouseListener(new MouseAdapter(){
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			new ForgotPasswordStep1();
			dispose();
		}
	});
	
	lblSignUp = new JLabel("Sign Up Here");
	lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 12));
	lblSignUp.setForeground(Color.BLUE);
	lblSignUp.setBounds(55, 241, 81, 14);
	getContentPane().add(lblSignUp);
	lblSignUp.addMouseListener(new MouseAdapter(){
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			new SignUpPage();

		}
	});
	lblNext.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			new ActivityStaffLogin();
			dispose();
		}
	});
	
	passwordField.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			btnLogin.doClick();
			
		}
	});
	
	lblTitle.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseReleased(MouseEvent e) {
			new ActivityHomePage();
			dispose();
			super.mouseReleased(e);
		}
	});
	setVisible(true);
	
	}
}
