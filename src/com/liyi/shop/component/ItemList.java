package com.liyi.shop.component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.liyi.shop.model.Item;

import java.util.ArrayList;

import javax.swing.BoxLayout;

public class ItemList extends JPanel {
	int u ;
	ArrayList<String> womens ; 
	public ItemList(int u, ArrayList<String> womens) {
		this.womens = womens;
		this.u = u;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(620,250);
		for(int i = u; i < u + 3; i++) {
		ItemSingle item = new ItemSingle(Item.items.get(Integer.parseInt(womens.get(i))).getPhoto(),Item.items.get(Integer.parseInt(womens.get(i))).getName(),Item.items.get(Integer.parseInt(womens.get(i))).getPrice());
		add(item);
		
		}

	}

}
