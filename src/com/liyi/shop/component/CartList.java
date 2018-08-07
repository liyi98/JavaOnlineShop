package com.liyi.shop.component;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.liyi.shop.activities.ActivityCart;
import com.liyi.shop.activities.Template1;
import com.liyi.shop.model.CartItem;

public class CartList extends JPanel{
	private ActivityCart cart;
	
	public CartList(ActivityCart cart) {
		this.cart = cart;
		setPreferredSize(new Dimension(700, Template1.c.getCart().getCartitems().size()* 100));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		refresh();

	}
	
	public void refresh() {
		removeAll();
		for(CartItem cartitem: Template1.c.getCart().getCartitems()) {
		add(new ItemCart(cart, cartitem));
		}
	}

}
