package member;

import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardPanel2 extends JPanel {
	JPanel panel;
	
	public BoardPanel2() {
		panel = new JPanel();
		setLayout(null);
		JLabel a = new JLabel("sdfsdfsd");
		
		JButton btnNewButton = new JButton("다음");
		//btnNewButton.setBounds(549, 406, 125, 29);
		
		JButton btnNewButton_1 = new JButton("이전");
		//btnNewButton_1.setBounds(66, 406, 125, 29);
				
		panel.add(a);
		panel.add(btnNewButton);
		panel.add(btnNewButton_1);
		
		BoardPanel.panel.add(a);
	}	
}
