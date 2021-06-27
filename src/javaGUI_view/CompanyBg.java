package javaGUI_view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class CompanyBg extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompanyBg frame = new CompanyBg();
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
	public CompanyBg() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CompanyBg.class.getResource("/bg_Resource/hotel_icon-removebg-preview.png")));
		setTitle("ABOUT BONA FIDE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_CompanyDesc = new JLabel("<html><p style=\\\"text-align:center;\\\">Bona Fide is a Malaysian-based Homestay Rental Site<br />providing outstanding homestay rental service to the clients</p></html>");
		lbl_CompanyDesc.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 18));
		lbl_CompanyDesc.setBounds(6, 55, 472, 106);
		contentPane.add(lbl_CompanyDesc);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 18));
		lblAboutUs.setBounds(196, 36, 92, 30);
		contentPane.add(lblAboutUs);
		
		JLabel lbl_CompanyName = new JLabel("Company Name");
		lbl_CompanyName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_CompanyName.setBounds(15, 200, 214, 24);
		contentPane.add(lbl_CompanyName);
		
		JLabel lbl_CompanyNameAns = new JLabel("Bona Fide");
		lbl_CompanyNameAns.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_CompanyNameAns.setBounds(50, 225, 424, 24);
		contentPane.add(lbl_CompanyNameAns);
		
		JLabel lbl_Contact = new JLabel("Contact Number");
		lbl_Contact.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_Contact.setBounds(15, 300, 214, 24);
		contentPane.add(lbl_Contact);
		
		JLabel lbl_ContactNumAns = new JLabel("05-847-0809 or 016-831-7755");
		lbl_ContactNumAns.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_ContactNumAns.setBounds(50, 325, 424, 24);
		contentPane.add(lbl_ContactNumAns);
		
		JLabel lbl_Address = new JLabel("Office Address");
		lbl_Address.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_Address.setBounds(15, 400, 214, 24);
		contentPane.add(lbl_Address);
		
		JLabel lbl_AddressAns = new JLabel("<html>333, Raintree Street, 34000 Taiping,<br/>Perak, Malaysia</html>");
		lbl_AddressAns.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_AddressAns.setBounds(50, 425, 424, 41);
		contentPane.add(lbl_AddressAns);
		
		JLabel lbl_Email = new JLabel("Email Address");
		lbl_Email.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_Email.setBounds(15, 500, 214, 24);
		contentPane.add(lbl_Email);
		
		JLabel lbl_CompanyInfo_4_3 = new JLabel("bonafiderentalsys@gmail.com");
		lbl_CompanyInfo_4_3.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_CompanyInfo_4_3.setBounds(50, 525, 424, 24);
		contentPane.add(lbl_CompanyInfo_4_3);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(245, 245, 245));
		btnNewButton.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btnNewButton.setBounds(324, 600, 150, 50);
		contentPane.add(btnNewButton);
		
		JLabel bg_CompanyBG = new JLabel("");
		bg_CompanyBG.setIcon(new ImageIcon(CompanyBg.class.getResource("/bg_Resource/marble1.jpg")));
		bg_CompanyBG.setBounds(0, 0, 484, 661);
		contentPane.add(bg_CompanyBG);
	}
}
