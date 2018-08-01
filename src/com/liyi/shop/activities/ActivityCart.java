package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Customer;
import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;

public class ActivityCart extends JFrame {
	public Customer c;
	public JLabel lblHome;
	public static JLabel lblNum;
	private static final long serialVersionUID = 1L;
	private JTable tableCart;
	private String []columnName = {"Image", "Price", "Weight", "-","Quantity","+", "Subtotal", "Delete"};
	private Object [][] row;
	private double subtotal;
	
	public ActivityCart() {
		row = new Object[Cart.carts.size()][8];
		/*for(int i = 0; i < row.length; i++) {
			Cart current = Cart.carts.get(i);
			row[i][0] = current.getItem().getPhoto();
			row[i][1] = current.getItem().getPrice();
			row[i][2] = current.getItem().getWeight();
			row[i][3] = "-";
			row[i][4] = current.getQuantity();
			row[i][5] = "+";
			row[i][6] = "+";
			row[i][7] = "delete";
		}*/

	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Cart");
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		

		
	      DefaultTableModel model = new DefaultTableModel(row, columnName)
	        {
				public Class getColumnClass(int column)
	            {
	                return getValueAt(0, column).getClass();
	            }
	        };
	    tableCart = new JTable( model );
	    tableCart.setShowVerticalLines(false);
	    tableCart.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    tableCart.setFont(new Font("Microsoft YaHei Light", Font.PLAIN, 13));
	    tableCart.setBounds(31, 89, 734, 337);
	    tableCart.setRowHeight(80);
	    tableCart.setDefaultEditor(Object.class, null);
		tableCart.getColumnModel().getColumn(0).setPreferredWidth(120);
		tableCart.getColumnModel().getColumn(5).setPreferredWidth(35);
		getContentPane().add(tableCart);
		JScrollPane scroll1 = new JScrollPane(tableCart);
		scroll1.setViewportBorder(null);
		scroll1.setBounds(31, 89, 734, 337);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		
		
		for(int i = 0; i < Cart.carts.size(); i++) {
			Cart current = Cart.carts.get(i);
			ImageIcon image =new ImageIcon(current.getItem().getPhoto());
			Image newimage = image.getImage().getScaledInstance(120, 80, Image.SCALE_SMOOTH );
			tableCart.getModel().setValueAt(new ImageIcon(newimage), i, 0);
			tableCart.getModel().setValueAt(current.getItem().getPrice(), i, 1);
			tableCart.getModel().setValueAt(current.getItem().getWeight(), i, 2);
			tableCart.getModel().setValueAt("-", i, 3);
			tableCart.getModel().setValueAt(current.getQuantity(), i, 4);
			tableCart.getModel().setValueAt("+", i, 5);
			subtotal = current.getItem().getPrice() * current.getQuantity() ;
			tableCart.getModel().setValueAt(subtotal, i, 6);
			tableCart.getModel().setValueAt("x", i, 7);

			
		}
		new TableButton(tableCart, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(e.getActionCommand());
				Cart newCart =  Cart.carts.get(index);
				int i = newCart.getQuantity();
				if( i > 1) {
				i--;
				subtotal = i * newCart.getItem().getPrice();
				tableCart.getModel().setValueAt(i, index, 4);
				tableCart.getModel().setValueAt(subtotal, index, 6);
				newCart.setQuantity(i);
				}else {
					
				}
				
		
			}
		}, 3);
		new TableButton(tableCart, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = Integer.parseInt(e.getActionCommand());
				Cart newCart =  Cart.carts.get(index);
				int i = newCart.getQuantity();
				if( i >= 1) {
				i++;
				subtotal = i * newCart.getItem().getPrice();
				tableCart.getModel().setValueAt(i, index, 4);
				tableCart.getModel().setValueAt(subtotal, index, 6);
				newCart.setQuantity(i);
				}else {
					
				}
				
		
			}
		}, 5);
		new TableButton(tableCart, new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cart.delCart(Integer.parseInt(e.getActionCommand()));
				dispose();
				new ActivityCart();
			}
		}, 7);


		setLocationRelativeTo(null);
		setVisible(true);
	}
}
