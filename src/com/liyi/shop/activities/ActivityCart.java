package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.liyi.shop.model.Customer;

public class ActivityCart extends JFrame {
	public static Customer c;
	public JLabel lblHome;
	public static JLabel lblNum;

	private static final long serialVersionUID = 1L;
	public ActivityCart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Cart");
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		
		lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblHome.setBounds(31, 18, 40, 16);
		getContentPane().add(lblHome);
		
		JLabel lblMen = new JLabel("Men");
		lblMen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblMen.setBounds(110, 18, 40, 16);
		getContentPane().add(lblMen);
		
		JLabel lblUsername = new JLabel("Guest");
		lblUsername.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblUsername.setBounds(566, 18, 120, 16);
		getContentPane().add(lblUsername);
		
		JLabel lblLogOut = new JLabel("Log Out");
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
		

		lblWomen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				dispose();
				new ActivityCategory("womens");

			}
		});


		lblSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				new ActivityCustomerLogin();
				dispose();
			}
		});
		getContentPane().add(lblSignIn);
		
		lblNum = new JLabel("(0)");
		lblNum.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblNum.setBounds(500, 18, 20, 16);
		getContentPane().add(lblNum);
		
		JLabel lblCart = new JLabel("");
		lblCart.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\shopping_cart_PNG38.png"));
		lblCart.setBounds(472, 13, 25, 25);
		getContentPane().add(lblCart);

		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				dispose();
				c = null;
				new ActivityHomePage();
			}
		});
		
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				new ActivityHomePage();
				dispose();
			

			}
		});
		lblCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				new ActivityCart();
				dispose();
			}
		});
		lblMen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ActivityCategory("mens");
				dispose();
				super.mouseReleased(e);
			}
		});
	
		
		if (c != null) {
			lblUsername.setText(c.getName());
			lblLogOut.setVisible(true);
			lblSignIn.setVisible(false);
		}else {
			//lblUsername.setVisible(false);

		}
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	


}
