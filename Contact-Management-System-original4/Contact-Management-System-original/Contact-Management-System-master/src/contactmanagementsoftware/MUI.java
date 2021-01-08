/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import org.jdesktop.swingx.JXTable;

import java.awt.Component;

/**
 *
 * @author ritz619
 */
public class MUI extends javax.swing.JFrame {

	/**
	 * Creates new form MUI
	 */
	private MUI mg;
	private static MUI uniqueInstance = new MUI();
	private ArrayList<ArrayList<Acquaintances>> a;
	private ArrayList<ArrayList<Acquaintances>> temp;
	private int x;
	private int num;
	private boolean flag;
	private boolean dflag;
	private String op;
	private String str;

	private MUI() {
		initComponents();
		String[] columnNames = {"S.No", "Name", "Mobile"," Email"};
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		jXTable1.setModel(model);
		setUpTableData();
	}

	public static MUI getInstance() {
		return uniqueInstance;
	}

	public void setMg(MUI mg) {
		this.mg = mg;
	}

	public void setA(ArrayList<ArrayList<Acquaintances>> a) {
		this.a = a;
	}

	public void setDescription(){
		name.setText("");
		mobile.setText("");
		email.setText("");
		one.setText("");
		two.setText("");
		three.setText("");
		if(!dflag){
			name.setEditable(true);
			mobile.setEditable(true);
			email.setEditable(true);
			one.setEditable(true);
			two.setEditable(true);
			three.setEditable(true);
		}
		if(flag)
			op = "Add";
		else
			op = "Edit";
		if(!flag){
			jButton10.setText("Save");
			Acquaintances e = a.get(x).get(num);            
			name.setText(e.getName());
			mobile.setText(e.getMobileNo());
			email.setText(e.getEmail());
			switch(x){
			case 0:
				PersonalFriends perF = (PersonalFriends)e;
				one.setText(perF.getEvents());
				two.setText(perF.getAContext());
				three.setText(perF.getADate());
				break;
			case 1:
				Relatives rel = (Relatives)e;
				one.setText(rel.getBDate());
				two.setText(rel.getLDate());
				break;
			case 2:
				ProfessionalFriends proF = (ProfessionalFriends)e;
				one.setText(proF.getCommonInterests());
				break;
			case 3:
				CasualAcquaintances ca = (CasualAcquaintances)e;
				one.setText(ca.getWhenWhere());
				two.setVisible(true);
				three.setVisible(true);
				two.setText(ca.getCircumstances());
				three.setText(ca.getOtherInfo());
				break;
			default:
				break;
			}
		}
		jButton10.setVisible(true);
		jButton11.setVisible(true);
		if(flag)
			jButton10.setText("Add");
		switch(x){
		case 0:
			two.setVisible(true);
			three.setVisible(true);
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
			jLabel7.setText("Specific Events:");
			jLabel8.setText("First Acquaintance Context:");
			jLabel9.setVisible(true);
			jLabel3.setVisible(true);
			jLabel8.setVisible(true);
			jLabel7.setVisible(true);
			jScrollPane5.setVisible(true);
			jScrollPane4.setVisible(true);
			jLabel9.setText("<html>First Acquaintance Date:<br>(dd/mm/yyyy)</html>");
			break;
		case 1:
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); 
			jLabel7.setText("<html>Relatives Birthday:<br> (dd/mm/yyyy)</html>");
			jLabel8.setVisible(true);
			jLabel7.setVisible(true);
			two.setVisible(true);
			jLabel8.setText("<html>Last Date met:<br> (dd/mm/yyyy)</html>");
			jLabel9.setVisible(false);
			three.setVisible(false);
			jScrollPane4.setVisible(true);
			jScrollPane5.setVisible(false);
			break;
		case 2:
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); 
			jLabel7.setText("Common Interests: ");
			jLabel7.setVisible(true);
			jLabel8.setVisible(false);
			two.setVisible(false);
			jScrollPane4.setVisible(false);
			jLabel9.setVisible(false);
			three.setVisible(false);
			jScrollPane5.setVisible(false);
			break;
		case 3:
			jScrollPane5.setVisible(true);
			jScrollPane4.setVisible(true);
			two.setVisible(true);
			three.setVisible(true);
			jLabel7.setVisible(true);
			jLabel8.setVisible(true);
			jLabel9.setVisible(true);
			jLabel7.setText("First meeting time & location:");
			jLabel8.setText("First meeting CIrcumstances:");
			jLabel9.setText("Other useful information:");
			break;
		default:
			break;
		}
		if(dflag){
			name.setEditable(false);
			mobile.setEditable(false);
			email.setEditable(false);
			one.setEditable(false);
			two.setEditable(false);
			three.setEditable(false);
			jButton10.setText("Back to main menu");
			jButton11.setVisible(false);
			jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
		}
	}

	public final void setUpTableData() {
		DefaultTableModel tableModel = (DefaultTableModel) jXTable1.getModel();
		tableModel.setRowCount(0);
		ArrayList<Acquaintances> list;
		try{        
			list = a.get(jList1.getSelectedIndex());
		}
		catch(Exception e){
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			String[] data = new String[4];
			data[0] = Integer.toString(i+1);
			data[1] = list.get(i).getName();
			data[2] = list.get(i).getMobileNo();
			data[3] = list.get(i).getEmail();
			tableModel.addRow(data);
		}
		jXTable1.setModel(tableModel);
		tableModel.fireTableDataChanged();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		jList1 = new javax.swing.JList();
		jScrollPane2 = new javax.swing.JScrollPane();
		jXTable1 = new org.jdesktop.swingx.JXTable();
		jLabel1 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jButton5 = new javax.swing.JButton();
		jButton6 = new javax.swing.JButton();
		jButton7 = new javax.swing.JButton();
		jButton8 = new javax.swing.JButton();
		jPanel2 = new javax.swing.JPanel();
		jScrollPane3 = new javax.swing.JScrollPane();
		details = new javax.swing.JTextPane();
		jButton9 = new javax.swing.JButton();
		jPanel3 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		email = new javax.swing.JTextField();
		jScrollPane4 = new javax.swing.JScrollPane();
		two = new javax.swing.JTextArea();
		jScrollPane5 = new javax.swing.JScrollPane();
		three = new javax.swing.JTextArea();
		jButton10 = new javax.swing.JButton();
		mobile = new javax.swing.JTextField();
		jScrollPane6 = new javax.swing.JScrollPane();
		one = new javax.swing.JTextArea();
		jButton11 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.CardLayout());

		jLabel2.setFont(new java.awt.Font("Ubuntu Medium", 0, 20)); // NOI18N
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setText("<html><u>Contact Management System</u></html>");

		//Button settings
		jButton1.setText("Add");
		jButton2.setText("Delete");
		jButton3.setText("Search");
		jButton4.setText("Exit");
		jButton5.setText("Edit");
		jButton6.setText("View full detail");
		jButton7.setText("Read from file");
		jButton8.setText("Save as file");
		jButton9.setText("Back to main menu");
		jButton10.setText("Add contact"); //TODO: nanti edit balik dapat add
		jButton11.setText("Cancel");

		ButtonController listener = new ButtonController();

		jButton1.addActionListener(listener);
		jButton2.addActionListener(listener);
		jButton3.addActionListener(listener);
		jButton4.addActionListener(listener);
		jButton5.addActionListener(listener);
		jButton6.addActionListener(listener);
		jButton7.addActionListener(listener);
		jButton8.addActionListener(listener);
		jButton9.addActionListener(listener);
		jButton10.addActionListener(listener);
		jButton11.addActionListener(listener);

		jList1.setModel(new javax.swing.AbstractListModel() {
			String[] strings = { "Personal Friends", "Relatives", "Professional Friends", "Casual Acquaintances" };
			public int getSize() { return strings.length; }
			public Object getElementAt(int i) { return strings[i]; }
		});
		jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
				jList1ValueChanged(evt);
			}
		});
		jScrollPane1.setViewportView(jList1);

		jXTable1.setModel(new javax.swing.table.DefaultTableModel(
				new Object [][] {
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null},
					{null, null, null, null}
				},
				new String [] {
						"S.No", "Name", "Mobile No", "Email"
				}
				) {
			Class[] types = new Class [] {
					java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
			};
			boolean[] canEdit = new boolean [] {
					false, false, false, false
			};

			public Class getColumnClass(int columnIndex) {
				return types [columnIndex];
			}

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit [columnIndex];
			}
		});
		jScrollPane2.setViewportView(jXTable1);

		jLabel1.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
		jLabel1.setText("Select Category:");

		jLabel3.setFont(new java.awt.Font("Ubuntu Medium", 0, 17)); // NOI18N
		jLabel3.setText("Details:");

		emailButton = new JButton("Save and email file");
		emailButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				emailButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1Layout.setHorizontalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addGap(38)
														.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(jButton6)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jButton7))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)))
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING)
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
																.addGroup(jPanel1Layout.createSequentialGroup()
																		.addComponent(jButton8)
																		.addPreferredGap(ComponentPlacement.RELATED)
																		.addComponent(jButton4, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
														.addGap(27))
												.addComponent(jLabel2)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
														.addGap(18)
														.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(jLabel1)
														.addGap(59)
														.addComponent(jLabel3)
														.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)))
										.addContainerGap())
								.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
										.addComponent(emailButton)
										.addGap(214))))
				);
		jPanel1Layout.setVerticalGroup(
				jPanel1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jButton2)
										.addComponent(jButton1))
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jButton3)
										.addComponent(jButton5)))
						.addGap(18)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jButton4)
										.addComponent(jButton8))
								.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
										.addComponent(jButton6)
										.addComponent(jButton7)))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(emailButton)
						.addGap(15)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(jLabel3))
						.addGap(18)
						.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
								.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
						.addContainerGap())
				);
		jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new Component[] {jButton1, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8});
		jPanel1.setLayout(jPanel1Layout);

		getContentPane().add(jPanel1, "card2");

		details.setEditable(false);
		jScrollPane3.setViewportView(details);

		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout.setHorizontalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
						.addContainerGap())
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addGap(194, 194, 194)
						.addComponent(jButton9)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
		jPanel2Layout.setVerticalGroup(
				jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel2Layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButton9)
						.addGap(21, 21, 21))
				);

		getContentPane().add(jPanel2, "card3");

		jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Casual Acquaintance Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); // NOI18N

		jLabel4.setText("Name:");

		jLabel5.setText("Mobile No:");

		jLabel6.setText("Email:");

		jLabel7.setText("First meeting time & location:");

		jLabel8.setText("First meeting CIrcumstances:");

		jLabel9.setText("Other useful information:");

		name.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameActionPerformed(evt);
			}
		});

		two.setColumns(20);
		two.setRows(5);
		two.setAutoscrolls(false);
		jScrollPane4.setViewportView(two);

		three.setColumns(20);
		three.setRows(5);
		jScrollPane5.setViewportView(three);

		one.setColumns(20);
		one.setRows(5);
		jScrollPane6.setViewportView(one);


		javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
		jPanel3.setLayout(jPanel3Layout);
		jPanel3Layout.setHorizontalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel9)
								.addComponent(jLabel8)
								.addComponent(jLabel7)
								.addComponent(jLabel6)
								.addComponent(jLabel5)
								.addComponent(jLabel4))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
										.addGap(132, 132, 132)))
						.addContainerGap())
				);
		jPanel3Layout.setVerticalGroup(
				jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel3Layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel4)
								.addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel5)
								.addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel7)
								.addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGap(17, 17, 17)
										.addComponent(jLabel8))
								.addGroup(jPanel3Layout.createSequentialGroup()
										.addGap(18, 18, 18)
										.addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(17, 17, 17)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel9))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
						.addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton10)
								.addComponent(jButton11))
						.addGap(3, 3, 3))
				);

		getContentPane().add(jPanel3, "card4");

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
		setUpTableData();
	}//GEN-LAST:event_jList1ValueChanged

	private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
		// TODO add your handling code here:
	}//GEN-LAST:event_nameActionPerformed

