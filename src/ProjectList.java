import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ProjectList extends LoginGUI implements ActionListener,ListSelectionListener {
	static int n = 0;

	protected JPanel PN_Button = new JPanel();
	private JButton BT_PCheck;
	private JButton BT_Participation;
	private JButton BT_PCreate;
	private JLabel label = new JLabel("ADSasdf");
    private String[] listStr = {"SW","JDP"};
    private JList list = new JList();
    private Border border = BorderFactory.createTitledBorder("프로젝트 리스트");
    private JScrollPane scroll = new JScrollPane();
	public ProjectList(){
		
		super.PN_Center.removeAll();
		PN_Center.setLayout(new BorderLayout());
		
		this.setTitle("내 프로젝트");
		 //스크롤 셋팅
        scroll.setViewportView(list);
        scroll.setBorder(border); //경계 설정
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); //가로바정책
		
        //list 셋팅
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setListData(listStr); //리스트의 데이터가 될 목록 설정
        list.addListSelectionListener(this); //이벤트리스너 장착
        
		BT_PCheck = new JButton("프로젝트 선택");
		BT_Participation = new JButton("다른 프로젝트 참가");
		BT_PCreate = new JButton("프로젝트 생성");
		BT_PCheck.addActionListener(this);
		BT_Participation.addActionListener(this);
		BT_PCreate.addActionListener(this);
		
		PN_Button.add(BT_PCheck);
		PN_Button.add(BT_Participation);
		PN_Button.add(BT_PCreate);
				
		PN_Center.add(label,BorderLayout.NORTH);
		PN_Center.add(scroll, BorderLayout.CENTER);
		this.add(PN_Button,BorderLayout.SOUTH);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()== BT_PCheck){
			Project P = new Project();
			this.dispose();
		}else if(e.getSource()==BT_Participation){
			ParticipateProject PP = new ParticipateProject();
			
		}else if(e.getSource()==BT_PCreate){
			CreateProject CP = new CreateProject();
			
		}else{
			
		}
	}
	
	 public void valueChanged(ListSelectionEvent e) 
	    {
	        if(e.getSource() == list)
	        {
	            String str = (String)list.getSelectedValue();
	            label.setText(str+"을 선택 하셨습니다");
	        }
	    }
}
