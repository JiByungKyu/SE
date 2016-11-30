package member;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import member.FindNumber;
import user.Main;
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
   private static Calendar cal;
   private static String[] year;
   private static String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
   private static String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
   
   JComboBox CB_year;
   JComboBox CB_month;
   JComboBox CB_day;
   
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
      
      LB_Pname.setBounds(10,0,100,50);
      TF_Pname.setBounds(140,10,150,30);
      LB_PPW.setBounds(10,50,118,50);
      TF_PPW.setBounds(140,60,150,30);
      LB_PSpecifi.setBounds(10,100,100,50);
      SP_PSpecifi.setBounds(140,110,200,100);
      LB_PDueDate.setBounds(10,250,100,50);
      
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
      
      PN_Button.add(BT_Add);
      PN_Button.add(BT_Return);
      
      
      getContentPane().add(PN_Center,BorderLayout.CENTER);
      
      int tYear;
      
      cal = Calendar.getInstance();
      year = new String[10];
      for(int i=0; i < 10; i++){
         tYear = cal.get(Calendar.YEAR);
         year[i] = Integer.toString(tYear + i);
      }
      
      CB_year = new JComboBox(year);
      CB_year.setBounds(140, 265, 59, 21);
      PN_Center.add(CB_year);
      
      CB_month = new JComboBox(month);
      CB_month.setBounds(222, 265, 44, 21);
      PN_Center.add(CB_month);
      
      CB_day = new JComboBox(day);
      CB_day.setBounds(281, 265, 44, 21);
      PN_Center.add(CB_day);
      
      JLabel LB_year = new JLabel("년");
      LB_year.setBounds(205, 265, 23, 21);
      PN_Center.add(LB_year);
      
      JLabel LB_month = new JLabel("월");
      LB_month.setBounds(267, 265, 23, 21);
      PN_Center.add(LB_month);
      
      JLabel LB_day = new JLabel("일");
      LB_day.setBounds(327, 265, 23, 21);
      PN_Center.add(LB_day);
      getContentPane().add(PN_Button,BorderLayout.SOUTH);
      
      this.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e){  
      if(e.getSource()==BT_Add){
         FindNumber a = new FindNumber();
         int pnumber = a.find("project", "pnumber");
         String sql = "INSERT INTO project VALUES (" + pnumber + ", '" + TF_Pname.getText() + "', '" + TF_PPW.getText() + "', '" + TA_PSpecifi.getText() + "')";
         try {
         Main.st.execute(sql);
      } catch (SQLException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }
         new SubFrame().createProject();
         this.dispose();
      }else{
         
         this.dispose();
      }
   }
}