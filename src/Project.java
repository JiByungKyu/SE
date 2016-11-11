import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Project extends ProjectList implements ActionListener {
	private JPanel PN_Main = new JPanel();
	private JPanel PN_Board = new JPanel();
	private JPanel PN_Backlog = new JPanel();
	private JPanel PN_Schedule = new JPanel();
	private JPanel PN_Setting = new JPanel();
	private JTabbedPane jtp = new JTabbedPane();
	public Project(){
		
		this.remove(PN_Center);
		this.remove(PN_Button);
		this.setTitle("PROJECTOK");
		
		
		setPN_Main();
		setPN_Board();
		setPN_Backlog();
		setPN_Schedule();
		setPN_Setting();
		
		jtp.addTab("메인", PN_Main);
		jtp.addTab("게시판", PN_Board);
		jtp.addTab("백로그", PN_Backlog);
		jtp.addTab("스케줄", PN_Schedule);
		jtp.addTab("설정", PN_Setting);
		
		
				
		this.add(jtp,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	private void setPN_Main(){
		JPanel PN_Action = new JPanel();
		
		PN_Main.setLayout(null);
		PN_Main.setBackground(Color.WHITE);
		JLabel LB_FriendAct = new JLabel("최근 활동");
		JLabel LB_Member = new JLabel("멤버");
		JLabel LB_PParticifi = new JLabel("설명");
		JLabel LB_Time = new JLabel("시간");
		JLabel LB_Task = new JLabel("업무");
		LB_FriendAct.setFont(new Font("Dialog",Font.BOLD,20));
		LB_FriendAct.setBounds(50,0,100,50);
		LB_Member.setBounds(350,0,100,50);
		LB_PParticifi.setBounds(350,100,100,50);
		LB_Time.setBounds(400,300,100,50);
		LB_Task.setBounds(400,330,100,50);
		PN_Action.setBounds(20, 50, 280, 320);
		PN_Action.add(LB_FriendAct);
		PN_Main.add(PN_Action);
		PN_Main.add(LB_Member);
		PN_Main.add(LB_PParticifi);
		PN_Main.add(LB_Time);
		PN_Main.add(LB_Task);
		

	}
	private void setPN_Board(){
		
	}
	private void setPN_Backlog(){
		
	}
	private void setPN_Schedule(){
		
	}
	private void setPN_Setting(){
		PN_Setting.setBackground(Color.WHITE);
		PN_Setting.setLayout(null);
		JPanel PN_ManageMem = new JPanel();
		JPanel PN_ManagePro = new JPanel();
		PN_ManageMem.setLayout(null);
		PN_ManagePro.setLayout(null);
		
		JLabel LB_ManageMem = new JLabel("멤버 관리");
		JButton BT_GiveAuthority = new JButton("권한 부여");
		JLabel LB_ManagePro = new JLabel("프로젝트 관리");
		JButton BT_PEdit = new JButton("정보 수정");
		JButton BT_PDelete = new JButton("삭제");
		
		PN_ManageMem.setBounds(30,50,250,300);
		PN_ManagePro.setBounds(350, 50, 250, 300);
		
		LB_ManageMem.setBounds(10, 0, 120, 50);
		BT_GiveAuthority.setBounds(10, 50, 100, 30);
		
		LB_ManagePro.setBounds(10,0,120,50);
		BT_PEdit.setBounds(10, 50, 100, 30);
		BT_PDelete.setBounds(10, 100, 100, 30);
		
		PN_ManageMem.add(LB_ManageMem);
		PN_ManageMem.add(BT_GiveAuthority);
		PN_ManagePro.add(LB_ManagePro);
		PN_ManagePro.add(BT_PEdit);
		PN_ManagePro.add(BT_PDelete);
		
		PN_Setting.add(PN_ManageMem);
		PN_Setting.add(PN_ManagePro);
	}
	
	
}
