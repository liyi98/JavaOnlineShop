package com.liyi.shop.component;

import java.awt.Color;

import javax.swing.JFrame;

import com.liyi.shop.activities.ActivityCustomerLogin;
import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Product;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ItemDetails extends JFrame {
	private Product item;
	private ItemQuantity quantity ;
	
	public ItemDetails(Product item) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(500,300);
		Color bk = new Color(255, 235, 238);
		Color txt = new Color(252,228,236);
		getContentPane().setBackground(bk);
		setTitle(item.getName());
		
		JLabel lblImage = new JLabel("");
		ImageIcon icon = new ImageIcon(item.getPhoto());
		Image newicon = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		lblImage.setIcon(new ImageIcon(newicon));
		lblImage.setBounds(10, 11, 200, 130);
		getContentPane().add(lblImage);
		
		JLabel lblName = new JLabel(item.getName());
		lblName.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		lblName.setBounds(235, 15, 200, 20);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("RM " + item.getPrice());
		lblPrice.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblPrice.setBounds(235, 45, 200, 20);
		getContentPane().add(lblPrice);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		lblWeight.setBounds(235, 78, 46, 20);
		getContentPane().add(lblWeight);
		
		JLabel lblkg = new JLabel(item.getWeight() + "kg");
		lblkg.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		lblkg.setBounds(291, 78, 46, 20);
		getContentPane().add(lblkg);
		
		JTextArea lblDescription = new JTextArea(item.getDescription());
		lblDescription.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		lblDescription.setBounds(10, 168, 460, 67);
		lblDescription.setLineWrap(true);
		lblDescription.setBackground(txt);
		getContentPane().add(lblDescription);
		
		quantity = new ItemQuantity();
		quantity.setSize(135, 30);
		quantity.setBackground(bk);
		quantity.lblNumber.setBackground(Color.PINK);
		quantity.setLocation(235, 115);
		getContentPane().add(quantity);
		
		JLabel lblStock = new JLabel("Stock Left");
		lblStock.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 10));
		lblStock.setBounds(373, 246, 62, 15);
		getContentPane().add(lblStock);
		
		JLabel lblNewLabel = new JLabel(Integer.toString(item.getStock()));
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 10));
		lblNewLabel.setBounds(445, 246, 30, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Template1.c == null ) {
					if(JOptionPane.showConfirmDialog(null,"Login to Proceed ", "Please Login", 0) == 0) {
						dispose();
						new ActivityCustomerLogin();
					}
					
				}else {
					Cart.addCart(item, Template1.c, Integer.parseInt(quantity.lblNumber.getText()));
				}
				Template1.lblNum.setText("(" + Cart.carts.size() + ")" );
			}
		});
		btnCart.setBounds(380, 115, 89, 30);
		Color custom = new Color(229,115,115);
		btnCart.setForeground(Color.WHITE);
		btnCart.setBackground(custom);
		getContentPane().add(btnCart);
		
		JLabel lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblimg.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\stock1.png"));
		lblimg.setBounds(342, 246, 15, 15);
		getContentPane().add(lblimg);
		
		JLabel lblType = new JLabel("New label");
		lblType.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 10));
		lblType.setBounds(10, 246, 200, 15);
		getContentPane().add(lblType);
		
		JLabel lblDescription_1 = new JLabel("Description");
		lblDescription_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		lblDescription_1.setBounds(10, 152, 76, 14);
		getContentPane().add(lblDescription_1);
		
		if(item.getType() == 1) {
			lblType.setText("Fragile Shipping Fee: RM 10/kg");
		}else {
			lblType.setText("Non-Fragile Shipping Fee: RM 8/kg");
		}
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
