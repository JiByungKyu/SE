package user;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;

public class IDPWSearch extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldPhone;
	private JTextField textFieldPWID;
	private JButton btnID; 
	private JButton btnPW;
	private JButton btnBack;
	private JLabel lblID;
	String searchID ;
	String searchPW;
	private JTextField textFieldPWPhone;
	private JTextField textFieldPWName;
	private JLabel lblPW;
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public IDPWSearch() {
		setSize(750,550);
		this.setTitle("ID/PW 찾기");
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelID = new JPanel();
		panelID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelID.setBackground(Color.WHITE);
		panelID.setBounds(19, 123, 319, 366);
		contentPane.add(panelID);
		panelID.setLayout(null);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(156, 166, 116, 24);
		panelID.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		
		JLabel lbName = new JLabel("Name");
		lbName.setBounds(72, 111, 36, 18);
		panelID.add(lbName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(156, 108, 116, 24);
		panelID.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblPNumber = new JLabel("PhoneNumber");
		lblPNumber.setBounds(27, 174, 91, 18);
		panelID.add(lblPNumber);
		
		btnID = new JButton("ID 찾기");
		btnID.setBounds(112, 284, 105, 27);
		panelID.add(btnID);
		
		lblID = new JLabel("");
		lblID.setFont(UIManager.getFont("Label.font"));
		lblID.setBounds(56, 243, 209, 18);
		panelID.add(lblID);
		btnID.addActionListener(this);
		JPanel panelPW = new JPanel();
		panelPW.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelPW.setBackground(Color.WHITE);
		panelPW.setBounds(370, 123, 340, 364);
		contentPane.add(panelPW);
		panelPW.setLayout(null);
		
		btnPW = new JButton("PW 찾기");
		btnPW.setBounds(119, 281, 105, 27);
		panelPW.add(btnPW);
		btnPW.addActionListener(this);
		JLabel lblD = new JLabel("ID");
		lblD.setBounds(86, 82, 13, 18);
		panelPW.add(lblD);
		
		textFieldPWID = new JTextField();
		textFieldPWID.setBounds(155, 79, 116, 24);
		panelPW.add(textFieldPWID);
		textFieldPWID.setColumns(10);
		
		textFieldPWPhone = new JTextField();
		textFieldPWPhone.setBounds(155, 202, 116, 24);
		panelPW.add(textFieldPWPhone);
		textFieldPWPhone.setColumns(10);
		
		textFieldPWName = new JTextField();
		textFieldPWName.setBounds(155, 145, 116, 24);
		panelPW.add(textFieldPWName);
		textFieldPWName.setColumns(10);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setBounds(68, 148, 36, 18);
		panelPW.add(label_1);
		
		JLabel label_2 = new JLabel("PhoneNumber");
		label_2.setBounds(14, 205, 91, 18);
		panelPW.add(label_2);
		
		lblPW = new JLabel("");
		lblPW.setFont(UIManager.getFont("Label.font"));
		lblPW.setBounds(62, 251, 209, 18);
		panelPW.add(lblPW);
		
		JLabel label = new JLabel("PROJECTOK");
		label.setFont(new Font("궁서", Font.BOLD, 40));
		label.setBounds(216, 50, 300, 50);
		contentPane.add(label);
		
		btnBack = new JButton("뒤로 가기");
		btnBack.setOpaque(true);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(19, 72, 105, 27);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str_ID="찾는 ID가 없습니다.";
		String str_PW="등록되지 않은 ID 입니다.";
		if(e.getSource()==btnID){
			//DB 연동
			try {
				searchID="select ID from account where name="+"'"+textFieldName.getText()+"' and phone_num="+"'"+textFieldPhone.getText()+"'";
				if (Main.st.execute(searchID)) {
					Main.rs = Main.st.getResultSet();
					if(Main.rs.next()){
					new SubFrame().findID(Main.rs.getString("ID"));
					lblID.setText("");
					}
					else
						lblID.setText(str_ID);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		}
		else if(e.getSource()==btnPW){
			try {
				searchPW="select ID,NAME,PHONE_NUM from account where ID="+"'"+textFieldPWID.getText()+"'";
				if (Main.st.execute(searchPW)) {
					Main.rs = Main.st.getResultSet();
					if(Main.rs.next()){
						if(textFieldPWName.getText().equals(Main.rs.getString("NAME"))&&textFieldPWPhone.getText().equals(Main.rs.getString("phone_num"))){
								new PWSearch(textFieldPWID.getText());
								dispose();
						}
						else
							lblPW.setText("정보가 일치하지 않습니다.");
					}else
						lblPW.setText(str_PW);
				}

			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==btnBack){
			new Login();
			dispose();
		}
	}
}
