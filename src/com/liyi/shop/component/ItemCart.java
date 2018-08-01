package com.liyi.shop.component;

import javax.swing.JPanel;

import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Product;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ItemCart extends JPanel {
	private Product item;
	
	public ItemCart(Product item) {
		this.item = item;
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 11, 120, 90);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(157, 49, 46, 14);
		add(lblNewLabel_1);

	}

}
