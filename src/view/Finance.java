package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;

public class Finance extends JPanel {
	private JTextField txt_OtherExpense;
	private double totalRevenue, employeeSalary, otherExpense;
	private JLabel lbl_TotalEmployeeSalary;
	private JLabel lbl_RM;
	private JLabel lbl_TotalRevenue;
	
	/**
	 * Create the panel.
	 */
	public Finance(double employeeSalary) {
		setLayout(null);

		JLabel totalRevenueLabel = new JLabel("Total Revenue");
		totalRevenueLabel.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		totalRevenueLabel.setBounds(134, 154, 380, 40);
		add(totalRevenueLabel);
		
		JLabel lblTotalEmployeeSalary = new JLabel("Total Employee Salary");
		lblTotalEmployeeSalary.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lblTotalEmployeeSalary.setBounds(134, 224, 380, 40);
		add(lblTotalEmployeeSalary);
		
		JLabel lblTotalExpense = new JLabel("<html>Other Expense<br/>(e.g. water bill, electric bill etc)</html>");
		lblTotalExpense.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lblTotalExpense.setBounds(134, 294, 380, 74);
		add(lblTotalExpense);
		
		JLabel lblTotalNetProfit = new JLabel("Total Net Profit");
		lblTotalNetProfit.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lblTotalNetProfit.setBounds(134, 434, 380, 40);
		add(lblTotalNetProfit);
		
		JLabel lbl_NetProfit = new JLabel("0.00");
		lbl_NetProfit.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_NetProfit.setBounds(717, 442, 183, 25);
		add(lbl_NetProfit);
		
		lbl_RM = new JLabel("RM");
		lbl_RM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_RM.setBounds(667, 162, 40, 25);
		add(lbl_RM);
		
		JLabel lblNewLabel_2 = new JLabel("FINANCE");
		lblNewLabel_2.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_2.setBounds(434, 15, 119, 25);
		add(lblNewLabel_2);

		
		txt_OtherExpense = new JTextField();
		txt_OtherExpense.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txt_OtherExpense.setColumns(10);
		txt_OtherExpense.setBounds(717, 299, 150, 30);
		add(txt_OtherExpense);
		
		JLabel lbl_RM_1 = new JLabel("RM");
		lbl_RM_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_RM_1.setBounds(667, 232, 40, 25);
		add(lbl_RM_1);
		
		JLabel lbl_RM_2 = new JLabel("RM");
		lbl_RM_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_RM_2.setBounds(667, 302, 40, 25);
		add(lbl_RM_2);
		
		JLabel lbl_RM_4 = new JLabel("RM");
		lbl_RM_4.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_RM_4.setBounds(667, 442, 40, 25);
		add(lbl_RM_4);
		
		lbl_TotalEmployeeSalary = new JLabel(String.format("%.2f", employeeSalary));
		lbl_TotalEmployeeSalary.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_TotalEmployeeSalary.setBounds(717, 232, 183, 25);
		add(lbl_TotalEmployeeSalary);
		
		lbl_TotalRevenue = new JLabel(String.format("%.2f", 27000.50));
		lbl_TotalRevenue.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 27));
		lbl_TotalRevenue.setBounds(717, 162, 183, 25);
		add(lbl_TotalRevenue);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_OtherExpense.setText("");
			}
		});
		btnReset.setBackground(SystemColor.controlHighlight);
		btnReset.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnReset.setBounds(640, 584, 147, 40);
		add(btnReset);
		
		JButton btnCalculate = new JButton("CALCULATE");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {																//2.2 Exception Handling
				otherExpense = Double.parseDouble(txt_OtherExpense.getText());
				double netProfit = Double.parseDouble(lbl_TotalRevenue.getText()) - Double.parseDouble(lbl_TotalEmployeeSalary.getText()) - Double.parseDouble(txt_OtherExpense.getText());
				lbl_NetProfit.setText(String.format("%.2f",netProfit));
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Invalid Input for \"Other Expense\".\nPlease try again.");
				}
			}
		});
		btnCalculate.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnCalculate.setBackground(SystemColor.controlHighlight);
		btnCalculate.setBounds(797, 584, 147, 40);
		add(btnCalculate);
		

		
		JButton btnExport = new JButton("EXPORT");
		btnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {																//2.2 Exception Handling
				File file = new File("C:\\Users\\ncs00\\eclipse-workspace\\Programming2_Assignment3_GUI\\src\\textFile\\Finance.txt");
				if(!file.exists()) {
					file.createNewFile();											//2.3 File IO
					}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Total Revenue\t:" + lbl_TotalRevenue.getText());
				bw.write("\nEmployee Salary\t:" + lbl_TotalEmployeeSalary.getText());
				bw.write("\nOther Expenses\t:" + txt_OtherExpense.getText());
				bw.write("\nNet Profit\t:" + lbl_NetProfit.getText());
				bw.close();
				fw.close();
				JOptionPane.showMessageDialog(null, "Data Exported");
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnExport.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnExport.setBackground(SystemColor.controlHighlight);
		btnExport.setBounds(483, 584, 147, 40);
		add(btnExport);

	}
}
