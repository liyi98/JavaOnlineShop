package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.liyi.shop.component.ItemListContainer;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Item;

public class ActivityHomePage extends JFrame{
	private Customer c;
	private JList<Item> list;
	private JTable table;
	private JLabel lblLogOut;
	private String name = "home";

	public ActivityHomePage(Customer c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.c = c;
		setResizable(false);
		setTitle("Home");
		setSize(800,600);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		
		JLabel lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblHome.setBounds(31, 18, 40, 16);
		getContentPane().add(lblHome);
		
		JLabel lblMen = new JLabel("Men");
		lblMen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblMen.setBounds(110, 18, 40, 16);
		getContentPane().add(lblMen);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblUsername.setBounds(566, 18, 120, 16);
		getContentPane().add(lblUsername);
		
		lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblLogOut.setBounds(715, 18, 50, 16);
		lblLogOut.setVisible(false);
		getContentPane().add(lblLogOut);
		
		JLabel lblWomen = new JLabel("Women");
		lblWomen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblWomen.setBounds(190, 18, 50, 16);
		getContentPane().add(lblWomen);
		
		
			
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblSignIn.setBounds(715, 18, 50, 16);
		lblSignIn.setVisible(true);
		lblSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				new ActivityCustomerLogin();
				dispose();
			}
		});
		getContentPane().add(lblSignIn);
		ItemListContainer i = new ItemListContainer("womens");
		i.setBounds(0, 0, 2000, 430);
		JScrollPane pane = new JScrollPane(i);
		pane.setBounds(75, 95, 620, 430);
		add(pane);
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				dispose();
				new ActivityHomePage(null);
			}
		});
		setVisible(true);
		
		if (c != null) {
			lblUsername.setText(c.getName());
			lblLogOut.setVisible(true);
			lblSignIn.setVisible(false);
		}else {
			lblUsername.setVisible(false);

		}
	}
	
	public Customer getC() {
		return c;
	}
}
