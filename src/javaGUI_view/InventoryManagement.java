package javaGUI_view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class InventoryManagement extends JPanel {
	private JTextField txtHomestayName;
	private JTextField txtPPN;
	private JTextField txtBeds;
	private JTextField txtGuest;
	private JTable table;
	
	public String getCellValue(int i, int j) {
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		return (String)model.getValueAt(i, j);
	}
	/**
	 * Create the panel.
	 */
	public InventoryManagement() {
		setLayout(null);
		
		JLabel hostelNameLabel = new JLabel("Hostel Name");
		hostelNameLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		hostelNameLabel.setBounds(10, 65, 178, 25);
		add(hostelNameLabel);
		
		txtHomestayName = new JTextField();
		txtHomestayName.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtHomestayName.setColumns(10);
		txtHomestayName.setBounds(160, 62, 216, 30);
		add(txtHomestayName);
		
		JLabel priceLabel = new JLabel("Price (RM)");
		priceLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		priceLabel.setBounds(10, 120, 178, 25);
		add(priceLabel);
		
		txtPPN = new JTextField();
		txtPPN.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtPPN.setColumns(10);
		txtPPN.setBounds(160, 117, 216, 30);
		add(txtPPN);
		
		JLabel bedLabel = new JLabel("Number of Beds");
		bedLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		bedLabel.setBounds(10, 175, 178, 25);
		add(bedLabel);
		
		txtBeds = new JTextField();
		txtBeds.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtBeds.setColumns(10);
		txtBeds.setBounds(160, 172, 216, 30);
		add(txtBeds);
		
		JLabel guestLabel = new JLabel("Max Guest(s)");
		guestLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		guestLabel.setBounds(10, 230, 178, 25);
		add(guestLabel);
		
		txtGuest = new JTextField();
		txtGuest.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtGuest.setColumns(10);
		txtGuest.setBounds(160, 227, 216, 30);
		add(txtGuest);
		
		JButton btnAddData = new JButton("ADD DATA");
		btnAddData.setBackground(SystemColor.controlHighlight);
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {												//2.2 Exception Handling
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						txtHomestayName.getText(),
						txtPPN.getText(),
						txtBeds.getText(),
						txtGuest.getText(),
				});
				int bed = Integer.parseInt(txtBeds.getText());
				int guest = Integer.parseInt(txtGuest.getText());
				double price = Double.parseDouble(txtPPN.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please input double value for \"Price Per Night\"\nand integer value for \"Number of Bed\" and \"Maximum Guest\".");
				}
			}
		});
		btnAddData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnAddData.setBounds(10, 310, 366, 40);
		add(btnAddData);
		
		JButton btnDeleteData = new JButton("DELETE DATA");
		btnDeleteData.setBackground(SystemColor.controlHighlight);
		btnDeleteData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				if(table.getSelectedRow()==-1) {
					if(table.getRowCount()==0) {
						JOptionPane.showMessageDialog(null,"No data to delete",
								"Administration - Inventory Management", JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null,"Select a row to delete",
								"Administration - Inventory Management", JOptionPane.OK_OPTION);
					}
				}else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDeleteData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnDeleteData.setBounds(10, 360, 366, 40);
		add(btnDeleteData);
		
		JButton btnPrintData = new JButton("PRINT DATA");
		btnPrintData.setBackground(SystemColor.controlHighlight);
		btnPrintData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {											//2.2 Exception Handling
					table.print();
				} catch (java.awt.print.PrinterException e_invtMgmt) {
					System.err.format("No printer found", e_invtMgmt.getMessage());
				}
			}
		});
		btnPrintData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnPrintData.setBounds(10, 510, 366, 40);
		add(btnPrintData);
		
		JButton btnExportData = new JButton("EXPORT DATA");
		btnExportData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {												//2.2 Exception Handling
				File file = new File("C:\\Users\\ncs00\\eclipse-workspace\\Programming2_Assignment3_GUI\\src\\textFile\\InventoryManagement.txt");
				if(!file.exists()) {
					file.createNewFile();
					}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());				//2.3 File IO
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Homestay\t\t|Price\t|Bed\t|Max Guests\n");

				for (int i=0; i<table.getRowCount(); i++) {
					for (int j=0; j<table.getColumnCount(); j++) {
						bw.write(table.getModel().getValueAt(i, j) + "\t|");
						}
					bw.write("\n________________________________________________\n");
					}
					bw.close();
					fw.close();
					JOptionPane.showMessageDialog(null, "Data Exported");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnExportData.setBackground(SystemColor.controlHighlight);
		btnExportData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnExportData.setBounds(10, 610, 366, 40);
		add(btnExportData);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(386, 65, 619, 584);
		add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Orchid Suite", "68.50", "3", "6"},
				{"Magic Studio", "98.00", "4", "6"},
				{"Diamond House", "112.50", "3", "6"},
			},
			new String[] {
				"Hostel Name", "Price Per Night (RM)", "Num of Bed(s)", "Max Guest(s)"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(137);
		table.getColumnModel().getColumn(1).setPreferredWidth(116);
		table.getColumnModel().getColumn(2).setPreferredWidth(82);
		table.getColumnModel().getColumn(3).setPreferredWidth(74);
		table.setRowHeight(60);
		table.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		scrollPane_1.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("INVENTORY MANAGEMENT");
		lblNewLabel_1.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(320, 15, 354, 25);
		add(lblNewLabel_1);
		
		JButton btnReset = new JButton("RESET DATA");
		btnReset.setBackground(SystemColor.controlHighlight);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtHomestayName.setText("");
				txtPPN.setText("");
				txtBeds.setText("");
				txtGuest.setText("");
			}
		});
		btnReset.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnReset.setBounds(10, 560, 366, 40);
		add(btnReset);
		
		JButton btnSearchData = new JButton("SEARCH DATA");
		btnSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					boolean search = false;
					String searchHomestayName = JOptionPane.showInputDialog("Enter Homestay Name:", "");
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					for(int i = 0; i < model.getRowCount(); i++) {
						if(searchHomestayName.equalsIgnoreCase((String) model.getValueAt(i, 0))) {
							JOptionPane.showMessageDialog(btnSearchData,
									"Search Result\nHomestay Name                 : " + model.getValueAt(i, 0)
											+ "\nPrice Per Night                    : " + model.getValueAt(i, 1)
											+ "\nNumber of Bed(s)               : " + model.getValueAt(i, 2)
											+ "\nMax Number of Guest(s)  : " + model.getValueAt(i, 3));
							search = true;
						}
					}
					if(!search)
						JOptionPane.showMessageDialog(btnSearchData, "No Matching Result.");
				
			}
		});
		btnSearchData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnSearchData.setBackground(SystemColor.controlHighlight);
		btnSearchData.setBounds(10, 460, 366, 40);
		add(btnSearchData);
		
		JButton btnEditData = new JButton("EDIT DATA");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (table.getSelectedRow() == -1) {
					if ((table.getRowCount() == 0)) {
						JOptionPane.showMessageDialog(null, "No data to edit",
								"Admin - Inventory Management", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to edit",
								"Admin - Inventory Management", JOptionPane.OK_OPTION);
					}
				} else {
					table.setValueAt(txtHomestayName.getText(), table.getSelectedRow(), 0);
					table.setValueAt(txtPPN.getText(), table.getSelectedRow(), 1);
					table.setValueAt(txtBeds.getText(), table.getSelectedRow(), 2);
					table.setValueAt(txtGuest.getText(), table.getSelectedRow(), 3);
					
				}
			}
		});
		btnEditData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnEditData.setBackground(SystemColor.controlHighlight);
		btnEditData.setBounds(10, 410, 366, 40);
		add(btnEditData);

	}
}
