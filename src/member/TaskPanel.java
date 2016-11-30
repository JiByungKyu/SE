package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class TaskPanel extends JPanel implements ActionListener {
	protected static JList<String> taskList;
	protected static DefaultListModel<String> listModel;
	protected JButton btn_add;
	protected JButton btn_delete;
	protected JButton btn_modify;
	protected JButton btn_showAll;
	//method
	TaskPanel(){
		listModel = new DefaultListModel<String>();
	
		setLayout(null);
		btn_showAll = new JButton("일정 모두 보기");
		btn_showAll.setBounds(113, 316, 126, 23);
		add(btn_showAll);
		btn_showAll.addActionListener(this);
		btn_add = new JButton("일정 추가");
		btn_add.setBounds(45, 274, 95, 23);
		add(btn_add);
		
		btn_add.addActionListener(this);
		btn_modify = new JButton("수정");
		btn_modify.setBounds(152, 274, 76, 23);
		add(btn_modify);
		btn_modify.addActionListener(this);
		btn_delete = new JButton("삭제");
		btn_delete.setBounds(238, 274, 76, 23);
		add(btn_delete);
		btn_delete.addActionListener(this);
		taskList = new JList<String>(listModel);
		
		taskList.setFixedCellWidth(250);
		JScrollPane scroller = new JScrollPane(taskList);
		scroller.setBounds(45, 80, 269, 162);
		add(scroller);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		taskList.setVisibleRowCount(10);//10줄까지만 보이도록 설정
		taskList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		/*showTask(CalendarPanel.getCalendar().get(Calendar.DATE),
				CalendarPanel.getCalendar().get(Calendar.MONTH) + 1,
				CalendarPanel.getCalendar().get(Calendar.YEAR));
		*/
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		if(event.equals("일정 추가")){
			new addTask();
		}
		else if(event.equals("수정")){
			new editTask();
		}
		else if(event.equals("삭제")){
			
		}
		else if(event.equals("일정 모두 보기")){
			
		}
		/*showTask(CalendarPanel.getCalendar().get(Calendar.DATE),
				CalendarPanel.getCalendar().get(Calendar.MONTH) + 1,
				CalendarPanel.getCalendar().get(Calendar.YEAR));
				*/
	}
	/*
	public static void showTask(int day, int month, int year){
		if(!listModel.isEmpty()){
			listModel.removeAllElements();
		}
		for(int i = 0; i < ToDoList.myTasks.size(); i++){
			if(ToDoList.myTasks.get(i).getStartDate().getDay() == day && 
					ToDoList.myTasks.get(i).getStartDate().getMonth() == month &&
					ToDoList.myTasks.get(i).getStartDate().getYear() == year)
			{
				listModel.addElement(toDoList.getTask().get(i).getName());
			}
		}
	}
	*/
}
