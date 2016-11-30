package project;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import member.MemberProject;
import user.Login;
import user.Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class ProjectList extends JFrame implements ActionListener,ListSelectionListener {
   /**
    * 
    */
   private static final long serialVersionUID = 1L;

   static int n = 0;
   private JPanel PN_PJdetail = new JPanel();
   protected JPanel PN_Button = new JPanel();
   private JButton BT_PCheck;
   private JButton BT_Participation;
   private JButton BT_PCreate;
   private JLabel label;
    private JList<String> list;
    private DefaultListModel listModel;
    private Border border = BorderFactory.createTitledBorder("프로젝트 리스트");
    private JScrollPane scroll;
    private JLabel LB_PickPname = new JLabel();
    private JPanel panel;
    private DefaultListModel listModel_mem = new DefaultListModel();
    private JList list_mem = new JList(listModel_mem);
    private JScrollPane Mem_scroll = new JScrollPane(list_mem);
    private JTextArea PContent = new JTextArea("");
    private ArrayList<Integer> pnumberList=new ArrayList<Integer>();
   private ArrayList<String> pnameList=new ArrayList<String>();
   private ArrayList<String> pspecList=new ArrayList<String>();
   public ProjectList(){
      super();
      listModel = new DefaultListModel();
      Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
      setSize(750,550);
      setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      this.setTitle("내 프로젝트");
      
      LB_PickPname.setBounds(111, 20, 137, 40);
      BT_PCheck = new JButton("프로젝트 선택");
      BT_Participation = new JButton("다른 프로젝트 참가");
      BT_PCreate = new JButton("프로젝트 생성");
      BT_PCheck.addActionListener(this);
      BT_Participation.addActionListener(this);
      BT_PCreate.addActionListener(this);
      PN_Button.setBorder(new CompoundBorder());
      
      PN_Button.add(BT_PCheck);
      PN_Button.add(BT_Participation);
      PN_Button.add(BT_PCreate);
      PN_PJdetail.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      
      PN_PJdetail.setLayout(null);
      PN_PJdetail.setBounds(379, 49, 320, 400);
      setPN_PJdetail();
      panel = new JPanel();
      panel.setLayout(null);
      panel.add(PN_PJdetail);
      PN_PJdetail.add(LB_PickPname);
      
      
      list_mem.setVisibleRowCount(4);
      list_mem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      
      PContent.setBounds(48,237,234,141);
      PContent.setEditable(false);
      PContent.setLineWrap(true);
      PContent.setWrapStyleWord(true);
      PN_PJdetail.add(PContent);
      Mem_scroll.setBounds(95, 116, 107, 76);
      Mem_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책
      Mem_scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
      PN_PJdetail.add(Mem_scroll);
      
      getContentPane().add(PN_Button, BorderLayout.SOUTH);
      getContentPane().add(panel, BorderLayout.CENTER);
      
      JPanel panel_1 = new JPanel();
      panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
      panel_1.setBounds(30, 49, 320, 400);
      panel.add(panel_1);
      panel_1.setLayout(null);
      list = new JList(listModel);
      scroll = new JScrollPane(list);
      scroll.setBounds(12, 79, 300, 300);
      panel_1.add(scroll);
      //스크롤 셋팅
        scroll.setBorder(border); //경계 설정
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //list 셋팅
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.addListSelectionListener(this); //이벤트리스너 장착
        list.setFont(list.getFont().deriveFont(22.0f));
        label = new JLabel("프로젝트를 선택하세요.");
        label.setBounds(23, 29, 200, 40);
        panel_1.add(label);
        
        list.addMouseListener(new MouseAdapter() {//리스트가 클릭되었을 때
          public void mouseClicked(MouseEvent evt) {
              JList list = (JList)evt.getSource();
              if (evt.getClickCount() > 0) {
                 LB_PickPname.setText(list.getSelectedValue().toString());//프로젝트명
                 String sql = "SELECT pspecification FROM project WHERE pname = '" + list.getSelectedValue().toString() +"'";
                 try {
					Main.rs = Main.st.executeQuery(sql);
					while(Main.rs.next())
						PContent.setText(Main.rs.getString("pspecification"));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 
                 
                 showPM(list.getSelectedValue().toString());   //멤버
              }
          }
       });
      
      showPL();   //프로젝트 리스트 설정(왼쪽거)
      
      setVisible(true);
   }
   
    public void showPL(){//프로젝트 리스트 설정(왼쪽거)
      String selectInfo="select pnumber, pname,pspecification from project where exists ( select pnumber from projectaccount where ID ="+"'"+Login.str_ID+"')";

      try {
         Main.rs=Main.st.executeQuery(selectInfo);
         
         while(Main.rs.next()){
        	pnumberList.add(Main.rs.getInt("pnumber"));
            pnameList.add(Main.rs.getString("pname"));
            pspecList.add(Main.rs.getString("pspecification"));
         }
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      Iterator<String> iter = pnameList.iterator();
      while(iter.hasNext())
      listModel.addElement(iter.next());
       }
    
   public void actionPerformed(ActionEvent e){
      if(e.getSource()== BT_PCheck) {   
         new MemberProject();
         this.dispose();
      }
      else if(e.getSource() == BT_Participation){
         new JoinProject();
      }
      else if(e.getSource()==BT_PCreate){
         new CreateProject();
      }
   }
   
    public void valueChanged(ListSelectionEvent e) 
       {
           if(e.getSource() == list)
           {
               String str = (String)list.getSelectedValue();
               label.setText(str+"을 선택 하셨습니다");
           }
       }
    
    
    public void setPN_PJdetail(){
      JLabel LB_PJName = new JLabel("프로젝트명 : ");
      JLabel LB_PJMem = new JLabel("멤버 : ");
      JLabel LB_PJcontent = new JLabel("내용 : ");
      LB_PJName.setBounds(20,20,79,40);
      LB_PJMem.setBounds(20, 100, 46, 40);
      LB_PJcontent.setBounds(20, 200, 46, 40);
      PN_PJdetail.add(LB_PJName);
      PN_PJdetail.add(LB_PJMem);
      PN_PJdetail.add(LB_PJcontent);
      // PN_PJdetail
       //repaint();
    }
    
    public void showPM(String pName){
    	listModel_mem.removeAllElements();
    	String sql = "SELECT name FROM account WHERE EXISTS (SELECT ID FROM projectaccount WHERE pnumber = (SELECT pnumber FROM project WHERE pname = '" + pName + "'))";
    	

    	try {
			Main.rs = Main.st.executeQuery(sql);
	    	while(Main.rs.next()){
	    	       listModel_mem.addElement(Main.rs.getString("name"));
	    	}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}