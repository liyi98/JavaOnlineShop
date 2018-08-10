package com.liyi.shop.component;


import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.liyi.shop.*;
import com.liyi.shop.model.Category;
import com.liyi.shop.Main;
import java.awt.Color;
import java.awt.SystemColor;

public class ItemListContainer extends JPanel {

	public ItemListContainer(String c) {
		setBackground(new Color(255, 235, 238));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane();
		if(c.equals("womens")) {
			for(int i = 0; i < Main.women.getAllItems().size(); i++) {
				if( i % 3 == 0) {
					add(new ItemList(i, Main.women.getAllItems()));
				}
			}
			
		}
		else if (c.equals("mens")) {
			for(int i = 0; i < Main.men.getAllItems().size(); i++) {
				if( i % 3 == 0) {
					add(new ItemList(i,  Main.men.getAllItems()));
				}
			}
			
		}
	}
			
	
	

}
