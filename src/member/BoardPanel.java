package member;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import user.Main;

public class BoardPanel extends JPanel implements ActionListener{
	public static JPanel panel;
	private JScrollPane SP_content;
	public static int contentcount = 0;
	public ArrayList<String> bnumber = new ArrayList<String>();
	public ArrayList<String> title = new ArrayList<String>();
	public ArrayList<String> content = new ArrayList<String>();
	public ArrayList<String> date = new ArrayList<String>();
	public ArrayList<String> name = new ArrayList<String>();
	
	private boolean isnew = false;
	private JButton BT_newcontent;
	int datalength = 0;

	public BoardPanel() {
		setLayout(null);
		
		String sql = "SELECT title FROM board";
		try {
			Main.st.execute(sql);
			Main.rs=Main.st.getResultSet();
			while(Main.rs.next()){
				datalength++;
				System.out.println(Main.rs.getString("title"));
				title.add(Main.rs.getString(("title")));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		int c=0;
		sql = "SELECT date FROM board";
		try {
			Main.rs = Main.st.executeQuery(sql);
			while(Main.rs.next()){
				
				date.add(Main.rs.getString(("date")));
				System.out.println(date.get(c++));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
		
		panel = new JPanel();
		//panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		//panel.setBounds(65, 40, 608, 360);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		SP_content = new JScrollPane(panel);
		SP_content.setBounds(65, 40, 608, 360);
		SP_content.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		BT_newcontent = new JButton("글쓰기");
		BT_newcontent.setBounds(300, 406, 150, 29);
		add(BT_newcontent);
		BT_newcontent.addActionListener(this);
		SP_content.getVerticalScrollBar().setUnitIncrement(16);
		add(SP_content);
		
		for(int i=0;i<datalength;i++){
			//Component com = Box.createVerticalStrut(10);
			JLabel title = new JLabel();
			
			title.setHorizontalAlignment(SwingConstants.LEFT);
			panel.add(title);
			//panel.add(com);
			
			title.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			title.setBounds(0, -15, 300, 50);
			title.setText(this.title.get(i));
			title.setFont(new Font("Dialog",Font.PLAIN,20));
			title.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					//dispose();
					isnew=false;
					new BoardContent(isnew);
				}
			});
			
		
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(BT_newcontent)){
			isnew=true;
			new BoardContent(isnew);
		}
		
	}
}
