package member;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

//import Calendar.TaskPanel;

public class SchedulePanel extends JPanel implements ActionListener, MouseWheelListener {
	/**
	 * 한기훈 11/15
	 */
	private static final long serialVersionUID = 1L;
	private static Calendar calendar;
	private JLabel label;
	private JPanel pn_month;
	private JPanel PN_calender;
	private JTable tb_dateView;
	private JTable tb_weekLabel;
	private JButton btn_leftShift;
	private JButton btn_rightShift;
	private JButton btn_todayShift;
	private DefaultTableModel dtm_weekTable;
	private DefaultTableModel dtm_dateTable;
	private String[] weekColumn = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
	private TaskPanel PN_task;
	
	public SchedulePanel(){	
		
		PN_calender = new JPanel();
		PN_calender.setBackground(Color.white);
		PN_calender.setLayout(new BorderLayout());
		calendar = Calendar.getInstance();
		label = new JLabel();
		pn_month = new JPanel(new BorderLayout());
		dtm_weekTable = new DefaultTableModel(0,7);
		dtm_dateTable = new DefaultTableModel(6,7);
		
		setLayout(new GridLayout(1,0));
		setBackground(Color.white);
		label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        label.setBounds(70, 10, 384, 54);
        
        pn_month.setBackground(Color.WHITE);
        pn_month.add(label,BorderLayout.CENTER);
		
		btn_leftShift = new JButton("<");
		btn_leftShift.setBackground(Color.WHITE);
		btn_leftShift.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_leftShift.setBorder(new EmptyBorder(5,5,5,5));
		btn_leftShift.addActionListener(this);
		
		btn_rightShift = new JButton(">");
		btn_rightShift.setBackground(Color.WHITE);
		btn_rightShift.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		btn_rightShift.setBorder(new EmptyBorder(5,5,5,5));
		btn_rightShift.addActionListener(this);
		
		btn_todayShift = new JButton("Today");
		btn_todayShift.setBackground(Color.WHITE);
		btn_todayShift.setBorder(new EmptyBorder(5,5,5,5));
		btn_todayShift.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btn_todayShift.addActionListener(this);
		
		pn_month.add(btn_leftShift, BorderLayout.WEST);
		pn_month.add(btn_rightShift,BorderLayout.EAST);
		pn_month.add(btn_todayShift, BorderLayout.SOUTH);
		
		tb_dateView = new JTable(dtm_dateTable) {
            private static final long serialVersionUID = 1L;
            
            public boolean isCellEditable(int row, int column) {
                return false;
            };

        };
		setFont(new Font("맑은 고딕",Font.PLAIN,12));
		
		DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        
        DefaultTableCellRenderer sunRed = new DefaultTableCellRenderer();
        sunRed.setForeground(Color.RED);
        sunRed.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer satBlue = new DefaultTableCellRenderer();
        satBlue.setForeground(Color.BLUE);
        satBlue.setHorizontalAlignment(JLabel.CENTER);
        DefaultTableCellRenderer sunDateRed = new DefaultTableCellRenderer();
        sunDateRed.setForeground(Color.RED);
        sunDateRed.setVerticalAlignment(SwingConstants.TOP);
        DefaultTableCellRenderer satDateBlue = new DefaultTableCellRenderer();
        satDateBlue.setForeground(Color.BLUE);
        satDateBlue.setVerticalAlignment(SwingConstants.TOP);
        DefaultTableCellRenderer top = new DefaultTableCellRenderer();
        top.setVerticalAlignment(SwingConstants.TOP);
        
        dtm_weekTable.addRow(weekColumn);
		
		tb_weekLabel = new JTable(dtm_weekTable);
		tb_weekLabel.setEnabled(false);
        tb_weekLabel.setRowSelectionAllowed(false);
        tb_weekLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
        tb_weekLabel.setBackground(Color.WHITE);
        tb_weekLabel.setRowHeight(25);
        tb_weekLabel.setFillsViewportHeight(true);
        tb_weekLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        tb_weekLabel.setBounds(12, 85, 500, 23);
        
        tb_weekLabel.getColumnModel().getColumn(1).setCellRenderer(center);
        tb_weekLabel.getColumnModel().getColumn(2).setCellRenderer(center);
        tb_weekLabel.getColumnModel().getColumn(3).setCellRenderer(center);
        tb_weekLabel.getColumnModel().getColumn(4).setCellRenderer(center);
        tb_weekLabel.getColumnModel().getColumn(5).setCellRenderer(center);
        tb_weekLabel.getColumnModel().getColumn(0).setCellRenderer(sunRed);
        tb_weekLabel.getColumnModel().getColumn(6).setCellRenderer(satBlue);
        
		tb_dateView.setCellSelectionEnabled(true);
		tb_dateView.setColumnSelectionAllowed(true);
		
		tb_dateView.addMouseWheelListener(this);
		tb_dateView.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tb_dateView.setBorder(new LineBorder(new Color(0, 0, 0)));
        tb_dateView.setRowHeight(60);
        tb_dateView.setFillsViewportHeight(true);
        tb_dateView.setBounds(12, 107, 500, 360);
        tb_dateView.getColumnModel().getColumn(0).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(1).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(2).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(3).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(4).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(5).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(6).setCellRenderer(top);
        tb_dateView.getColumnModel().getColumn(0).setCellRenderer(sunDateRed);
        tb_dateView.getColumnModel().getColumn(6).setCellRenderer(satDateBlue);
        
        PN_calender.add(tb_weekLabel,BorderLayout.CENTER);
        PN_calender.add(tb_dateView,BorderLayout.SOUTH);
        PN_calender.add(pn_month, BorderLayout.NORTH);
        add(PN_calender,BorderLayout.CENTER);
        
        PN_task = new TaskPanel();
        
        
        add(PN_task, BorderLayout.EAST);
        
        calendarView();
	}
	
	protected void calendarView() {
        label.setText((calendar.get(Calendar.YEAR) + "년, ") + (calendar.get(Calendar.MONTH) + 1) + "월");
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int endDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                tb_dateView.setValueAt("", i, j);
            }
        }
        for (int day = 1, row = 0, col = dayWeek - 1; day < endDay + 1; day++, col++) {
            if (col % 7 == 0) {
                col = 0;
                row += 1;
            }
            tb_dateView.setValueAt(" " + day, row, col);
        }
    }
	
	public static Calendar getCalendar(){
		return calendar; 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btn_todayShift){
			calendar = Calendar.getInstance();		
			calendarView();
		}
		if(e.getSource() == btn_leftShift){
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DATE));
			calendarView();
		}
		if(e.getSource() == btn_rightShift){
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
			calendarView();
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if(e.getWheelRotation() == -1){
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) - 1, calendar.get(Calendar.DATE));
			calendarView();
		}
		if(e.getWheelRotation() == 1){
			calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
			calendarView();
		}
	}	
}
