package com.liyi.shop.component;

import java.awt.Color;

import javax.swing.JFrame;

import com.liyi.shop.activities.ActivityCustomerLogin;
import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.Cart;
import com.liyi.shop.model.CartItem;
import com.liyi.shop.model.Product;
import com.liyi.shop.model.Rate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class ItemDetails extends JFrame {
	private Product item;
	private ItemQuantity quantity ;
	private JLabel lblRatings ;
	private JButton btnRate;
	private JLabel lblType;
	
	public ItemDetails(Product item, JFrame parent) {
		this.item = item;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(500,400);
		Color bk = new Color(255, 235, 238);
		Color txt = new Color(252,228,236);
		getContentPane().setBackground(bk);
		setTitle(item.getName());
		
		JLabel lblImage = new JLabel("");
		ImageIcon icon = new ImageIcon(item.getPhoto());
		Image newicon = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		lblImage.setIcon(new ImageIcon(newicon));
		lblImage.setBounds(10, 11, 200, 130);
		getContentPane().add(lblImage);
		
		JLabel lblName = new JLabel(item.getName());
		lblName.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		lblName.setBounds(235, 15, 200, 20);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("RM " + item.getPrice());
		lblPrice.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 13));
		lblPrice.setBounds(235, 45, 135, 20);
		getContentPane().add(lblPrice);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 11));
		lblWeight.setBounds(235, 78, 46, 20);
		getContentPane().add(lblWeight);
		
		JLabel lblkg = new JLabel(item.getWeight() + "kg");
		lblkg.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		lblkg.setBounds(291, 78, 46, 20);
		getContentPane().add(lblkg);
		
		JTextArea lblDescription = new JTextArea(item.getDescription());
		lblDescription.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 11));
		lblDescription.setBounds(10, 168, 460, 67);
		lblDescription.setLineWrap(true);
		lblDescription.setBackground(txt);
		getContentPane().add(lblDescription);
		
		
		quantity = new ItemQuantity();
		quantity.setSize(135, 30);
		quantity.setBackground(bk);
		quantity.lblNumber.setBackground(Color.PINK);
		quantity.setLocation(235, 115);
		getContentPane().add(quantity);
		
		JLabel lblStock = new JLabel("Stock Left");
		lblStock.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 10));
		lblStock.setBounds(373, 246, 62, 15);
		getContentPane().add(lblStock);
		
		JLabel lblNewLabel = new JLabel(Integer.toString(item.getStock()));
		lblNewLabel.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 10));
		lblNewLabel.setBounds(445, 246, 30, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Template1.c == null ) {
					if(JOptionPane.showConfirmDialog(null,"Login to Proceed ", "Please Login", 0) == 0) {
						parent.dispose();
						dispose();
						new ActivityCustomerLogin();
					}
					
				}else {
					Template1.c.getCart().getCartitems().add(new CartItem(item ,Integer.parseInt(quantity.lblNumber.getText())));
					Template1.lblNum.setText("(" + Template1.c.getCart().getCartitems().size() + ")" );
				}
				
			}
		});
		btnCart.setBounds(380, 115, 89, 30);
		Color custom = new Color(236, 64, 122);
		btnCart.setForeground(Color.WHITE);
		btnCart.setBackground(custom);
		getContentPane().add(btnCart);
		
		JLabel lblimg = new JLabel("");
		lblimg.setHorizontalAlignment(SwingConstants.CENTER);
		lblimg.setIcon(new ImageIcon("C:\\Users\\addme\\Documents\\PhotoOnlineShop\\stock1.png"));
		lblimg.setBounds(342, 246, 15, 15);
		getContentPane().add(lblimg);
		
		StarRating star = new StarRating();
		star.setLocation(10, 312);
		getContentPane().add(star);
		
		lblType = new JLabel("New label");
		lblType.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 10));
		lblType.setBounds(10, 246, 200, 15);
		getContentPane().add(lblType);
		
		JLabel lblDescription_1 = new JLabel("Description");
		lblDescription_1.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 11));
		lblDescription_1.setBounds(10, 152, 76, 14);
		getContentPane().add(lblDescription_1);
		
		btnRate = new JButton("Rate");
		btnRate.setBackground(Color.LIGHT_GRAY);
		btnRate.setBounds(161, 312, 80, 23);
		getContentPane().add(btnRate);
		
		lblRatings = new JLabel();
		lblRatings.setForeground(Color.RED);
		lblRatings.setBackground(Color.YELLOW);
		lblRatings.setFont(new Font("Microsoft JhengHei", Font.BOLD, 18));
		lblRatings.setHorizontalAlignment(SwingConstants.CENTER);
		lblRatings.setBounds(389, 49, 50, 20);
		getContentPane().add(lblRatings);
		
		JLabel lblGiveARatings = new JLabel("Give a ratings.....");
		lblGiveARatings.setFont(new Font("Microsoft JhengHei", Font.BOLD, 11));
		lblGiveARatings.setBounds(10, 284, 100, 20);
		getContentPane().add(lblGiveARatings);
		
		checkRateSize();
		checkCustomer();
		checkItemType();
			

		btnRate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				item.addRate(new Rate(star.getRate(), Template1.c, item));
			}
		});
		

		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void checkItemType() {
		if(item.getType() == 1) {
			lblType.setText("Fragile Shipping Fee: RM 10/kg");
		}else {
			lblType.setText("Non-Fragile Shipping Fee: RM 8/kg");
		}
	}
	private void checkRateSize() {
		if(item.getRates().size() == 0) {
			lblRatings.setText("0.0");
		}else {
			String averageRate = new DecimalFormat("#0.0").format(item.getAverageRate());
			lblRatings.setText(averageRate);
		}
	}
	
	private void checkCustomer() {
		if(Template1.c != null){
			btnRate.setEnabled(true);
		}else {
			btnRate.setEnabled(false);
		}
	}
}
