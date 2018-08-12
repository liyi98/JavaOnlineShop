package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.liyi.shop.activities.ActivityAdminCustomer;
import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Product;
import com.liyi.shop.model.Staff;
import com.toedter.calendar.JDateChooser;
import javax.swing.JPasswordField;

public class EditCustomer extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtSafeword;
	private JLabel lblResetPassword;
	private JDateChooser calendar;
	private char[] pass1;
	private String password1;
	private Staff staff;
	private JPasswordField txtPassword;
	
	public EditCustomer(Customer customer,JFrame parent, Staff staff) throws ParseException {
		this.staff = staff;
		setResizable(false);
		setTitle("Edit Customer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(420,580);
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
		
		txtPhone = new JTextField(customer.getPhone());
		txtPhone.setColumns(10);
		txtPhone.setBackground(SystemColor.controlLtHighlight);
		txtPhone.setBounds(150, 239, 220, 20);
		getContentPane().add(txtPhone);
		
		txtAddress1 = new JTextField(customer.getAddress1());
		txtAddress1.setColumns(10);
		txtAddress1.setBackground(SystemColor.controlLtHighlight);
		txtAddress1.setBounds(150, 279, 220, 20);
		getContentPane().add(txtAddress1);
		
		txtAddress2 = new JTextField(customer.getAddress2());
		txtAddress2.setColumns(10);
		txtAddress2.setBackground(SystemColor.controlLtHighlight);
		txtAddress2.setBounds(150, 319, 220, 20);
		getContentPane().add(txtAddress2);
		
		txtSafeword = new JTextField(customer.getSafeword());
		txtSafeword.setColumns(10);
		txtSafeword.setBackground(SystemColor.controlLtHighlight);
		txtSafeword.setBounds(150, 359, 220, 20);
		txtSafeword.setEditable(false);
		getContentPane().add(txtSafeword);
		
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
		
		JLabel lblNewLabel = new JLabel("must exactly 8charaters");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(150, 379, 220, 12);
		getContentPane().add(lblNewLabel);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		Color custom = new Color(236, 64, 122);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(custom);
		btnSave.setBounds(281, 465, 89, 30);
		getContentPane().add(btnSave);
		
		lblResetPassword = new JLabel("Reset Password");
		lblResetPassword.setForeground(Color.BLUE);
		lblResetPassword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblResetPassword.setBounds(25, 470, 100, 14);
		getContentPane().add(lblResetPassword);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblPassword.setBounds(25, 403, 120, 15);
		getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField(customer.getPassword());
		txtPassword.setColumns(10);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(150, 403, 220, 20);
		txtPassword.setEnabled(false);
		getContentPane().add(txtPassword);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dob = calendar.getDate().getDate()+ "-" + (calendar.getDate().getMonth() + 1) + "-" + (1900 + calendar.getDate().getYear());
				customer.setName(txtName.getText());
				customer.setEmail(txtEmail.getText());
				customer.setPhone(txtPhone.getText());
				customer.setAddress1(txtAddress1.getText());
				customer.setAddress2(txtAddress2.getText());
				customer.setDob(dob);
				String gender = (rdbtnFemale.isSelected())? "Female": "Male";
				customer.setGender(gender);
				pass1 = txtPassword.getPassword();
				password1 = new String(pass1);
				customer.setPassword(password1);
				dispose();
				parent.dispose();
				new ActivityAdminCustomer(staff);
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
