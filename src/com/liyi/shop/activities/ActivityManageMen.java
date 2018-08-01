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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.liyi.shop.Main;
import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Category;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Product;
import com.liyi.shop.model.Staff;
import com.liyi.shop.small.activity.AddCustomerPage;
import com.liyi.shop.small.activity.AddProduct;
import com.liyi.shop.small.activity.EditCustomer;
import com.liyi.shop.small.activity.EditProduct;

public class ActivityManageMen extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField txtSearch;
	public static Staff staff;
	private JTable tablemen;
	private String[] columnName = {"ID", "Name", "Price", "Stock", "Action", "Action"};	
	private Object[][] array ;

	public ActivityManageMen(Staff staff) {
		Color btn = new Color(240, 248, 255);
		array = new Object[Main.men.getAllItems().size()][6];
		for(int row = 0; row < array.length; row++) {
			Product current = Main.men.getAllItems().get(row);
			array[row][0] = current.getId();
			array[row][1] = current.getName();
			array[row][2] = current.getPrice();
			array[row][3] = current.getStock();
			array[row][4] = "Edit";
			array[row][5] = "Delete";
		}
		Template3 menubar = new Template3(staff, this);
		getContentPane().add(menubar);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		setTitle("Manager- Men - Product");
		
		JButton btnAddProduct = new JButton("+ Add New Product");
		btnAddProduct.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
		btnAddProduct.setBounds(585, 60, 177, 28);
		btnAddProduct.setBackground(btn);
		getContentPane().add(btnAddProduct);
		
		txtSearch = new JTextField();
		txtSearch.setText("Search");
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearch.setBounds(26, 115, 670, 30);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("GO!");
		btnSearch.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		btnSearch.setBounds(698, 115, 64, 30);
		btnSearch.setBackground(btn);
		getContentPane().add(btnSearch);
	
		tablemen = new JTable(array, columnName);
		tablemen.setDefaultEditor(Object.class, null);
		tablemen.setRowHeight(25);
		tablemen.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		tablemen.setBounds(26, 204, 736, 276);
		tablemen.getColumnModel().getColumn(0).setPreferredWidth(5);
		tablemen.getColumnModel().getColumn(3).setPreferredWidth(10);
		tablemen.getColumnModel().getColumn(2).setPreferredWidth(10);
		tablemen.getColumnModel().getColumn(4).setPreferredWidth(5);
		tablemen.getColumnModel().getColumn(5).setPreferredWidth(5);
		new TableButton(tablemen, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditProduct(Main.men, ActivityManageMen.this, Main.men.getAllItems().get(Integer.parseInt(e.getActionCommand())), staff);
				
			}
		}, 4);

		new TableButton(tablemen, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					Main.men.delProduct(Integer.parseInt(e.getActionCommand()));
					dispose();
					new ActivityManageMen(staff);
				}else{
					
				};
			}
		}, 5);
		getContentPane().add(tablemen);
		Color ivory = new Color(255, 235, 238);
		JScrollPane scroll1 = new JScrollPane(tablemen);
		scroll1.setBackground(ivory);
		scroll1.setBounds(26, 178, 736, 343);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh(Main.men.searchProducts(Main.men, txtSearch.getText()));
				
			}
		});
		btnAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddProduct(Main.men, ActivityManageMen.this,staff);
			
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refresh(ArrayList<Product> result) {
	
		tablemen.setModel(new DefaultTableModel(columnName,result.size()));
		
		new TableButton(tablemen, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new EditCustomer(result.get(Integer.parseInt(e.getActionCommand())));
				
			}
		}, 4);
		new TableButton(tablemen, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer.delCustomer(Integer.parseInt(e.getActionCommand()));
				dispose();
				new ActivityManageMen(staff);
			}
		}, 5);
		for (int row = 0; row < result.size(); row++) {
			Product current = result.get(row);
			tablemen.getModel().setValueAt(current.getId(), row, 0);
			tablemen.getModel().setValueAt(current.getName(), row, 1);
			tablemen.getModel().setValueAt(current.getPrice(), row, 2);
			tablemen.getModel().setValueAt(current.getStock(), row, 3);
			tablemen.getModel().setValueAt("Edit", row, 4);
			tablemen.getModel().setValueAt("Delete", row, 5);

		}
	}
}
