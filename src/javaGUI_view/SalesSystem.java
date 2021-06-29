package javaGUI_view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SalesSystem extends JFrame {

	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JTextField txt_CardNumber;
	private JTextField txt_CardholderName;
	private JTextField txt_CVV;
	private JTextField txt_EXP_YY;
	private JTextField txt_EXP_MM;
	private JPanel customerRegistration;
	private JPanel panel_PaymentInfo;
	private JPanel panel_BookingDetails;
	private JTextField txt_Contact;
	private JTextField txt_Email;
	private JTextField txt_Name;
	private double ppn, originalPrice, totalPrice, discountPrice, totalRevenue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesSystem frame = new SalesSystem();
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
	
	public double calculateOriginalPrice(double p, int n) {
		originalPrice = p * n;
		return originalPrice;
	}
	
	public double calculateTotalPriceAfterDiscount() {
		discountPrice = originalPrice * 0.90;
		return discountPrice;
	}
	
	public double getTotalRevenue() {
		return this.totalRevenue;
	}
	
	public void setTotalRevenue(double a) {
		this.totalRevenue = a;
	}
	
	/**
	 * Create the frame.
	 */
	
	public SalesSystem() {
		InventoryManagement invt = new InventoryManagement();
		setTitle("Registration & Booking");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SalesSystem.class.getResource("/bg_Resource/hotel_icon-removebg-preview.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 576);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(0, 0, 1264, 681);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		customerRegistration = new JPanel();
		layeredPane.add(customerRegistration, "name_119678796029700");
		customerRegistration.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Customer Information");
		lblNewLabel.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(373, 45, 266, 38);
		customerRegistration.add(lblNewLabel);
		
		JLabel lbl_Name = new JLabel("Name");
		lbl_Name.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Name.setBounds(345, 145, 97, 25);
		customerRegistration.add(lbl_Name);
		
		JLabel lbl_Email = new JLabel("Email");
		lbl_Email.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Email.setBounds(345, 245, 163, 25);
		customerRegistration.add(lbl_Email);
		
		JLabel lbl_ContactNumber = new JLabel("Contact Number");
		lbl_ContactNumber.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_ContactNumber.setBounds(345, 345, 163, 25);
		customerRegistration.add(lbl_ContactNumber);
		
		txt_Contact = new JTextField();
		txt_Contact.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Contact.setColumns(10);
		txt_Contact.setBounds(513, 342, 200, 30);
		customerRegistration.add(txt_Contact);
		
		txt_Email = new JTextField();
		txt_Email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Email.setColumns(10);
		txt_Email.setBounds(513, 242, 200, 30);
		customerRegistration.add(txt_Email);
		
		txt_Name = new JTextField();
		txt_Name.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txt_Name.setColumns(10);
		txt_Name.setBounds(513, 142, 200, 30);
		customerRegistration.add(txt_Name);
		
		JButton btn_Proceed_01 = new JButton("Proceed");
		btn_Proceed_01.setBackground(new Color(245, 245, 245));
		btn_Proceed_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt_Name.getText();
				String email = txt_Email.getText();
				String contact = txt_Contact.getText();
				
				if((name.equals(""))||(email.equals("")||(contact.equals("")))) {
					JOptionPane.showMessageDialog(btn_Proceed_01, ("Oops... Seems like you forgot to fill in all the information."));
				}else
					switchPanelTo(panel_BookingDetails);
			}
		});
		
		btn_Proceed_01.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btn_Proceed_01.setBounds(849, 476, 150, 50);
		customerRegistration.add(btn_Proceed_01);
		
		JButton btn_Inquiries = new JButton("Any Inquiries?");
		btn_Inquiries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyBg aboutUs1 = new CompanyBg();
				aboutUs1.setVisible(true);
			}
		});
		btn_Inquiries.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 25));
		btn_Inquiries.setBackground(new Color(245, 245, 245));
		btn_Inquiries.setBounds(10, 476, 200, 50);
		customerRegistration.add(btn_Inquiries);
		
		JLabel bg_CustomerRegistration = new JLabel("");
		bg_CustomerRegistration.setIcon(new ImageIcon(SalesSystem.class.getResource("/bg_Resource/marble bg.png")));
		bg_CustomerRegistration.setBounds(0, 0, 1012, 537);
		customerRegistration.add(bg_CustomerRegistration);
		
		panel_BookingDetails = new JPanel();
		layeredPane.add(panel_BookingDetails, "name_100976821642300");
		panel_BookingDetails.setLayout(null);
		
		JLabel lbl_OriginalPrice1 = new JLabel("0.00");
		lbl_OriginalPrice1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_OriginalPrice1.setBounds(487, 351, 155, 25);
		panel_BookingDetails.add(lbl_OriginalPrice1);
		
		JLabel lbl_TotalPrice = new JLabel("0.00");
		lbl_TotalPrice.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_TotalPrice.setBounds(487, 401, 155, 25);
		panel_BookingDetails.add(lbl_TotalPrice);
		
		JLabel lbl_homestayPPN = new JLabel("0.00");
		lbl_homestayPPN.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_homestayPPN.setBounds(487, 301, 155, 25);
		panel_BookingDetails.add(lbl_homestayPPN);
		
		JLabel lbl_GuestNumber = new JLabel("Number of Guest");
		lbl_GuestNumber.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_GuestNumber.setBounds(287, 251, 186, 25);
		panel_BookingDetails.add(lbl_GuestNumber);
		
		JLabel lbl_NightsToStay = new JLabel("Night(s) to Stay");
		lbl_NightsToStay.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_NightsToStay.setBounds(287, 201, 186, 25);
		panel_BookingDetails.add(lbl_NightsToStay);
		
		JLabel lbl_Date = new JLabel("Date to Stay In");
		lbl_Date.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_Date.setBounds(287, 151, 186, 25);
		panel_BookingDetails.add(lbl_Date);
		
		JLabel lbl_HomestayName = new JLabel("Homestay Name");
		lbl_HomestayName.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_HomestayName.setBounds(288, 101, 186, 25);
		panel_BookingDetails.add(lbl_HomestayName);
		
		JLabel lbl_BookingDetail = new JLabel("Booking Details");
		lbl_BookingDetail.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lbl_BookingDetail.setBounds(410, 16, 188, 30);
		panel_BookingDetails.add(lbl_BookingDetail);
		
		JComboBox comboBox_HomestayName = new JComboBox();
		comboBox_HomestayName.setBackground(new Color(245, 245, 245));
		comboBox_HomestayName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(String.valueOf(comboBox_HomestayName.getSelectedItem()).equals(invt.getCellValue(0, 0))) {
						ppn = Double.parseDouble(invt.getCellValue(0, 1));
					}else if(String.valueOf(comboBox_HomestayName.getSelectedItem()).equals(invt.getCellValue(1, 0))) {
						ppn = Double.parseDouble(invt.getCellValue(1, 1));
					}else if(String.valueOf(comboBox_HomestayName.getSelectedItem()).equals(invt.getCellValue(2, 0))) {
						ppn = Double.parseDouble(invt.getCellValue(2, 1));
					}
					
					lbl_homestayPPN.setText(Double.toString(ppn));
			}
		});
		comboBox_HomestayName.setModel(new DefaultComboBoxModel(new String[] {"Select Homestay", invt.getCellValue(0, 0) , invt.getCellValue(1, 0), invt.getCellValue(2, 0)}));
		comboBox_HomestayName.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboBox_HomestayName.setBounds(485, 98, 219, 30);
		panel_BookingDetails.add(comboBox_HomestayName);
		
		JComboBox comboBox_DD = new JComboBox();
		comboBox_DD.setBackground(new Color(245, 245, 245));
		comboBox_DD.setModel(new DefaultComboBoxModel(new String[] {"DD", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_DD.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboBox_DD.setBounds(485, 148, 55, 30);
		panel_BookingDetails.add(comboBox_DD);
		
		JComboBox comboBox_MM = new JComboBox();
		comboBox_MM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboBox_MM.setBackground(new Color(245, 245, 245));
		comboBox_MM.setModel(new DefaultComboBoxModel(new String[] {"MM", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}));
		comboBox_MM.setBounds(550, 148, 70, 30);
		panel_BookingDetails.add(comboBox_MM);
		
		JComboBox comboBox_YY = new JComboBox();
		comboBox_YY.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboBox_YY.setBackground(new Color(245, 245, 245));
		comboBox_YY.setModel(new DefaultComboBoxModel(new String[] {"YY", "2021", "2022", "2023"}));
		comboBox_YY.setBounds(629, 148, 75, 30);
		panel_BookingDetails.add(comboBox_YY);
		
		JComboBox comboBox_NightToStayIn = new JComboBox();
		comboBox_NightToStayIn.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboBox_NightToStayIn.setBackground(new Color(245, 245, 245));
		comboBox_NightToStayIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int night = Integer.parseInt(String.valueOf(comboBox_NightToStayIn.getSelectedItem()));
				originalPrice = calculateOriginalPrice(ppn, night);
				lbl_OriginalPrice1.setText(Double.toString(originalPrice));
				
				if(night>=3) {
					totalPrice = calculateTotalPriceAfterDiscount();
				}else
					totalPrice = originalPrice;
				
				lbl_TotalPrice.setText(String.format("%.2f", totalPrice));
			}
		});
		comboBox_NightToStayIn.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14"}));
		comboBox_NightToStayIn.setBounds(485, 198, 40, 30);
		panel_BookingDetails.add(comboBox_NightToStayIn);
		
		JComboBox comboBox_Guest = new JComboBox();
		comboBox_Guest.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		comboBox_Guest.setBackground(new Color(245, 245, 245));
		comboBox_Guest.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_Guest.setBounds(485, 248, 40, 30);
		panel_BookingDetails.add(comboBox_Guest);
		
		String homestay = String.valueOf(comboBox_HomestayName.getSelectedItem());
		String day = String.valueOf(comboBox_DD.getSelectedItem());
		String month = String.valueOf(comboBox_MM.getSelectedItem());
		String year = String.valueOf(comboBox_YY.getSelectedItem());
		String date = day + "/" + month + "/" + year;
		
		JButton btn_Proceed_02 = new JButton("Proceed");
		btn_Proceed_02.setBackground(new Color(245, 245, 245));
		btn_Proceed_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((comboBox_HomestayName.getSelectedItem().equals("Select Homestay"))||(comboBox_NightToStayIn.getSelectedItem().equals("0"))||(comboBox_DD.getSelectedItem().equals("DD"))||(comboBox_MM.getSelectedItem().equals("MM"))||(comboBox_YY.getSelectedItem().equals("YY")))
					JOptionPane.showMessageDialog(btn_Proceed_02, ("Oops... Seems like you forgot to fill in all the information."));
				else
					switchPanelTo(panel_PaymentInfo);
			}
		});
		btn_Proceed_02.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btn_Proceed_02.setBounds(847, 471, 150, 50);
		panel_BookingDetails.add(btn_Proceed_02);
		
		JLabel lbl_PPN = new JLabel("Price Per Night");
		lbl_PPN.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN.setBounds(287, 301, 186, 25);
		panel_BookingDetails.add(lbl_PPN);
		
		JLabel lbl_OriginalPrice = new JLabel("Original Price");
		lbl_OriginalPrice.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_OriginalPrice.setBounds(287, 351, 186, 25);
		panel_BookingDetails.add(lbl_OriginalPrice);
		
		JButton btn_Previous_01 = new JButton("Previous");
		btn_Previous_01.setBackground(new Color(245, 245, 245));
		btn_Previous_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(customerRegistration);
			}
		});
		btn_Previous_01.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btn_Previous_01.setBounds(687, 471, 150, 50);
		panel_BookingDetails.add(btn_Previous_01);
		
		JLabel lbl_totalPrice = new JLabel("Total Price");
		lbl_totalPrice.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_totalPrice.setBounds(287, 401, 186, 25);
		panel_BookingDetails.add(lbl_totalPrice);
		
		JButton btn_Inquiries_1 = new JButton("Any Inquiries?");
		btn_Inquiries_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyBg aboutUs2 = new CompanyBg();
				aboutUs2.setVisible(true);
			}
		});
		btn_Inquiries_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btn_Inquiries_1.setBackground(new Color(245, 245, 245));
		btn_Inquiries_1.setBounds(10, 471, 200, 50);
		panel_BookingDetails.add(btn_Inquiries_1);
		
		JLabel lbl_PPN_1 = new JLabel("<html>*10% off for 3 nights<br/> or more</html>");
		lbl_PPN_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_PPN_1.setBounds(549, 201, 197, 50);
		panel_BookingDetails.add(lbl_PPN_1);
		
		JLabel bg_BookingDetails = new JLabel("");
		bg_BookingDetails.setIcon(new ImageIcon(SalesSystem.class.getResource("/bg_Resource/marble bg.png")));
		bg_BookingDetails.setBounds(0, 0, 1009, 536);
		panel_BookingDetails.add(bg_BookingDetails);
		
		panel_PaymentInfo = new JPanel();
		layeredPane.add(panel_PaymentInfo, "name_101197580726600");
		panel_PaymentInfo.setLayout(null);
		
		JLabel lbl_PaymentTitle = new JLabel("Credit/Debit Card Info");
		lbl_PaymentTitle.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 20));
		lbl_PaymentTitle.setBounds(380, 23, 247, 32);
		panel_PaymentInfo.add(lbl_PaymentTitle);
		
		JLabel lbl_CardNumber = new JLabel("Card Number");
		lbl_CardNumber.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_CardNumber.setBounds(303, 175, 194, 25);
		panel_PaymentInfo.add(lbl_CardNumber);
		
		JLabel lbl_EXP = new JLabel("EXP (Valid thru) ");
		lbl_EXP.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_EXP.setBounds(303, 225, 194, 25);
		panel_PaymentInfo.add(lbl_EXP);
		
		JLabel lbl_CVV = new JLabel("CVC/CVV");
		lbl_CVV.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_CVV.setBounds(303, 275, 194, 25);
		panel_PaymentInfo.add(lbl_CVV);
		
		JLabel lbl_CardholderName = new JLabel("Cardholder Name");
		lbl_CardholderName.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_CardholderName.setBounds(303, 325, 194, 25);
		panel_PaymentInfo.add(lbl_CardholderName);
		
		txt_CardNumber = new JTextField();
		txt_CardNumber.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txt_CardNumber.setColumns(10);
		txt_CardNumber.setBounds(507, 172, 200, 30);
		panel_PaymentInfo.add(txt_CardNumber);
		
		txt_CardholderName = new JTextField();
		txt_CardholderName.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txt_CardholderName.setColumns(10);
		txt_CardholderName.setBounds(507, 322, 200, 30);
		panel_PaymentInfo.add(txt_CardholderName);
		
		txt_CVV = new JTextField();
		txt_CVV.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txt_CVV.setColumns(10);
		txt_CVV.setBounds(507, 272, 50, 30);
		panel_PaymentInfo.add(txt_CVV);
		
		txt_EXP_YY = new JTextField();
		txt_EXP_YY.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txt_EXP_YY.setText("YY");
		txt_EXP_YY.setColumns(10);
		txt_EXP_YY.setBounds(576, 222, 50, 30);
		panel_PaymentInfo.add(txt_EXP_YY);
		
		txt_EXP_MM = new JTextField();
		txt_EXP_MM.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		txt_EXP_MM.setText("MM");
		txt_EXP_MM.setColumns(10);
		txt_EXP_MM.setBounds(507, 222, 50, 30);
		panel_PaymentInfo.add(txt_EXP_MM);
		
		JLabel lbl_Symbol = new JLabel("/");
		lbl_Symbol.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 15));
		lbl_Symbol.setBounds(561, 225, 17, 25);
		panel_PaymentInfo.add(lbl_Symbol);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBackground(new Color(245, 245, 245));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cardNumber = txt_CardNumber.getText();
				String exp_mm = txt_EXP_MM.getText();
				String exp_yy = txt_EXP_YY.getText();
				String cvv = txt_CVV.getText();
				String cardholderName = txt_CardholderName.getText();
				
				if((cardNumber.equals(""))||(exp_mm.equals("")||(exp_yy.equals("")||(cvv.equals(""))||(cardholderName.equals(""))))) {
					JOptionPane.showMessageDialog(btnBook, ("Oops... Seems like you forgot to fill in all the information."));
				}else {
					if(cardNumber.length()!=16)
						JOptionPane.showMessageDialog(btnBook, ("Card number must be 16 digits."));
					else {
						setTotalRevenue(totalPrice);
						JOptionPane.showMessageDialog(btnBook,
								("ALL DONE!!!\nThe Booking will be processsed.\nTransaction will be done within 3 days\nWe will update your booking status via email"));
						dispose();
						AdsAndMarketing ads = new AdsAndMarketing();
						Login log = new Login(ads.getFlyerNumber(), totalRevenue);
						log.setVisible(true);
					}
				}
				
				try {																//2.2 Exception Handling
				File file = new File("C:\\Users\\ncs00\\eclipse-workspace\\Programming2_Assignment3_GUI\\src\\textFile\\Sales.txt");
				if(!file.exists()) {
					file.createNewFile();											//2.3 File IO
					}
				FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("Name\t\t:" + txt_Name.getText());
				bw.write("\nEmail\t\t:" + txt_Email.getText());
				bw.write("\nContact Num\t:" + txt_Contact.getText());
				bw.write("\n---------------\nHomestay Name\t:" + comboBox_HomestayName.getSelectedItem());
				bw.write("\nDate to Stay In\t:" + comboBox_DD.getSelectedItem() + "/"  + comboBox_MM.getSelectedItem() + "/" + comboBox_YY.getSelectedItem() );
				bw.write("\nNights to Stay\t:" + comboBox_NightToStayIn.getSelectedItem());
				bw.write("\nNumber of Guest\t:" + comboBox_Guest.getSelectedItem());
				bw.write("\nTotal price\t\t:RM" + lbl_TotalPrice.getText());
				bw.write("\nBooking Status\t: Transaction in Progress.");
				bw.write("\n");
				bw.close();
				fw.close();
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnBook.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnBook.setBounds(845, 476, 150, 50);
		panel_PaymentInfo.add(btnBook);
		
		JButton btn_Previous_02 = new JButton("Previous");
		btn_Previous_02.setBackground(new Color(245, 245, 245));
		btn_Previous_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanelTo(panel_BookingDetails);
			}
		});
		btn_Previous_02.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btn_Previous_02.setBounds(525, 476, 150, 50);
		panel_PaymentInfo.add(btn_Previous_02);
		
		JButton btn_Cancel_1 = new JButton("Cancel");
		btn_Cancel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				if (JOptionPane.showConfirmDialog(frame, "All your data will not be saved.", "Cancel booking?", 
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					dispose();
			}
			}
		});
		btn_Cancel_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btn_Cancel_1.setBackground(new Color(245, 245, 245));
		btn_Cancel_1.setBounds(685, 476, 150, 50);
		panel_PaymentInfo.add(btn_Cancel_1);
		
		JButton btn_Inquiries_2 = new JButton("Any Inquiries?");
		btn_Inquiries_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CompanyBg aboutUs3 = new CompanyBg();
				aboutUs3.setVisible(true);
			}
		});
		btn_Inquiries_2.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btn_Inquiries_2.setBackground(new Color(245, 245, 245));
		btn_Inquiries_2.setBounds(10, 476, 200, 50);
		panel_PaymentInfo.add(btn_Inquiries_2);
		
		JLabel bg_CreditDebitMarble = new JLabel("");
		bg_CreditDebitMarble.setIcon(new ImageIcon(SalesSystem.class.getResource("/bg_Resource/marble bg.png")));
		bg_CreditDebitMarble.setBounds(0, 0, 1007, 537);
		panel_PaymentInfo.add(bg_CreditDebitMarble);
	}
}
