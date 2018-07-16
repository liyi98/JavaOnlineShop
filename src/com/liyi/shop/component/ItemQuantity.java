package com.liyi.shop.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ItemQuantity extends JPanel {
	private int num = 1;
	public JLabel lblNumber;
	public ItemQuantity() {
		setSize(114,31);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setHorizontalAlignment(SwingConstants.CENTER);
		Color custom = new Color(255,240,255);
		btnMinus.setBackground(custom);
		btnMinus.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		btnMinus.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(btnMinus)){
					if(num>1) {
					num--;
					lblNumber.setText(" " + num + "");
					}
				}
				}
		});

		setLayout(new GridLayout(0, 3, 0, 0));
		add(btnMinus);
		
		lblNumber = new JLabel(" " + num + " ");
		lblNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumber.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 18));
		add(lblNumber);
		
		JButton btnAdd = new JButton("+");
		btnAdd.setHorizontalAlignment(SwingConstants.CENTER);
		btnAdd.setBackground(custom);
		btnAdd.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(btnAdd)) {
					if(num>=1 && num<=98) {
						num++;
						lblNumber.setText(" " + num + "");
					}
				}
			}
		});

		add(btnAdd);
		setVisible(true);
	}

}
