package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.liyi.shop.activities.ActivityAdminManager;
import com.liyi.shop.model.Staff;

public class EditStaff extends JFrame{
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JTextField txtPhone;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JLabel lblResetPassword;
	private JRadioButton rdbtnManager;
	private JRadioButton rdbtnAdmin;
	private char[] pass1;
	private String password1;
	private Staff staff;

	
	public EditStaff(Staff staff, JFrame parent) {
		this.staff = staff;
		setResizable(false);
		setTitle("Edit Staff");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,530);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		
		JLabel lblTitle = new JLabel("Edit Staff");
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
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setHorizontalAlignment(SwingConstants.LEFT);
		lblPhone.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblPhone.setBounds(25, 200, 120, 15);
		getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address1");
		lblAddress.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblAddress.setBounds(25, 240, 120, 15);
		getContentPane().add(lblAddress);
		
		JLabel lblAddress_1 = new JLabel("Address2");
		lblAddress_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblAddress_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblAddress_1.setBounds(25, 280, 120, 15);
		getContentPane().add(lblAddress_1);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setHorizontalAlignment(SwingConstants.LEFT);
		lblRole.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblRole.setBounds(25, 320, 120, 15);
		getContentPane().add(lblRole);
		
		txtName = new JTextField(staff.getName());
		txtName.setBackground(SystemColor.controlLtHighlight);
		txtName.setBounds(150, 79, 220, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField(staff.getEmail());
		txtEmail.setColumns(10);
		txtEmail.setBackground(SystemColor.controlLtHighlight);
		txtEmail.setBounds(150, 119, 220, 20);
		getContentPane().add(txtEmail);
	
		
		txtPassword = new JPasswordField(staff.getPassword());
		txtPassword.setEnabled(false);
		txtPassword.setColumns(10);
		txtPassword.setBackground(SystemColor.controlLtHighlight);
		txtPassword.setBounds(150, 159, 220, 20);
		getContentPane().add(txtPassword);
		
		txtPhone = new JTextField(staff.getPhone());
		txtPhone.setColumns(10);
		txtPhone.setBackground(SystemColor.controlLtHighlight);
		txtPhone.setBounds(150, 199, 220, 20);
		getContentPane().add(txtPhone);
		
		txtAddress1 = new JTextField(staff.getAddress1());
		txtAddress1.setColumns(10);
		txtAddress1.setBackground(SystemColor.controlLtHighlight);
		txtAddress1.setBounds(150, 239, 220, 20);
		getContentPane().add(txtAddress1);
		
		txtAddress2 = new JTextField(staff.getAddress2());
		txtAddress2.setColumns(10);
		txtAddress2.setBackground(SystemColor.controlLtHighlight);
		txtAddress2.setBounds(150, 279, 220, 20);
		getContentPane().add(txtAddress2);

		rdbtnManager = new JRadioButton("Manager");
		rdbtnManager.setBounds(151, 318, 109, 23);
		getContentPane().add(rdbtnManager);
		
		rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setSelected(true);
		rdbtnAdmin.setBounds(261, 318, 109, 23);
		getContentPane().add(rdbtnAdmin);
		System.out.println(staff.getRole());
	
		ButtonGroup group2 = new ButtonGroup();
		group2.add(rdbtnAdmin);
		group2.add(rdbtnManager);
		
		if(staff.getRole() == 1) {
			rdbtnManager.setSelected(true);
		}else {
			rdbtnAdmin.setSelected(true);
		}
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		Color custom = new Color(236, 64, 122);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(custom);
		btnSave.setBounds(281, 432, 89, 30);
		getContentPane().add(btnSave);
		
		lblResetPassword = new JLabel("Reset Password");
		lblResetPassword.setForeground(Color.BLUE);
		lblResetPassword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblResetPassword.setBounds(25, 441, 100, 14);
		getContentPane().add(lblResetPassword);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staff.setName(txtName.getText());
				staff.setEmail(txtEmail.getText());
				staff.setPhone(txtPhone.getText());
				staff.setAddress1(txtAddress1.getText());
				staff.setAddress2(txtAddress2.getText());
				pass1 = txtPassword.getPassword();
				password1 = new String(pass1);
				staff.setPassword(password1);
				dispose();
				parent.dispose();
				new ActivityAdminManager(staff);
			}
		});
		
		lblResetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				txtPassword.setEnabled(true);
			}
		});
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
