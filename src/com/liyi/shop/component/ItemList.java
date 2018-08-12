package com.liyi.shop.component;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.liyi.shop.Main;
import com.liyi.shop.model.Product;

import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import java.awt.Color;

public class ItemList extends JPanel {
	
	public ItemList(int i, ArrayList<Product> item, JFrame parent) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setSize(620,250);
		setBackground(new Color(255, 235, 238));
		for (int a = 0; a < 3; i++, a++) {
			if (i < item.size()) {
			add(new ItemSingle(item.get(i), parent));
			} else {
				add(new ItemSingleBlank());
			}
		}

		setVisible(true);
	}

}
