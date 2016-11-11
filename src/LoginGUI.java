import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginGUI extends JFrame implements ActionListener{
	private JButton BT_Login;
	private JButton BT_Membership;
	private JLabel LB_ProgramName;
	private JLabel LB_IDLabel;
	private JLabel LB_PWLabel;
	private JTextField TF_IDField;
	private JTextField TF_PWField;
	private Font FT_ProNameFont;
	protected JPanel PN_Center;
	
	public LoginGUI(){
		
		this.setSize(650,450);	
		this.setLocation(500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Login/resister");
		
		PN_Center = new JPanel();
		PN_Center.setLayout(null);
		PN_Center.setBackground(Color.WHITE);
		FT_ProNameFont = new Font("궁서",Font.BOLD,40);
		BT_Login = new JButton("로그인");
		BT_Membership = new JButton("회원가입");
		LB_ProgramName = new JLabel("PROJECTOK");
		LB_ProgramName.setFont(FT_ProNameFont);
		LB_IDLabel = new JLabel("ID");
		LB_PWLabel = new JLabel("PASSWORD");
		TF_IDField = new JTextField(15);
		TF_PWField = new JTextField(15);
		BT_Login.addActionListener(this);
		BT_Membership.addActionListener(this);
		
		LB_ProgramName.setBounds(190,50,300,50);
		LB_IDLabel.setBounds(10, 100, 100, 50);	
		TF_IDField.setBounds(10, 150, 150, 30);
		LB_PWLabel.setBounds(10, 180, 100, 50);
		TF_PWField.setBounds(10, 230, 150, 30);
		BT_Login.setBounds(10, 280, 80, 30);
		BT_Membership.setBounds(110, 280, 95, 30);
		
		
		PN_Center.add(LB_ProgramName);
		PN_Center.add(LB_IDLabel);
		PN_Center.add(TF_IDField);
		PN_Center.add(LB_PWLabel);
		PN_Center.add(TF_PWField);
		PN_Center.add(BT_Login);
		PN_Center.add(BT_Membership);
		
		
	
		
		this.add(PN_Center,BorderLayout.CENTER);
		
		 
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){		
		if(e.getSource() == BT_Login){
			ProjectList PL = new ProjectList();
			this.dispose();
		}else if(e.getSource() == BT_Membership){
			Register Ms = new Register();
		}else{
			
		}
	}
}