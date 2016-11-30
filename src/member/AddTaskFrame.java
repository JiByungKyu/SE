package member;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;

import java.awt.SystemColor;

public class AddTaskFrame extends JFrame implements ActionListener {
	private JPanel panel = new JPanel();
	
	protected JTextField TF_title;
	protected JComboBox CB_type;
	protected JComboBox CB_status;
	protected JComboBox CB_progress;
	protected JTextArea TA_content;
	
	JButton BTN_create;
	JButton BTN_cancel;
	
	JLabel title;
	JLabel content;
	JLabel progress;
	JLabel status;
	JLabel type;
	
	String[] prog = {"0","10","20","30","40","50","60","70","80","90","100"};
	String[] stat = {"Activate", "InActivate"};
	String[] ty = {"Story","To Do", "Done"};
	
	public AddTaskFrame() {
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		title = new JLabel("Title :");
		title.setHorizontalAlignment(SwingConstants.LEFT);
		title.setBounds(22, 10, 65, 20);
		panel.add(title);
		
		content = new JLabel("Content :");
		content.setHorizontalAlignment(SwingConstants.LEFT);
		content.setBounds(22, 112, 65, 15);
		panel.add(content);
		
		status = new JLabel("Status :");
		status.setHorizontalAlignment(SwingConstants.LEFT);
		status.setBounds(22, 87, 65, 15);
		panel.add(status);
		
		type = new JLabel("Type :");
		type.setHorizontalAlignment(SwingConstants.LEFT);
		type.setBounds(22, 34, 65, 21);
		panel.add(type);
		
		TF_title = new JTextField();
		TF_title.setBounds(111, 10, 198, 21);
		panel.add(TF_title);
		TF_title.setColumns(10);
		
		TA_content = new JTextArea();
		TA_content.setBounds(111, 108, 261, 70);
		TA_content.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
		panel.add(TA_content);
		 
		CB_type = new JComboBox(ty);
		CB_type.setBounds(111, 34, 116, 21);
		panel.add(CB_type);
		
		
		BTN_create = new JButton("Create");
		BTN_create.setBounds(77, 188, 97, 23);
		BTN_create.addActionListener(this);
		panel.add(BTN_create);
		
		BTN_cancel = new JButton("Cancel");
		BTN_cancel.setBounds(212, 188, 97, 23);
		BTN_cancel.addActionListener(this);
		panel.add(BTN_cancel);
		
		progress = new JLabel("Progress :");
		progress.setBounds(22, 59, 65, 20);
		panel.add(progress);
		
		CB_status = new JComboBox(stat);
		CB_status.setBounds(111, 84, 116, 21);
		panel.add(CB_status);
		
		CB_progress = new JComboBox(prog);
		CB_progress.setBounds(111, 59, 116, 21);
		panel.add(CB_progress);
		
		setSize(410, 260); //크기 설정
		setVisible(true); //보이기
		setLocation(400,300);
		
	}
	
	public String getTaskType(){
		return (String) CB_type.getSelectedItem();
	}
	
	public String getTaskTitle(){
		return TF_title.getText();
	}
	
	void clear(){
		TF_title.setText("");
		CB_status.setSelectedIndex(0);
		CB_type.setSelectedIndex(0);
		CB_progress.setSelectedIndex(0);
		CB_status.setSelectedIndex(0);
		TA_content.removeAll();		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BTN_create){
			BacklogPanel.createTask();
			BacklogPanel.addCount();
			setVisible(false);
		}
		else if(e.getSource() == BTN_cancel){
			setVisible(false);
			clear();
		}
	}
}
