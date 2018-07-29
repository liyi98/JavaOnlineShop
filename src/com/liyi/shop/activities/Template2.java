package com.liyi.shop.activities;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Staff;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JToolBar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import java.awt.CardLayout;

public class Template2 extends JPanel{
	private JFrame parent;
	public static Staff staff;
	public Template2(Staff staff, JFrame parent) {
		this.parent = parent;
		setLayout(null);
		setSize(800,50);
		Color bk = new Color(255, 205, 210);
		Color btn = new Color(240, 248, 255);
		setBackground(bk);
		setLayout(null);
		
		JLabel lblLogout = new JLabel("Log Out");
		lblLogout.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblLogout.setBounds(710, 12, 60, 20);
		add(lblLogout);
	
		
		JButton btnCustomer = new JButton("Customer");
		btnCustomer.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnCustomer.setBounds(30, 12, 100, 24);
		btnCustomer.setBackground(btn);
		add(btnCustomer);
		
		JButton btnManager = new JButton("Manager");
		btnManager.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnManager.setBounds(180, 12, 100, 24);
		btnManager.setBackground(btn);
		add(btnManager);
		
		JLabel lblUsername = new JLabel(staff.getName());
		lblUsername.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblUsername.setBounds(565, 12, 120, 20);
		add(lblUsername);

		
		btnCustomer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			new ActivityAdminCustomer(staff);
			parent.dispose();
				
			}
		});
		
		
		btnManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new ActivityAdminManager(staff);
			parent.dispose();

			}
		});
		lblLogout.addMouseListener(new MouseAdapter() {
		 @Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			super.mouseReleased(e);
			parent.dispose();
			new ActivityStaffLogin();
		}
		});

	}

}
