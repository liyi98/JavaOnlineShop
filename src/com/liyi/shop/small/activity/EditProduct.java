package com.liyi.shop.small.activity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.liyi.shop.Main;
import com.liyi.shop.activities.ActivityManageMen;
import com.liyi.shop.activities.ActivityManageWomen;
import com.liyi.shop.model.Category;
import com.liyi.shop.model.FragileProduct;
import com.liyi.shop.model.NonFragileProduct;
import com.liyi.shop.model.Product;
import com.liyi.shop.model.Staff;

public class EditProduct extends JFrame{

	private static final long serialVersionUID = 1L;
	private Product product;
	private JFrame parent;
	private JTextField txtPath;
	private JTextField txtName;
	private JTextField txtPrice;
	private JTextField txtWeight;
	private JTextField txtStock;
	private JRadioButton rdbtnFragile;
	private JRadioButton rdbtnNonFragile;
	private Staff staff;
	private JLabel lblRatings;
	
	public EditProduct( Category category, JFrame parent, Product product, Staff staff) {
		this.staff = staff;
		this.parent = parent;
		this.product = product;
		getContentPane().setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		setResizable(false);
		setTitle("Edit Product");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(419,600);
		getContentPane().setLayout(null);
		Color bk = new Color(255, 235, 238);
		Color btn = new Color(240, 248, 255);
		getContentPane().setBackground(bk);
		
		JLabel lblTitle = new JLabel("Edit Product");
		lblTitle.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 24));
		lblTitle.setBounds(126, 11, 178, 40);
		getContentPane().add(lblTitle);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblName.setBounds(25, 230, 120, 20);
		getContentPane().add(lblName);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblPrice.setBounds(25, 270, 120, 20);
		getContentPane().add(lblPrice);
		
		txtName = new JTextField(product.getName());
		txtName.setBounds(150, 230, 220, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtPrice = new JTextField(product.getPrice()+ "");
		txtPrice.setColumns(10);
		txtPrice.setBounds(150, 271, 220, 20);
		getContentPane().add(txtPrice);
		
		JLabel lblWeigth = new JLabel("Weight");
		lblWeigth.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblWeigth.setBounds(25, 310, 120, 20);
		getContentPane().add(lblWeigth);
		
		txtWeight = new JTextField(Double.toString(product.getWeight()) );
		txtWeight.setColumns(10);
		txtWeight.setBounds(150, 310, 220, 20);
		getContentPane().add(txtWeight);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblStock.setBounds(25, 350, 120, 20);
		getContentPane().add(lblStock);
		
		txtStock = new JTextField(Integer.toString(product.getStock()));
		txtStock.setColumns(10);
		txtStock.setBounds(150, 350, 220, 20);
		getContentPane().add(txtStock);
		
		JLabel lbldes = new JLabel("Description");
		lbldes.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lbldes.setBounds(25, 390, 120, 20);
		getContentPane().add(lbldes);
		
		JTextArea textArea = new JTextArea(product.getDescription());
		textArea.setBounds(150, 389, 220, 50);
		getContentPane().add(textArea);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblType.setBounds(25, 450, 120, 20);
		getContentPane().add(lblType);
		
		rdbtnFragile = new JRadioButton("Fragile");
		rdbtnFragile.setBackground(SystemColor.info);
		rdbtnFragile.setBounds(150, 450, 109, 23);
		getContentPane().add(rdbtnFragile);
		
		rdbtnNonFragile = new JRadioButton("Non-Fragile");
		rdbtnNonFragile.setBackground(SystemColor.info);
		rdbtnNonFragile.setBounds(261, 450, 109, 23);
		getContentPane().add(rdbtnNonFragile);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnFragile);
		group.add(rdbtnNonFragile);
	
		checkType();
		
		txtPath = new JTextField(product.getPhoto());
		txtPath.setBounds(235, 95, 135, 20);
		getContentPane().add(txtPath);
		txtPath.setColumns(10);
		
		JLabel lblImage = new JLabel();
		lblImage.setBounds(25, 62, 200, 130);
		ImageIcon icon = new ImageIcon(product.getPhoto());
		Image newIcon = icon.getImage().getScaledInstance(200, 130, Image.SCALE_SMOOTH);
		lblImage.setIcon(new ImageIcon(newIcon));
		getContentPane().add(lblImage);
		
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.setBackground(btn);
		btnBrowse.setBounds(255, 126, 100, 23);
		getContentPane().add(btnBrowse);
		
		JLabel lblrate = new JLabel("Ratings");
		lblrate.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblrate.setBounds(25, 491, 120, 20);
		getContentPane().add(lblrate);
		
		lblRatings = new JLabel();
		lblRatings.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 13));
		lblRatings.setBounds(152, 495, 120, 20);
		getContentPane().add(lblRatings);
		checkRate();
		

	
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Microsoft JhengHei Light", Font.BOLD, 13));
		Color custom = new Color(236, 64, 122);
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(custom);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((product.getType() == 1 && rdbtnFragile.isSelected()) || (product.getType() == 2 && rdbtnNonFragile.isSelected()) ) {
					product.setName(txtName.getText());
					product.setPrice(Double.parseDouble(txtPrice.getText()));
					product.setDescription(textArea.getText());
					product.setWeight(Double.parseDouble(txtWeight.getText()));
					product.setStock(Integer.parseInt(txtStock.getText()));
				}else if(product.getType() == 1 && rdbtnNonFragile.isSelected()) {
					category.getAllItems().remove(product);
					category.addItem(new NonFragileProduct(txtName.getText(), txtPath.getText(), Double.parseDouble(txtPrice.getText()), textArea.getText(),Double.parseDouble(txtWeight.getText()), Integer.parseInt(txtStock.getText())));
				}else if(product.getType() == 2 && rdbtnFragile.isSelected()) {
					category.getAllItems().remove(product);
					category.addItem(new FragileProduct(txtName.getText(), txtPath.getText(), Double.parseDouble(txtPrice.getText()), textArea.getText(),Double.parseDouble(txtWeight.getText()), Integer.parseInt(txtStock.getText())));
				}
				parent.dispose();
				if(category.equals(Main.women)) {
				new ActivityManageWomen(staff);
				}else {
					new ActivityManageMen(staff);
				}
				dispose();
			}
		});
		btnSave.setBounds(282, 525, 89, 30);
		getContentPane().add(btnSave);
		
	
		
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	            JFileChooser chooser = new JFileChooser();
	            chooser.setCurrentDirectory(new java.io.File("."));
	            chooser.setDialogTitle("Browse the folder to process");
	            FileNameExtensionFilter filter = new FileNameExtensionFilter(
	                    "JPG & PNG Images", "jpg", "png");
	            chooser.setFileFilter(filter);
	            chooser.setAcceptAllFileFilterUsed(true);   
	            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	                System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	                txtPath.setText(chooser.getSelectedFile().toString());
	            } else {
	                System.out.println("No Selection ");
	            }
			}
		});
		
		
		txtPrice.addKeyListener(new KeyAdapter() {
			  @Override
				  public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				   
				      if (!((c >= '0') && (c <= '9') || (c == '.') ||
				         (c == KeyEvent.VK_BACK_SPACE) ||
				         (c == KeyEvent.VK_DELETE))) {
				        getToolkit().beep();
				        e.consume();
				      }
				    }

		});
		
		txtWeight.addKeyListener(new KeyAdapter() {
			  @Override
				  public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				   
				      if (!((c >= '0') && (c <= '9') || (c == '.') ||
				         (c == KeyEvent.VK_BACK_SPACE) ||
				         (c == KeyEvent.VK_DELETE))) {
				        getToolkit().beep();
				        e.consume();
				      }
				    }

		});

		txtStock.addKeyListener(new KeyAdapter() {
			  @Override
				  public void keyTyped(KeyEvent e) {
				      char c = e.getKeyChar();
				   
				      if (!((c >= '0') && (c <= '9') ||
				         (c == KeyEvent.VK_BACK_SPACE) ||
				         (c == KeyEvent.VK_DELETE))) {
				        getToolkit().beep();
				        e.consume();
				      }
				    }

		});

		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	private void checkRate() {
		if(product.getRates().size() == 0) {
			lblRatings.setText("0.0");
		}else {
			String averageRate = new DecimalFormat("#0.0").format(product.getAverageRate());
			lblRatings.setText(averageRate);
		}
	}
	
	private void checkType() {
		if(product.getType() == 1) {
			rdbtnFragile.setSelected(true);
		}else {
			rdbtnNonFragile.setSelected(true);
		}
	}
}
