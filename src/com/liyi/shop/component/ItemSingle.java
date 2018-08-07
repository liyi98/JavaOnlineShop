package com.liyi.shop.component;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.liyi.shop.activities.ActivityCustomerLogin;
import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.CartItem;
import com.liyi.shop.model.Product;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

public class ItemSingle extends JPanel {

	 private Product item ;
	 //private ItemQuantity itemQuantity ;
	public ItemSingle(Product item) {
		this.item = item;
		setSize(240,220);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel lblProductImage = new JLabel("");
		lblProductImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		ImageIcon icon = new ImageIcon(item.getPhoto());
		Image newicon = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		lblProductImage.setIcon(new ImageIcon(newicon));
		add(lblProductImage);
		add(Box.createRigidArea(new Dimension(10, 8)));
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(Color.DARK_GRAY);
		lblProductName.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblProductName.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductName.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		lblProductName.setText(item.getName());
		add(lblProductName);
		add(Box.createRigidArea(new Dimension(7, 7)));
		
		JLabel lblProductPrice = new JLabel("Product Price");
		lblProductPrice.setForeground(Color.BLACK);
		lblProductPrice.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblProductPrice.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 14));
		lblProductPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblProductPrice.setText("RM " + item.getPrice());
		add(lblProductPrice);
		add(Box.createRigidArea(new Dimension(7, 7)));
		/*itemQuantity = new ItemQuantity();
		add(itemQuantity);
		add(Box.createRigidArea(new Dimension(7, 7)));
		
		itemQuantity.setLayout(new BoxLayout(itemQuantity, BoxLayout.X_AXIS));*/
		
		JButton btnCart = new JButton("Add To Cart");
		Color custom = new Color(236, 64, 122);
		btnCart.setForeground(Color.WHITE);
		btnCart.setBackground(custom);
		btnCart.setFocusable(false);
		
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Template1.c == null ) {
				JOptionPane.showMessageDialog(null,"Please Login to Proceed ", "Login", 2);				
					
				}else {
				Template1.c.getCart().getCartitems().add(new CartItem(item,1));
				
				}
			
				Template1.lblNum.setText("(" + Template1.c.getCart().getCartitems().size() + ")" );
		
				
				
			}
		});
		lblProductImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				super.mouseReleased(arg0);
				new ItemDetails(item);
			}
		});
		btnCart.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));
		btnCart.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCart.setSize(50, 25);
		add(btnCart);
		add(Box.createRigidArea(new Dimension(10, 10)));
		setVisible(true);

	}
}
