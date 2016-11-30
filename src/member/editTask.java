package member;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class editTask extends JFrame implements ActionListener {
	JPanel PN_content;
	JPanel PN_button;
	JButton BT_edit;
	JButton BT_cancel;
	private static Calendar cal;
	private static String[] year;
	private static String[] month = {"1","2","3","4","5","6","7","8","9","10","11","12"};
	private static String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	
	JComboBox CB_year;
	JComboBox CB_month;
	JComboBox CB_day;
	
	private JTextField textField;
	private JLabel lblNewLabel_1;
	public editTask(){
		getContentPane().setLayout(new BorderLayout());
		setSize(279,270);
		setLocation(500,200);
		PN_content = new JPanel();
		PN_button = new JPanel();
		
		
		PN_content.setLayout(null);
		
		
		
		
		BT_edit= new JButton("수정");
		BT_edit.addActionListener(this);
		BT_cancel= new JButton("취소");
		BT_cancel.addActionListener(this);
		
		PN_button.add(BT_edit);
		PN_button.add(BT_cancel);
		
		
		getContentPane().add(PN_content,BorderLayout.CENTER);
		
		JLabel label = new JLabel("일정명 : ");
		label.setBounds(29, 13, 59, 15);
		PN_content.add(label);
		
		textField = new JTextField();
		textField.setBounds(88, 10, 116, 21);
		PN_content.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("내용 : ");
		lblNewLabel.setBounds(29, 81, 46, 15);
		PN_content.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(88, 81, 159, 96);
		PN_content.add(textArea);
		
		lblNewLabel_1 = new JLabel("날짜 : ");
		lblNewLabel_1.setBounds(29, 38, 57, 33);
		PN_content.add(lblNewLabel_1);
		
		int tYear;
		
		cal = Calendar.getInstance();
		year = new String[10];
		for(int i=0; i < 10; i++){
			tYear = cal.get(Calendar.YEAR);
			year[i] = Integer.toString(tYear + i);
		}
		
		
		CB_year = new JComboBox(year);
		CB_year.setBounds(88, 45, 59, 21);
		PN_content.add(CB_year);
		
		CB_month = new JComboBox(month);
		CB_month.setBounds(152, 45, 45, 21);
		PN_content.add(CB_month);
		
		CB_day = new JComboBox(day);
		CB_day.setBounds(204, 45, 43, 21);
		PN_content.add(CB_day);
		getContentPane().add(PN_button,BorderLayout.SOUTH);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(BT_edit)){
			
			dispose();
		}else if(e.getSource().equals(BT_cancel)){
			dispose();
		}
	
	}
}