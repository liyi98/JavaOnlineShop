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
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class ItemSingleBlank extends JPanel {
	public ItemSingleBlank() {
		setSize(240,220);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(new Color(255, 235, 238));
		ImageIcon icon = new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\transparent.png");
		Image newicon = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		JLabel lblProductImage = new JLabel("");
		lblProductImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductImage.setIcon(new ImageIcon(newicon));
		add(lblProductImage);
		add(Box.createRigidArea(new Dimension(10, 8)));
		setVisible(true);


	}
}
