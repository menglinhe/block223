package ca.mcgill.ecse223.block.view;

import javax.swing.*;
import java.awt.*;

import ca.mcgill.ecse223.block.controller.*;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

// Note : need method refresh data

public class Block223Page extends JFrame implements Block223PlayModeInterface {
	
	private static final long serialVersionUID = -5468712039074806735L;


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
		
		JLabel levelNumberLabel = new JLabel("Level:");
		
		JLabel livesRemainingLabel = new JLabel("Lives:");
		
		JLabel scoreLabel = new JLabel("Score:");
		
		JLabel hallOfFameLabel = new JLabel("Hall of Fame");
		hallOfFameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_rightMenuPanel = new GroupLayout(rightMenuPanel);
		gl_rightMenuPanel.setHorizontalGroup(
			gl_rightMenuPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightMenuPanel.createSequentialGroup()
					.addGroup(gl_rightMenuPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rightMenuPanel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_rightMenuPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(levelNumberLabel)
								.addComponent(livesRemainingLabel, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(scoreLabel)))
						.addGroup(gl_rightMenuPanel.createSequentialGroup()
							.addGap(66)
							.addComponent(hallOfFameLabel)))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		gl_rightMenuPanel.setVerticalGroup(
			gl_rightMenuPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightMenuPanel.createSequentialGroup()
					.addGap(28)
					.addComponent(levelNumberLabel)
					.addGap(18)
					.addComponent(livesRemainingLabel)
					.addGap(18)
					.addComponent(scoreLabel)
					.addGap(18)
					.addComponent(hallOfFameLabel)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		rightMenuPanel.setLayout(gl_rightMenuPanel);
		
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
				try {
					manageGames.refreshData();
					manageGames.setVisible(true);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(Block223Page.this, e.getMessage());
				}
			}
		});
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPage.setVisible(true);
			}
		});
		manageBlocksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					blockSettings.updateGamesList();
					blockSettings.setVisible(true);
				} catch (InvalidInputException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(Block223Page.this, e.getMessage());
				}
			}
		});
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_RELEASED) {
					if ((e.getKeyChar() == 'l') || (e.getKeyChar() == 'r') || (e.getKeyChar() == ' ')) {
						System.out.println(e.getKeyChar());
						userInputs += e.getKeyChar();
					}
				}
				return false;
			}
		});
	}
	
	// refreshData() method 
	
	private void mainWindowRefreshData() {
		
	}

	private String userInputs = "";
	
	@Override
	public String takeInputs() {
		String returnInput = new String(userInputs);
		userInputs = "";
		return returnInput;
	}
	
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
}
