package com.liyi.shop.activities;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ForgotPasswordStep2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtPassword;
	public ForgotPasswordStep2(String password) {
		setTitle("ForgotPasswordStep2");
		setSize(460,320);
		setLocationRelativeTo(null);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		getContentPane().setLayout(null);
		
		JLabel lblYourPasswordIs = new JLabel("Your Password is");
		lblYourPasswordIs.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 21));
		lblYourPasswordIs.setBounds(140, 38, 179, 46);
		getContentPane().add(lblYourPasswordIs);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(78, 108, 305, 34);
		getContentPane().add(txtPassword);
		txtPassword.setColumns(10);
		txtPassword.setText(password);
		
		JButton btnNewButton = new JButton("OK");
		Color custom = new Color(236, 64, 122);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(custom);
		btnNewButton.setBounds(314, 193, 89, 25);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ActivityCustomerLogin();
				dispose();
			}
		});;
		getContentPane().add(btnNewButton);
		
		setVisible(true);
	}

}
