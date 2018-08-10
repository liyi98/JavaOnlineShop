package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Customer;

import javafx.scene.Parent;

import javax.swing.ImageIcon;

public class Template1 extends JPanel {
	public static Customer c;
	public JLabel lblHome;
	public static JLabel lblNum;
	
	public Template1(JFrame parent){
		setSize(800,50);
		Color bk = new Color(255, 205, 210);
		setBackground(bk);
		setLayout(null);
		
		lblHome = new JLabel("Home");
		lblHome.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblHome.setBounds(31, 18, 40, 16);
		add(lblHome);
		
		JLabel lblMen = new JLabel("Men");
		lblMen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblMen.setBounds(110, 18, 40, 16);
		add(lblMen);
		
		JLabel lblUsername = new JLabel("Guest");
		lblUsername.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblUsername.setBounds(566, 18, 120, 16);
		add(lblUsername);
		
		JLabel lblLogOut = new JLabel("Log Out");
		lblLogOut.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblLogOut.setBounds(715, 18, 50, 16);
		lblLogOut.setVisible(false);
		add(lblLogOut);
		
		JLabel lblWomen = new JLabel("Women");
		lblWomen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblWomen.setBounds(190, 18, 50, 16);
		add(lblWomen);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblSignIn.setBounds(715, 18, 50, 16);
		lblSignIn.setVisible(true);
		

		lblWomen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseReleased(e);
				parent.dispose();
				new ActivityCategory("womens");

			}
		});


		lblSignIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				new ActivityCustomerLogin();
				parent.dispose();
			}
		});
		add(lblSignIn);
		
		lblNum = new JLabel();
		lblNum.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblNum.setBounds(500, 18, 20, 16);
		add(lblNum);
		
		if(c != null) {
			lblNum.setText("(" + c.getCart().getCartitems().size() +")");
		}else {
			lblNum.setText("(0)");
		}
		
		JLabel lblCart = new JLabel("");
		lblCart.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\shopping_cart_PNG38.png"));
		lblCart.setBounds(472, 13, 25, 25);
		add(lblCart);

		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				parent.dispose();
				c = null;
				new ActivityHomePage();
			}
		});
		
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				new ActivityHomePage();
				parent.dispose();
			

			}
		});
		lblCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				if(c == null ) {
					JOptionPane.showMessageDialog(null,"Please Login to Proceed ", "Login", 2);							
				}else {	
					new ActivityCart();
					parent.dispose();
					}
			}
		});
		lblMen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				new ActivityCategory("mens");
				parent.dispose();
				super.mouseReleased(e);
			}
		});
	
		
		if (c != null) {
			lblUsername.setText(c.getName());
			lblUsername.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					try {
						new CustomerProfile();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					parent.dispose();
				}
			});
			lblLogOut.setVisible(true);
			lblSignIn.setVisible(false);
		}else {
			//lblUsername.setVisible(false);

		}

	}
	


}
