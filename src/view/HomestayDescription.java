package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

public class HomestayDescription extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPanel panel_OrchidSuite;
	private JPanel panel_MagicStudio;
	private JPanel panel_DiamondHouse;
	private JPanel homestaySelection;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public void switchPanelTo(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomestayDescription frame = new HomestayDescription();
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
	public HomestayDescription() {

		setTitle("Homestay Description");
		SalesSystem reg = new SalesSystem();
		InventoryManagement invt = new InventoryManagement();
				
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomestayDescription.class.getResource("/bg_Resource/hotel_icon-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 960, 540);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		homestaySelection = new JPanel();
		layeredPane.add(homestaySelection, "name_5342146597700");
		homestaySelection.setLayout(null);
		
		JLabel lblPleaseSelectOne = new JLabel("Please select one homestay to continue.");
		lblPleaseSelectOne.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblPleaseSelectOne.setBounds(252, 193, 453, 30);
		homestaySelection.add(lblPleaseSelectOne);
		
		JLabel lblHiCustomer = new JLabel("Hi, our beloved client.");
		lblHiCustomer.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		lblHiCustomer.setBounds(353, 163, 253, 30);
		homestaySelection.add(lblHiCustomer);
		
		JRadioButton rdbtnOrchidSuite = new JRadioButton(invt.getCellValue(0, 0));
		buttonGroup.add(rdbtnOrchidSuite);
		rdbtnOrchidSuite.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		rdbtnOrchidSuite.setBounds(353, 243, 250, 23);
		homestaySelection.add(rdbtnOrchidSuite);
		
		JRadioButton rdbtnMagicStudioGeorgetown = new JRadioButton(invt.getCellValue(1, 0));
		buttonGroup.add(rdbtnMagicStudioGeorgetown);
		rdbtnMagicStudioGeorgetown.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		rdbtnMagicStudioGeorgetown.setBounds(353, 286, 250, 36);
		homestaySelection.add(rdbtnMagicStudioGeorgetown);
		
		JRadioButton rdbtnDiamondHouseIpoh = new JRadioButton(invt.getCellValue(2, 0));
		buttonGroup.add(rdbtnDiamondHouseIpoh);
		rdbtnDiamondHouseIpoh.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		rdbtnDiamondHouseIpoh.setBounds(353, 343, 250, 23);
		homestaySelection.add(rdbtnDiamondHouseIpoh);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnOrchidSuite.isSelected())
					switchPanelTo(panel_OrchidSuite);
				else if(rdbtnMagicStudioGeorgetown.isSelected())
					switchPanelTo(panel_MagicStudio);
				else if(rdbtnDiamondHouseIpoh.isSelected())
					switchPanelTo(panel_DiamondHouse);
				else
					JOptionPane.showMessageDialog(btnSelect, "Please kindly select one homestay to continue.");
			}
		});
		btnSelect.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnSelect.setBackground(new Color(245, 245, 245));
		btnSelect.setBounds(789, 442, 150, 50);
		homestaySelection.add(btnSelect);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBack_1.setBackground(new Color(245, 245, 245));
		btnBack_1.setBounds(629, 442, 150, 50);
		homestaySelection.add(btnBack_1);
		
		JLabel bg_HomestayDescriptionPillows = new JLabel("");
		bg_HomestayDescriptionPillows.setIcon(new ImageIcon(HomestayDescription.class.getResource("/bg_Resource/blanket.png")));
		bg_HomestayDescriptionPillows.setBounds(0, 0, 960, 540);
		homestaySelection.add(bg_HomestayDescriptionPillows);
		
		panel_OrchidSuite = new JPanel();
		layeredPane.add(panel_OrchidSuite, "name_295492590170800");
		panel_OrchidSuite.setLayout(null);
		
		JLabel lblOrchidSuite = new JLabel(invt.getCellValue(0, 0));
		lblOrchidSuite.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 15));
		lblOrchidSuite.setBounds(457, 21, 92, 31);
		panel_OrchidSuite.add(lblOrchidSuite);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.setVisible(true);
			}
		});
		btnBook.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBook.setBackground(new Color(245, 245, 245));
		btnBook.setBounds(785, 440, 150, 50);
		panel_OrchidSuite.add(btnBook);
		
		JButton btnBack_OS = new JButton("Back");
		btnBack_OS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(homestaySelection);
			}
		});
		btnBack_OS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBack_OS.setBackground(new Color(245, 245, 245));
		btnBack_OS.setBounds(625, 440, 150, 50);
		panel_OrchidSuite.add(btnBack_OS);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 10));
		tabbedPane.setBounds(10, 21, 330, 320);
		panel_OrchidSuite.add(tabbedPane);
		
		JLabel lbl_LivingRoom_OS = new JLabel("");
		lbl_LivingRoom_OS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/1OS_living room.jpeg")));
		tabbedPane.addTab("Living Room", null, lbl_LivingRoom_OS, null);
		
		JLabel lbl_DiningArea_OS = new JLabel("");
		lbl_DiningArea_OS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/1OS_dining area.jpeg")));
		tabbedPane.addTab("Dining Area", null, lbl_DiningArea_OS, null);
		
		JLabel lbl_bedroom1_OS = new JLabel("");
		lbl_bedroom1_OS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/1OS_Master room.jpeg")));
		tabbedPane.addTab("Room 1", null, lbl_bedroom1_OS, null);
		
		JLabel lbl_bedroom2_OS = new JLabel("");
		lbl_bedroom2_OS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/1OS_room 2.jpeg")));
		tabbedPane.addTab("Room 2", null, lbl_bedroom2_OS, null);
		
		JLabel lbl_bedroom3_OS = new JLabel("");
		lbl_bedroom3_OS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/1OS_room3.jpeg")));
		tabbedPane.addTab("Room 3", null, lbl_bedroom3_OS, null);
		
		JLabel lbl_Address = new JLabel("Address");
		lbl_Address.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Address.setBounds(360, 90, 189, 21);
		panel_OrchidSuite.add(lbl_Address);
		
		JLabel lbl_PPN = new JLabel("Price Per Night (RM)");
		lbl_PPN.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN.setBounds(360, 150, 189, 31);
		panel_OrchidSuite.add(lbl_PPN);
		
		JLabel lbl_Facilities = new JLabel("Facilities");
		lbl_Facilities.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Facilities.setBounds(360, 210, 189, 21);
		panel_OrchidSuite.add(lbl_Facilities);
		
		JLabel lbl_Max = new JLabel("Max Num of Guest");
		lbl_Max.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Max.setBounds(360, 270, 189, 21);
		panel_OrchidSuite.add(lbl_Max);
		
		JLabel lbl_Bed = new JLabel("Number of Beds");
		lbl_Bed.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Bed.setBounds(360, 330, 189, 21);
		panel_OrchidSuite.add(lbl_Bed);
		
		JLabel lbl_Address_OS = new JLabel("<html>21, Jalan Mahawangsa 1,<br/>Kuah, 07000 Langkawi, Kedah</html> ");
		lbl_Address_OS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Address_OS.setBounds(573, 90, 323, 57);
		panel_OrchidSuite.add(lbl_Address_OS);
		
		JLabel lbl_PPN_OS = new JLabel("RM " + invt.getCellValue(0, 1));
		lbl_PPN_OS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN_OS.setBounds(573, 155, 323, 21);
		panel_OrchidSuite.add(lbl_PPN_OS);
		
		JLabel lbl_Facilities_OS = new JLabel("<html>TV, WiFi, Netflix, stove,<br/>air-conditioner</html>");
		lbl_Facilities_OS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Facilities_OS.setBounds(573, 210, 323, 49);
		panel_OrchidSuite.add(lbl_Facilities_OS);
		
		JLabel lbl_Max_OS = new JLabel(invt.getCellValue(0, 3));
		lbl_Max_OS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Max_OS.setBounds(573, 270, 323, 21);
		panel_OrchidSuite.add(lbl_Max_OS);
		
		JLabel lbl_Bed_OS = new JLabel(invt.getCellValue(0, 2));
		lbl_Bed_OS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Bed_OS.setBounds(573, 330, 323, 21);
		panel_OrchidSuite.add(lbl_Bed_OS);
		
		panel_MagicStudio = new JPanel();
		layeredPane.add(panel_MagicStudio, "name_295505862071400");
		panel_MagicStudio.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 10));
		tabbedPane_1.setBounds(10, 21, 330, 320);
		panel_MagicStudio.add(tabbedPane_1);
		
		JLabel lbl_LivingRoom_MS = new JLabel("");
		lbl_LivingRoom_MS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/MSliving room.jpg")));
		tabbedPane_1.addTab("Living Room", null, lbl_LivingRoom_MS, null);
		
		JLabel lbl_DiningArea_MS = new JLabel("");
		lbl_DiningArea_MS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/MSdining area.jpg")));
		tabbedPane_1.addTab("Dining Area", null, lbl_DiningArea_MS, null);
		
		JLabel lbl_bedroom1_MS = new JLabel("");
		lbl_bedroom1_MS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/MSroom1.jpg")));
		tabbedPane_1.addTab("Room 1", null, lbl_bedroom1_MS, null);
		
		JLabel lbl_bedroom2_MS = new JLabel("New label");
		lbl_bedroom2_MS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/MSroom2.jpg")));
		tabbedPane_1.addTab("Room 2", null, lbl_bedroom2_MS, null);
		
		JLabel lbl_bedroom3_MS = new JLabel("");
		lbl_bedroom3_MS.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/MSroom3.jpg")));
		tabbedPane_1.addTab("Room 3", null, lbl_bedroom3_MS, null);
		
		JButton btnBook_2 = new JButton("Book");
		btnBook_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.setVisible(true);
			}
		});
		btnBook_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBook_2.setBackground(new Color(245, 245, 245));
		btnBook_2.setBounds(785, 440, 150, 50);
		panel_MagicStudio.add(btnBook_2);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(homestaySelection);
			}
		});
		btnBack_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBack_2.setBackground(new Color(245, 245, 245));
		btnBack_2.setBounds(625, 440, 150, 50);
		panel_MagicStudio.add(btnBack_2);
		
		JLabel lblMagicStudio = new JLabel(invt.getCellValue(1, 0));
		lblMagicStudio.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 15));
		lblMagicStudio.setBounds(457, 21, 92, 31);
		panel_MagicStudio.add(lblMagicStudio);
		
		JLabel lbl_Address_1 = new JLabel("Address");
		lbl_Address_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Address_1.setBounds(360, 90, 198, 21);
		panel_MagicStudio.add(lbl_Address_1);
		
		JLabel lbl_PPN_1 = new JLabel("Price Per Night (RM)");
		lbl_PPN_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN_1.setBounds(360, 150, 198, 21);
		panel_MagicStudio.add(lbl_PPN_1);
		
		JLabel lbl_Facilities_1 = new JLabel("Facilities");
		lbl_Facilities_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Facilities_1.setBounds(360, 210, 198, 21);
		panel_MagicStudio.add(lbl_Facilities_1);
		
		JLabel lbl_Max_1 = new JLabel("Max Num of Guest");
		lbl_Max_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Max_1.setBounds(360, 270, 198, 21);
		panel_MagicStudio.add(lbl_Max_1);
		
		JLabel lbl_Bed_1 = new JLabel("Number of Beds");
		lbl_Bed_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Bed_1.setBounds(360, 330, 198, 21);
		panel_MagicStudio.add(lbl_Bed_1);
		
		JLabel lbl_Bed_MS = new JLabel(invt.getCellValue(1, 2));
		lbl_Bed_MS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Bed_MS.setBounds(573, 330, 274, 21);
		panel_MagicStudio.add(lbl_Bed_MS);
		
		JLabel lbl_Max_MS = new JLabel(invt.getCellValue(1, 3));
		lbl_Max_MS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Max_MS.setBounds(573, 270, 274, 21);
		panel_MagicStudio.add(lbl_Max_MS);
		
		JLabel lbl_Facilities_MS = new JLabel("<html>TV, WiFi, Netflix, stove,<br/>air-conditioner</html>");
		lbl_Facilities_MS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Facilities_MS.setBounds(573, 210, 274, 50);
		panel_MagicStudio.add(lbl_Facilities_MS);
		
		JLabel lbl_PPN_MS = new JLabel("RM " + invt.getCellValue(1, 1));
		lbl_PPN_MS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN_MS.setBounds(573, 150, 274, 21);
		panel_MagicStudio.add(lbl_PPN_MS);
		
		JLabel lbl_Address_MS = new JLabel("<html>52, Lebuh Noordin,<br/>10300, George Town, Penang</html>");
		lbl_Address_MS.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Address_MS.setBounds(573, 90, 274, 57);
		panel_MagicStudio.add(lbl_Address_MS);
		
		panel_DiamondHouse = new JPanel();
		layeredPane.add(panel_DiamondHouse, "name_295510606370500");
		panel_DiamondHouse.setLayout(null);
		
		JTabbedPane tabbedPane_1_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 11));
		tabbedPane_1_1.setBounds(10, 11, 330, 320);
		panel_DiamondHouse.add(tabbedPane_1_1);
		
		JLabel lbl_LivingRoom_DH = new JLabel("");
		lbl_LivingRoom_DH.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/DH_living room.jpg")));
		tabbedPane_1_1.addTab("Living Room", null, lbl_LivingRoom_DH, null);
		
		JLabel lbl_DiningArea_DH = new JLabel("");
		lbl_DiningArea_DH.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/DH_Dining area.jpg")));
		tabbedPane_1_1.addTab("Dining Area", null, lbl_DiningArea_DH, null);
		
		JLabel lbl_Bedroom1_DH = new JLabel("");
		lbl_Bedroom1_DH.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/DH_Room1.jpg")));
		tabbedPane_1_1.addTab("Room 1", null, lbl_Bedroom1_DH, null);
		
		JLabel lbl_bedroom2_DH = new JLabel("");
		lbl_bedroom2_DH.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/DH_Room2.jpg")));
		tabbedPane_1_1.addTab("Room 2", null, lbl_bedroom2_DH, null);
		
		JLabel lbl_bedroom3_DH = new JLabel("");
		lbl_bedroom3_DH.setIcon(new ImageIcon(HomestayDescription.class.getResource("/homestayPic/DH_Room3.jpg")));
		tabbedPane_1_1.addTab("Room 3", null, lbl_bedroom3_DH, null);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(homestaySelection);
			}
		});
		btnBack_3.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBack_3.setBackground(new Color(245, 245, 245));
		btnBack_3.setBounds(625, 440, 150, 50);
		panel_DiamondHouse.add(btnBack_3);
		
		JButton btnBook_3 = new JButton("Book");
		btnBook_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.setVisible(true);
			}
		});
		btnBook_3.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBook_3.setBackground(new Color(245, 245, 245));
		btnBook_3.setBounds(785, 440, 150, 50);
		panel_DiamondHouse.add(btnBook_3);
		
		JLabel lblDiamondHouse = new JLabel(invt.getCellValue(2, 0));
		lblDiamondHouse.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lblDiamondHouse.setBounds(440, 21, 225, 31);
		panel_DiamondHouse.add(lblDiamondHouse);
		
		JLabel lbl_Address_2 = new JLabel("Address");
		lbl_Address_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Address_2.setBounds(360, 90, 186, 21);
		panel_DiamondHouse.add(lbl_Address_2);
		
		JLabel lbl_Address_OS_1_1 = new JLabel("<html>33, Jalan Haji Wahab, Taman Canning, 31400 Ipoh</html>");
		lbl_Address_OS_1_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Address_OS_1_1.setBounds(573, 90, 365, 57);
		panel_DiamondHouse.add(lbl_Address_OS_1_1);
		
		JLabel lbl_PPN_2 = new JLabel("Price Per Night (RM)");
		lbl_PPN_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN_2.setBounds(360, 150, 186, 21);
		panel_DiamondHouse.add(lbl_PPN_2);
		
		JLabel lbl_PPN_DH = new JLabel("RM " + invt.getCellValue(2, 1));
		lbl_PPN_DH.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN_DH.setBounds(573, 150, 365, 21);
		panel_DiamondHouse.add(lbl_PPN_DH);
		
		JLabel lbl_Facilities_2 = new JLabel("Facilities");
		lbl_Facilities_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Facilities_2.setBounds(360, 210, 186, 21);
		panel_DiamondHouse.add(lbl_Facilities_2);
		
		JLabel lbl_Facilities_DH = new JLabel("<html>TV, WiFi, Netflix, stove,<br/>air-conditioner</html>");
		lbl_Facilities_DH.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Facilities_DH.setBounds(573, 210, 365, 50);
		panel_DiamondHouse.add(lbl_Facilities_DH);
		
		JLabel lbl_Max_2 = new JLabel("Max Num of Guest");
		lbl_Max_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Max_2.setBounds(360, 270, 186, 21);
		panel_DiamondHouse.add(lbl_Max_2);
		
		JLabel lbl_Max_DH = new JLabel(invt.getCellValue(2, 3));
		lbl_Max_DH.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Max_DH.setBounds(573, 270, 365, 21);
		panel_DiamondHouse.add(lbl_Max_DH);
		
		JLabel lbl_Bed_2 = new JLabel("Number of Beds");
		lbl_Bed_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Bed_2.setBounds(360, 330, 186, 21);
		panel_DiamondHouse.add(lbl_Bed_2);
		
		JLabel lbl_Bed_DH = new JLabel(invt.getCellValue(2, 2));
		lbl_Bed_DH.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Bed_DH.setBounds(573, 330, 365, 21);
		panel_DiamondHouse.add(lbl_Bed_DH);
	}
}
