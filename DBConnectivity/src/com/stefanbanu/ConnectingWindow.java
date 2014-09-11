package com.stefanbanu;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConnectingWindow extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private DataBaseConnector dbc;

	private JFrame controllingFrame; // needed for pop up dialogs

	public ConnectingWindow() {
		setFocusable(true);

		createWindow();

	}

	private void createWindow() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Welcome to Connection Window");
		setSize(600, 500);
		setLocationRelativeTo(null);
		requestFocus(true);
		setAlwaysOnTop(true);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.requestFocus(true);
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);

		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JButton btnNextStep = new JButton("Connect to mysql server.");
		btnNextStep.requestFocus(true);
		btnNextStep.setBackground(Color.BLUE);
		

		btnNextStep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// aici este chemata clasa DataBaseConnector
				dbc = new DataBaseConnector();
				dbc.getData();

				setAlwaysOnTop(false);
				JOptionPane.showMessageDialog(controllingFrame,
						"Success! You are now connected to mysql server.");
				dispose();

				new ShowData();
			}
		});
		GridBagConstraints gbc_btnNextStep = new GridBagConstraints();
		gbc_btnNextStep.insets = new Insets(0, 0, 5, 0);
		gbc_btnNextStep.gridx = 8;
		gbc_btnNextStep.gridy = 7;
		contentPane.add(btnNextStep, gbc_btnNextStep);

		setVisible(true);

	}

}
