package user;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import project.ProjectList;

import java.awt.Color;
import java.awt.Dimension;

public class Login extends JFrame implements ActionListener {
   /**
    * 로그인
    */
   
   private JButton BT_Login;
   private JButton BT_Membership;
   private JLabel LB_ProgramName;
   private JLabel LB_IDLabel;
   private JLabel LB_PWLabel;
   private JTextField TF_IDField;
   private JPasswordField TF_PWField;
   private Font FT_ProNameFont;
   //private JLabel LB_LoginState;
   private String selectIdPw="Select ID,PW from account";
   public static String str_ID;
   private String str_PW;
   private JButton BT_Search;
   
   public Login(){
      super();
      getContentPane().setBackground(Color.WHITE);
      setTitle("Login/resister");
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(750,550);
		setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      FT_ProNameFont = new Font("궁서",Font.BOLD,40);
      BT_Login = new JButton("로그인");
      BT_Membership = new JButton("회원가입");
      LB_ProgramName = new JLabel("PROJECTOK");
      LB_ProgramName.setFont(FT_ProNameFont);
      LB_IDLabel = new JLabel("ID");
      LB_PWLabel = new JLabel("PASSWORD");
      TF_IDField = new JTextField(15);
      TF_PWField = new JPasswordField(15);
      BT_Login.addActionListener(this);
      BT_Membership.addActionListener(this);
      LB_ProgramName.setBounds(216,50,300,50);
      LB_IDLabel.setBounds(216, 112, 100, 50);   
      TF_IDField.setBounds(216, 162, 150, 30);
      LB_PWLabel.setBounds(216, 192, 100, 50);
      TF_PWField.setBounds(216, 242, 150, 30);
      BT_Login.setBounds(216, 292, 80, 30);
      BT_Membership.setBounds(316, 292, 95, 30);
      
      getContentPane().setLayout(null);
      getContentPane().add(LB_ProgramName);
      getContentPane().add(LB_IDLabel);
      getContentPane().add(TF_IDField);
      getContentPane().add(LB_PWLabel);
      getContentPane().add(TF_PWField);
      getContentPane().add(BT_Login);
      getContentPane().add(BT_Membership);
      
      BT_Search = new JButton("ID/PW 찾기");
      BT_Search.setBounds(216, 358, 195, 30);
      BT_Search.addActionListener(this);
      getContentPane().add(BT_Search);
      
      setVisible(true);
   }
   public static String encrypt(String passwd){
	   //스트링을 바이트로
	   byte[] byteArray = passwd.getBytes();
	   
	   MessageDigest md = null;
	   try{
	    //암호화 방법선택
	    md = MessageDigest.getInstance("SHA1");   
	   }catch(NoSuchAlgorithmException e){
	    e.printStackTrace();
	   }
	   if(md == null){
	    return null;
	   }
	   
	   md.reset();
	   md.update(byteArray);
	   //암호화
	   byte digest[] = md.digest();
	   
	   StringBuffer buffer = new StringBuffer();
	   //헥사 값으로 저장
	   for(int i = 0; i < digest.length; i++){
	    buffer.append(Integer.toHexString(0xFF & digest[i]));
	   }
	   return buffer.toString();
	  }
   public void actionPerformed(ActionEvent e){      
      boolean isID=false;
      boolean isPW=false;
      if(e.getSource() == BT_Login){
            try{
               
               if (Main.st.execute(selectIdPw)) {
                  Main.rs = Main.st.getResultSet();
               while (Main.rs.next()) {
                  if(Main.rs.getString("ID").equals(TF_IDField.getText())){
                     str_ID=Main.rs.getString("ID");
                     isID=true;
                     if(Main.rs.getString("PW").equals(Login.encrypt(TF_PWField.getText()))){
                        isPW=true;
                        str_PW=Main.rs.getString("PW");   
                     }
                     break;
                  }                     
               }
            }
         } catch (SQLException sqex) {
            System.out.println("SQLException: " + sqex.getMessage());
            System.out.println("SQLState: " + sqex.getSQLState());
         }
            
         if(isID) 
            {
            if(isPW){
               ProjectList PL = new ProjectList();
               dispose();
            }
            else{
               new SubFrame().notPW();
               }
            }
         else
            new SubFrame().notID();
      }
      else if(e.getSource() == BT_Membership){
         new Register();
         dispose();
      }
      else if(e.getSource()==BT_Search){
    	  new IDPWSearch();
    	  dispose();
      }
      else{
         
      }
   }
}