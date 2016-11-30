package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;

public class ProjectMainPanel extends JPanel {
   JPanel LPanel;
   private DefaultListModel listModel = new DefaultListModel();
   private JList List = new JList(listModel);
   private JScrollPane SP_board = new JScrollPane(List);
   
   JPanel Rpanel;
   private DefaultListModel memlistModel = new DefaultListModel();
   private JList memList = new JList(memlistModel);
   private JScrollPane scroller = new JScrollPane(memList);//스크롤 생성
   private JTextArea PContent;
   private JProgressBar Timebar;
   private JProgressBar Taskbar;
   public ProjectMainPanel(){
      setLayout(null);
      
      LPanel = new JPanel();
      LPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      JLabel LB_FriendAct = new JLabel("최근 활동");
      LB_FriendAct.setFont(new Font("Dialog",Font.BOLD,20));
      LB_FriendAct.setBounds(102,20,90,29);
      LPanel.setBounds(41, 23, 303, 419);
      LPanel.setLayout(null);
      LPanel.add(LB_FriendAct);
      add(LPanel);
      SP_board.setBounds(30, 59, 250, 314);
      LPanel.add(SP_board);
      SP_board.getVerticalScrollBar().setUnitIncrement(16);
      SP_board.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      setRecentActivities();
     
      
      Rpanel = new JPanel();
      Rpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      Rpanel.setBounds(368, 23, 303, 419);
      add(Rpanel);
      Rpanel.setLayout(null);
      JLabel LB_PContent = new JLabel("프로젝트 설명");
      LB_PContent.setBounds(42, 36, 89, 15);
      
      JLabel LB_Member = new JLabel("멤버");
      LB_Member.setBounds(42,206,30,15);
      Rpanel.add(LB_Member);
      
      Timebar = new JProgressBar();
      Timebar.setBounds(107, 358, 146, 15);
      Timebar.setMinimum(0); 
      Timebar.setMaximum(100); 
      
      Rpanel.add(Timebar);
      setTimebar();
      Taskbar = new JProgressBar();
      Taskbar.setBounds(107, 383, 146, 15);
      Taskbar.setMinimum(0); 
      Taskbar.setMaximum(100); 
       
      Rpanel.add(Taskbar);
      setTaskbar();
      Rpanel.add(LB_PContent);
      scroller.setBounds(42, 231, 200, 85);
      Rpanel.add(scroller);
      
      
      memList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      JLabel LB_Task = new JLabel("업무");
      LB_Task.setBounds(65, 383, 30, 15);
      Rpanel.add(LB_Task);
      
      JLabel LB_Time = new JLabel("시간");
      LB_Time.setBounds(65, 358, 30, 15);
      Rpanel.add(LB_Time);
      
      PContent = new JTextArea();
      PContent.setBounds(42, 61, 194, 101);
      PContent.setEditable(false);
      PContent.setLineWrap(true);
      PContent.setWrapStyleWord(true);
      setMemList();
      setPContent();
      Rpanel.add(PContent);
      memList.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent evt) {
              JList list = (JList)evt.getSource();
              if (evt.getClickCount() > 0) {
                  //int index = list.locationToIndex(evt.getPoint());
                  System.out.println( list.getSelectedValue().toString());
                  
              }
          }
      });
       
   }
   public void setMemList(){
	   //memlistModel.removeAllElements();
	   memlistModel.addElement("사람1");
	      memlistModel.addElement("사람2");
	      memlistModel.addElement("사람3");
	      memlistModel.addElement("사람4");
	      memlistModel.addElement("사람5");
	      memlistModel.addElement("사람6");
   }
   public void setPContent(){
	   PContent.setText("프로젝트 내용입니다");
   }
   
   public void setRecentActivities(){
	   for(int i=0; i<10; i++){
		   listModel.addElement("활동"+i);
	   }
   }
   
   public void setTimebar(){
	   Timebar.setValue(50);
   }
   
   public void setTaskbar(){
	   Taskbar.setValue(50);
   }
   /*
   private void jListNicknamesMouseClicked(java.awt.event.MouseEvent evt) {                                            
       JList list = (JList)evt.getSource();
       if (evt.getClickCount() == 2) {
           int index = list.locationToIndex(evt.getPoint());
           System.out.println("index: "+index);
       }
   }
   */
}