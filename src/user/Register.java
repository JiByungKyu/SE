package user;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register extends JFrame implements ActionListener{
	boolean isVerified = false;
   JButton BT_Addmem;
   JButton BT_Cancel;
   JButton BT_CheckID;
   JLabel LB_NameLabel;
   JTextField TF_NameText;
   JLabel LB_IDLabel;
   JTextField TF_IDText;
   JLabel LB_PWLabel;
   JPasswordField TF_PWText;
   JLabel LB_PWLabelcheck;
   JPasswordField TF_PWTextcheck;
   JLabel LB_Age;
   JTextField TF_Age;
   JLabel LB_Sex;
   JLabel LB_Question;
   JTextField TF_Question;
   JLabel LB_Answer;
   JTextField TF_Answer;
   JLabel LB_NumberLabel;
   JTextField TF_Secondnum;
   JTextField TF_Firstnum;
   JTextField TF_Thirdnum;
   JPanel PN_Center;
   JRadioButton RB_boy;
   JRadioButton RB_girl;
   private JLabel label_1;


   public Register(){
      setSize(750,550);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setTitle("회원가입");
      Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
      this.setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
      
      PN_Center = new JPanel();
      PN_Center.setLayout(null);
      PN_Center.setBackground(Color.WHITE);
      
      BT_Addmem = new JButton("확인");
      BT_Cancel = new JButton("이전");
      BT_CheckID = new JButton("아이디 확인");
      BT_Addmem.addActionListener(this);
      BT_Cancel.addActionListener(this);
      BT_CheckID.addActionListener(this);
      
      ButtonGroup sexGroup = new ButtonGroup();
      
      LB_NameLabel = new JLabel("이름");
      TF_NameText = new JTextField(15);
      LB_IDLabel = new JLabel("아이디");
      TF_IDText = new JTextField(15);
      LB_PWLabel = new JLabel("비밀번호");
      TF_PWText = new JPasswordField(15);
      LB_PWLabelcheck = new JLabel("비밀번호 확인");
      TF_PWTextcheck = new JPasswordField(15);
      LB_Age = new JLabel("나이");
      TF_Age = new JTextField(15);
      LB_Sex = new JLabel("성별");
      
      LB_Question = new JLabel("비밀번호 질문");
      TF_Question = new JTextField(15);
      LB_Answer = new JLabel("비밀번호 대답");
      TF_Answer = new JTextField(15);
      LB_NumberLabel = new JLabel("핸드폰 번호");
      TF_Firstnum = new JTextField(4);
      TF_Secondnum = new JTextField(4);
      TF_Thirdnum = new JTextField(4);
      
      
      LB_IDLabel.setBounds(173,26,100,50);
      TF_IDText.setBounds(271,37,150,30);   
      
      LB_PWLabel.setBounds(173,72,100,50);
      TF_PWText.setBounds(273,82,150,30);
      
      LB_PWLabelcheck.setBounds(173,122,100,50);
      TF_PWTextcheck.setBounds(273,132,150,30);
      
      LB_NameLabel.setBounds(173,172,100,50);
      TF_NameText.setBounds(273,182,150,30);
      
      LB_NumberLabel.setBounds(173,222,100,50);
      TF_Firstnum.setBounds(273,232,30,30);
      TF_Secondnum.setBounds(318,232,45,30);
      TF_Thirdnum.setBounds(377,232,45,30);
      
      LB_Age.setBounds(173,272,100,50);
      TF_Age.setBounds(273,282,150,30);
      
      LB_Sex.setBounds(173,322,100,50);
      
      LB_Question.setBounds(173,372,100,50);
      TF_Question.setBounds(273,382,150,30);
      
      LB_Answer.setBounds(173,422,100,50);
      TF_Answer.setBounds(273,432,150,30);
      

      
      BT_Addmem.setBounds(230,472,100,30);
      BT_Cancel.setBounds(377,472,100,30);
      BT_CheckID.setBounds(445,36,110,30);
      
      
      PN_Center.add(LB_NameLabel);
      PN_Center.add(TF_NameText);
      PN_Center.add(LB_IDLabel);
      PN_Center.add(TF_IDText);
      PN_Center.add(LB_PWLabel);
      PN_Center.add(TF_PWText);
      PN_Center.add(LB_PWLabelcheck);
      PN_Center.add(TF_PWTextcheck);
      PN_Center.add(LB_Age);
      PN_Center.add(TF_Age);
      PN_Center.add(LB_Sex);
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
      
      
      getContentPane().add(PN_Center,BorderLayout.CENTER);
      
      JLabel label = new JLabel("-");
      label.setBounds(308, 232, 6, 30);
      PN_Center.add(label);
      
      label_1 = new JLabel("-");
      label_1.setBounds(367, 232, 6, 30);
      PN_Center.add(label_1);
      
      RB_boy = new JRadioButton("남");
      RB_boy.setBackground(Color.WHITE);
      RB_boy.setBounds(285, 336, 45, 23);
      PN_Center.add(RB_boy);
      
      RB_girl = new JRadioButton("여");
      RB_girl.setBackground(Color.WHITE);
      RB_girl.setBounds(355, 336, 45, 23);
      PN_Center.add(RB_girl);
      sexGroup.add(RB_boy);
      sexGroup.add(RB_girl);
      
      this.setVisible(true);
   }
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource()==BT_Addmem){
    	  if(isVerified){
	    	  String sex=null;
	    	  if(RB_boy.isSelected())
	    		  sex="남";
	    	  else if(RB_girl.isSelected())
	    		  sex="여";
	    	  if(TF_PWText.getText().equals(TF_PWTextcheck.getText())){
	    	  
	    	  String sql = "INSERT INTO account VALUES (" + TF_Age.getText() + ", '" + TF_NameText.getText() +
	    			  "', '" + TF_IDText.getText() + "', '" + Login.encrypt(TF_PWText.getText()) + "', '" + TF_Question.getText() +
	    			  "', '" + TF_Answer.getText() + "', '" + sex + "', '" + TF_Firstnum.getText() + TF_Secondnum.getText()
	    			  + TF_Thirdnum.getText() + "')";
	    	  
	    	  try {
	    		  Main.st.executeUpdate(sql);
	    	  } catch (SQLException e1) { //정보 미입력
				new SubFrame().notFillInfo();
	    	  }
	    	  new SubFrame().confirmRegister();
	         this.dispose();
	         }
	    	  else
	    		  new SubFrame().notPW();
    	  }
    	  else  //아이디중복확인 안함
    		  new SubFrame().notIDCheck();
      }
      
      else if(e.getSource()==BT_Cancel){
         this.dispose();
         new Login();
      }
      
      else if(e.getSource()==BT_CheckID){
    	  String id=TF_IDText.getText();
    	  String sql = "SELECT ID FROM account WHERE ID = '" + id + "'";
    	  try {
    		  Main.rs=Main.st.executeQuery(sql);
	    	  if(Main.rs.next())
	              new SubFrame().notAvailableID();
	      	  else
	              new SubFrame().availableID();
	    	  isVerified=true;
		} catch (SQLException e1) {
		}    	  
      }
   }
}