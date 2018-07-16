package com.liyi.shop.small.activity;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;

import com.liyi.shop.activities.ActivityCustomerLogin;
import com.liyi.shop.model.Customer;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class AddCustomerPage extends JFrame{
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField textBirthday;
	private JTextField textPhone;
	private JTextField textAddress1;
	private JTextField textAddress2;
	private JTextField textSafeword;
	public AddCustomerPage() {
		setResizable(false);
		setTitle("New Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,600);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		
		JLabel lblTitle = new JLabel("New Customer");
		lblTitle.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		lblTitle.setBounds(126, 11, 178, 40);
		getContentPane().add(lblTitle);
		
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
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblGender.setBounds(25, 240, 120, 15);
		getContentPane().add(lblGender);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblBirthday.setBounds(25, 280, 120, 15);
		getContentPane().add(lblBirthday);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblPhone.setBounds(25, 320, 120, 15);
		getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address1");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblAddress.setBounds(25, 360, 120, 15);
		getContentPane().add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address2");
		lblAddress_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblAddress_1.setBounds(25, 400, 120, 15);
		getContentPane().add(lblAddress_1);
		
		JLabel lblSafeword = new JLabel("SafeWord");
		lblSafeword.setHorizontalAlignment(SwingConstants.LEFT);
		lblSafeword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblSafeword.setBounds(25, 440, 120, 15);
		getContentPane().add(lblSafeword);
		
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
		
		textBirthday = new JTextField();
		textBirthday.setColumns(10);
		textBirthday.setBackground(SystemColor.controlLtHighlight);
		textBirthday.setBounds(150, 279, 220, 20);
		getContentPane().add(textBirthday);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBackground(SystemColor.controlLtHighlight);
		textPhone.setBounds(150, 320, 220, 20);
		getContentPane().add(textPhone);
		
		textAddress1 = new JTextField();
		textAddress1.setColumns(10);
		textAddress1.setBackground(SystemColor.controlLtHighlight);
		textAddress1.setBounds(150, 359, 220, 20);
		getContentPane().add(textAddress1);
		
		textAddress2 = new JTextField();
		textAddress2.setColumns(10);
		textAddress2.setBackground(SystemColor.controlLtHighlight);
		textAddress2.setBounds(150, 399, 220, 20);
		getContentPane().add(textAddress2);
		
		textSafeword = new JTextField();
		textSafeword.setColumns(10);
		textSafeword.setBackground(SystemColor.controlLtHighlight);
		textSafeword.setBounds(150, 439, 220, 20);
		getContentPane().add(textSafeword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(SystemColor.text);
		rdbtnMale.setBounds(151, 238, 109, 23);
		getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(SystemColor.text);
		rdbtnFemale.setBounds(262, 238, 109, 23);
		getContentPane().add(rdbtnFemale);
		
		JLabel lblNewLabel = new JLabel("must exactly 4charaters");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(150, 466, 240, 12);
		getContentPane().add(lblNewLabel);
		
		JButton btnSignUp = new JButton("Add");
		btnSignUp.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		Color custom = new Color(236, 64, 122);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(custom);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer c = new Customer();
				if(txtPassword.getText().equals(txtConfirmPassword.getText())) {
				c.addCustomer(txtName.getText(), txtEmail.getText(), txtPassword.getText(), rdbtnMale.getText(), textBirthday.getText(),textPhone.getText(),textAddress1.getText(), textAddress2.getText(), textSafeword.getText());
				}
			}
		});
		btnSignUp.setBounds(281, 496, 89, 30);
		getContentPane().add(btnSignUp);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
