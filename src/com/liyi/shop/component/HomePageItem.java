package com.liyi.shop.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.liyi.shop.model.Product;
import javax.swing.SwingConstants;
import java.awt.Font;

public class HomePageItem extends JPanel{
	
	public HomePageItem(Product product) {
		setLayout(null);
		setSize(230,190);
		setBackground(new Color(255, 235, 238));
		JLabel lblProductImage = new JLabel("hi");
		lblProductImage.setLocation(12, 0);
		lblProductImage.setSize(200, 130);
		ImageIcon icon = new ImageIcon(product.getPhoto());
		Image newicon = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		lblProductImage.setIcon(new ImageIcon(newicon));
		add(lblProductImage);
		
		JLabel lblName = new JLabel(product.getName());
		lblName.setFont(new Font("Microsoft JhengHei", Font.BOLD, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(12, 138, 200, 20);
		add(lblName);
		
		JLabel lblGoToVisit = new JLabel("Go to Visit");
		lblGoToVisit.setForeground(new Color(236, 64, 122));
		lblGoToVisit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGoToVisit.setHorizontalAlignment(SwingConstants.CENTER);
		lblGoToVisit.setBounds(12, 166, 200, 14);
		add(lblGoToVisit);
		setVisible(true);
	}

}
