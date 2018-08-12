package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.liyi.shop.component.CustomTextField;
import com.liyi.shop.component.ItemListContainer;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ActivityCategory extends JFrame{
	private String category ;
	private ItemListContainer itemlistcontainer;
	private CustomTextField textField;
	private JScrollPane pane;

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
		textField = new CustomTextField("Search...");
		textField.setBounds(10, 81, 130, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGo = new JButton("Go");
		btnGo.setBackground(Color.LIGHT_GRAY);
		btnGo.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 14));
		btnGo.setBounds(85, 112, 55, 25);
		getContentPane().add(btnGo);
		refresh("init","");
		ButtonGroup group = new ButtonGroup();
		
		btnGo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh("searching", textField.getText());		
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void refresh(String init,String query) {
		if(init.equals("init") ) {
			itemlistcontainer = new ItemListContainer(category, query, ActivityCategory.this);
			itemlistcontainer.setBounds(0, 60, 2000, 430);
			pane = new JScrollPane(itemlistcontainer);
			pane.setBounds(150, 80, 630, 480);
			pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
			getContentPane().add(pane);
		}else {
			if(query.equals("Search...")) {
			ActivityCategory.this.getContentPane().remove(itemlistcontainer);
			  ActivityCategory.this.getContentPane().remove(pane);                      
				itemlistcontainer = new ItemListContainer(category, "", ActivityCategory.this);
				itemlistcontainer.setBounds(0, 60, 2000, 430);
				pane = new JScrollPane(itemlistcontainer);
				pane.setBounds(150, 80, 630, 480);
				pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
				getContentPane().add(pane);
			    ActivityCategory.this.revalidate(); 
			    ActivityCategory.this.repaint();
			}else {
				ActivityCategory.this.getContentPane().remove(itemlistcontainer);
				  ActivityCategory.this.getContentPane().remove(pane);                      
					itemlistcontainer = new ItemListContainer(category, query, ActivityCategory.this);
					itemlistcontainer.setBounds(0, 60, 2000, 430);
					pane = new JScrollPane(itemlistcontainer);
					pane.setBounds(150, 80, 630, 480);
					pane.getVerticalScrollBar().setPreferredSize(new Dimension(4,1));
					getContentPane().add(pane);
				    ActivityCategory.this.revalidate(); 
				    ActivityCategory.this.repaint();
			}
		}

	}
	
	
}
