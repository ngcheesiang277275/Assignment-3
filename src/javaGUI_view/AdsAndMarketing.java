package javaGUI_view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;

public class AdsAndMarketing extends JPanel {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int flyerNumber;

	/**
	 * Create the panel.
	 */
	public AdsAndMarketing() {
		setLayout(null);
		
		JLabel lbl_AdvertisementAndMarketing = new JLabel("ADVERTISEMENT & MARKETING");
		lbl_AdvertisementAndMarketing.setFont(new Font("Malgun Gothic Semilight", Font.BOLD | Font.ITALIC, 25));
		lbl_AdvertisementAndMarketing.setBounds(306, 15, 392, 25);
		add(lbl_AdvertisementAndMarketing);
		
		JLabel lbl_SelectMethod = new JLabel("Select one of the following promoting method to promote your homestay");
		lbl_SelectMethod.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_SelectMethod.setBounds(174, 510, 650, 27);
		add(lbl_SelectMethod);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(SystemColor.textHighlightText);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Promoting Method.", "Free gift for 3 or more nights booking.", "RM5 KFC voucher for 4 or more nights booking", "Free breakfast for any booking."}));
		comboBox.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		comboBox.setBounds(174, 556, 650, 33);
		add(comboBox);
		
		JButton btnSelectMethod = new JButton("Select Method");
		btnSelectMethod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Select Advertising Method."))
					JOptionPane.showMessageDialog(btnSelectMethod, "Please select a marketing method.");
				else
					JOptionPane.showMessageDialog(btnSelectMethod, comboBox.getSelectedItem() + "\nwill be used to promote your homestay.");
			}
		});
		btnSelectMethod.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnSelectMethod.setBackground(SystemColor.controlHighlight);
		btnSelectMethod.setBounds(644, 604, 180, 45);
		add(btnSelectMethod);
		
		JLabel lbl_SelectMethod_1 = new JLabel("Select one advertisement flyer to display on LOGIN interface");
		lbl_SelectMethod_1.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		lbl_SelectMethod_1.setBounds(174, 75, 650, 27);
		add(lbl_SelectMethod_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(494, 113, 392, 398);
		add(tabbedPane);
		
		JPanel flyer_Normal = new JPanel();
		tabbedPane.addTab("Normal", null, flyer_Normal, null);
		flyer_Normal.setLayout(null);
		
		JLabel pic_flyerNormal = new JLabel("");
		pic_flyerNormal.setIcon(new ImageIcon(AdsAndMarketing.class.getResource("/bg_Resource/flyer/small_No_Flyer.png")));
		pic_flyerNormal.setBounds(0, 0, 387, 370);
		flyer_Normal.add(pic_flyerNormal);
		
		JPanel flyer_20Discount = new JPanel();
		tabbedPane.addTab("Facilities Boost Poster", null, flyer_20Discount, null);
		flyer_20Discount.setLayout(null);
		
		JLabel pic_flyer20Discount = new JLabel("");
		pic_flyer20Discount.setIcon(new ImageIcon(AdsAndMarketing.class.getResource("/bg_Resource/flyer/small_NO_DEPOSIT.png")));
		pic_flyer20Discount.setBounds(0, 0, 387, 370);
		flyer_20Discount.add(pic_flyer20Discount);
		
		JPanel flyer_HomestayPreview = new JPanel();
		tabbedPane.addTab("Homestay Preview", null, flyer_HomestayPreview, null);
		flyer_HomestayPreview.setLayout(null);
		
		JLabel pic_flyerPreview = new JLabel("");
		pic_flyerPreview.setIcon(new ImageIcon(AdsAndMarketing.class.getResource("/bg_Resource/flyer/small_Preview.png")));
		pic_flyerPreview.setBounds(0, 0, 387, 370);
		flyer_HomestayPreview.add(pic_flyerPreview);
		
		JComboBox comboBox_Flyer = new JComboBox();
		comboBox_Flyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!comboBox_Flyer.getSelectedItem().equals("Select Flyer")) 
					tabbedPane.setSelectedIndex(comboBox_Flyer.getSelectedIndex()-1);
			}
		});
		comboBox_Flyer.setModel(new DefaultComboBoxModel(new String[] {"Select Flyer", "No Flyer (Normal Cover)", "Facilities Boost Poster", "Homestay Preview"}));
		comboBox_Flyer.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		comboBox_Flyer.setBackground(Color.WHITE);
		comboBox_Flyer.setBounds(174, 142, 310, 33);
		add(comboBox_Flyer);
		
		JButton btnSelectFlyer = new JButton("Select Flyer");
		btnSelectFlyer.addActionListener(new ActionListener() {

			int flyerNumber;
			public void actionPerformed(ActionEvent e) {
				if(comboBox_Flyer.getSelectedItem().equals("Select Advertising Method."))
					JOptionPane.showMessageDialog(btnSelectFlyer, "Please select a marketing method.");
				else {
					if(comboBox_Flyer.getSelectedItem().equals("No Flyer (Normal Cover)"))
						this.flyerNumber = 0;
					else if(comboBox_Flyer.getSelectedItem().equals("Facilities Boost Poster"))
						this.flyerNumber = 1;
					else if(comboBox_Flyer.getSelectedItem().equals("Homestay Preview"))
						this.flyerNumber = 2;
					else
						JOptionPane.showMessageDialog(btnSelectFlyer,
								comboBox_Flyer.getSelectedItem() + "Please select a flyer first.");
					setFlyerNumber(this.flyerNumber);
					if(!comboBox_Flyer.getSelectedItem().equals("Select Flyer")) 
					JOptionPane.showMessageDialog(btnSelectFlyer,
							comboBox_Flyer.getSelectedItem() + "\nwill be used to promote your homestay.");
				}
			}
		});
		btnSelectFlyer.setFont(new Font("Malgun Gothic Semilight", Font.PLAIN, 20));
		btnSelectFlyer.setBackground(SystemColor.controlHighlight);
		btnSelectFlyer.setBounds(304, 223, 180, 45);
		add(btnSelectFlyer);

	}

	public void setFlyerNumber(int a) {
		this.flyerNumber = a;
	}

	public int getFlyerNumber() {
		return this.flyerNumber;
	}
}
