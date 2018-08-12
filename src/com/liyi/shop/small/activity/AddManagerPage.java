package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Manager;
import com.liyi.shop.model.Staff;

public class AddManagerPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField textPhone;
	private JTextField textAddress1;
	private JTextField textAddress2;
	private JButton btnAdd;
	private char[] pass1;
	private String password1;
	private char[] pass2;
	private String password2;
	
	public AddManagerPage(JFrame frame, Staff staff) {
		getContentPane().setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		setResizable(false);
		setTitle("New Manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,500);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);

		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblName.setBounds(25, 80, 120, 15);
		getContentPane().add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblEmail.setBounds(25, 120, 120, 15);
		getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblPassword.setBounds(25, 160, 120, 15);
		getContentPane().add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(25, 200, 120, 15);
		getContentPane().add(lblConfirmPassword);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblPhone.setBounds(25, 240, 120, 15);
		getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address1");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblAddress.setBounds(25, 280, 120, 15);
		getContentPane().add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address2");
		lblAddress_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblAddress_1.setBounds(25, 320, 120, 15);
		getContentPane().add(lblAddress_1);
		
		txtName = new JTextField();
		txtName.setBackground(SystemColor.controlLtHighlight);
		txtName.setBounds(150, 79, 220, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBackground(SystemColor.controlLtHighlight);
		txtEmail.setBounds(150, 119, 220, 20);
		getContentPane().add(txtEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBackground(SystemColor.controlLtHighlight);
		txtPassword.setBounds(150, 159, 220, 20);
		getContentPane().add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBackground(SystemColor.controlLtHighlight);
		txtConfirmPassword.setBounds(150, 199, 220, 20);
		getContentPane().add(txtConfirmPassword);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBackground(SystemColor.controlLtHighlight);
		textPhone.setBounds(150, 239, 220, 20);
		getContentPane().add(textPhone);
		
		textAddress1 = new JTextField();
		textAddress1.setColumns(10);
		textAddress1.setBackground(SystemColor.controlLtHighlight);
		textAddress1.setBounds(150, 279, 220, 20);
		getContentPane().add(textAddress1);
		
		textAddress2 = new JTextField();
		textAddress2.setColumns(10);
		textAddress2.setBackground(Color.WHITE);
		textAddress2.setBounds(150, 319, 220, 20);
		getContentPane().add(textAddress2);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		btnAdd.setBounds(281, 385, 89, 30);
		Color custom = new Color(236, 64, 122);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(custom);
		getContentPane().add(btnAdd);
		
		JLabel lblNewLabel = new JLabel("New Manager");
		lblNewLabel.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		lblNewLabel.setBounds(126, 11, 178, 40);
		getContentPane().add(lblNewLabel);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pass1 = txtPassword.getPassword();
				password1 = new String(pass1);
				pass2 = txtConfirmPassword.getPassword();
				password2 = new String(pass2);
				if(checkSignUp() > 2) {
					Staff.addStaff(new Manager(txtName.getText(), txtEmail.getText(),password1, textAddress1.getText(), textAddress2.getText(), textPhone.getText()));
					JOptionPane.showMessageDialog(null,"Sucess!");
					}else if (checkSignUp() == 0) {
						JOptionPane.showMessageDialog(null,"Please fill up all the required field");
					}else if (checkSignUp() == 1) {
						JOptionPane.showMessageDialog(null,"Your password not match");
					}else{
						JOptionPane.showMessageDialog(null,"Wrong Email Format");
					}
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public int checkSignUp() {
		pass1 = txtPassword.getPassword();
		password1 = new String(pass1);
		pass2 = txtConfirmPassword.getPassword();
		password2 = new String(pass2);

		if(txtName.getText().isEmpty() ||txtEmail.getText().isEmpty()||textPhone.getText().isEmpty() || textAddress1.getText().isEmpty() || password1.isEmpty() ) {
			return 0;
		}else if(!password1.equals(password2)){
			return 1;
		}else if(!txtEmail.getText().matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$")) {
			return 2;
		}else{
			return 3;
		}
		
	}
}
