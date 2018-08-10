package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
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

import com.liyi.shop.activities.ActivityCustomerLogin;
import com.liyi.shop.model.Customer;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.border.LineBorder;


public class SignUpPage extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtName;
	private JTextField txtEmail;
	private JPasswordField txtPassword;
	private JPasswordField txtConfirmPassword;
	private JTextField textPhone;
	private JTextField textAddress1;
	private JTextField textAddress2;
	private JTextField textSafeword;
	private JLabel lblSignIn;
	private JDateChooser calendar;
	private char[] pass1;
	private String password1;
	private char[] pass2;
	private String password2;



	public SignUpPage() {
		setResizable(false);
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,600);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		
		JLabel lblSignUpHere = new JLabel("Sign Up");
		lblSignUpHere.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 32));
		lblSignUpHere.setBounds(145, 11, 133, 44);
		getContentPane().add(lblSignUpHere);
		
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
		txtName.setBackground(Color.WHITE);
		txtName.setBounds(150, 79, 220, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(150, 119, 220, 20);
		getContentPane().add(txtEmail);
		
		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);
		txtPassword.setBackground(Color.WHITE);
		txtPassword.setBounds(150, 159, 220, 20);
		getContentPane().add(txtPassword);
		
		txtConfirmPassword = new JPasswordField();
		txtConfirmPassword.setColumns(10);
		txtConfirmPassword.setBackground(Color.WHITE);
		txtConfirmPassword.setBounds(150, 199, 220, 20);
		getContentPane().add(txtConfirmPassword);
		
		textPhone = new JTextField();
		textPhone.setColumns(10);
		textPhone.setBackground(Color.WHITE);
		textPhone.setBounds(150, 320, 220, 20);
		getContentPane().add(textPhone);
		
		textAddress1 = new JTextField();
		textAddress1.setColumns(10);
		textAddress1.setBackground(Color.WHITE);
		textAddress1.setBounds(150, 359, 220, 20);
		getContentPane().add(textAddress1);
		
		textAddress2 = new JTextField();
		textAddress2.setColumns(10);
		textAddress2.setBackground(Color.WHITE);
		textAddress2.setBounds(150, 399, 220, 20);
		getContentPane().add(textAddress2);
		
		textSafeword = new JTextField();
		textSafeword.setColumns(10);
		textSafeword.setBackground(Color.WHITE);
		textSafeword.setBounds(150, 439, 220, 20);
		getContentPane().add(textSafeword);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(151, 238, 109, 23);
		getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(262, 238, 109, 23);
		getContentPane().add(rdbtnFemale);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
	
		JLabel lblNewLabel = new JLabel("must exactly 8charaters");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(150, 466, 240, 12);
		getContentPane().add(lblNewLabel);
		
		calendar = new JDateChooser();
		calendar.setSize(220, 20);
		calendar.setLocation(150, 280);
		getContentPane().add(calendar);
		
		JButton btnSignUp = new JButton("Sign Up");
		Color custom = new Color(236, 64, 122);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(custom);
		btnSignUp.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				pass1 = txtPassword.getPassword();
				password1 = new String(pass1);
				pass2 = txtConfirmPassword.getPassword();
				password2 = new String(pass2);
				if(checkSignUp() > 5) {
				String gender = (rdbtnFemale.isSelected())? "Female": "Male";
				String dob = calendar.getDate().getDate()+ "-" + (calendar.getDate().getMonth() + 1) + "-" + (1900 + calendar.getDate().getYear());
				Customer.customers.add(new Customer(txtName.getText(), txtEmail.getText(), password1, gender,dob ,textPhone.getText(),textAddress1.getText(), textAddress2.getText(), textSafeword.getText()));
				JOptionPane.showMessageDialog(null,"Sucess!");

				}else if (checkSignUp() == 0) {
					JOptionPane.showMessageDialog(null,"Please fill up all the required field");
				}else if (checkSignUp() == 1) {
					JOptionPane.showMessageDialog(null,"Safeword must exactly 8 character");
				}else if(checkSignUp() == 2) {
					JOptionPane.showMessageDialog(null,"Your password not match");
				}else if(checkSignUp() == 4) {
					JOptionPane.showMessageDialog(null,"Password must more than 6 character");
				}else if(checkSignUp() == 6) {
						JOptionPane.showMessageDialog(null,"Email already exist");
				}else {
					JOptionPane.showMessageDialog(null,"Wrong Email Format");
				}
			}
		});
		btnSignUp.setBounds(281, 496, 89, 23);
		getContentPane().add(btnSignUp);
		
		lblSignIn = new JLabel("Please Sign In Here");
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSignIn.setForeground(Color.BLUE);
		lblSignIn.setBounds(25, 500, 120, 14);
		lblSignIn.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				dispose();
				new ActivityCustomerLogin();
			}
		});
		
		
		getContentPane().add(lblSignIn);
		
		JLabel lbldob = new JLabel("Birthday");
		lbldob.setHorizontalAlignment(SwingConstants.LEFT);
		lbldob.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lbldob.setBounds(25, 280, 120, 20);
		getContentPane().add(lbldob);		

		setLocationRelativeTo(null);
		setVisible(true);
	}
	public int checkSignUp() {
		pass1 = txtPassword.getPassword();
		password1 = new String(pass1);
		pass2 = txtPassword.getPassword();
		password2 = new String(pass2);
		char[] safeword = textSafeword.getText().toCharArray();
		for(Customer customer: Customer.customers) {
			if(txtEmail.getText().equals(customer.getEmail())) {
				return 5;
			}
		}
		if(txtName.getText().isEmpty() ||txtEmail.getText().isEmpty()||textPhone.getText().isEmpty() || textAddress1.getText().isEmpty() || password1.isEmpty() || textSafeword.getText().isEmpty()) {
			return 0;
		}else if(!(safeword.length == 8)) {
			return 1;
		}else if(!password1.equals(password2)){
			return 2;
		}else if(!txtEmail.getText().matches("^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$")) {
			return 3;
		}else if(pass1.length < 7){
			return 4;
		}else {
			return 6;
		}
		
	
		
	}
}
