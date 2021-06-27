package javaGUI_view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLayeredPane layeredPane;
	private JLabel lblRole;
	private JRadioButton rdbtnCustomers;
	private JRadioButton rdbtnAdmin;
	private JButton btnRoleProceed;
	private JLabel bg_LoginBed;
	private JPanel panel_adminLogin;
	private JLabel bg_LoginAdmin;
	private JLabel lblAdminLogin;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JTextField txtUsername;
	private JButton btnBack;
	private JButton btnExit;
	private JPasswordField passwordField;
	private JPanel panel_Preview;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_NoAds;
	private JPanel panel_20Discount;
	private JLayeredPane layeredPane_Ads;
	private JButton btnAboutUs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdsAndMarketing ads = new AdsAndMarketing();
					Login frame = new Login(ads.getFlyerNumber());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanelTo(JLayeredPane layeredPane, JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	/**
	 * Create the frame.
	 */
	
	public Login(int a) {

		setTitle("Bona Fide Homestay Rental System");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/bg_Resource/hotel_icon-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(250, 240, 230));
		layeredPane.setBounds(640, 0, 624, 681);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel_role = new JPanel();
		panel_role.setBackground(new Color(250, 240, 230));
		layeredPane.add(panel_role, "name_286671467431600");
		panel_role.setLayout(null);
		
		btnAboutUs = new JButton("About Us");
		btnAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyBg abous = new CompanyBg();
				abous.setVisible(true);
			}
		});
		btnAboutUs.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnAboutUs.setBackground(new Color(245, 245, 245));
		btnAboutUs.setBounds(15, 620, 148, 50);
		panel_role.add(btnAboutUs);
			
		lblRole = new JLabel("Please choose your role to proceed.");
		lblRole.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblRole.setBounds(104, 274, 416, 37);
		panel_role.add(lblRole);
		
		rdbtnCustomers = new JRadioButton("I'm a Client");
		rdbtnCustomers.setBackground(new Color(245, 245, 245));
		buttonGroup.add(rdbtnCustomers);
		rdbtnCustomers.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		rdbtnCustomers.setBounds(212, 327, 200, 50);
		panel_role.add(rdbtnCustomers);
		
		rdbtnAdmin = new JRadioButton("I'm an Admin");
		rdbtnAdmin.setBackground(new Color(245, 245, 245));
		buttonGroup.add(rdbtnAdmin);
		rdbtnAdmin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		rdbtnAdmin.setBounds(212, 409, 200, 50);
		panel_role.add(rdbtnAdmin);
		
		btnRoleProceed = new JButton("Proceed");
		btnRoleProceed.setBackground(new Color(245, 245, 245));
		btnRoleProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnCustomers.isSelected()) {
					HomestayDescription hms = new HomestayDescription();
					hms.setVisible(true);
				}else if(rdbtnAdmin.isSelected()) 
					switchPanelTo(layeredPane, panel_adminLogin);
				else
					JOptionPane.showMessageDialog(btnRoleProceed, "Oops... Seems like you forgot to select your role.");
			}
		});
		btnRoleProceed.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnRoleProceed.setBounds(489, 620, 125, 50);
		panel_role.add(btnRoleProceed);
		
		btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Bona Fide Homestay Rental System", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnExit.setBackground(new Color(245, 245, 245));
		btnExit.setBounds(354, 620, 125, 50);
		panel_role.add(btnExit);
		
		bg_LoginBed = new JLabel("");
		bg_LoginBed.setIcon(new ImageIcon(Login.class.getResource("/bg_Resource/bed.png")));
		bg_LoginBed.setBounds(0, 0, 624, 681);
		panel_role.add(bg_LoginBed);
		
		panel_adminLogin = new JPanel();
		panel_adminLogin.setBackground(new Color(250, 240, 230));
		layeredPane.add(panel_adminLogin, "name_286671476134400");
		panel_adminLogin.setLayout(null);
		
		lblAdminLogin = new JLabel("<html><p style=\\\"text-align:center;\\\">Please Enter Admin<br />Username and Password</p></html>");
		lblAdminLogin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblAdminLogin.setBounds(171, 209, 283, 72);
		panel_adminLogin.add(lblAdminLogin);
		
		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblUsername.setBounds(130, 312, 200, 27);
		panel_adminLogin.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblPassword.setBounds(130, 350, 200, 27);
		panel_adminLogin.add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Dialog", Font.PLAIN, 25));
		txtUsername.setBounds(273, 310, 262, 30);
		panel_adminLogin.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnAdminLogin = new JButton("Log In");
		btnAdminLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if ((txtUsername.getText().equals("Spongebob")) && (passwordField.getText().equals("277275"))) {
					JOptionPane.showMessageDialog(btnAdminLogin, ("\nADMIN \"" + txtUsername.getText() + "\" LOG IN SUCCESSFULLY!"));
					AdminFrame admin = new AdminFrame();
					admin.setVisible(true);
					switchPanelTo(layeredPane, panel_role);
					txtUsername.setText("");
					passwordField.setText("");
					dispose();
				} else {
					JOptionPane.showMessageDialog(btnAdminLogin, "Invalid Username or Password");
				}
			}
		});
		btnAdminLogin.setBackground(new Color(245, 245, 245));
		btnAdminLogin.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnAdminLogin.setBounds(354, 620, 125, 50);
		panel_adminLogin.add(btnAdminLogin);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(layeredPane, panel_role);
			}
		});
		btnBack.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnBack.setBackground(new Color(245, 245, 245));
		btnBack.setBounds(489, 620, 125, 50);
		panel_adminLogin.add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Dialog", Font.PLAIN, 25));
		passwordField.setBounds(273, 348, 262, 30);
		panel_adminLogin.add(passwordField);
		
		bg_LoginAdmin = new JLabel("");
		bg_LoginAdmin.setIcon(new ImageIcon(Login.class.getResource("/bg_Resource/AdminLogin.png")));
		bg_LoginAdmin.setBounds(0, 0, 624, 681);
		panel_adminLogin.add(bg_LoginAdmin);
		
		layeredPane_Ads = new JLayeredPane();
		layeredPane_Ads.setBounds(0, 0, 642, 681);
		contentPane.add(layeredPane_Ads);
		layeredPane_Ads.setLayout(new CardLayout(0, 0));
		
		panel_NoAds = new JPanel();
		layeredPane_Ads.add(panel_NoAds, "name_483924202496600");
		panel_NoAds.setLayout(null);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/bg_Resource/flyer/No_Flyer.png")));
		lblNewLabel.setBounds(0, 0, 642, 681);
		panel_NoAds.add(lblNewLabel);
		
		panel_20Discount = new JPanel();
		layeredPane_Ads.add(panel_20Discount, "name_483924209901000");
		panel_20Discount.setLayout(null);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/bg_Resource/flyer/NO_DEPOSIT.png")));
		lblNewLabel_1.setBounds(0, 0, 642, 681);
		panel_20Discount.add(lblNewLabel_1);
		
		panel_Preview = new JPanel();
		layeredPane_Ads.add(panel_Preview, "name_483924217394500");
		panel_Preview.setLayout(null);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/bg_Resource/flyer/Preview.png")));
		lblNewLabel_2.setBounds(0, 0, 642, 681);
		panel_Preview.add(lblNewLabel_2);
		
		switch(a) {
		case 0:
			switchPanelTo(layeredPane_Ads, panel_NoAds);
			break;
		case 1:
			switchPanelTo(layeredPane_Ads, panel_20Discount);
			break;
		case 2:
			switchPanelTo(layeredPane_Ads, panel_Preview);
			break;
		}
	}
}
