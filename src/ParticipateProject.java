import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ParticipateProject extends JFrame implements ActionListener {
	JPanel PN_Center;
	JPanel PN_Button;
	JLabel LB_Pnumber;
	JTextField TF_Pnumber;
	JLabel LB_PPW;
	JTextField TF_PPW;
	
	JButton BT_Particifi;
	JButton BT_Return;
	
	public ParticipateProject(){
		this.setSize(300,300);
		this.setTitle("프로젝트 참가");
		this.setLocation(500, 300);
		
		PN_Center = new JPanel();
		PN_Button = new JPanel();
		PN_Button.setLayout(new FlowLayout(FlowLayout.CENTER));
		LB_Pnumber =  new JLabel("프로젝트 번호");
		TF_Pnumber = new JTextField(15);
		LB_PPW =  new JLabel("프로젝트 PW");
		TF_PPW = new JTextField(15);
		BT_Particifi = new JButton("확인");
		BT_Return = new JButton("취소");
		BT_Particifi.addActionListener(this);
		BT_Return.addActionListener(this);
		
		PN_Center.setLayout(null);
		
		
		LB_Pnumber.setBounds(10, 50, 100, 50);
		TF_Pnumber.setBounds(110, 60, 150, 30);
		LB_PPW.setBounds(10, 100, 100, 50);
		TF_PPW.setBounds(110, 110, 150, 30);
		
		PN_Center.add(LB_Pnumber);
		PN_Center.add(TF_Pnumber);
		PN_Center.add(LB_PPW);
		PN_Center.add(TF_PPW);
		
		PN_Button.add(BT_Particifi);
		PN_Button.add(BT_Return);
		
		this.add(PN_Center,BorderLayout.CENTER);
		this.add(PN_Button,BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==BT_Particifi){
			this.dispose();
		}else if(e.getSource()==BT_Return){
			this.dispose();
		}
	}
}
