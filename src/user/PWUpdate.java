package user;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class PWUpdate extends JFrame implements ActionListener{
	private JButton button ;
	private JPasswordField PF;
	private JPasswordField PF_Check;
	private JLabel label;
	private String str_ID;
	public PWUpdate(String ID) {
		setVisible(true);
		setSize(445,320);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
		JLabel labelPW = new JLabel("새 비밀번호");
		labelPW.setBounds(91, 81, 90, 25);
		getContentPane().add(labelPW);
		str_ID=ID;
		PF = new JPasswordField();
		PF.setBounds(197, 81, 110, 25);
		getContentPane().add(PF);
		
		PF_Check = new JPasswordField();
		PF_Check.setBounds(197, 123, 110, 25);
		getContentPane().add(PF_Check);
		
		button= new JButton("변경하기");
		button.addActionListener(this);
		button.setBounds(164, 184, 105, 27);
		getContentPane().add(button);
		
		label = new JLabel("비밀번호 확인");
		label.setBounds(79, 123, 90, 25);
		getContentPane().add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String update="update account set PW ="+"'"+Login.encrypt((PF.getText()))+"' where ID="+"'"+str_ID+"'";
		if(e.getSource()==button){
			if(PF.getText().equals(PF_Check.getText())){
				try {
					Main.st.executeUpdate(update);
					new Login();
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			else
				new SubFrame().notPW();
		}
		
	}
}
