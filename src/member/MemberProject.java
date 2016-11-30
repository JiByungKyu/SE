package member;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;

public class MemberProject extends JFrame implements ActionListener {
	private ProjectMainPanel PN_Main = new ProjectMainPanel();
	private BoardPanel PN_Board = new BoardPanel();
	private BacklogPanel PN_Backlog = new BacklogPanel();
	private SchedulePanel PN_Schedule = new SchedulePanel();
	private JTabbedPane jtp = new JTabbedPane();
	public static int pnumber = 1;
	
	public MemberProject(){
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		
		setTitle("PROJECTOK");
		setVisible(true);
		setSize(750,550);
		setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
		
		
		
		
		jtp.addTab("메인", PN_Main);
		PN_Main.setLayout(null);
		jtp.addTab("게시판", PN_Board);
		jtp.addTab("백로그", PN_Backlog);
		jtp.addTab("스케줄", PN_Schedule);
				
		getContentPane().add(jtp,BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	
	
}
