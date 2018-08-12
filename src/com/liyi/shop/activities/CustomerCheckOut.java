package com.liyi.shop.activities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import com.liyi.shop.component.CustomTextField;
import com.liyi.shop.model.Order;
import com.liyi.shop.model.OrderItem;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;


public class CustomerCheckOut extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox paymentMethod;
	private JTable orderTable;
	private JRadioButton rdbtnMaybank;
	private JRadioButton rdbtnCimbBank;
	private JRadioButton rdbtnHongleongConnect;
	private JRadioButton rdbtnPublic;
	private JButton btnConfirm;
	private String[] columnName = {"No", "Name", "Price", "Quantity", "SubTotal"};
	private Object[][] array ;
	private JTextField txtCardName;
	private JTextField txtCardNum;
	private JTextField txtCVC;
	private Timer timer;
	private int second = 59;
	private int minute = 9;
	
	public CustomerCheckOut( Order order) {
		array = new Object[order.getAllOrderItem().size()][5];
		for(int i = 0; i < array.length; i++) {
			OrderItem orderitem = order.getAllOrderItem().get(i);
			array[i][0] = i + 1;
			array[i][1] = orderitem.getProduct().getName();
			array[i][2] = orderitem.getProduct().getPrice();
			array[i][3] = orderitem.getQuantity();
			String subtotal = new DecimalFormat("#,###0.00").format(orderitem.getSubtotal());
			array[i][4] = subtotal;
			
		}
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 16));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setTitle("CheckOut");
		setResizable(false);
		setSize(800,600);
		
		Color bk = new Color(255, 235, 238);
		Color btn = new Color(236, 64, 122);
		JPanel header = new JPanel();
		header.setBackground(new Color(255, 205, 210));
		header.setSize(800, 50);
		header.setLayout(null);
		getContentPane().add(header);
		
		JLabel lblSecond = new JLabel("59");
		lblSecond.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecond.setFont(new Font("Microsoft JhengHei", Font.BOLD, 22));
		lblSecond.setBounds(395, 5 ,50, 40);
		header.add(lblSecond);
		
		JLabel lblMinute = new JLabel("9");
		lblMinute.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinute.setFont(new Font("Microsoft JhengHei", Font.BOLD, 22));
		lblMinute.setBounds(360, 5, 50, 40);
		header.add(lblMinute);
		
		JLabel lblSymbol = new JLabel(":");
		lblSymbol.setHorizontalAlignment(SwingConstants.LEFT);
		lblSymbol.setFont(new Font("Microsoft JhengHei", Font.BOLD, 17));
		lblSymbol.setBounds(398, 15, 46, 20);
		header.add(lblSymbol);
		getContentPane().setBackground(bk);
		
		 timer = new Timer(1000, new ActionListener() {
	            @Override  
	            public void actionPerformed(ActionEvent e) {
	            	if(minute == 0 && second == 0) {
	            		timer.stop();
	               	 	dispose();
	               	 	new ActivityHomePage();
	            	}
	            	if(second <10 ) {
	            	     lblSecond.setText(String.valueOf("0" + second)); 
	            	}else {
	                    lblMinute.setText(String.valueOf(minute));
	            		lblSecond.setText(String.valueOf(second));
	            	}
	           
	                second--;
	                if (second == 0) {
	                	if(minute > 0) {
	                	minute = minute - 1;
	                	second = 59;
	                	}              
	                    //timer.removeActionListener(this);        
	                }
	            }
	        });
	        timer.start();
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 16));
		lblPayment.setBounds(516, 76, 128, 39);
		getContentPane().add(lblPayment);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 15));
		lblTotal.setBounds(516, 138, 77, 32);
		getContentPane().add(lblTotal);
		

		String sum = new DecimalFormat("RM #,##0.00").format(order.getSum());	
		JLabel lblPrice = new JLabel(sum);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 15));
		lblPrice.setBounds(608, 138, 95, 32);
		getContentPane().add(lblPrice);
		
		JLabel lblSelect = new JLabel("Select Payment Method");
		lblSelect.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 14));
		lblSelect.setBounds(516, 209, 195, 22);
		getContentPane().add(lblSelect);
		
		JLabel lblShippingFee = new JLabel("Shipping Fee:");
		lblShippingFee.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblShippingFee.setBounds(23, 512, 100, 18);
		getContentPane().add(lblShippingFee);
		
		JLabel lblTotalFee = new JLabel("Total:");
		lblTotalFee.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblTotalFee.setBounds(23, 482, 100, 18);
		getContentPane().add(lblTotalFee);
		
		JLabel lblTotal1 = new JLabel();
		lblTotal1.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblTotal1.setBounds(124, 482, 100, 18);
		getContentPane().add(lblTotal1);
		
		JLabel lblFee = new JLabel();
		lblFee.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblFee.setBounds(124, 512, 100, 18);
		getContentPane().add(lblFee);
		
		String total = new DecimalFormat("RM #,##0.00").format(order.getTotal());
		String fee = new DecimalFormat("RM #,##0.00").format(order.getTotalShippingFee());
		lblTotal1.setText(total);
		lblFee.setText(fee);
		
		paymentMethod = new JComboBox();
		paymentMethod.setModel(new DefaultComboBoxModel(new String[] {"Please Select", "Online Banking", "Credit Card"}));
		paymentMethod.setBackground(new Color(255, 205, 210));
		paymentMethod.setBounds(516, 242, 157, 20);
		getContentPane().add(paymentMethod);
		
		rdbtnMaybank = new JRadioButton("MayBank2u");
		rdbtnMaybank.setBackground(new Color(255, 255, 240));
		rdbtnMaybank.setBounds(516, 281, 157, 23);
		getContentPane().add(rdbtnMaybank);
		rdbtnMaybank.setVisible(false);
		rdbtnMaybank.setSelected(true);
		
		rdbtnCimbBank = new JRadioButton("CIMB Bank");
		rdbtnCimbBank.setBackground(new Color(255, 255, 240));
		rdbtnCimbBank.setBounds(516, 328, 157, 23);
		getContentPane().add(rdbtnCimbBank);
		rdbtnCimbBank.setVisible(false);
		
		rdbtnHongleongConnect = new JRadioButton("HongLeong Connect");
		rdbtnHongleongConnect.setBackground(new Color(255, 255, 240));
		rdbtnHongleongConnect.setBounds(516, 380, 157, 23);
		getContentPane().add(rdbtnHongleongConnect);
		rdbtnHongleongConnect.setVisible(false);
		
		rdbtnPublic = new JRadioButton("Public Bank");
		rdbtnPublic.setBackground(new Color(255, 255, 240));
		rdbtnPublic.setBounds(516, 427, 157, 23);
		getContentPane().add(rdbtnPublic);
		rdbtnPublic.setVisible(false);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnMaybank);
		group.add(rdbtnCimbBank);
		group.add(rdbtnHongleongConnect);
		group.add(rdbtnPublic);
		
		orderTable = new JTable(array, columnName);
		orderTable.setBackground(Color.WHITE);
		getContentPane().add(orderTable);
		orderTable.setEnabled(false);
		JScrollPane jpane = new JScrollPane(orderTable);
		orderTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(200);
		//orderTable.setModel(new DefaultTableModel(array, columnName));
		jpane.setBackground(Color.WHITE);
		jpane.setBounds(23, 76, 408, 374);
		jpane.setPreferredSize(new Dimension(450, 110));
		getContentPane().add(jpane);
		
		
		btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 12));
		btnConfirm.setBounds(665, 512, 89, 25);
		btnConfirm.setForeground(Color.white);
		btnConfirm.setBackground(btn);
		btnConfirm.setEnabled(false);
		getContentPane().add(btnConfirm);
		
		txtCardName = new JTextField("Card Holder Name");
		txtCardName.setBounds(516, 282, 157, 23);
		getContentPane().add(txtCardName);
		txtCardName.setColumns(10);
		
		txtCardNum = new JTextField("Card Number 16 digits");
		txtCardNum.setBounds(516, 329, 157, 23);
		getContentPane().add(txtCardNum);
		txtCardNum.setColumns(10);
		
		txtCVC = new JTextField("CVC");
		txtCVC.setBounds(686, 329, 43, 23);
		getContentPane().add(txtCVC);
		txtCVC.setColumns(10);
		check();
		
		txtCardNum.setVisible(false);
		txtCardName.setVisible(false);
		txtCVC.setVisible(false);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
		btnConfirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to confirm?", "Warning", 0) == 0) {
					order.setStatus("Process");	
					dispose();
					new ActivityHomePage();
				}else {
				}
			}
		});
		
		txtCardNum.addKeyListener(new KeyAdapter() {
			  @Override
				  public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				     
				      if (!((c >= '0') && (c <= '9') || (c == '.') ||
				         (c == KeyEvent.VK_BACK_SPACE) ||
				         (c == KeyEvent.VK_DELETE))) {
				        getToolkit().beep();
				        e.consume();
				      }
				      check();
				    }
			  
		});
		txtCardNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				check();
			}
		});
		txtCardNum.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				check();
				if (txtCardNum.getText().equals("")) {
					txtCardNum.setText("Card Number 16 digits");
					
				}

			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (txtCardNum.getText().equals("Card Number 16 digits")) {
					txtCardNum.setText("");
				}
				check();
			}
		});
		txtCVC.addKeyListener(new KeyAdapter() {
			  @Override
				  public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				     
				      if (!((c >= '0') && (c <= '9') || (c == '.') ||
				         (c == KeyEvent.VK_BACK_SPACE) ||
				         (c == KeyEvent.VK_DELETE))) {
				        getToolkit().beep();
				        e.consume();
				      }
				      check();
				    }
			  
		});
		txtCVC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
	
				super.keyReleased(e);
				check();
			}
		});
		txtCVC.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				if (txtCVC.getText().equals("")) {
					txtCVC.setText("CVC");
					
				}
				check();
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtCVC.getText().equals("CVC")) {
					txtCVC.setText("");
				}				
				check();
			}
		});
		txtCardName.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				if (txtCardName.getText().equals("")) {
					txtCardName.setText("Card Holder Name");
					
				}
				check();
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtCardName.getText().equals("Card Holder Name")) {
					txtCardName.setText("");
				}
				check();	
			}
		});
		txtCardName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				check();
			}
		});
		
		
		paymentMethod.addActionListener( new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(paymentMethod.getSelectedIndex() == 1) {
					setVisibleRadioButton(true);
					setVisibleTextBox(false);
					btnConfirm.setEnabled(true);
				}else if(paymentMethod.getSelectedIndex() == 2){
					setVisibleRadioButton(false);
					setVisibleTextBox(true);
					check();
				}else {
					setVisibleRadioButton(false);
					setVisibleTextBox(false);
					btnConfirm.setEnabled(false);
				}
				
			}
		});
		
	}

	private void setVisibleRadioButton(boolean choose) {
		rdbtnPublic.setVisible(choose);
		rdbtnMaybank.setVisible(choose);
		rdbtnCimbBank.setVisible(choose);
		rdbtnHongleongConnect.setVisible(choose);
	}
	
	private void setVisibleTextBox(boolean choose) {
		txtCardNum.setVisible(choose);
		txtCardName.setVisible(choose);
		txtCVC.setVisible(choose);
	}
	
	private void check() {
		char[] num = txtCardNum.getText().toCharArray();
		char[] cvc = txtCVC.getText().toCharArray();
		if(num.length != 16 || cvc.length != 3 || txtCardName.getText().isEmpty()) {	
			txtCardNum.setToolTipText("Please enter 16 digit");
			txtCVC.setToolTipText("3 digit");
			btnConfirm.setEnabled(false);
		}else {
		btnConfirm.setEnabled(true);
		}
	}
}
