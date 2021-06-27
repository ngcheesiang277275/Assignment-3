package view;

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

public class EmployeeMangement extends JPanel {
	private JTextField txtName;
	private JTextField txtPosition;
	private JTextField txtSalary;
	private JTextField txtContactNum;
	private JTable table;
	private double totalSalary;
	
	public double calculateTotalSalary() {
		double total = 0;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(int i = 0; i < model.getRowCount(); i++) {
			total += Double.parseDouble((String) model.getValueAt(i, 2));
		}
		return total;
	}
	
	public double getTotalSalary() {
		return this.totalSalary;
	}

	/**
	 * Create the panel.
	 */
	public EmployeeMangement() {
		setLayout(null);	
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		nameLabel.setBounds(10, 65, 178, 25);
		add(nameLabel);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(160, 62, 216, 30);
		add(txtName);
		
		JLabel positionLabel = new JLabel("Position");
		positionLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		positionLabel.setBounds(10, 120, 178, 25);
		add(positionLabel);
		
		txtPosition = new JTextField();
		txtPosition.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtPosition.setColumns(10);
		txtPosition.setBounds(160, 117, 216, 30);
		add(txtPosition);
		
		JLabel salaryLabel = new JLabel("Salary");
		salaryLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		salaryLabel.setBounds(10, 175, 178, 25);
		add(salaryLabel);
		
		txtSalary = new JTextField();
		txtSalary.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtSalary.setColumns(10);
		txtSalary.setBounds(160, 172, 216, 30);
		add(txtSalary);
		
		JLabel contactNoLabel = new JLabel("Contact no.");
		contactNoLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		contactNoLabel.setBounds(10, 230, 178, 25);
		add(contactNoLabel);
		
		txtContactNum = new JTextField();
		txtContactNum.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtContactNum.setColumns(10);
		txtContactNum.setBounds(160, 227, 216, 30);
		add(txtContactNum);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE MANAGEMENT");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(320, 15, 334, 25);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(386, 65, 619, 584);
		add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Taehyung", "Manager", "5000.00", "012-3499011"},
				{"Lisa", "Assistant", "3500.00", "013-5590992"},
				{"Sehun", "Staff", "2800.00", "016-7726398"},
			},
			new String[] {
				"Employee Name", "Position", "Salary (RM)", "Contact No."
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(141);
		table.getColumnModel().getColumn(1).setPreferredWidth(115);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		this.totalSalary = calculateTotalSalary();
		
		JButton btnAddData = new JButton("ADD DATA");
		btnAddData.setBackground(SystemColor.controlHighlight);
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {												//2.2 -Exception Handling
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						txtName.getText(),
						txtPosition.getText(),
						txtSalary.getText(),
						txtContactNum.getText(),
				});
				totalSalary += Double.parseDouble(txtSalary.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please enter a double value for \"Salary\".");
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
								"Administration - Employee Management", JOptionPane.OK_OPTION);
					}else {
						JOptionPane.showMessageDialog(null,"Select a row to delete",
								"Administration - Employee Management", JOptionPane.OK_OPTION);
					}
				}else {
					totalSalary -= Double.parseDouble((String)table.getValueAt(table.getSelectedRow(), 2));
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
				try {
					table.print();
				} catch (java.awt.print.PrinterException e_EmployeeMgmt) {
					System.err.format("No printer found", e_EmployeeMgmt.getMessage());
				}		
				
			}
		});
		btnPrintData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnPrintData.setBounds(10, 510, 366, 40);
		add(btnPrintData);
		
		JButton btnReset = new JButton("RESET DATA");
		btnReset.setBackground(SystemColor.controlHighlight);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtPosition.setText("");
				txtSalary.setText("");
				txtContactNum.setText("");
			}
		});
		btnReset.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnReset.setBounds(10, 560, 366, 40);
		add(btnReset);
		
		JButton btnExportData = new JButton("EXPORT DATA");
		btnExportData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				File file = new File("C:\\Users\\ncs00\\eclipse-workspace\\Programming2_Assignment3_GUI\\src\\textFile\\EmployeeManagement.txt");
				if(!file.exists()) {
					file.createNewFile();
					}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("EmployeeName\t|Position\t|Salary\t|Contact Number\n");
				for (int i=0; i<table.getRowCount(); i++) {
					for (int j=0; j<table.getColumnCount(); j++) {
						bw.write(table.getModel().getValueAt(i, j) + "\t|");
						}
					bw.write("\n________________________________________\n");
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
		
		JButton btnSearchData = new JButton("SEARCH DATA");
		btnSearchData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean search = false;
				String searchEmployeeName = JOptionPane.showInputDialog("Enter Employee Name:", "");
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				for(int i = 0; i < model.getRowCount(); i++) {
					if(searchEmployeeName.equalsIgnoreCase((String) model.getValueAt(i, 0))) {
						JOptionPane.showMessageDialog(btnSearchData,
								"Search Result\nEmployee Name : " + model.getValueAt(i, 0)
										+ "\nPosition               : " + model.getValueAt(i, 1)
										+ "\nSalary                  : " + model.getValueAt(i, 2)
										+ "\nContact No.         : " + model.getValueAt(i, 3));
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
								"Admin - Employee Management", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Input the new data and select a row to update the data",
								"Admin - Employee Management", JOptionPane.OK_OPTION);
					}
				} else {
					table.setValueAt(txtName.getText(), table.getSelectedRow(), 0);
					table.setValueAt(txtPosition.getText(), table.getSelectedRow(), 1);
					table.setValueAt(txtSalary.getText(), table.getSelectedRow(), 2);
					table.setValueAt(txtContactNum.getText(), table.getSelectedRow(), 3);
					
				}
			}
		});
		btnEditData.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnEditData.setBackground(SystemColor.controlHighlight);
		btnEditData.setBounds(10, 410, 366, 40);
		add(btnEditData);

	}
}
