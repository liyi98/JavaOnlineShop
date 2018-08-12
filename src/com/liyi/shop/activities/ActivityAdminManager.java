package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.liyi.shop.component.CustomTextField;
import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Staff;
import com.liyi.shop.small.activity.AddManagerPage;
import com.liyi.shop.small.activity.EditStaff;

public class ActivityAdminManager extends JFrame {

	private CustomTextField txtSearch;	
	private String[] columnName = {"ID", "Name", "Email", "Phone", "Role", "Action", "Action"};	
	private Object[][] array = new Object[Staff.staffs.size()][7];
	private JTable table2;
	public Staff staff;
	
	public ActivityAdminManager(Staff staff) {
		Color btn = new Color(240, 248, 255);
		this.staff = staff;
		for(int row = 0; row < array.length; row++) {
			Staff current = Staff.staffs.get(row);
			array[row][0] = current.getId();
			array[row][1] = current.getName();
			array[row][2] = current.getEmail();
			array[row][3] = current.getPhone();
			array[row][4] = (current.getRole()== 1)?"Manager": "Admin";
			array[row][5] = "Edit";
			array[row][6] = "Delete";
		}
		Template2 menubar = new Template2(staff, this);
		add(menubar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		setTitle("Admin Panel - Manager");
		
		JButton btnAddManager = new JButton("+ Add New Manager");
		btnAddManager.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		btnAddManager.setBounds(585, 60, 177, 28);
		btnAddManager.setBackground(btn);
		getContentPane().add(btnAddManager);
		
		txtSearch = new CustomTextField("Search...");
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearch.setBounds(26, 115, 670, 30);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("GO!");
		btnSearch.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		btnSearch.setBounds(698, 115, 64, 30);
		btnSearch.setBackground(btn);
		getContentPane().add(btnSearch);
		
		table2 = new JTable(array, columnName);
		table2.setDefaultEditor(Object.class, null);
		table2.setRowHeight(25);
		table2.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		table2.setBounds(26, 204, 736, 276);
		table2.getColumnModel().getColumn(6).setPreferredWidth(35);
		table2.getColumnModel().getColumn(5).setPreferredWidth(35);
		table2.getColumnModel().getColumn(4).setPreferredWidth(35);
		table2.getColumnModel().getColumn(0).setPreferredWidth(35);
		new TableButton(table2, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
			new EditStaff(Staff.staffs.get(Integer.parseInt(e.getActionCommand())), ActivityAdminManager.this);	
				
			}
		}, 5);
		new TableButton(table2, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					Staff.deleteStaff(Staff.staffs.get(Integer.parseInt(e.getActionCommand())));
					dispose();
					new ActivityAdminManager(staff);
				}else{
				
				};
		
			}
		}, 6);
		getContentPane().add(table2);
		Color ivory = new Color(255, 235, 238);
		JScrollPane scroll1 = new JScrollPane(table2);
		scroll1.setBackground(ivory);
		scroll1.setBounds(26, 178, 736, 343);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		
		btnAddManager.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddManagerPage(ActivityAdminManager.this, staff);
				
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh(Staff.searchStaff(txtSearch.getText()));
				
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void refresh(ArrayList<Staff> result) {
		
		table2.setModel(new DefaultTableModel(columnName,result.size()));
		new TableButton(table2, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditStaff(result.get(Integer.parseInt(e.getActionCommand())),  ActivityAdminManager.this);
				
			}
		}, 5);
		new TableButton(table2, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					Staff.deleteStaff(Staff.staffs.get(Integer.parseInt(e.getActionCommand())));
					dispose();
					new ActivityAdminManager(staff);
				}else{
				
				};
			}
		}, 6);
		for (int row = 0; row < result.size(); row++) {
			Staff current = result.get(row);
			table2.getModel().setValueAt(current.getId(), row, 0);
			table2.getModel().setValueAt(current.getName(), row, 1);
			table2.getModel().setValueAt(current.getEmail(), row, 2);
			table2.getModel().setValueAt(current.getPhone(), row, 3);
			array[row][4] = (current.getRole()== 1)?"Manager": "Admin";
			table2.getModel().setValueAt("Edit", row, 5);
			table2.getModel().setValueAt("Delete", row, 6);

		}
	}

}
