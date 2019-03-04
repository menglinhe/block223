package ca.mcgill.ecse223.block.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse223.block.controller.Block223Controller;
import ca.mcgill.ecse223.block.controller.InvalidInputException;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageGames extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7748537705368152328L;
	private JPanel contentPane;
	private JTextField enterGameNameTxt;
	UpdateGameSettings updateGameSettings = new UpdateGameSettings();
	AddGameDefineSettings addGameDefineSettings = new AddGameDefineSettings();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageGames frame = new ManageGames();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManageGames() {
		setTitle("Manage Games");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 367, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		enterGameNameTxt = new JTextField();
		enterGameNameTxt.setText("Enter game name");
		enterGameNameTxt.setColumns(10);
		enterGameNameTxt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enterGameNameTxt.setText("");
			}
		});

		
		JButton addNewGameButton = new JButton("Add new game");
		addNewGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gameName = enterGameNameTxt.getText();
				try {
					Block223Controller.createGame(gameName);
				} catch (InvalidInputException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				addGameDefineSettings.setVisible(true);
			}
		});
		
		JComboBox selectAGameComboBox = new JComboBox();
		selectAGameComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select a game"}));
		
		JButton updateGameButton = new JButton("Update game");
		updateGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateGameSettings.setVisible(true);
			}
		});
		
		JButton deleteGameButton = new JButton("Delete game");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(enterGameNameTxt, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectAGameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(addNewGameButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteGameButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
						.addComponent(updateGameButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(enterGameNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(addNewGameButton))
					.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(updateGameButton)
						.addComponent(selectAGameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(deleteGameButton)
					.addGap(27))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
