package com.liyi.shop.component;


import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.liyi.shop.Main;
import java.awt.Font;

public class ItemListContainer extends JPanel {
	private String query ;
	private JLabel lblResult;
	public ItemListContainer(String c, String query, JFrame parent) {
	
		this.query = query;
		setBackground(new Color(255, 235, 238));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		lblResult = new JLabel("Result Not Found...");
		lblResult.setFont(new Font("Microsoft JhengHei", Font.ITALIC, 15));
		add(lblResult);
		lblResult.setVisible(false);
		
	
		
		if(c.equals("womens")) {
			checklblResultWomen();
			for(int i = 0; i < Main.women.searchProducts(Main.women, query).size(); i++) {
				if( i % 3 == 0) {
					add(new ItemList(i, Main.women.searchProducts(Main.women, query), parent));
				}
			}
			
		}
	
		else if (c.equals("mens")) {
			checklblResultMen();
			for(int i = 0; i < Main.men.searchProducts(Main.men, query).size(); i++) {
				if( i % 3 == 0) {
					add(new ItemList(i,  Main.men.searchProducts(Main.men, query), parent));
				}
			}
			
		}
	}
			
	private void checklblResultWomen() {
		System.out.println(Main.women.searchProducts(Main.women, query).size() );
		if(Main.women.searchProducts(Main.women, query).size() > 0 ) {	
			lblResult.setVisible(false);
		}else {
			lblResult.setVisible(true);
		}
	}
	
	private void checklblResultMen() {
		if(Main.men.searchProducts(Main.men, query).size() > 0 ) {	
			lblResult.setVisible(false);
		}else {
			lblResult.setVisible(true);
		}
	}
	

}
