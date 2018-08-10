package com.liyi.shop.component;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class CustomTextField extends JTextField {

	public CustomTextField(String placeholder) {
		setText(placeholder);

		addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals("")) {
					setText(placeholder);
					
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(placeholder)) {
					setText("");
				}
			}
		});
	}

}
