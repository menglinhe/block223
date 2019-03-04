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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 320, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel block223TitleLabel = new JLabel("BLOCK 223");
		block223TitleLabel.setFont(new Font("Source Sans Pro", Font.PLAIN, 26));
		
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
				} catch (InvalidInputException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordLabel)
						.addComponent(userNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(104, Short.MAX_VALUE)
					.addComponent(block223TitleLabel)
					.addGap(83))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(113)
					.addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(132, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addComponent(dontHaveAnAccountLabel)
					.addContainerGap(99, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(106)
					.addComponent(signUpHereButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(112, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(block223TitleLabel)
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(userNameLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordLabel))
					.addGap(42)
					.addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(55)
					.addComponent(dontHaveAnAccountLabel)
					.addGap(18)
					.addComponent(signUpHereButton)
					.addGap(9))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
