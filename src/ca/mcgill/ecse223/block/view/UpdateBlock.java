package ca.mcgill.ecse223.block.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JButton;

public class UpdateBlock extends JFrame {

	private JPanel contentPane;
	private JTable colorPreview;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateBlock frame = new UpdateBlock();
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
	public UpdateBlock() {
		setTitle("Update block");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JComboBox comboBox = new JComboBox();
		
		JLabel redLabel = new JLabel("R : ");
		
		JFormattedTextField redField = new JFormattedTextField();
		redField.setText("0");
		
		JSlider redSlider = new JSlider();
		redSlider.setValue(0);
		redSlider.setMaximum(255);
		
		JLabel greenLabel = new JLabel("G : ");
		
		JFormattedTextField greenField = new JFormattedTextField();
		greenField.setText("0");
		
		JSlider greenSlider = new JSlider();
		greenSlider.setValue(0);
		greenSlider.setMaximum(255);
		
		JLabel blueLabel = new JLabel("B : ");
		
		JFormattedTextField blueField = new JFormattedTextField();
		blueField.setText("0");
		
		JSlider blueSlider = new JSlider();
		blueSlider.setValue(0);
		blueSlider.setMaximum(255);
		
		colorPreview = new JTable();
		
		JButton btnUpdate = new JButton("Update");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(81)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addContainerGap()
											.addComponent(redLabel)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(redField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(redSlider, 0, 0, Short.MAX_VALUE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addContainerGap()
										.addComponent(greenLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
										.addGap(4)
										.addComponent(greenField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
										.addGap(6)
										.addComponent(greenSlider, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addComponent(blueLabel, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
									.addGap(4)
									.addComponent(blueField, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
									.addGap(6)
									.addComponent(blueSlider, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
							.addGap(10)
							.addComponent(colorPreview, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(102)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(colorPreview, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(redSlider, 0, 0, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(redField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(redLabel)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(greenLabel))
								.addComponent(greenField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(greenSlider, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(3)
									.addComponent(blueLabel))
								.addComponent(blueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(blueSlider, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addGap(36)
					.addComponent(btnUpdate)
					.addGap(82))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
