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

public class ItemSingleBlank extends JPanel {
	public ItemSingleBlank(String image, String name, Double price) {
		setSize(240,220);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblProductImage = new JLabel("");
		lblProductImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductImage.setIcon(new ImageIcon(image));
		add(lblProductImage);
		add(Box.createRigidArea(new Dimension(10, 8)));
		setVisible(true);


	}
}
