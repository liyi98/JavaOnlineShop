package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.liyi.shop.component.CartList;
import com.liyi.shop.component.TableButton;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.Customer;
import com.liyi.shop.model.Order;
import com.liyi.shop.model.OrderItem;

import java.awt.Font;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ActivityCart extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLabel lblTotal;
	private JLabel lblShipping;
	private JLabel lblSum;
	private JButton btnCheckout;
	
	public ActivityCart() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("Cart");
		setResizable(false);
		setSize(800,600);
		Color bk = new Color(255, 205, 210);
		getContentPane().setBackground(bk);
		
		Template1 menubar = new Template1(this);
		getContentPane().add(menubar);
		CartList cart = new CartList(this);
		Color btn = new Color(236, 64, 122);

		JScrollPane scroll1 = new JScrollPane(cart);
		scroll1.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		scroll1.setBounds(31, 95, 734, 337);
		scroll1.getVerticalScrollBar().setPreferredSize(new Dimension(4,2));
		getContentPane().add(scroll1);
		
		JLabel lblImage = new JLabel("Image");
		lblImage.setForeground(Color.BLACK);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblImage.setBounds(43, 70, 103, 18);
		getContentPane().add(lblImage);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductName.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblProductName.setBounds(185, 70, 100, 18);
		getContentPane().add(lblProductName);
		
		JLabel lblPrice = new JLabel("Price(RM)");
		lblPrice.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setBounds(335, 70, 60, 18);
		getContentPane().add(lblPrice);
		
		JLabel lblWeight = new JLabel("Weight(kg)");
		lblWeight.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeight.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblWeight.setBounds(423, 70, 80, 18);
		getContentPane().add(lblWeight);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblQuantity.setBounds(515, 70, 100, 18);
		getContentPane().add(lblQuantity);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblSubtotal.setBounds(625, 70, 100, 18);
		getContentPane().add(lblSubtotal);
		
		JLabel lblTotalLabel = new JLabel("Total:");
		lblTotalLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTotalLabel.setBounds(31, 453, 100, 18);
		getContentPane().add(lblTotalLabel);
		
		JLabel lblFeeLabel = new JLabel("Shipping Fee:");
		lblFeeLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblFeeLabel.setBounds(31, 482, 100, 18);
		getContentPane().add(lblFeeLabel);
		
		btnCheckout = new JButton("Checkout");
		btnCheckout.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		btnCheckout.setBounds(672, 510, 89, 25);
		btnCheckout.setBackground(btn);
		btnCheckout.setForeground(Color.WHITE);
		btnCheckout.setFocusable(false);
		getContentPane().add(btnCheckout);
		
		checkCart();
		
		JLabel lblSumLabel = new JLabel("Sum:");
		lblSumLabel.setFont(new Font("Arial", Font.PLAIN, 13));
		lblSumLabel.setBounds(31, 510, 100, 18);
		getContentPane().add(lblSumLabel);
	
		lblTotal = new JLabel();
		lblTotal.setFont(new Font("Arial", Font.PLAIN, 13));
		lblTotal.setBounds(132, 455, 100, 14);
		getContentPane().add(lblTotal);
		
		lblShipping = new JLabel();
		lblShipping.setFont(new Font("Arial", Font.PLAIN, 13));
		lblShipping.setBounds(132, 484, 100, 14);
		getContentPane().add(lblShipping);
		
		lblSum = new JLabel();
		lblSum.setFont(new Font("Arial", Font.BOLD, 13));
		lblSum.setBounds(132, 510, 100, 18);
		getContentPane().add(lblSum);
		
		refresh();
		btnCheckout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new CustomerCheckOut(Template1.c.addOrder(new Order(Template1.c, "UnSucessful")));
				dispose();
				
			}
		});
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refresh() {
		String total = new DecimalFormat("RM #,##0.00").format(Template1.c.getCart().getTotal());	
		String fee = new DecimalFormat("RM #,##0.00").format(Template1.c.getCart().getTotalShippingFee());
		String sum = new DecimalFormat("RM #,##0.00").format(Template1.c.getCart().getSum());
		lblTotal.setText(total);
		lblShipping.setText(fee);
		lblSum.setText(sum);
	}

	private void checkCart() {
		if(Template1.c.getCart().getCartitems().size() == 0) {
			btnCheckout.setEnabled(false);
		}else {
			btnCheckout.setEnabled(true);
		}
	}
}
