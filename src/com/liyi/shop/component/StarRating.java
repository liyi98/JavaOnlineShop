package com.liyi.shop.component;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StarRating extends JPanel {
	private int i = 0;
	
	public StarRating() {
		setLayout(null);
		setSize(100,19);
		setBackground(new Color(255, 235, 238));
		JLabel lblstar1 = new JLabel();
		lblstar1.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\star.png"));
		lblstar1.setSize(19, 19);
		lblstar1.setLocation(0, 0);
		add(lblstar1);
		
		JLabel lblstar2 = new JLabel();
		lblstar2.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\star.png"));
		lblstar2.setSize(19, 19);
		lblstar2.setLocation(19, 0);
		add(lblstar2);
		
		JLabel lblstar3 = new JLabel();
		lblstar3.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\star.png"));
		lblstar3.setSize(19, 19);
		lblstar3.setLocation(38, 0);
		add(lblstar3);
		
		JLabel lblstar4 = new JLabel();
		lblstar4.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\star.png"));
		lblstar4.setSize(19, 19);
		lblstar4.setLocation(57, 0);
		add(lblstar4);
		
		JLabel lblstar5 = new JLabel();
		lblstar5.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\star.png"));
		lblstar5.setSize(19, 19);
		lblstar5.setLocation(76, 0);
		add(lblstar5);
		
		JLabel lblrate1 = new JLabel();
		lblrate1.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\rate.png"));
		lblrate1.setSize(19, 19);
		lblrate1.setLocation(0, 0);
		lblrate1.setVisible(false);
		add(lblrate1);
	
		JLabel lblrate2 = new JLabel();
		lblrate2.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\rate.png"));
		lblrate2.setSize(19, 19);
		lblrate2.setLocation(19, 0);
		lblrate2.setVisible(false);
		add(lblrate2);
		
		JLabel lblrate3 = new JLabel();
		lblrate3.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\rate.png"));
		lblrate3.setSize(19, 19);
		lblrate3.setLocation(38, 0);
		lblrate3.setVisible(false);
		add(lblrate3);
		
		JLabel lblrate4 = new JLabel();
		lblrate4.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\rate.png"));
		lblrate4.setSize(19, 19);
		lblrate4.setLocation(57, 0);
		lblrate4.setVisible(false);
		add(lblrate4);
		
		JLabel lblrate5 = new JLabel();
		lblrate5.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\rate.png"));
		lblrate5.setSize(19, 19);
		lblrate5.setLocation(76, 0);
		lblrate4.setVisible(false);
		add(lblrate5);
		
		lblstar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 1;
				lblstar1.setVisible(false);
				lblrate1.setVisible(true);
				
			}
		});
		
		lblrate1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 1;
				lblstar1.setVisible(false);
				lblstar2.setVisible(true);
				lblstar3.setVisible(true);
				lblstar4.setVisible(true);
				lblstar5.setVisible(true);
				lblrate1.setVisible(true);
				lblrate2.setVisible(false);
				lblrate3.setVisible(false);
				lblrate4.setVisible(false);
				lblrate5.setVisible(false);
			}
		});
		lblstar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 2;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
			}
		});
		lblrate2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 2;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(true);
				lblstar4.setVisible(true);
				lblstar5.setVisible(true);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(false);
				lblrate4.setVisible(false);
				lblrate5.setVisible(false);
			}
		});
		
		lblstar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 3;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(false);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(true);
			}
		});
		
		lblrate3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 3;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(false);
				lblstar4.setVisible(true);
				lblstar5.setVisible(true);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(true);
				lblrate4.setVisible(false);
				lblrate5.setVisible(false);
			}
		});
		
		lblstar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 4;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(false);
				lblstar4.setVisible(false);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(true);
				lblrate4.setVisible(true);
			}
		});
		
		lblrate4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 4;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(false);
				lblstar4.setVisible(false);
				lblstar5.setVisible(true);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(true);
				lblrate4.setVisible(true);
				lblrate5.setVisible(false);
			}
		});
		lblstar5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 5;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(false);
				lblstar4.setVisible(false);
				lblstar5.setVisible(false);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(true);
				lblrate4.setVisible(true);
				lblrate5.setVisible(true);
			}
		});
		
		lblrate5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				i = 5;
				lblstar1.setVisible(false);
				lblstar2.setVisible(false);
				lblstar3.setVisible(false);
				lblstar4.setVisible(false);
				lblstar5.setVisible(false);
				lblrate1.setVisible(true);
				lblrate2.setVisible(true);
				lblrate3.setVisible(true);
				lblrate4.setVisible(true);
				lblrate5.setVisible(true);
			}
		});
	}
	public int getRate() {
		return i ;
	}
}
