package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.ImageIcon;

public class AdminFrame extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {												//2.2 Exception Handling
					AdminFrame frame = new AdminFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanelTo(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		setTitle("Administration");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminFrame.class.getResource("/bg_Resource/hotel_icon-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(241, 11, 1015, 660);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
//		Login log = new Login(0);

		EmployeeMangement employee = new EmployeeMangement();
		layeredPane.add(employee, "name_296874963524500");
		
		InventoryManagement invtMgmt = new InventoryManagement();
		layeredPane.add(invtMgmt, "name_296877169628700");
		
		SalesSystem reg = new SalesSystem();
		
		Finance finance = new Finance(employee.getTotalSalary());
		layeredPane.add(finance, "name_296878934031700");
		
		AdsAndMarketing ads = new AdsAndMarketing();
		layeredPane.add(ads, "name_296880651385200");
		
		JButton btnEmployeeMgmt = new JButton("<html><p style=\"text-align:center;\">Employee<br />Management</p></html>");
		btnEmployeeMgmt.setBackground(new Color(245, 245, 245));
		btnEmployeeMgmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(employee);
			}
		});
		btnEmployeeMgmt.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnEmployeeMgmt.setBounds(20, 60, 195, 80);
		contentPane.add(btnEmployeeMgmt);
		
		JButton btnInventoryMgmt = new JButton("<html><p style=\\\"text-align:center;\\\">Inventory<br />Management</p></html>");
		btnInventoryMgmt.setBackground(new Color(245, 245, 245));
		btnInventoryMgmt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(invtMgmt);
			}
		});
		btnInventoryMgmt.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnInventoryMgmt.setBounds(20, 180, 195, 80);
		contentPane.add(btnInventoryMgmt);
		
		JButton btnFinance = new JButton("Finance");
		btnFinance.setBackground(new Color(245, 245, 245));
		btnFinance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(finance);
			}
		});
		btnFinance.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnFinance.setBounds(20, 300, 195, 80);
		contentPane.add(btnFinance);
		
		JButton btnAds = new JButton("<html><p style=\\\"text-align:center;\\\">Advertisement<br />& Marketing</p></html>");
		btnAds.setBackground(new Color(245, 245, 245));
		btnAds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(ads);
			}
		});
		btnAds.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnAds.setBounds(20, 420, 195, 80);
		contentPane.add(btnAds);
		
		JButton btnBack = new JButton("Back To Login");
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Go Back to Login Page??", "Administration", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					Login newLogin = new Login(ads.getFlyerNumber());
					dispose();
					newLogin.setVisible(true);
				}
			}
		});
		btnBack.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnBack.setBounds(20, 540, 195, 80);
		contentPane.add(btnBack);
		
		JLabel bg_AdminMarble = new JLabel("");
		bg_AdminMarble.setIcon(new ImageIcon(AdminFrame.class.getResource("/bg_Resource/marble bg.png")));
		bg_AdminMarble.setBounds(0, 0, 1264, 681);
		contentPane.add(bg_AdminMarble);
	}
}
