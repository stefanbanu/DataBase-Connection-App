package com.stefanbanu;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

public class ShowData extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	DataBaseConnector dbc = new DataBaseConnector();
	private JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShowData() {

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 540);
		setTitle("Data Window!");
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);

		final JButton btnNewButton = new JButton("Populate Table");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			
					table.setModel(DbUtils.resultSetToTableModel(dbc.getRs()));
					btnNewButton.setEnabled(false);
					
					dbc.close();
					//System.out.println("Everything is closed.");
			
			}

		});
		btnNewButton.setBounds(296, 11, 132, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 57, 667, 388);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
