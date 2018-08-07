package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import com.liyi.shop.component.ItemListContainer;

public class ActivityCategory extends JFrame{
	private String category ;
	private ItemListContainer itemlistcontainer;

	public ActivityCategory(String category) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		this.category = category;
		setTitle(category);
		itemlistcontainer = new ItemListContainer(category);
		itemlistcontainer.setBounds(0, 0, 2000, 430);
		JScrollPane pane = new JScrollPane(itemlistcontainer);
		pane.setBounds(20, 95, 760, 430);
		pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
		add(pane);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	

}
