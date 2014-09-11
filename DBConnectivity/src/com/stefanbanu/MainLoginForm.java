package com.stefanbanu;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class MainLoginForm extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textName;
	// private JTextField textPass;
	private JPasswordField textPass;

	private JFrame controllingFrame; // needed for pop up dialogs

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public MainLoginForm() {

		// afisare interfata look & feel windows 7
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setResizable(false);
		setTitle("Login Form!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 400);
		setLocationRelativeTo(null);

		requestFocus(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textName = new JTextField();
		textName.setBounds(94, 127, 106, 20);
		textName.requestFocus(true);
		contentPane.add(textName);
		textName.setColumns(10);

		textPass = new JPasswordField(8);
		textPass.setEchoChar('*');
		textPass.setColumns(8);
		textPass.setBounds(94, 177, 106, 20);
		contentPane.add(textPass);

		// //////////////////////////////////////// username
		// /////////////////////
		JLabel lblName = new JLabel("UserName:");
		lblName.setBounds(115, 109, 64, 14);
		contentPane.add(lblName);
		// /////////////////////////////////////// password
		// //////////////////////////

		JLabel lblPass = new JLabel("Password:");
		lblPass.setBounds(115, 159, 64, 14);
		contentPane.add(lblPass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String inputUserName = textName.getText();

				char[] inputPassword = textPass.getPassword();

				if (inputUserName.equals("stefan")
						&& (isPasswordCorrect(inputPassword))) {
					setAlwaysOnTop(false);
					dispose();
					JOptionPane.showMessageDialog(controllingFrame,
							"Success! You typed the right password.");

					//System.out.println("pass correct");
					
					login();

				} else {
					setAlwaysOnTop(false);
					JOptionPane.showMessageDialog(controllingFrame,
							"Invalid password. Try again.", "Error Message",
							JOptionPane.ERROR_MESSAGE);

					textName.setText("");
					textName.requestFocus(true);

					textPass.setText("");
					// System.out.println("not correct");
				}

			}

		});
		btnLogin.setBounds(102, 319, 89, 23);
		contentPane.add(btnLogin);
	}

	// chemam ConnectingWindow class
	private void login() {
		dispose();
		new ConnectingWindow();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainLoginForm frame = new MainLoginForm();

					frame.setVisible(true);
					frame.setAlwaysOnTop(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Checks the passed-in array against the correct password. After this
	 * method returns, you should invoke eraseArray on the passed-in array.
	 */
	private static boolean isPasswordCorrect(char[] input) {
		boolean isCorrect = true;
		char[] correctPassword = { 'p', 'a', 's', 's', 'w', 'o', 'r', 'd' };

		if (input.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(input, correctPassword);
		}

		// Zero out the password.
		Arrays.fill(correctPassword, '0');

		return isCorrect;
	}

}
