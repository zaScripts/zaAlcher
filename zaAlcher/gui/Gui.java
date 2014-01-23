package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.text.NumberFormatter;

import zaAlcher.ZaAlcher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;

public class Gui {

	public JFrame frmZaalcher;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZaalcher = new JFrame();
		frmZaalcher.setResizable(false);
		frmZaalcher.setTitle("zaAlcher");
		frmZaalcher.setAlwaysOnTop(true);
		frmZaalcher.setBounds(100, 100, 450, 300);
		frmZaalcher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZaalcher.getContentPane().setLayout(null);
		
		JLabel lblPlaceHighAlchemy = new JLabel("INSTRUCTIONS");
		lblPlaceHighAlchemy.setFont(new Font("SimSun", Font.BOLD, 11));
		lblPlaceHighAlchemy.setBounds(10, 11, 225, 14);
		frmZaalcher.getContentPane().add(lblPlaceHighAlchemy);
		
		JLabel lblEnterTheId = new JLabel("Enter the id of the item you want to alchemy.");
		lblEnterTheId.setBounds(10, 36, 225, 14);
		frmZaalcher.getContentPane().add(lblEnterTheId);
		
		JLabel lblPlaceHighAlchemy_1 = new JLabel("Place high alchemy to 5th slot of your action bar, equip your fire staff.");
		lblPlaceHighAlchemy_1.setBounds(10, 61, 366, 14);
		frmZaalcher.getContentPane().add(lblPlaceHighAlchemy_1);
		
		JLabel lblPressStart = new JLabel("Before pressing Start, make sure the item is in your inventory.");
		lblPressStart.setBounds(10, 86, 318, 14);
		frmZaalcher.getContentPane().add(lblPressStart);
		
		JLabel lblItemId = new JLabel("Item ID:");
		lblItemId.setBounds(10, 142, 46, 14);
		frmZaalcher.getContentPane().add(lblItemId);
		
		NumberFormat format = NumberFormat.getIntegerInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
	    formatter.setMaximum(Integer.MAX_VALUE);
	    formatter.setAllowsInvalid(false);
	    formatter.setCommitsOnValidEdit(true);
		final JFormattedTextField formattedTextField = new JFormattedTextField(formatter);
		formattedTextField.setBounds(66, 139, 92, 17);
		frmZaalcher.getContentPane().add(formattedTextField);
		
		JButton btnStart = new JButton("Start!");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(formattedTextField.getValue() ==null)
					return;
				ZaAlcher.ItemID = (int) formattedTextField.getValue();
				ZaAlcher.started =true;
				ZaAlcher.startingTime = System.currentTimeMillis();
				frmZaalcher.setVisible(false);
			}
		});
		btnStart.setBounds(10, 204, 89, 23);
		frmZaalcher.getContentPane().add(btnStart);
	}
}
