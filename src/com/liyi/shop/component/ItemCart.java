package com.liyi.shop.component;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.liyi.shop.activities.ActivityCart;
import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.CartItem;
import com.liyi.shop.model.Product;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class ItemCart extends JPanel {
	private JLabel lblQuantity;
	private JLabel lblDel;
	private JLabel lblSubtotal;
	private CartItem cartitem;

	
	public ItemCart(ActivityCart cart, CartItem cartitem) {
		this.cartitem = cartitem;
		setLayout(null);
		Color btn = new Color(236, 64, 122);

		setSize(710, 120);
		ImageIcon icon = new ImageIcon(cartitem.getProduct().getPhoto());
		Image img = icon.getImage().getScaledInstance(130, 90, Image.SCALE_SMOOTH);
		JLabel lblImage = new JLabel(new ImageIcon(img));
		lblImage.setBounds(10, 11, 120, 90);
		add(lblImage);
		
		JLabel lblName = new JLabel(cartitem.getProduct().getName());
		lblName.setBounds(160, 42, 146, 29);
		add(lblName);
		
		String price = new DecimalFormat("#,##0.00").format(cartitem.getProduct().getPrice());	
		JLabel lblPrice = new JLabel(price);
		lblPrice.setBounds(316, 49, 46, 14);
		add(lblPrice);
		
		JLabel lblWeight = new JLabel(Double.toString(cartitem.getProduct().getWeight()));
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setBounds(391, 49, 46, 14);
		add(lblWeight);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setBounds(471, 44, 40, 25);
		btnMinus.setBackground(btn);
		btnMinus.setForeground(Color.WHITE);
		btnMinus.setFocusable(false);
		add(btnMinus);
		
		
		lblQuantity = new JLabel(Integer.toString(cartitem.getQuantity()));
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setBounds(509, 49, 34, 14);
		add(lblQuantity);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(539, 44, 46, 25);
		btnPlus.setBackground(btn);
		btnPlus.setForeground(Color.WHITE);
		btnPlus.setFocusable(false);
		add(btnPlus);
		
	
		lblSubtotal = new JLabel();
		lblSubtotal.setBounds(619, 49, 60, 14);
		add(lblSubtotal);
		
		
		lblDel = new JLabel("x");
		lblDel.setHorizontalAlignment(SwingConstants.LEFT);
		lblDel.setForeground(Color.RED);
		lblDel.setBounds(700, 49, 20, 14);
		add(lblDel);

		refresh();
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			int i = Integer.parseInt(lblQuantity.getText());
				if( i > 1) {
					i--;				
					cartitem.setQuantity(i);
					refresh();
					cart.refresh();
	
					
				}else {
					
				}
				
			}
		});
		
		btnPlus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int i = Integer.parseInt(lblQuantity.getText());
				if( i >= 1) {
					i++;
					lblQuantity.setText(Integer.toString(i));
					cartitem.setQuantity(i);
					refresh();
					cart.refresh();
				}else {
					
				}
				
			}
		});
		
		lblDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Template1.c.getCart().getCartitems().remove(cartitem);
				cart.dispose();
				new ActivityCart();
				
			}
		});

	}
	
	public void refresh() {
		String subtotal = new DecimalFormat("#,##0.00").format(cartitem.subTotal());	
		lblSubtotal.setText(subtotal);
		lblQuantity.setText(Integer.toString(cartitem.getQuantity()));
		
	}

}
