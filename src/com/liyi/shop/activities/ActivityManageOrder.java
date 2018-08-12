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

import com.liyi.shop.Main;
import com.liyi.shop.component.CustomTextField;
import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Order;
import com.liyi.shop.model.Product;
import com.liyi.shop.model.Staff;
import com.liyi.shop.small.activity.EditOrder;

public class ActivityManageOrder extends JFrame{
	private static final long serialVersionUID = 1L;
	private CustomTextField txtSearch;
	public static Staff staff;
	private JTable tableOrder;
	private String[] columnName = {"Order ID", "Order Date", "Order Status", "Customer ID ", "Action", "Action"};	
	private Object[][] array ;
	private int num = 0;
	private ArrayList<Order> orders = new ArrayList<>();

	public ActivityManageOrder(Staff staff) {
		Color btn = new Color(240, 248, 255);
		for(Customer customer : Customer.customers) {
			num += customer.getAllOrder().size();
			for (Order order : customer.getAllOrder()) {
				orders.add(order);
			}
		}
		System.out.println(num);
		array = new Object[num][6];
		for(int row = 0; row < num ; row++) {
			Order current = orders.get(row);
			//System.out.println(current.getOrderID());
			array[row][0] = current.getOrderID();
			array[row][1] = current.getDate();
			array[row][2] = current.getStatus();
			array[row][3] = current.getCustomer().getId();
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
		setTitle("Order");
		
		
		txtSearch = new CustomTextField("Please Enter Order ID");
		
		txtSearch.setFont(new Font("Tahoma", Font.ITALIC, 13));
		txtSearch.setBounds(26, 115, 670, 30);
		getContentPane().add(txtSearch);
		txtSearch.setColumns(10);
		txtSearch.setForeground(Color.GRAY);

		JButton btnSearch = new JButton("GO!");
		btnSearch.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		btnSearch.setBounds(698, 115, 64, 30);
		btnSearch.setBackground(btn);
		getContentPane().add(btnSearch);
	
		tableOrder = new JTable(array, columnName);
		tableOrder.setDefaultEditor(Object.class, null);
		tableOrder.setRowHeight(25);
		tableOrder.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		tableOrder.setBounds(26, 204, 736, 276);
		tableOrder.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableOrder.getColumnModel().getColumn(3).setPreferredWidth(10);
		tableOrder.getColumnModel().getColumn(2).setPreferredWidth(10);
		tableOrder.getColumnModel().getColumn(4).setPreferredWidth(5);
		tableOrder.getColumnModel().getColumn(5).setPreferredWidth(5);
		
		new TableButton(tableOrder, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new EditOrder(orders.get(Integer.parseInt(e.getActionCommand())), ActivityManageOrder.this, staff);
				
			}
		}, 4);

		new TableButton(tableOrder, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					orders.get(Integer.parseInt(e.getActionCommand())).getCustomer().delOrder(orders.get(Integer.parseInt(e.getActionCommand())));
					dispose();
					new ActivityManageOrder(staff);
				}else{
					
				};
			}
		}, 5);
		getContentPane().add(tableOrder);
		Color ivory = new Color(255, 235, 238);
		JScrollPane scroll1 = new JScrollPane(tableOrder);
		scroll1.setBackground(ivory);
		scroll1.setBounds(26, 178, 736, 343);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh(searchOrderID(Integer.parseInt(txtSearch.getText())));
				
			}
		});
	/*	btnAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddProduct(Main.men, ActivityManageMen.this,staff);
			
			}
		});*/
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refresh(ArrayList<Order> result) {
	
		tableOrder.setModel(new DefaultTableModel(columnName,result.size()));
		
		new TableButton(tableOrder, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//new EditCustomer(result.get(Integer.parseInt(e.getActionCommand())));
				
			}
		}, 4);
		new TableButton(tableOrder, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					orders.remove(Integer.parseInt(e.getActionCommand()));
					dispose();
					new ActivityManageOrder(staff);
				}else{
					
				};
			}
		}, 5);
		for (int row = 0; row < result.size(); row++) {
			Order current = result.get(row);
			tableOrder.getModel().setValueAt(current.getOrderID(), row, 0);
			tableOrder.getModel().setValueAt(current.getDate(), row, 1);
			tableOrder.getModel().setValueAt(current.getStatus(), row, 2);
			tableOrder.getModel().setValueAt(current.getCustomer().getId(), row, 3);
			tableOrder.getModel().setValueAt("Edit", row, 4);
			tableOrder.getModel().setValueAt("Delete", row, 5);

		}
	}
	
	private ArrayList<Order> searchOrderID(int query) {
		ArrayList<Order> tmp = new ArrayList<>();
		for(Order order : orders) {
			if(order.getOrderID() == query) {
				tmp.add(order);
			}
		}
		return tmp;
	}
}
