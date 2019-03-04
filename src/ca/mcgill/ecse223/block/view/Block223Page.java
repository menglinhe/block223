package ca.mcgill.ecse223.block.view;

import javax.swing.*;
import java.awt.*;

import ca.mcgill.ecse223.block.controller.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import ca.mcgill.ecse223.block.view.*;

// Note : need method refresh data

public class Block223Page extends JFrame {
	
	private static final long serialVersionUID = -5468712039074806735L;
	private JLabel errorMessage;
	private String error = null;


	// Instantiate the other windows 
	AddGameDefineSettings addGameDefineSettings = new AddGameDefineSettings();
	ManageGames manageGames = new ManageGames();
	LoginPage loginPage = new LoginPage();
	Block223Settings block223Settings = new Block223Settings();
	BlockSettings blockSettings = new BlockSettings();
	
	// Main window UI
	public Block223Page() {
		setTitle("Block 223");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 450);
		setResizable(false);
		
		JPanel downMenuPanel = new JPanel();
		downMenuPanel.setPreferredSize(new Dimension(590, 60));
		downMenuPanel.setSize(new Dimension(590, 60));
		downMenuPanel.setMinimumSize(new Dimension(590, 60));
		downMenuPanel.setMaximumSize(new Dimension(590, 60));
		downMenuPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		FlowLayout fl_downMenuPanel = (FlowLayout) downMenuPanel.getLayout();
		fl_downMenuPanel.setVgap(20);
		fl_downMenuPanel.setHgap(20);
		getContentPane().add(downMenuPanel, BorderLayout.SOUTH);
		
		JButton loginButton = new JButton("Login");
		downMenuPanel.add(loginButton);
		
		JButton block223SettingsButton = new JButton("Settings");
		
				downMenuPanel.add(block223SettingsButton);
				block223SettingsButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						block223Settings.setVisible(true);
					}
				});
		
		JButton manageGamesButton = new JButton("Manage Games");

		downMenuPanel.add(manageGamesButton);
		
		JButton manageBlocksButton = new JButton("Manage Blocks");

		downMenuPanel.add(manageBlocksButton);
		
		JButton quitButton = new JButton("Quit");

		downMenuPanel.add(quitButton);
		
		JPanel rightMenuPanel = new JPanel();
		rightMenuPanel.setPreferredSize(new Dimension(200, 330));
		rightMenuPanel.setMinimumSize(new Dimension(200, 330));
		rightMenuPanel.setMaximumSize(new Dimension(200, 330));
		rightMenuPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		getContentPane().add(rightMenuPanel, BorderLayout.EAST);
		rightMenuPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel playAreaPanel = new JPanel();
		playAreaPanel.setBounds(new Rectangle(0, 0, 390, 390));
		playAreaPanel.setPreferredSize(new Dimension(390, 390));
		playAreaPanel.setMinimumSize(new Dimension(390, 390));
		playAreaPanel.setMaximumSize(new Dimension(390, 390));
		playAreaPanel.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 0)));
		playAreaPanel.setBackground(new Color(153, 153, 153));
		getContentPane().add(playAreaPanel, BorderLayout.CENTER);
		playAreaPanel.setLayout(null);
		
		// Listeners 
		manageGamesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageGames.setVisible(true);
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPage.setVisible(true);
			}
		});
		manageBlocksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				blockSettings.setVisible(true);
			}
		});
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	// refreshData() method 
	
	public void mainWindowRefreshData() {
		// error
		errorMessage.setText(error);
		if (error == null || error.length() == 0) {
			// populate page with data
//			userNameTxt.setText("");
		}
		
	}
}
