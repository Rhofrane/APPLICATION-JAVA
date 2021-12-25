package Travelling_Ticket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.print.attribute.DateTimeSyntax;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Travelling {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Travelling window = new Travelling();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Travelling() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(173, 216, 230));
		frame.setBounds(0, 0, 1370, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(59, 42, 617, 52);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Systeme de ticket de vol");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Classe");
		lblNewLabel_1.setBounds(20, 157, 61, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JRadioButton rdbtnStandard = new JRadioButton("Standard");
		rdbtnStandard.setBounds(34, 188, 109, 23);
		frame.getContentPane().add(rdbtnStandard);
		
		JRadioButton rdbtnEconomique = new JRadioButton("Economique");
		rdbtnEconomique.setBounds(34, 224, 109, 23);
		frame.getContentPane().add(rdbtnEconomique);
		
		JRadioButton rdbtnPremièreClasse = new JRadioButton("Premi\u00E8reClasse");
		rdbtnPremièreClasse.setBounds(34, 266, 109, 23);
		frame.getContentPane().add(rdbtnPremièreClasse);
		
		JLabel lblNewLabel_2 = new JLabel("Age");
		lblNewLabel_2.setBounds(209, 157, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JRadioButton rdbtnAdulte = new JRadioButton("Adulte");
		rdbtnAdulte.setBounds(209, 188, 109, 23);
		frame.getContentPane().add(rdbtnAdulte);
		
		JRadioButton rdbtnmoinsde5ans = new JRadioButton("moinsde5ans");
		rdbtnmoinsde5ans.setBounds(209, 224, 109, 23);
		frame.getContentPane().add(rdbtnmoinsde5ans);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 182, 275, 2);
		frame.getContentPane().add(separator);
		
		JComboBox cmbDestination = new JComboBox();
		cmbDestination.setModel(new DefaultComboBoxModel(new String[] {"Destination", "Paris", "Londre", "Alg\u00E9rie", "Tahrane", "Berlin", "Istanbul"}));
		cmbDestination.setFont(new Font("Tahoma", Font.BOLD, 24));
		cmbDestination.setBounds(89, 311, 193, 29);
		frame.getContentPane().add(cmbDestination);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 296, 275, 2);
		frame.getContentPane().add(separator_1);
		
		JLabel txtTax = new JLabel("Taxe");
		txtTax.setBounds(20, 371, 46, 14);
		frame.getContentPane().add(txtTax);
		
		JLabel txtSubTotal = new JLabel("SubTotal");
		txtSubTotal.setBounds(20, 398, 56, 14);
		frame.getContentPane().add(txtSubTotal);
		
		JLabel txtTotal = new JLabel("Total");
		txtTotal.setBounds(20, 425, 88, 14);
		frame.getContentPane().add(txtTotal);
		
		textField = new JTextField();
		textField.setBounds(112, 368, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 395, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(112, 422, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 476, 275, 14);
		frame.getContentPane().add(separator_2);
		
		JButton btnNewButton = new JButton("Total");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double tax=19.50;
				double MilesK8=25.78;
				double MilesK20=45.23;
				double MilesK30=55.98;
				double totalCost,eco=3.8,fclass=3.2;
				if ((rdbtnStandard.isSelected())&&(rdbtnAdulte.isSelected()))
				{
					totalCost=(tax*MilesK8)/100;
					String sTax= String.format("£%,2f",totalCost);
					textField.setText(sTax);
					String subTotal= String.format("£%,2f",MilesK8);
					textField_1.setText(subTotal);
					String Total= String.format("£%,2f",MilesK8+totalCost);
					textField_2.setText(Total);
					textField_11.setText(Total);
					textField_3.setText("STD");
					textField_5.setText("1");
					textField_6.setText("0");
					
					
				}
				else if ((rdbtnEconomique.isSelected())&&(rdbtnAdulte.isSelected()))
				{
					totalCost=(tax*MilesK8)/100;
					String sTax= String.format("£%,2f",totalCost);
					textField.setText(sTax);
					String subTotal= String.format("£%,2f",MilesK20);
					textField_1.setText(subTotal);
					String Total= String.format("£%,2f",MilesK20+totalCost);
					textField_2.setText(Total);
					textField_11.setText(Total);
					textField_3.setText("ECO");
					textField_5.setText("1");
					textField_6.setText("0");
					
					
				}
				else if ((rdbtnPremièreClasse.isSelected())&&(rdbtnAdulte.isSelected()))
				{
					totalCost=(tax*MilesK8)/100;
					String sTax= String.format("£%,2f",totalCost);
					textField.setText(sTax);
					String subTotal= String.format("£%,2f",MilesK30);
					textField_1.setText(subTotal);
					String Total= String.format("£%,2f",MilesK30+totalCost);
					textField_2.setText(Total);
					textField_11.setText(Total);
					textField_3.setText("FIRST");
					textField_5.setText("1");
					textField_6.setText("0");
					
					
				}
				else if ((rdbtnStandard.isSelected())&&(rdbtnmoinsde5ans.isSelected()))
				{
					totalCost=(tax*MilesK8)/100;
					String sTax= String.format("£%,2f",totalCost-10);
					textField.setText(sTax);
					String subTotal= String.format("£%,2f",MilesK8);
					textField_1.setText(subTotal);
					String Total= String.format("£%,2f",MilesK8+totalCost-10);
					textField_2.setText(Total);
					textField_11.setText(Total);
					textField_3.setText("STD");
					textField_5.setText("0");
					textField_6.setText("1");
					
					
				}
				else if ((rdbtnEconomique.isSelected())&&(rdbtnmoinsde5ans.isSelected()))
				{
					totalCost=(tax*MilesK8)/100;
					String sTax= String.format("£%,2f",totalCost-10);
					textField.setText(sTax);
					String subTotal= String.format("£%,2f",MilesK8);
					textField_1.setText(subTotal);
					String Total= String.format("£%,2f",MilesK8+totalCost-10);
					textField_2.setText(Total);
					textField_11.setText(Total);
					textField_3.setText("ECO");
					textField_5.setText("0");
					textField_6.setText("1");
					
					
				}
				else if ((rdbtnPremièreClasse.isSelected())&&(rdbtnmoinsde5ans.isSelected()))
				{
					totalCost=(tax*MilesK8)/100;
					String sTax= String.format("£%,2f",totalCost-10);
					textField.setText(sTax);
					String subTotal= String.format("£%,2f",MilesK8);
					textField_1.setText(subTotal);
					String Total= String.format("£%,2f",MilesK8+totalCost-10);
					textField_2.setText(Total);
					textField_11.setText(Total);
					textField_3.setText("FIRST");
					textField_5.setText("0");
					textField_6.setText("1");
					
					
				}
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("null")
			public void actionPerformed(ActionEvent e) {
				Calendar timer=Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime= new SimpleDateFormat("HH:mm:ss");
				textField_12.setText(tTime.format(timer.getTime()));
				
				LocalTime now = LocalTime.now();
				LocalTime oldDate = now.plusHours(1).plusMinutes(10);
				 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern(" HH:mm:ss");

				    String formattedDate = oldDate.format(myFormatObj);
				    
				textField_13.setText(""+formattedDate);
				Duration duration = Duration.between(oldDate, now);
				textField_14.setText(""+ duration);
				
				SimpleDateFormat tdate= new SimpleDateFormat("dd/MMM/yyyy");
				textField_9.setText(tdate.format(timer.getTime()));
				textField_7.setText("Paris *");
				textField_8.setText((String) cmbDestination.getSelectedItem()+ " *");
				
				/*generation d un id en utilisant random*/
				int n;
				String a="";
				n=100+(int)(Math.random()*4521);
				a+=100+n;
				textField_10.setText(a);
				
				
				
				
				
				
				
			}
		});
		btnNewButton.setToolTipText("cout total du ticket");
		btnNewButton.setBounds(19, 490, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("r\u00E9inisialiser");
		btnNewButton_1.setToolTipText("r\u00E9inisialiser le systeme");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				textField_1 .setText(null);
				textField_2.setText(null);
				rdbtnAdulte.setSelected(false);
				rdbtnmoinsde5ans.setSelected(false);
				rdbtnPremièreClasse.setSelected(false);
				rdbtnEconomique.setSelected(false);
				rdbtnStandard.setSelected(false);
				cmbDestination.setSelectedItem("Destination");
				textField_3.setText(null);
				
				textField_5.setText(null);
				textField_6.setText(null);
				textField_7.setText(null);
				textField_8.setText(null);
				textField_9.setText(null);
				textField_10.setText(null);
				textField_11.setText(null);
				textField_12.setText(null);
				textField_13.setText(null);
				textField_14.setText(null);
			}	
		});
		btnNewButton_1.setBounds(151, 490, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exist");
		btnNewButton_2.setToolTipText("sortir du systeme");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame=new JFrame("Exist");
				if(JOptionPane.showConfirmDialog(frame,"confirmez si vous voulez exiter","Tecketing systeme",
				JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION		) {
				System.exit(0);	
				}
					
				
			}
		});
		btnNewButton_2.setBounds(266, 490, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(462, 432, 12, -242);
		frame.getContentPane().add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(451, 188, -26, 197);
		frame.getContentPane().add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(377, 171, 34, 342);
		frame.getContentPane().add(separator_5);
		
		JLabel lblClasse = new JLabel("Classe");
		lblClasse.setBounds(462, 157, 56, 14);
		frame.getContentPane().add(lblClasse);
		
		JLabel lblAdulte = new JLabel("Adulte");
		lblAdulte.setBounds(614, 157, 56, 14);
		frame.getContentPane().add(lblAdulte);
		
		JLabel lblMoinsdeans = new JLabel("moinsde5ans");
		lblMoinsdeans.setBounds(761, 157, 86, 14);
		frame.getContentPane().add(lblMoinsdeans);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(502, 201, 500, -17);
		frame.getContentPane().add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(451, 188, 488, -4);
		frame.getContentPane().add(separator_7);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(462, 206, 86, 20);
		frame.getContentPane().add(textField_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(614, 206, 86, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(761, 206, 86, 20);
		frame.getContentPane().add(textField_6);
		
		JSeparator separator_7_1 = new JSeparator();
		separator_7_1.setBounds(462, 237, 474, 10);
		frame.getContentPane().add(separator_7_1);
		
		JLabel lblNewLabel_3 = new JLabel("Villedepard\r\n");
		lblNewLabel_3.setBounds(435, 296, 76, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Villearrive");
		lblNewLabel_4.setBounds(435, 371, 76, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel txtdate = new JLabel("date");
		txtdate.setBounds(435, 422, 61, 14);
		frame.getContentPane().add(txtdate);
		
		JLabel txtID = new JLabel("ID_ticket");
		txtID.setBounds(421, 476, 61, 14);
		frame.getContentPane().add(txtID);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(502, 296, 86, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(502, 368, 86, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(502, 422, 86, 20);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(492, 476, 86, 20);
		frame.getContentPane().add(textField_10);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(831, 488, -20, -190);
		frame.getContentPane().add(separator_8);
		
		JSeparator separator_7_1_1 = new JSeparator();
		separator_7_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_7_1_1.setBounds(643, 285, 23, 228);
		frame.getContentPane().add(separator_7_1_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("prix");
		lblNewLabel_6_1.setBounds(676, 296, 61, 14);
		frame.getContentPane().add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("duree_depart");
		lblNewLabel_6_2.setBounds(676, 371, 76, 14);
		frame.getContentPane().add(lblNewLabel_6_2);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(761, 296, 86, 20);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(761, 368, 86, 20);
		frame.getContentPane().add(textField_12);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("duree_arriv\u00E9e");
		lblNewLabel_6_2_1.setBounds(676, 432, 76, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(761, 432, 140, 20);
		frame.getContentPane().add(textField_13);
		
		JLabel lblNewLabel_6_2_1_1 = new JLabel("calcul_duree");
		lblNewLabel_6_2_1_1.setBounds(676, 476, 105, 14);
		frame.getContentPane().add(lblNewLabel_6_2_1_1);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(761, 476, 109, 20);
		frame.getContentPane().add(textField_14);
		
		JLabel lblNewLabel_5 = new JLabel("BENABDELLAH RHOFRANE");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.ITALIC, 12));
		lblNewLabel_5.setBounds(20, 11, 158, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton_3 = new JButton("rengistrer");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/reservation","root","");
					PreparedStatement ps =conn.prepareStatement("INSERT INTO `user`(`Classe`, `Adulte`, `moinsde5ans`, `Villedepard`, `Villearrive`, `date`, `id_ticket`, `prix`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
					ps.setString(1, textField_3.getText());
		            ps.setString(2,textField_5.getText());
		            
		            ps.setString(3,textField_6.getText());
		            ps.setString(4,textField_7.getText());
		            ps.setString(5,textField_8.getText());
		            ps.setString(6,textField_9.getText());
		            ps.setString(7,textField_10.getText());
		            ps.setString(8,textField_11.getText());
		            int x= ps.executeUpdate();
		            if(x>0) {
		            	System.out.println("votre regstration est faite avec succes..");
		            }else {
		            	System.out.println("Registration Failed");
		            }
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_3.setBounds(151, 556, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(946, 188, 398, 302);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
			table.addMouseListener(new MouseAdapter() {
			@Override
				public void mouseClicked(MouseEvent e) {
					int i=table.getSelectedRow();
					textField_3.setText(model.getValueAt(i,0).toString());
					textField_5.setText(model.getValueAt(i,1).toString());
					textField_6.setText(model.getValueAt(i,2).toString());
					textField_7.setText(model.getValueAt(i,3).toString());
					textField_8.setText(model.getValueAt(i,4).toString());
					textField_9.setText(model.getValueAt(i,5).toString());
					textField_10.setText(model.getValueAt(i,6).toString());
					textField_11.setText(model.getValueAt(i,7).toString());
			}
});
		
		table.setBackground(new Color(176, 224, 230));
		model=new DefaultTableModel();
		Object[] column= {"Classe", "Adulte", "moinsde5ans", "Villedepard", "Villearrive", "date", "id_ticket", "prix"};
		final Object[] row=new Object[8];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_4 = new JButton("ADD");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().equals("") && textField_5.getText().equals("") && textField_6.getText().equals("") && textField_7.getText().equals("")&& textField_8.getText().equals("")&& textField_9.getText().equals("")&&textField_10.getText().equals("")&&textField_11.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Fill Complete Information");
				}
				else {
					row[0] =textField_3.getText();
		            row[1]=textField_5.getText();
		            
		            row[2]=textField_6.getText();
		            row[3]=textField_7.getText();
		            row[4]=textField_8.getText();
		            row[5]=textField_9.getText();
		            row[6]=textField_10.getText();
		            row[7]=textField_11.getText();
					model.addRow(row);
					JOptionPane.showMessageDialog(null,"Ticket Saved Successfully");
				}
				
			}
		});
		btnNewButton_4.setBounds(913, 528, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Update");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				model.setValueAt(textField_3.getText(),i,0);
				model.setValueAt(textField_5.getText(),i,1);
				model.setValueAt(textField_6.getText(),i,2);
				model.setValueAt(textField_7.getText(),i,3);
				model.setValueAt(textField_8.getText(),i,4);
				model.setValueAt(textField_9.getText(),i,5);
				model.setValueAt(textField_10.getText(),i,6);
				model.setValueAt(textField_11.getText(),i,7);
				
				 
			}
				 
		  
		});
		btnNewButton_5.setBounds(1094, 528, 89, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete Data");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/reservation","root","");
					PreparedStatement ps =conn.prepareStatement("DELETE FROM `user` WHERE id_ticket=?");
					
		            ps.setString(1,textField_10.getText());
		            
		            int x= ps.executeUpdate();
		            if(x>0) {
		            	System.out.println("votre su est faite avec succes..");
		            }else {
		            	System.out.println("su Failed");
		            }
					
				}catch(Exception e2) {
					System.out.println(e2);
				}
				
			}
		});
		btnNewButton_6.setBounds(913, 584, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
					model.removeRow(i);
					JOptionPane.showMessageDialog(null,"Ticket Deleted Successfully");
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Please Select a Row first");
				}
			}
		});
		btnNewButton_7.setBounds(1094, 584, 89, 23);
		frame.getContentPane().add(btnNewButton_7);
	}
}
