package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.liyi.shop.model.Staff;

public class Template3 extends JPanel{
	private JFrame parent;
	public static Staff staff;
	private static final long serialVersionUID = 1L;

	public Template3(Staff staff, JFrame parent) {
		this.parent = parent;
		setSize(800,50);
		Color bk = new Color(255, 205, 210);
		Color btn = new Color(240, 248, 255);
		setBackground(bk);
		setLayout(null);
		
		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblLogout.setBounds(697, 16, 60, 15);
		add(lblLogout);
	
		
		JButton btnWomen = new JButton("Women ");
		btnWomen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnWomen.setBounds(26, 13, 90, 23);
		btnWomen.setBackground(btn);
		add(btnWomen);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnOrder.setBounds(277, 12, 90, 23);
		btnOrder.setBackground(btn);
		add(btnOrder);
		
		JLabel lblUsername = new JLabel("hi");
		lblUsername.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblUsername.setBounds(570, 17, 84, 14);
		add(lblUsername);
		
		JButton btnMen = new JButton("Men");
		btnMen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnMen.setBounds(149, 12, 90, 23);
		btnMen.setBackground(btn);
		add(btnMen);
		btnWomen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				new ActivityManageWomen(staff);
				
				
			}
		});
		
		btnMen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				new ActivityManageMen(staff);
				
			}
		});
		btnOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parent.dispose();
				new ActivityManageOrder(staff);
			}
		});
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				parent.dispose();
				new ActivityStaffLogin();
			}
		});

	}
}
