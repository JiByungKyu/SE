package project;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import user.Login;
import user.Main;
import user.SubFrame;

public class JoinProject extends JFrame implements ActionListener {
   JPanel PN_Center;
   JPanel PN_Button;
   JLabel LB_Pnumber;
   JTextField TF_Pnumber;
   JLabel LB_PPW;
   JTextField TF_PPW;
   
   JButton BT_Particifi;
   JButton BT_Return;
   
   public JoinProject(){
      this.setSize(300,300);
      this.setTitle("프로젝트 참가");
      Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
      
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
      String pname = TF_Pnumber.getText(); 
      String pw = TF_PPW.getText();

      if(e.getSource()==BT_Particifi){
         boolean isVerified=false;

         String sql = "SELECT ppw FROM project WHERE pname = '" + pname + "'";
         
         try {
            Main.rs = Main.st.executeQuery(sql);
            while(Main.rs.next())
               if(pw.compareTo(Main.rs.getString("ppw"))==0)
                  isVerified=true;
         } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }
         
         if(isVerified){
            
            sql = "SELECT pnumber FROM project WHERE pname = '" + pname + "'";
            try {
               int pnumber=0;
               Main.rs=Main.st.executeQuery(sql);
               while(Main.rs.next())
                   pnumber = Main.rs.getInt("pnumber");
               sql = "INSERT INTO projectaccount VALUES (" + pnumber + ", '" + Login.str_ID + "')";
            } catch (SQLException e1) {
               // TODO Auto-generated catch block
               e1.printStackTrace();
            }
            
            
            new SubFrame().participateProject();
            this.dispose();
         }
         else{
            new SubFrame().notParticipateProject();
            this.dispose();
         }
      }else if(e.getSource()==BT_Return){
         this.dispose();
      }
   }
}