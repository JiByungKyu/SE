package member;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import project.DnDUtil;
import project.JoinProject;
import user.Login;
import user.Main;

public class BacklogPanel extends JPanel implements ActionListener{
	static final DataFlavor[] supportedFlavors = { null };
    static JPanel PN_Story;
    static JPanel PN_ToDo;
    static JPanel PN_Done;
    
    JPanel panel;
    
    ArrayList<String> title;
    ArrayList<String> content;
    ArrayList<String> ID;
    ArrayList<String> taskProgress;
    ArrayList<String> taskstatus;
    ArrayList<String> taskType;
    
    JLabel story;
    JLabel todo;
    JLabel done;
    
    JButton BTN_create;
    JButton BTN_edit;
    JButton BTN_delete;
    
    static DragSource dragSource;
    static DnDUtil dndListener;
    JLabel[] task;
    DragGestureRecognizer[] dragTask;
    static DragGestureRecognizer[] dTasks;
    MouseListener mouseListener;
    
    static AddTaskFrame add;
    static int total = 0;
    static int count = 0;
    static ArrayList<JLabel> list;
    
    static
    {
        try {
            supportedFlavors[ 0 ] = new DataFlavor( DataFlavor.javaJVMLocalObjectMimeType );
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
   
    public BacklogPanel(){
    	setBackground(Color.WHITE);
		new BoxLayout(this, BoxLayout.X_AXIS);
		title = new ArrayList<String>();
		content = new ArrayList<String>();
		ID = new ArrayList<String>();
		taskProgress = new ArrayList<String>();
		taskstatus = new ArrayList<String>();
		taskType = new ArrayList<String>();
		dTasks = new DragGestureRecognizer[100];
		list = new ArrayList<JLabel>();
		
    	PN_Story = new JPanel(); 
    	PN_Story.setBorder(new LineBorder(new Color(0, 0, 0)));
    	PN_Story.setBounds(22, 41, 220, 475);
    	PN_ToDo = new JPanel();
    	PN_ToDo.setBorder(new LineBorder(new Color(0, 0, 0)));
    	PN_ToDo.setBounds(241, 41, 355, 475);
    	PN_Done = new JPanel();
    	PN_Done.setBorder(new LineBorder(new Color(0, 0, 0)));
    	PN_Done.setBounds(595, 41, 355, 475);
    	
    	PN_Story.setBackground( Color.WHITE );
    	PN_ToDo.setBackground( Color.WHITE );
    	PN_Done.setBackground( Color.WHITE );
    	
    	dndListener = new DnDUtil();
        dragSource = new DragSource();
        setLayout(null);
        	
        add(PN_Story);        
        PN_Story.setLayout(new GridLayout(0, 2, 0, 0));        
        add(PN_ToDo);          
        PN_ToDo.setLayout(new GridLayout(0, 3, 0, 0));;
        add(PN_Done);
        PN_Done.setLayout(new GridLayout(0, 2, 0, 0));
        
        DropTarget dropTarget1 = new DropTarget( PN_Story, DnDConstants.ACTION_MOVE, dndListener );
        DropTarget dropTarget2 = new DropTarget( PN_ToDo, DnDConstants.ACTION_MOVE, dndListener );
        DropTarget dropTarget3 = new DropTarget( PN_Done, DnDConstants.ACTION_MOVE, dndListener );
        
        panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(22, 0, 928, 33);
        add(panel);
        panel.setLayout(null);
        
        story = new JLabel("Story");
        story.setBackground(Color.WHITE);
        story.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        story.setBounds(90, 0, 59, 33);
        panel.add(story);
        
        todo = new JLabel("To Do");
        todo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        todo.setBounds(382, 0, 57, 33);
        panel.add(todo);
        
        done = new JLabel("Done");
        done.setFont(new Font("맑은 고딕", Font.BOLD, 15));
        done.setBounds(735, 0, 57, 33);
        panel.add(done);
        
        BTN_create = new JButton("Create");
        BTN_create.addActionListener(this);
        BTN_create.setBounds(602, 526, 108, 33);
        add(BTN_create);
        
        BTN_edit = new JButton("Edit");
        BTN_edit.addActionListener(this);
        BTN_edit.setBounds(722, 526, 108, 33);
        add(BTN_edit);
        
        BTN_delete = new JButton("Delete");
        BTN_delete.addActionListener(this);
        BTN_delete.setBounds(842, 526, 108, 33);
        add(BTN_delete);
        
        importBacklog();
        mouseListener = new MouseAdapter() { 
            public void mouseClicked(MouseEvent mouseEvent) {     
               if (mouseEvent.getClickCount() == 2) { 
            	   System.out.println("ddarg;ejgre;");
               } 
            } 
         };
    }
    
    public static void addCount(){
    	count++;
    } 
    
    void importBacklog(){
    	try {
			Main.rs = Main.st.executeQuery("SELECT * FROM backlog where pnumber='"+ MemberProject.pnumber +"'");
			while(Main.rs.next()){
				title.add(Main.rs.getString("title"));
				content.add(Main.rs.getString("content"));
				ID.add(Main.rs.getString("name"));
				taskProgress.add(Main.rs.getString("taskprogress"));
				taskstatus.add(Main.rs.getString("taskstatus"));
				taskType.add(Main.rs.getString("taskType"));
				count++;
			}
			task = new JLabel[count];
			dragTask = new DragGestureRecognizer[count];
			
			for(int i = 0; i < count; i++){
				task[i] = new JLabel(title.get(i));
				task[i].addMouseListener(mouseListener);
				dragTask[i] = dragSource.createDefaultDragGestureRecognizer(task[i], DnDConstants.ACTION_MOVE, dndListener);
				if(taskType.get(i).equals("0")){
					PN_Story.add(task[i]);
				}
				else if(taskType.get(i).equals("1")){
					PN_ToDo.add(task[i]);
				}
				else {
					PN_Done.add(task[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    static void createTask(){
    	
    	list.add(new JLabel(add.getTaskTitle()));
    	dTasks[total] = dragSource.createDefaultDragGestureRecognizer(list.get(total), DnDConstants.ACTION_MOVE, dndListener);
    	if(add.getTaskType().equals("Story")){
    		PN_Story.add(list.get(total));
    	}
    	else if(add.getTaskType().equals("To Do")){
    		PN_ToDo.add(list.get(total));
    	}
    	else {
    		PN_Done.add(list.get(total));
    	}
    	
    	
    	try {
    		String a ="INSERT INTO backlog "
					+ "VALUES (" + FindNumber.find("backlog", "tnumber") + ", '" + add.getTaskTitle() + "' , '" + add.TA_content.getText() 
					+ "' , '" + Login.str_ID + "' , '" + add.CB_progress.getSelectedItem() + "' , '" + add.CB_status.getSelectedItem() + "' , '" 
					+ add.CB_type.getSelectedItem() + "' , " + MemberProject.pnumber + ")";
    		System.out.println(a);
    		Main.st.execute(a);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	add.clear();
    	total++;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == BTN_create){
			if(add == null)
				add = new AddTaskFrame();
			add.setVisible(true);
		}
		else if(e.getSource() == BTN_edit){
			
		}
		else if(e.getSource() == BTN_delete){
			
		}
	}
}