package com.liyi.shop.small.activity;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Order;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class ChangePassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField txtOldPassword;
	private JPasswordField txtNewPassword;
	private JPasswordField txtConfirm;
	private JButton btnSave;
	private char[] old;
	private String oldpassword;
	private char[] pass1;
	private String password1;
	private char[] pass2;
	private String password2;

	public ChangePassword() {
		setTitle("Change Password");
		setResizable(false);
		setSize(460,320);
		
		Color bk = new Color(255, 205, 210);
		Color btn = new Color(236, 64, 122);
		getContentPane().setBackground(bk);
		getContentPane().setLayout(null);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		lblOldPassword.setBounds(64, 55, 120, 20);
		getContentPane().add(lblOldPassword);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		lblNewPassword.setBounds(64, 105, 120, 20);
		getContentPane().add(lblNewPassword);
		
		JLabel lblConfirm = new JLabel("Confirm Password");
		lblConfirm.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		lblConfirm.setBounds(64, 155, 129, 20);
		getContentPane().add(lblConfirm);
		
		txtOldPassword = new JPasswordField();
		txtOldPassword.setBounds(217, 57, 160, 20);
		getContentPane().add(txtOldPassword);
		txtOldPassword.setColumns(10);
		
		txtNewPassword = new JPasswordField();
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(217, 107, 160, 20);
		getContentPane().add(txtNewPassword);
		
		txtConfirm = new JPasswordField();
		txtConfirm.setColumns(10);
		txtConfirm.setBounds(217, 157, 160, 20);
		getContentPane().add(txtConfirm);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSave.setBounds(311, 226, 89, 25);
		btnSave.setBackground(btn);
		btnSave.setForeground(Color.white);
		getContentPane().add(btnSave);
		
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkPassword() == 1) {
					JOptionPane.showMessageDialog(null,"Old Password incorrect");
				}else if(checkPassword() == 2) {
					JOptionPane.showMessageDialog(null,"Password must more than 6 characters");
				}else if(checkPassword() == 3) {
					JOptionPane.showMessageDialog(null,"Password not match");
				}else if(checkPassword() == 0){
					pass1 = txtNewPassword.getPassword();
					password1 = new String(pass1);
					Template1.c.setPassword(password1);
					JOptionPane.showMessageDialog(null,"Update Sucessful!");
				}else {
					
				}
				
			}
		});
	    
		setLocationRelativeTo(null);
		setVisible(true);
		    
	}
	
	private int checkPassword() {
		old = txtOldPassword.getPassword();
		oldpassword = new String(old);
		pass1 = txtNewPassword.getPassword();
		password1 = new String(pass1);
		pass2 = txtConfirm.getPassword();
		password2 = new String(pass2);
		if(!Template1.c.getPassword().equals(oldpassword)) {
			return 1;
		}else if(pass1.length < 7) {
			return 2;
		}else if(!(password1.equals(password2))){
			return 3;
		}
		return 0;
	}
}
