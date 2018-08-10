package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.liyi.shop.model.Customer;
import com.liyi.shop.small.activity.ChangePassword;
import com.liyi.shop.small.activity.OrderHistory;
import com.toedter.calendar.JDateChooser;

public class CustomerProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddress1;
	private JTextField txtAddress2;
	private JTextField txtSafeWord;
	private JLabel lblPassword;
	private JDateChooser calendar;
	private JButton btnOrder;

	public CustomerProfile() throws ParseException {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("My Profile- Account Settings");
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 235, 238);
		Color btn = new Color(236, 64, 122);
		getContentPane().setBackground(bk);
		
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblName.setBounds(250, 100, 100, 20);
		getContentPane().add(lblName);
		
		txtName = new JTextField(Template1.c.getName());
		txtName.setToolTipText("");
		txtName.setBounds(371, 100, 200, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblEmail.setBounds(250, 150, 100, 20);
		getContentPane().add(lblEmail);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblPhone.setBounds(250, 200, 100, 20);
		getContentPane().add(lblPhone);
		
		JLabel lblAddress = new JLabel("Address1");
		lblAddress.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblAddress.setBounds(250, 250, 100, 20);
		getContentPane().add(lblAddress);
		
		JLabel lblAddress2 = new JLabel("Address2");
		lblAddress2.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblAddress2.setBounds(250, 300, 100, 20);
		getContentPane().add(lblAddress2);
		
		txtEmail = new JTextField(Template1.c.getEmail());
		txtEmail.setColumns(10);
		txtEmail.setBounds(371, 150, 200, 20);
		getContentPane().add(txtEmail);
		
		txtPhone = new JTextField(Template1.c.getPhone());
		txtPhone.setColumns(10);
		txtPhone.setBounds(371, 200, 200, 20);
		getContentPane().add(txtPhone);
		
		txtAddress1 = new JTextField(Template1.c.getAddress1());
		txtAddress1.setColumns(10);
		txtAddress1.setBounds(371, 250, 200, 20);
		getContentPane().add(txtAddress1);
		
		txtAddress2 = new JTextField(Template1.c.getAddress2());
		txtAddress2.setColumns(10);
		txtAddress2.setBounds(371, 300, 200, 20);
		getContentPane().add(txtAddress2);
		
		String sDate1= Template1.c.getDob();;  
	    Date date1=new SimpleDateFormat("dd-MM-yyyy").parse(sDate1); 
		calendar = new JDateChooser();
		
		calendar.setDate(date1);
		calendar.setSize(200, 20);
		calendar.setLocation(371, 350);
		getContentPane().add(calendar);
		
		btnOrder = new JButton("See You Transaction History Here");
		btnOrder.setBackground(btn);
		btnOrder.setForeground(Color.white);
		btnOrder.setFocusable(false);
		btnOrder.setBounds(20, 61, 253, 20);
		getContentPane().add(btnOrder);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(592, 498, 89, 25);
		btnUpdate.setBackground(btn);
		btnUpdate.setFocusable(false);
		btnUpdate.setForeground(Color.white);
		getContentPane().add(btnUpdate);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblBirthday.setBounds(250, 350, 100, 20);
		getContentPane().add(lblBirthday);
		
		JLabel lblSafeWord = new JLabel("SafeWord");
		lblSafeWord.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblSafeWord.setBounds(250, 400, 100, 20);
		getContentPane().add(lblSafeWord);
		
		txtSafeWord = new JTextField((String) null);
		txtSafeWord.setColumns(10);
		txtSafeWord.setBounds(371, 400, 200, 20);
		getContentPane().add(txtSafeWord);
		
		lblPassword = new JLabel("Change Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setBounds(471, 445, 100, 18);
		getContentPane().add(lblPassword);
		btnUpdate.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String dob = calendar.getDate().getDate()+ "-" + (calendar.getDate().getMonth() + 1) + "-" + (1900 + calendar.getDate().getYear());
				Customer customer = Template1.c ;
				customer.setName(txtName.getText());
				customer.setEmail(txtEmail.getText());
				customer.setPhone(txtPhone.getText());
				customer.setAddress1(txtAddress1.getText());
				customer.setAddress2(txtAddress2.getText());
				customer.setDob(dob);
				dispose();
				try {
					new CustomerProfile();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		});
		
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OrderHistory();
				
			}
		});
		
		lblPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ChangePassword();
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
}