//	public boolean MobileNoChecker(String str){
//		int x;
//		if(str.isEmpty() || str.length() < 6 || str.length() > 15)
//			return false;
//		for(int j = 0 ; j < str.length() ; j++)
//		{
//			x = (int)str.charAt(j);
//			if( x < 48 || x > 57 )
//				return false;    
//		}
//		return true;
//	}

//	public boolean validDate(String Date){
//		String pattern = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
//		Pattern r = Pattern.compile(pattern);
//		Matcher m = r.matcher(Date);
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		if(!m.find()){
//			JOptionPane.showMessageDialog(mg, "Enter a valid date");
//			return false;
//		}
//		else
//			return true;
//	}

	private void emailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
		String s = (String)JOptionPane.showInputDialog(
				mg,
				"Enter your email",
				"Input",
				JOptionPane.PLAIN_MESSAGE,
				null,
				null,
				"username@domain.com");
		if(s==null)
			return;

		SendFileToEmail sendFile = new SendFileToEmail(s, a);
		sendFile.sendEmail();
		JOptionPane.showMessageDialog(mg, "Successfuly sent email to "+s);
	}//GEN-LAST:event_emailButtonActionPerformed

	public JPanel getJPanel1() {
		return jPanel1;
	}

	public JPanel getJPanel2() {
		return jPanel2;
	}

	public JPanel getJPanel3() {
		return jPanel3;
	}

	public JList getJList1() {
		return jList1;
	}

	public boolean getFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}

	public void setDFlag(boolean dflag) {
		this.dflag = dflag;
	}

	public JXTable getJXTable1() {
		return jXTable1;
	}

	public ArrayList<ArrayList<Acquaintances>> getA() {
		return a;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public JTextPane getDetails() {
		return details;
	}
	
	public JTextField getNameTxt() {
		return name;
	}
	
	public JTextField getMobile() {
		return mobile;
	}
	
	public JTextField getEmail() {
		return email;
	}
	
	public JTextArea getOne() {
		return one;
	}
	
	public JTextArea getTwo() {
		return two;
	}
	
	public JTextArea getThree() {
		return three;
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextPane details;
	private javax.swing.JTextField email;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton10;
	private javax.swing.JButton jButton11;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JButton jButton5;
	private javax.swing.JButton jButton6;
	private javax.swing.JButton jButton7;
	private javax.swing.JButton jButton8;
	private javax.swing.JButton jButton9;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JList jList1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JScrollPane jScrollPane4;
	private javax.swing.JScrollPane jScrollPane5;
	private javax.swing.JScrollPane jScrollPane6;
	private org.jdesktop.swingx.JXTable jXTable1;
	private javax.swing.JTextField mobile;
	private javax.swing.JTextField name;
	private javax.swing.JTextArea one;
	private javax.swing.JTextArea three;
	private javax.swing.JTextArea two;
	private JButton emailButton;
	// End of variables declaration//GEN-END:variables

}