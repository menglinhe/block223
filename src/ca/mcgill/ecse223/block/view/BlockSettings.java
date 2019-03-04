package ca.mcgill.ecse223.block.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import ca.mcgill.ecse223.block.controller.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

public class BlockSettings extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3667609650702992689L;
	private JPanel contentPane;
	private JTable table;
	private JColorChooser colorChooserCreateBlock = new JColorChooser();
	private JColorChooser colorChooserUpdateBlock= new JColorChooser();
	private JTextField pointsTxt;
	private JTextField updatePointsTxt;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BlockSettings frame = new BlockSettings();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BlockSettings() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 865, 450);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setTitle("Block settings");
		setResizable(false);
		
        AbstractColorChooserPanel[] panelsCreate = colorChooserCreateBlock.getChooserPanels();
        for (AbstractColorChooserPanel x : panelsCreate) {
        	if (!(x.getDisplayName().equals("RGB"))) {
        		colorChooserCreateBlock.removeChooserPanel(x);
        	}
        }
        
        AbstractColorChooserPanel[] panelsUpdate = colorChooserUpdateBlock.getChooserPanels();
        for (AbstractColorChooserPanel x : panelsUpdate) {
        	if (!(x.getDisplayName().equals("RGB"))) {
        		colorChooserUpdateBlock.removeChooserPanel(x);
        	}
        }

		JLabel blockLivePositionLabel = new JLabel("Select a block to get its position.");

		@SuppressWarnings("serial")
		JTable gridTable = new JTable() {
			@Override
			public Component prepareRenderer(TableCellRenderer renderer, int row, int col) {
				Component comp = super.prepareRenderer(renderer, row, col);
				if (getSelectedRow() == row && getSelectedColumn() == col) {
					if ((getColumnModel().getColumn(col).getWidth() == 20) && (getRowHeight(row) == 20)) {
						comp.setBackground(Color.YELLOW);
						blockLivePositionLabel.setText("Selected block is at position " + (row / 2) + " / " + (col / 2) + ".");
					} else {
						blockLivePositionLabel.setText("Select a block to get its position.");
					}
				} else if ((col % 2 == 1) && (row % 2 == 1)) {
					// get color of blocks and apply here
					comp.setBackground(Color.BLACK);
				} else {
					comp.setBackground(Color.WHITE);
				}
				return comp;
			}
		};
		gridTable.setShowGrid(false);
		gridTable.setRowSelectionAllowed(false);
		gridTable.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(0, 0, 0)));
		gridTable.setModel(new DefaultTableModel(
				new Object[][] {
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
								null, null, null, null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "left wall padding", "bc1", "padding", "bc2", "padding", "bc3", "New column",
						"New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column", "New column", "New column" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false, false, false, false, false, false, false, false, false,
					false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		gridTable.setRowHeight(0, 10);
		gridTable.setRowHeight(1, 20);
		gridTable.setRowHeight(2, 2);
		gridTable.setRowHeight(3, 20);
		gridTable.setRowHeight(4, 2);
		gridTable.setRowHeight(5, 20);
		gridTable.setRowHeight(6, 2);
		gridTable.setRowHeight(7, 20);
		gridTable.setRowHeight(8, 2);
		gridTable.setRowHeight(9, 20);
		gridTable.setRowHeight(10, 2);
		gridTable.setRowHeight(11, 20);
		gridTable.setRowHeight(12, 2);
		gridTable.setRowHeight(13, 20);
		gridTable.setRowHeight(14, 2);
		gridTable.setRowHeight(15, 20);
		gridTable.setRowHeight(16, 2);
		gridTable.setRowHeight(17, 20);
		gridTable.setRowHeight(18, 2);
		gridTable.setRowHeight(19, 20);
		gridTable.setRowHeight(20, 2);
		gridTable.setRowHeight(21, 20);
		gridTable.setRowHeight(22, 2);
		gridTable.setRowHeight(23, 20);
		gridTable.setRowHeight(24, 2);
		gridTable.setRowHeight(25, 20);
		gridTable.setRowHeight(26, 2);
		gridTable.setRowHeight(27, 20);
		gridTable.setRowHeight(28, 10);
		gridTable.getColumnModel().getColumn(0).setPreferredWidth(10);
		gridTable.getColumnModel().getColumn(0).setMinWidth(10);
		gridTable.getColumnModel().getColumn(0).setMaxWidth(10);
		gridTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(1).setMinWidth(20);
		gridTable.getColumnModel().getColumn(1).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(2).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(2).setMinWidth(5);
		gridTable.getColumnModel().getColumn(2).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(3).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(3).setMinWidth(20);
		gridTable.getColumnModel().getColumn(3).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(4).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(4).setMinWidth(5);
		gridTable.getColumnModel().getColumn(4).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(5).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(5).setMinWidth(20);
		gridTable.getColumnModel().getColumn(5).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(6).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(6).setMinWidth(5);
		gridTable.getColumnModel().getColumn(6).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(7).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(7).setMinWidth(20);
		gridTable.getColumnModel().getColumn(7).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(8).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(8).setMinWidth(5);
		gridTable.getColumnModel().getColumn(8).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(9).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(9).setMinWidth(20);
		gridTable.getColumnModel().getColumn(9).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(10).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(10).setMinWidth(5);
		gridTable.getColumnModel().getColumn(10).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(11).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(11).setMinWidth(20);
		gridTable.getColumnModel().getColumn(11).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(12).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(12).setMinWidth(5);
		gridTable.getColumnModel().getColumn(12).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(13).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(13).setMinWidth(20);
		gridTable.getColumnModel().getColumn(13).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(14).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(14).setMinWidth(5);
		gridTable.getColumnModel().getColumn(14).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(15).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(15).setMinWidth(20);
		gridTable.getColumnModel().getColumn(15).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(16).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(16).setMinWidth(5);
		gridTable.getColumnModel().getColumn(16).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(17).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(17).setMinWidth(20);
		gridTable.getColumnModel().getColumn(17).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(18).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(18).setMinWidth(5);
		gridTable.getColumnModel().getColumn(18).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(19).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(19).setMinWidth(20);
		gridTable.getColumnModel().getColumn(19).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(20).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(20).setMinWidth(5);
		gridTable.getColumnModel().getColumn(20).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(21).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(21).setMinWidth(20);
		gridTable.getColumnModel().getColumn(21).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(22).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(22).setMinWidth(5);
		gridTable.getColumnModel().getColumn(22).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(23).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(23).setMinWidth(20);
		gridTable.getColumnModel().getColumn(23).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(24).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(24).setMinWidth(5);
		gridTable.getColumnModel().getColumn(24).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(25).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(25).setMinWidth(20);
		gridTable.getColumnModel().getColumn(25).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(26).setPreferredWidth(5);
		gridTable.getColumnModel().getColumn(26).setMinWidth(5);
		gridTable.getColumnModel().getColumn(26).setMaxWidth(5);
		gridTable.getColumnModel().getColumn(27).setPreferredWidth(20);
		gridTable.getColumnModel().getColumn(27).setMinWidth(20);
		gridTable.getColumnModel().getColumn(27).setMaxWidth(20);
		gridTable.getColumnModel().getColumn(28).setPreferredWidth(10);
		gridTable.getColumnModel().getColumn(28).setMinWidth(10);
		gridTable.getColumnModel().getColumn(28).setMaxWidth(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 153, 153)));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 153, 153)));
		
		JLabel deleteBlockLabel = new JLabel("Delete a block from level:");
		
		JButton deleteButton = new JButton("Delete");

		
		JLabel selectBlockFromGridLabel = new JLabel("Select a block from the grid.");
		
		JCheckBox deleteFromGameCheckBox = new JCheckBox("Delete from game?");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(deleteButton)
							.addGap(82))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(selectBlockFromGridLabel)
							.addGap(47))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(deleteFromGameCheckBox)
							.addGap(56))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(deleteBlockLabel)
							.addGap(53))))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(deleteBlockLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
					.addComponent(deleteFromGameCheckBox)
					.addGap(18)
					.addComponent(selectBlockFromGridLabel)
					.addGap(18)
					.addComponent(deleteButton)
					.addGap(18))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 153, 153)));
		
		JButton updateColorButton = new JButton("Choose the color");
		
		updateColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			        JDialog dialog = new JDialog();
					dialog.setTitle("Choose the color");
					dialog.setContentPane(colorChooserUpdateBlock);
					dialog.pack();
					dialog.setVisible(true);
			        Color newColor = colorChooserUpdateBlock.getColor();
			        if (newColor != null) {
			        	// SET THE BLOCK COLOR
			        }
			}
		});
		
		
		JLabel updateASelectedBlockLabel = new JLabel("Update a selected block:");
		
		JLabel updatePointsLabel = new JLabel("Points :");
		
		updatePointsTxt = new JTextField();
		updatePointsTxt.setColumns(10);
		
		JButton updateButton = new JButton("Update");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(59)
					.addComponent(updateColorButton)
					.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(78)
					.addComponent(updatePointsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(updatePointsTxt, 0, 0, Short.MAX_VALUE)
					.addGap(78))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(83)
					.addComponent(updateButton)
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addComponent(updateASelectedBlockLabel)
					.addGap(55))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(updateASelectedBlockLabel)
					.addGap(18)
					.addComponent(updateColorButton)
					.addGap(18)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(updatePointsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(3)
							.addComponent(updatePointsLabel)))
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(updateButton)
					.addGap(18))
		);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 153, 153)));
		
		JLabel placeABlockLabel = new JLabel("Place a block: ");
		
		JButton placeBlockButton = new JButton("Place");
		
		JLabel moveABlockLabel = new JLabel("Move a block:");
		
		JLabel selectPositionLabel = new JLabel("Select position.");
		
		JButton moveBlockButton = new JButton("Move");
		
		JLabel selectLabel = new JLabel("Select");
		
		JLabel newPositionLabel = new JLabel("new position.");
		
		JLabel andLabel = new JLabel("&");
		
		JComboBox selectBlockComboBox = new JComboBox();
		selectBlockComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select block"}));
		
		JCheckBox blockSelectedCheckBox = new JCheckBox("Selected?");
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(placeBlockButton)
						.addComponent(selectPositionLabel, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectBlockComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(placeABlockLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_3.createSequentialGroup()
									.addComponent(moveBlockButton)
									.addGap(4))
								.addComponent(selectLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
								.addComponent(newPositionLabel, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
								.addComponent(andLabel)
								.addComponent(blockSelectedCheckBox, Alignment.TRAILING))
							.addGap(21))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(moveABlockLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(127, Short.MAX_VALUE)
					.addComponent(placeBlockButton)
					.addGap(14))
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(placeABlockLabel)
						.addComponent(moveABlockLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(selectPositionLabel)
						.addComponent(blockSelectedCheckBox))
					.addGap(8)
					.addComponent(andLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(selectLabel)
						.addComponent(selectBlockComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(newPositionLabel)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(moveBlockButton)
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JComboBox selectGameComboBox = new JComboBox();
		selectGameComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select game"}));
		
		// temp!!! do not use
		List<TOGame> games = Block223Controller.getDesignableGames();
		/*for (int i = 0; i < games.size(); i++) {
			String gameName = games.get(i).getName();
			selectGameComboBox.addItem(gameName);
		}*/

		JComboBox selectLevelComboBox = new JComboBox();
		selectLevelComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select level"}));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(4, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(selectGameComboBox, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(selectLevelComboBox, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(blockLivePositionLabel))
						.addComponent(gridTable, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
					.addGap(12))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(gridTable, GroupLayout.PREFERRED_SIZE, 351, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(selectGameComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(selectLevelComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(blockLivePositionLabel))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		
		JLabel createBlockLabel = new JLabel("Create a block:");
		
		JButton createColorButton = new JButton("Choose the color");
		createColorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				dialog.setTitle("Choose the color");
				dialog.setContentPane(colorChooserCreateBlock);
				dialog.pack();

				dialog.setVisible(true);
		        Color newColor = colorChooserCreateBlock.getColor();
		        if (newColor != null) {
		        	// SET THE BLOCK COLOR
		        }
			}
		});
		
		JLabel pointsLabel = new JLabel("Points :");
		
		pointsTxt = new JTextField();
		pointsTxt.setColumns(10);
		
		JButton createButton = new JButton("Create");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(59)
					.addComponent(createColorButton)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(79)
					.addComponent(createBlockLabel)
					.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(78)
					.addComponent(pointsLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pointsTxt, 0, 0, Short.MAX_VALUE)
					.addGap(78))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addComponent(createButton)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(createBlockLabel)
					.addGap(18)
					.addComponent(createColorButton)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(pointsTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(pointsLabel)))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(createButton)
					.addGap(18))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		// setBlockColor(1,1);
		
		// Listener methods 
		
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				boolean checked = deleteFromGameCheckBox.isSelected();
				int indexLevel = (int) selectLevelComboBox.getSelectedItem();
				int gridHorizontalPosition = gridTable.getSelectedRow() / 2;
				int gridVerticalPosition = gridTable.getSelectedColumn() / 2;
				if (checked) {
					System.out.println(gridHorizontalPosition);
					System.out.println(gridVerticalPosition);
					try {
						Block223Controller.deleteBlock(indexLevel);
					} catch (InvalidInputException e) {
						e.printStackTrace();
					} 
				}
				 else {
					try {
						Block223Controller.removeBlock(indexLevel, gridHorizontalPosition, gridVerticalPosition);
					} catch (InvalidInputException e) {
						e.printStackTrace();
					}
					blockSettingsRefreshData();
				} 
			}
		});
		
		moveBlockButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {	
				int oldGridHorizontalPosition = 0;
				int oldGridVerticalPosition = 0;
				int newGridHorizontalPosition;
				int newGridVerticalPosition;
				int indexLevel = (int) selectLevelComboBox.getSelectedItem();
				boolean blockSelected = blockSelectedCheckBox.isSelected();
				if (blockSelected) {
					oldGridHorizontalPosition = gridTable.getSelectedRow() / 2;
					oldGridVerticalPosition = gridTable.getSelectedColumn() / 2;
				}
				newGridHorizontalPosition = gridTable.getSelectedRow() / 2;
				newGridVerticalPosition = gridTable.getSelectedColumn() / 2;
				try {
					Block223Controller.moveBlock(indexLevel, oldGridHorizontalPosition, oldGridVerticalPosition, newGridHorizontalPosition, newGridVerticalPosition);
				}
				catch (InvalidInputException e) {
					e.printStackTrace();
				}
				blockSettingsRefreshData();
			}
		});
	}

	public void blockSettingsRefreshData() {
		
	}
}
