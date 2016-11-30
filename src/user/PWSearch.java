package user;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class PWSearch extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField TF_Answer;
	private JButton btnPW;
	private JButton btnBack;
	private String str_ID;
	private String searchPW;
	private JTextArea TA_Question;
	private String str_Answer;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public PWSearch(String ID) {

		setSize(750,550);
		this.setTitle("PW 찾기");
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		str_ID=ID;
		JLabel lblQuestion = new JLabel("질문 ");
		lblQuestion.setBounds(81, 108, 62, 18);
		contentPane.add(lblQuestion);
		
		JLabel lblAnswer = new JLabel("답");
		lblAnswer.setBounds(81, 310, 62, 18);
		contentPane.add(lblAnswer);
		
		btnPW = new JButton("PW 찾기");
		btnPW.setBounds(300, 368, 105, 27);
		contentPane.add(btnPW);
		btnPW.addActionListener(this);
		TF_Answer = new JTextField();
		TF_Answer.setBounds(171, 307, 116, 24);
		contentPane.add(TF_Answer);
		TF_Answer.setColumns(10);
		
		TA_Question = new JTextArea();
		TA_Question.setBounds(171, 106, 350, 160);
		contentPane.add(TA_Question);
		btnBack = new JButton("뒤로가기");
		btnBack.setOpaque(true);
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(38, 41, 105, 27);
		btnBack.addActionListener(this);
		contentPane.add(btnBack);
		btnBack.addActionListener(this);
		this.setVisible(true);
		setting();
		
	}
	private void setting(){
		try {
			searchPW="select question,answer from account where ID="+"'"+str_ID+"'";
			if (Main.st.execute(searchPW)) {
				Main.rs = Main.st.getResultSet();
				if(Main.rs.next()){
					TA_Question.setText(Main.rs.getString("question"));
					str_Answer=Main.rs.getString("answer");
					}
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String searchPW;
		if(e.getSource()==btnPW){
			//DB 연동
			if(str_Answer.equals(TF_Answer.getText())){
				new PWUpdate(str_ID);
				dispose();
			}
			else
				new SubFrame().failAnswer();
		}
		else if(e.getSource()==btnBack){
			new Login();
			dispose();
		}
	}
}
