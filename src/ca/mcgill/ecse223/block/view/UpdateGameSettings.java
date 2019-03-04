package ca.mcgill.ecse223.block.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateGameSettings extends JFrame {

	private JPanel contentPane;
	private JTextField nrOfLevelsTxt;
	private JTextField NrOfBlocksTxt;
	private JTextField minBallSpeedTxt;
	private JTextField BallFactorTxt;
	private JTextField maxPaddleLengthTxt;
	private JTextField minePaddleLengthTxt;
	private JLabel minBallSpeedLabel;
	private JLabel ballFactorLabel;
	private JLabel maxPaddleLengthLabel;
	private JLabel minPaddleLengthLabel;
	private JButton updateGameButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateGameSettings frame = new UpdateGameSettings();
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
	public UpdateGameSettings() {
		setTitle("Update Game");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 361, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		nrOfLevelsTxt = new JTextField();
		nrOfLevelsTxt.setColumns(10);
		
		NrOfBlocksTxt = new JTextField();
		NrOfBlocksTxt.setColumns(10);
		
		minBallSpeedTxt = new JTextField();
		minBallSpeedTxt.setColumns(10);
		
		BallFactorTxt = new JTextField();
		BallFactorTxt.setColumns(10);
		
		maxPaddleLengthTxt = new JTextField();
		maxPaddleLengthTxt.setColumns(10);
		
		minePaddleLengthTxt = new JTextField();
		minePaddleLengthTxt.setColumns(10);
		
		JLabel nrOfLevelsLabel = new JLabel("Number of levels:");
		
		JLabel nrOfBlocksLabel = new JLabel("Number of blocks:");
		
		minBallSpeedLabel = new JLabel("Min ball speed:");
		
		ballFactorLabel = new JLabel("Ball increase factor:");
		
		maxPaddleLengthLabel = new JLabel("Max paddle length:");
		
		minPaddleLengthLabel = new JLabel("Min paddle length:");
		
		updateGameButton = new JButton("Update game");
		updateGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nrOfLevelsLabel)
						.addComponent(nrOfBlocksLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(minBallSpeedLabel, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(ballFactorLabel, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(minPaddleLengthLabel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(maxPaddleLengthLabel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(minePaddleLengthTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(maxPaddleLengthTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(BallFactorTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(minBallSpeedTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(NrOfBlocksTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(nrOfLevelsTxt, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(125)
					.addComponent(updateGameButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(115))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(53, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(nrOfLevelsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nrOfLevelsLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(NrOfBlocksTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nrOfBlocksLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(minBallSpeedTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(minBallSpeedLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(BallFactorTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ballFactorLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(maxPaddleLengthTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(maxPaddleLengthLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(minePaddleLengthTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(minPaddleLengthLabel))
					.addGap(49)
					.addComponent(updateGameButton)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
