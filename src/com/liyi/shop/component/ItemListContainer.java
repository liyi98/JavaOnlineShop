package com.liyi.shop.component;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.liyi.shop.model.Item;

public class ItemListContainer extends JPanel {
		String c ;
		ArrayList<String> womens = new ArrayList<>();
		ArrayList<String> mens = new ArrayList<>();
		ArrayList<String> home = new ArrayList<>();
		
	public ItemListContainer(String c) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JScrollPane scroll = new JScrollPane();
		
		if(c.equals("womens")) {
		for(int t = 0; t<Item.items.size();t++) {
			if(Item.items.get(t).getType().equals("women")){
				womens.add( t + "");
			}
		
		}
		}else if(c.equals("mens")){
			for(int t = 0; t<Item.items.size();t++) {
				if(Item.items.get(t).getType().equals("men")){
					mens.add( t + "");				
				}
			
			}
		}else if(c.equals("home")) {
			for(int u = Item.items.size(); u<Item.items.size() - 6;u--) {
				if(u % 3 == 0) {
					add(new ItemList(u,home));
				}
			
			}
		}
			

					
			for(int u = 0; u< womens.size() ; u++) {
				if(u % 3 == 0) {
					add(new ItemList(u,womens));
				}
			
			}
		}
		
				
			
	
	

}
