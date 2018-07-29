package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Product;
import com.liyi.shop.model.Staff;

import javax.swing.JTextArea;

public class AddProduct extends JFrame{

	private static final long serialVersionUID = 1L;
	private JTextField txtPath;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtWeight;
	private JTextField txtStock;
	private Staff staff;
	private JFrame frame;
	
	public AddProduct(JFrame frame, Staff staff) {
		this.frame = frame;
		getContentPane().setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		setResizable(false);
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,600);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		Color btn = new Color(240, 248, 255);
		getContentPane().setBackground(bk);
		
		JLabel lblTitle = new JLabel("Add Product");
		lblTitle.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		lblTitle.setBounds(126, 11, 178, 40);
		getContentPane().add(lblTitle);
	
		
	
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		Color custom = new Color(236, 64, 122);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(custom);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*customer.setName(txtName.getText());
				customer.setEmail(txtEmail.getText());
				customer.setPhone(textPhone.getText());
				customer.setAddress1(textAddress1.getText());
				customer.setAddress2(textAddress2.getText());
				String gender = (rdbtnFemale.isSelected())? "Female": "Male";
				customer.setGender(gender);
				dispose();*/
			}
		});
		btnSave.setBounds(281, 499, 89, 30);
		getContentPane().add(btnSave);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(25, 62, 200, 130);
		lblImage.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\gallery-512.png"));
		getContentPane().add(lblImage);
		
		txtPath = new JTextField();
		txtPath.setBounds(235, 95, 135, 20);
		getContentPane().add(txtPath);
		txtPath.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setDialogTitle("Browse the folder to process");
	            FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                    "JPG & PNG Images", "jpg", "png");
	            chooser.setFileFilter(filter);
	            chooser.setAcceptAllFileFilterUsed(true);     
	            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	                txtPath.setText(chooser.getSelectedFile().toString());
	                lblImage.setIcon(new ImageIcon(chooser.getSelectedFile().toString()));
	            } else {
	                
	            }
			}
		});
		btnBrowse.setBackground(btn);
		btnBrowse.setBounds(255, 126, 100, 23);
		getContentPane().add(btnBrowse);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblName.setBounds(25, 230, 120, 20);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblPrice.setBounds(25, 270, 120, 20);
		getContentPane().add(lblPrice);
		
		txtName = new JTextField();
		txtName.setBounds(150, 230, 220, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(150, 271, 220, 20);
		getContentPane().add(txtPrice);
		
		JLabel lblWeigth = new JLabel("Weight");
		lblWeigth.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblWeigth.setBounds(25, 310, 120, 20);
		getContentPane().add(lblWeigth);
		
		txtWeight = new JTextField() ;
		txtWeight.setColumns(10);
		txtWeight.setBounds(150, 310, 220, 20);
		getContentPane().add(txtWeight);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblStock.setBounds(25, 350, 120, 20);
		getContentPane().add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(150, 350, 220, 20);
		getContentPane().add(txtStock);
		
		JLabel lbldes = new JLabel("Description");
		lbldes.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lbldes.setBounds(25, 390, 120, 20);
		getContentPane().add(lbldes);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(150, 389, 220, 50);
		getContentPane().add(textArea);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblType.setBounds(25, 450, 120, 20);
		getContentPane().add(lblType);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Fragile");
		rdbtnNewRadioButton.setBackground(SystemColor.info);
		rdbtnNewRadioButton.setBounds(150, 450, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Non-Fragile");
		rdbtnNewRadioButton_1.setBackground(SystemColor.info);
		rdbtnNewRadioButton_1.setBounds(261, 450, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnNewRadioButton);
		group.add(rdbtnNewRadioButton_1);
		

		setLocationRelativeTo(null);
		setVisible(true);

	}
}
