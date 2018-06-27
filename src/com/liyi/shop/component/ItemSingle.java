package com.liyi.shop.component;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class ItemSingle extends JPanel {
	public ItemSingle(String image, String name, Double price) {
		setSize(240,220);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblProductImage = new JLabel("");
		lblProductImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductImage.setIcon(new ImageIcon(image));
		add(lblProductImage);
		add(Box.createRigidArea(new Dimension(10, 8)));
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblProductName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductName.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblProductName.setText(name);
		add(lblProductName);
		add(Box.createRigidArea(new Dimension(7, 7)));
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblProductPrice.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblProductPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductPrice.setText("RM " + price.toString());
		add(lblProductPrice);
		ItemQuantity itemQuantity = new ItemQuantity();
		add(itemQuantity);
		add(Box.createRigidArea(new Dimension(7, 7)));
		
		itemQuantity.setLayout(new BoxLayout(itemQuantity, BoxLayout.X_AXIS));
		
		JButton btnCart = new JButton("Add To Cart");
		Color custom = new Color(236, 64, 122);
		btnCart.setForeground(Color.WHITE);
		btnCart.setBackground(custom);
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCart.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));
		btnCart.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCart.setSize(50, 25);
		add(btnCart);
		add(Box.createRigidArea(new Dimension(10, 10)));
		setVisible(true);

	}
}
