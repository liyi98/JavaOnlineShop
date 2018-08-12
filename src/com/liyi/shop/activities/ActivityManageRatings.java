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
import com.liyi.shop.model.Rate;
import com.liyi.shop.model.Staff;
import com.liyi.shop.small.activity.EditOrder;

public class ActivityManageRatings extends JFrame{
	private static final long serialVersionUID = 1L;
	private CustomTextField txtSearch;
	public static Staff staff;
	private JTable tableRate;
	private String[] columnName = {"Product ID", "ProductName", "Ratings", "Customer ID ", "CustomerName", "Action"};	
	private Object[][] array ;
	private ArrayList<Rate> ratings = new ArrayList<>();

	public ActivityManageRatings(Staff staff) {
		Color btn = new Color(240, 248, 255);
		for(Product product : Main.men.getAllItems()) {
			for (Rate rate : product.getRates()) {
				ratings.add(rate);
			}
		}
		for(Product product : Main.women.getAllItems()) {
			for (Rate rate : product.getRates()) {
				ratings.add(rate);
			}
		}
		array = new Object[ratings.size()][6];
		for(int row = 0; row < ratings.size() ; row++) {
			Rate current = ratings.get(row);
			//System.out.println(current.getOrderID());
			array[row][0] = current.getProduct().getId();
			array[row][1] = current.getProduct().getName();
			array[row][2] = current.getRate();
			array[row][3] = current.getCustomer().getId();
			array[row][4] = current.getCustomer().getName();
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
		setTitle("Ratings");
		
		
		txtSearch = new CustomTextField("Please Enter Product ID");
		
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
	
		tableRate = new JTable(array, columnName);
		tableRate.setDefaultEditor(Object.class, null);
		tableRate.setRowHeight(25);
		tableRate.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		tableRate.setBounds(26, 204, 736, 276);
		tableRate.getColumnModel().getColumn(0).setPreferredWidth(5);
		tableRate.getColumnModel().getColumn(3).setPreferredWidth(10);
		tableRate.getColumnModel().getColumn(2).setPreferredWidth(10);
		tableRate.getColumnModel().getColumn(4).setPreferredWidth(5);
		


		getContentPane().add(tableRate);
		Color ivory = new Color(255, 235, 238);
		JScrollPane scroll1 = new JScrollPane(tableRate);
		scroll1.setBackground(ivory);
		scroll1.setBounds(26, 178, 736, 343);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				refresh(searchProductId(txtSearch.getText()));
				
			}
		});
		new TableButton(tableRate, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					ratings.get(Integer.parseInt(e.getActionCommand())).getProduct().delRate(ratings.get(Integer.parseInt(e.getActionCommand())));
					dispose();
					new ActivityManageRatings(staff);
				}else{
					
				};
			}
		}, 5);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refresh(ArrayList<Rate> result) {
	
		tableRate.setModel(new DefaultTableModel(columnName,result.size()));
		
		new TableButton(tableRate, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Warning", 0) == 0) {
					result.get(Integer.parseInt(e.getActionCommand())).getProduct().delRate(result.get(Integer.parseInt(e.getActionCommand())));
					dispose();
					new ActivityManageRatings(staff);
				}else{
					
				};
			}
		}, 5);
		
		for (int row = 0; row < result.size(); row++) {
			Rate current = result.get(row);
			tableRate.getModel().setValueAt(current.getProduct().getId(), row, 0);
			tableRate.getModel().setValueAt(current.getProduct().getName(), row, 1);
			tableRate.getModel().setValueAt(current.getRate(), row, 2);
			tableRate.getModel().setValueAt(current.getCustomer().getId(), row, 3);
			tableRate.getModel().setValueAt(current.getCustomer().getName(), row, 4);
			tableRate.getModel().setValueAt("Delete", row, 5);
		}
	}
	
	private ArrayList<Rate> searchProductId(String query) {
		ArrayList<Rate> tmp = new ArrayList<>();
		for(Rate rating : ratings) {
			if(rating.getProduct().getId().contains(query)) {
				tmp.add(rating);
			}
		}
		return tmp;
	}
}
