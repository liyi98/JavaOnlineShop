package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.liyi.shop.model.Customer;

import javax.swing.ImageIcon;

public class ForgotPasswordStep1 extends JFrame{
	private JTextField txtEmail;
	private JTextField txtSafeWord;
	private JLabel lblBack;
	public ForgotPasswordStep1() {
		setTitle("ForgotPasswordStep1");
		setResizable(false);
		setSize(460,320);
		setLocationRelativeTo(null);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		getContentPane().setLayout(null);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter Your Email and Safeword to Process Finding your Password");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPleaseEnterYour.setBounds(47, 31, 380, 14);
		getContentPane().add(lblPleaseEnterYour);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));
		lblNewLabel.setBounds(47, 88, 60, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSafeword = new JLabel("SafeWord");
		lblSafeword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));
		lblSafeword.setBounds(47, 130, 60, 14);
		getContentPane().add(lblSafeword);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(183, 86, 220, 23);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtSafeWord = new JTextField();
		txtSafeWord.setColumns(10);
		txtSafeWord.setBounds(183, 128, 220, 23);
		getContentPane().add(txtSafeWord);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setBounds(314, 193, 89, 23);
		Color custom = new Color(236, 64, 122);
		btnProceed.setForeground(Color.WHITE);
		btnProceed.setBackground(custom);
		getContentPane().add(btnProceed);
		btnProceed.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String newc = Customer.findPassword(txtEmail.getText(), txtSafeWord.getText());
				if(newc != null) {
					new ForgotPasswordStep2(newc);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Your Email or Safeword is wrong. Please try again");
				}
				
			}
		});
		
		lblBack = new JLabel("");
		lblBack.setIcon(new ImageIcon("C:\\Users\\addme\\Downloads\\keyboard_arrow_left_grey_192x192.png"));
		lblBack.setBounds(0, 101, 38, 29);
		getContentPane().add(lblBack);
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				new ActivityCustomerLogin();
				dispose();
			}
		});
		
		setVisible(true);
	}
	

}
