package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.liyi.shop.component.ItemListContainer;
import com.liyi.shop.component.ItemSingle;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Customer;

public class ActivityHomePage extends JFrame{
	private ItemListContainer itemlistcontainer;

	public ActivityHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		setTitle("Home");
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		itemlistcontainer = new ItemListContainer("womens");
		itemlistcontainer.setBounds(0, 0, 2000, 430);
		JScrollPane pane = new JScrollPane(itemlistcontainer);
		pane.setBounds(20, 95, 760, 430);
		pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
		add(pane);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	
}
