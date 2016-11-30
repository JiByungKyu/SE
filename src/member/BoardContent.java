package member;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class BoardContent extends JFrame implements ActionListener {
	public JTextArea TA_title;
	public JTextArea TA_writer;
	public JTextArea TA_content;
	private JPanel contentPane;
	private JButton BT_newcontent;
	private JButton BT_cancel;
	
	public BoardContent(boolean isnew) {
		Dimension dimen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(300,200);
		//setLocation((int)dimen.getWidth()/2 - this.getWidth()/2, (int)dimen.getHeight()/2 - this.getHeight()/2);
		setSize(750,550);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LB_title = new JLabel("제목");
		LB_title.setBounds(61, 59, 78, 21);
		contentPane.add(LB_title);
		
		JLabel LB_writer = new JLabel("작성자");
		LB_writer.setBounds(61, 130, 78, 21);
		contentPane.add(LB_writer);
		
		JLabel LB_content = new JLabel("내용");
		LB_content.setBounds(61, 196, 48, 21);
		contentPane.add(LB_content);
		
	
		TA_title = new JTextArea();
		TA_title.setEditable(isnew);
		TA_title.setBounds(135, 58, 279, 24);
		contentPane.add(TA_title);
		
		TA_writer = new JTextArea();
		TA_writer.setEditable(isnew);
		TA_writer.setBounds(135, 129, 104, 24);
		contentPane.add(TA_writer);
		
		TA_content = new JTextArea();
		TA_content.setEditable(isnew);
		TA_content.setLineWrap(true);
		TA_content.setWrapStyleWord(true);
		TA_content.setBounds(135, 195, 341, 188);
		
		if(isnew){
			BT_newcontent = new JButton("작성");
			BT_newcontent.setBounds(157, 433, 97, 23);
			BT_newcontent.addActionListener(this);
			contentPane.add(BT_newcontent);
			
			BT_cancel = new JButton("취소");
			BT_cancel.setBounds(316, 433, 97, 23);
			BT_cancel.addActionListener(this);
			contentPane.add(BT_cancel);
		}
		contentPane.add(TA_content);

	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(BT_newcontent)){
			
			dispose();
		}else if(e.getSource().equals(BT_cancel)){
			dispose();
		}
	}
}
