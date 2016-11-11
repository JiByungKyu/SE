import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	JButton BT_Addmem;
	JButton BT_Cancel;
	JButton BT_CheckID;
	JLabel LB_NameLabel;
	JTextField TF_NameText;
	JLabel LB_IDLabel;
	JTextField TF_IDText;
	JLabel LB_PWLabel;
	JTextField TF_PWText;
	JLabel LB_Age;
	JTextField TF_Age;
	JLabel LB_Sex;
	JTextField TF_Sex;
	JLabel LB_Question;
	JTextField TF_Question;
	JLabel LB_Answer;
	JTextField TF_Answer;
	JLabel LB_NumberLabel;
	JTextField TF_Secondnum;
	JTextField TF_Firstnum;
	JTextField TF_Thirdnum;
	JPanel PN_Center;
	public Register(){
		this.setSize(400,600);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("회원가입");
		this.setLocation(400, 250);
		
		PN_Center = new JPanel();
		PN_Center.setLayout(null);
		
		
		BT_Addmem = new JButton("추가");
		BT_Cancel = new JButton("취소");
		BT_CheckID = new JButton("아이디 확인");
		BT_Addmem.addActionListener(this);
		BT_Cancel.addActionListener(this);
		BT_CheckID.addActionListener(this);
		
		LB_NameLabel = new JLabel("이름");
		TF_NameText = new JTextField(15);
		LB_IDLabel = new JLabel("아이디");
		TF_IDText = new JTextField(15);
		LB_PWLabel = new JLabel("비밀번호");
		TF_PWText = new JTextField(15);
		LB_Age = new JLabel("나이");
		TF_Age = new JTextField(15);
		LB_Sex = new JLabel("성별");
		TF_Sex = new JTextField(15);
		
		LB_Question = new JLabel("비밀번호 질문");
		TF_Question = new JTextField(15);
		LB_Answer = new JLabel("비밀번호 대답");
		TF_Answer = new JTextField(15);
		LB_NumberLabel = new JLabel("핸드폰 번호");
		TF_Firstnum = new JTextField(4);
		TF_Secondnum = new JTextField(4);
		TF_Thirdnum = new JTextField(4);
		
		
				
		
		LB_NameLabel.setBounds(10,50,100,50);
		TF_NameText.setBounds(110,60,150,30);
		LB_IDLabel.setBounds(10,100,100,50);
		TF_IDText.setBounds(110,110,150,30);
		LB_PWLabel.setBounds(10,150,100,50);
		TF_PWText.setBounds(110,160,150,30);
		LB_Age.setBounds(10,200,100,50);
		TF_Age.setBounds(110,210,150,30);
		LB_Sex.setBounds(10,250,100,50);
		TF_Sex.setBounds(110,260,150,30);
		LB_Question.setBounds(10,300,100,50);
		TF_Question.setBounds(110,310,150,30);
		LB_Answer.setBounds(10,350,100,50);
		TF_Answer.setBounds(110,360,150,30);
		LB_NumberLabel.setBounds(10,400,100,50);
		TF_Firstnum.setBounds(110,410,50,30);
		TF_Secondnum.setBounds(160,410,50,30);
		TF_Thirdnum.setBounds(210,410,50,30);
		
		BT_Addmem.setBounds(10,500,100,30);
		BT_Cancel.setBounds(150,500,100,30);
		BT_CheckID.setBounds(260,110,110,30);
		
		
		PN_Center.add(LB_NameLabel);
		PN_Center.add(TF_NameText);
		PN_Center.add(LB_IDLabel);
		PN_Center.add(TF_IDText);
		PN_Center.add(LB_PWLabel);
		PN_Center.add(TF_PWText);
		PN_Center.add(LB_Age);
		PN_Center.add(TF_Age);
		PN_Center.add(LB_Sex);
		PN_Center.add(TF_Sex);
		PN_Center.add(LB_Question);
		PN_Center.add(TF_Question);
		PN_Center.add(LB_Answer);
		PN_Center.add(TF_Answer);
		PN_Center.add(LB_NumberLabel);
		PN_Center.add(TF_Firstnum);
		PN_Center.add(TF_Secondnum);
		PN_Center.add(TF_Thirdnum);
		
		
		PN_Center.add(BT_Addmem);
		PN_Center.add(BT_Cancel);
		PN_Center.add(BT_CheckID);
		
		
		this.add(PN_Center,BorderLayout.CENTER);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==BT_Addmem){
			this.dispose();
		}else if(e.getSource()==BT_Cancel){
			this.dispose();
		}else if(e.getSource()==BT_CheckID){
			
		}
	}
}
