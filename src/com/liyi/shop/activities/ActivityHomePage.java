package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.liyi.shop.Main;
import com.liyi.shop.component.HomePageItem;
import com.liyi.shop.component.ItemListContainer;
import com.liyi.shop.component.ItemSingle;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Customer;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class ActivityHomePage extends JFrame{
	private ItemListContainer itemlistcontainer;

	public ActivityHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 235, 238);
		getContentPane().setBackground(bk);
		setTitle("Home");
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		
		JPanel panel = new JPanel();
		panel.setBounds(47, 93, 692, 191);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(47, 334, 692, 191);
		getContentPane().add(panel1);
		panel1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblWomen = new JLabel("Fashion Women New Arrival");
		lblWomen.setBounds(47, 62, 200, 20);
		getContentPane().add(lblWomen);
		
		JLabel lblMen = new JLabel("Fashion Men New Arrival");
		lblMen.setBounds(47, 307, 200, 20);
		getContentPane().add(lblMen);
		for(int i = Main.women.getAllItems().size() - 1 ; i > Main.women.getAllItems().size() -4  ; --i) {
			panel.add(new HomePageItem(Main.women.getAllItems().get(i)));
		}
		
		for(int i = Main.men.getAllItems().size() - 1 ; i > Main.men.getAllItems().size() -4  ; --i) {
			panel1.add(new HomePageItem(Main.men.getAllItems().get(i)));
		}
			
			
		setLocationRelativeTo(null);
		setVisible(true);

	}
}
