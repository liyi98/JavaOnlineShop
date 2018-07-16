package com.liyi.shop.activities;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import com.liyi.shop.component.ItemListContainer;

public class ActivityCategory extends Template1{
	private String category ;
	private ItemListContainer itemlistcontainer;

	public ActivityCategory(String category) {
		this.category = category;
		setTitle(category);
		itemlistcontainer = new ItemListContainer(category);
		itemlistcontainer.setBounds(0, 0, 2000, 430);
		JScrollPane pane = new JScrollPane(itemlistcontainer);
		pane.setBounds(20, 95, 760, 430);
		pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
		add(pane);
	}

	@Override
	public void start() {

		
	}
	

}
