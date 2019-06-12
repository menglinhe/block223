/*
 * Block223, author p17 of ecse223 2019W class
 * Students: Ahmet Akgul, Mehdi Ammar, Nick Prudie, Omar Noor, Tian Ci Liu, Menglin He
 * Block223: term-long course project, simple block/ball game
 * Functionality: as an admin, define game setting (levels, balls, blocks, test and publish game
 * as a player, start/pause/resume the game by hitting space key, move the paddle by hitting the
 * left/right arrow key on the keyboard, let the ball bounces on the paddle and hits the block
 */
package ca.mcgill.ecse223.block.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import ca.mcgill.ecse223.block.controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5703902052168872654L;
	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordTxt;
	
	
	SignUpPage signUpPage = new SignUpPage();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		
		JLabel block223TitleLabel = new JLabel("BLOCK 223");
		block223TitleLabel.setFont(new Font("Source Sans Pro Black", Font.PLAIN, 36));
		
		JLabel userNameLabel = new JLabel("Username:");
		
		JLabel passwordLabel = new JLabel("Password:");
		
		userNameTxt = new JTextField();
		userNameTxt.setColumns(10);
		
		passwordTxt = new JPasswordField();
		
		passwordTxt.setColumns(10);
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = userNameTxt.getText();
				char[] charPassword = passwordTxt.getPassword();
				String password = new String(charPassword); 
				try {
					Block223Controller.login(username, password);
					LoginPage.this.dispose();
				} catch (InvalidInputException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(contentPane, e1.getMessage());
				} 
			}
		});
		
		passwordTxt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					// call login
					loginButton.doClick();
				}
			}
		});
		
		JButton signUpHereButton = new JButton("Sign up here!");
		signUpHereButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpPage.setVisible(true);
			}
		});
		
		JLabel dontHaveAnAccountLabel = new JLabel("Don't have an account?");
		
		JLabel prompt1 = new JLabel("Login with admin pass to create / update Block223");
		prompt1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JLabel prompt2 = new JLabel("Login with player pass to play Block223");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(98, Short.MAX_VALUE)
					.addComponent(signUpHereButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addGap(87))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(96, Short.MAX_VALUE)
					.addComponent(dontHaveAnAccountLabel)
					.addGap(85))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(74)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordLabel)
						.addComponent(userNameLabel, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(101))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(prompt1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(prompt2)
							.addGap(26)))
					.addGap(22))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addComponent(block223TitleLabel)
					.addGap(53))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(block223TitleLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel))
					.addGap(28)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(prompt1)
					.addGap(13)
					.addComponent(prompt2)
					.addGap(32)
					.addComponent(dontHaveAnAccountLabel)
					.addGap(11)
					.addComponent(signUpHereButton)
					.addGap(9))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
