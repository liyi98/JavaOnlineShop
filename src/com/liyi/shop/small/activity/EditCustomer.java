package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Customer;
import com.toedter.calendar.JDateChooser;

public class EditCustomer extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField textPhone;
	private JTextField textAddress1;
	private JTextField textAddress2;
	private JTextField textSafeword;
	private JDateChooser calendar;
	
	public EditCustomer(Customer customer) throws ParseException {
		setResizable(false);
		setTitle("Edit Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,530);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		
		JLabel lblTitle = new JLabel("Edit Customer");
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
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.LEFT);
		lblGender.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblGender.setBounds(25, 160, 120, 15);
		getContentPane().add(lblGender);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setHorizontalAlignment(SwingConstants.LEFT);
		lblBirthday.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblBirthday.setBounds(25, 200, 120, 15);
		getContentPane().add(lblBirthday);
		
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
		
		JLabel lblSafeword = new JLabel("SafeWord");
		lblSafeword.setHorizontalAlignment(SwingConstants.LEFT);
		lblSafeword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblSafeword.setBounds(25, 360, 120, 15);
		getContentPane().add(lblSafeword);
		
		txtName = new JTextField(customer.getName());
		txtName.setBackground(SystemColor.controlLtHighlight);
		txtName.setBounds(150, 79, 220, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField(customer.getEmail());
		txtEmail.setColumns(10);
		txtEmail.setBackground(SystemColor.controlLtHighlight);
		txtEmail.setBounds(150, 119, 220, 20);
		getContentPane().add(txtEmail);
		
		String sDate1= customer.getDob();;  
	    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(sDate1); 
		calendar = new JDateChooser(date1);
		calendar.setSize(220, 20);
		calendar.setLocation(151, 200);
		getContentPane().add(calendar);
		
		textPhone = new JTextField(customer.getPhone());
		textPhone.setColumns(10);
		textPhone.setBackground(SystemColor.controlLtHighlight);
		textPhone.setBounds(150, 239, 220, 20);
		getContentPane().add(textPhone);
		
		textAddress1 = new JTextField(customer.getAddress1());
		textAddress1.setColumns(10);
		textAddress1.setBackground(SystemColor.controlLtHighlight);
		textAddress1.setBounds(150, 279, 220, 20);
		getContentPane().add(textAddress1);
		
		textAddress2 = new JTextField(customer.getAddress2());
		textAddress2.setColumns(10);
		textAddress2.setBackground(SystemColor.controlLtHighlight);
		textAddress2.setBounds(150, 319, 220, 20);
		getContentPane().add(textAddress2);
		
		textSafeword = new JTextField(customer.getSafeword());
		textSafeword.setColumns(10);
		textSafeword.setBackground(SystemColor.controlLtHighlight);
		textSafeword.setBounds(150, 359, 220, 20);
		getContentPane().add(textSafeword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(SystemColor.text);
		rdbtnMale.setBounds(151, 159, 109, 23);
		getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(SystemColor.text);
		rdbtnFemale.setBounds(262, 159, 109, 23);
		getContentPane().add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		
		if(customer.getGender().equals("Female")) {
			rdbtnFemale.setSelected(true);
		}else {
			rdbtnMale.setSelected(true);
		}
		
		JLabel lblNewLabel = new JLabel("must exactly 4charaters");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(150, 379, 240, 12);
		getContentPane().add(lblNewLabel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		Color custom = new Color(236, 64, 122);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(custom);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dob = calendar.getDate().getDate()+ "-" + (calendar.getDate().getMonth() + 1) + "-" + (1900 + calendar.getDate().getYear());
				customer.setName(txtName.getText());
				customer.setEmail(txtEmail.getText());
				customer.setPhone(textPhone.getText());
				customer.setAddress1(textAddress1.getText());
				customer.setAddress2(textAddress2.getText());
				customer.setDob(dob);
				String gender = (rdbtnFemale.isSelected())? "Female": "Male";
				customer.setGender(gender);
				dispose();
			}
		});
		btnSave.setBounds(281, 432, 89, 30);
		getContentPane().add(btnSave);
		
		JLabel lblNewLabel_1 = new JLabel("Reset Password");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(25, 441, 100, 14);
		getContentPane().add(lblNewLabel_1);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
