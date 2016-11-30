package project;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import user.SubFrame;

public class CreateProject extends JFrame implements ActionListener {
	JPanel PN_Center;
	JPanel PN_Button;
	JButton BT_Add;
	JButton BT_Return;
	JScrollPane SP_PSpecifi;
	JLabel LB_Pname;
	JTextField TF_Pname;
	JLabel LB_PPW;
	JTextField TF_PPW;
	JLabel LB_PSpecifi;
	JTextArea TA_PSpecifi;
	JLabel LB_PDueDate;
	JTextField TF_PDuedate;
	
	public CreateProject(){
		this.setSize(400,500);	
		this.setTitle("프로젝트 생성");
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);

		PN_Center = new JPanel();
		PN_Center.setLayout(null);
		
		PN_Button =  new JPanel();
		PN_Button.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		LB_Pname = new JLabel("프로젝트 이름");
		TF_Pname = new JTextField(15);
		LB_PPW = new JLabel("프로젝트 비밀번호");
		TF_PPW = new JTextField(15);
		LB_PSpecifi = new JLabel("프로젝트 내용");
		TA_PSpecifi = new JTextArea();
		SP_PSpecifi =  new JScrollPane(TA_PSpecifi);
		
		LB_PDueDate = new JLabel("프로젝트 기한");
		TF_PDuedate = new JTextField(15);
		
		LB_Pname.setBounds(10,0,100,50);
		TF_Pname.setBounds(140,10,150,30);
		LB_PPW.setBounds(10,50,100,50);
		TF_PPW.setBounds(140,60,150,30);
		LB_PSpecifi.setBounds(10,100,100,50);
		SP_PSpecifi.setBounds(140,110,200,100);
		LB_PDueDate.setBounds(10,250,100,50);
		TF_PDuedate.setBounds(140,260,150,30);
		
		BT_Add = new JButton("생성");
		BT_Return = new JButton("취소");
		BT_Add.addActionListener(this);
		BT_Return.addActionListener(this);
		
		
		PN_Center.add(LB_Pname);
		PN_Center.add(TF_Pname);
		PN_Center.add(LB_PPW);
		PN_Center.add(TF_PPW);
		PN_Center.add(LB_PSpecifi);
		PN_Center.add(SP_PSpecifi);
		PN_Center.add(LB_PDueDate);
		PN_Center.add(TF_PDuedate);
		
		PN_Button.add(BT_Add);
		PN_Button.add(BT_Return);
		
		
		this.add(PN_Center,BorderLayout.CENTER);
		this.add(PN_Button,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){  
		if(e.getSource()==BT_Add){
			
			new SubFrame().createProject();
			this.dispose();
		}else{
			
			this.dispose();
		}
	}
}
