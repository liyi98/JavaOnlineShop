package com.liyi.shop.activities;

import java.awt.Dimension;

import javax.swing.JScrollPane;

import com.liyi.shop.component.ItemListContainer;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Customer;

public class ActivityHomePage extends Template1{
	private ItemListContainer itemlistcontainer;
	@Override
	public void start() {
		setTitle("Home");
		itemlistcontainer = new ItemListContainer("womens");
		itemlistcontainer.setBounds(0, 0, 2000, 430);
		JScrollPane pane = new JScrollPane(itemlistcontainer);
		pane.setBounds(20, 95, 760, 430);
		pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
		add(pane);
	

	}
	
	
}
