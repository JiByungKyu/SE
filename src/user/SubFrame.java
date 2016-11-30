package user;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.awt.SystemColor;

public class SubFrame extends JFrame implements ActionListener{
	JLabel label = new JLabel("");
	JButton button = new JButton("확인");
	private JPanel panel = new JPanel();

	
	public SubFrame() {
		//setIconImage(Toolkit.getDefaultToolkit().getImage("image\\Icon.jpg"));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		getContentPane().add(panel);
		panel.setLayout(null);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("굴림", Font.BOLD, 16));
		label.setBounds(29, 34, 421, 51);
		button.setBounds(168, 98, 125, 29);
		
		setSize(500, 200); //크기 설정
		setVisible(true); //보이기
		setLocation(600, 250);
		panel.add(label);
		panel.add(button);
		button.addActionListener(this); //버튼 액션 실행
	}
	
	public void confirmRegister(){
		label.setText("회원가입이 완료되었습니다!");
	}
	public void failAnswer(){
		label.setText("답이 일치하지 않습니다");
	}
	public void failLogin(){
		label.setText("아이디와 비밀번호를 확인해주세요.");
	}
	public void findID(String ID){
		label.setText("ID : "+ ID);
	}
	public void availableID(){
		label.setText("사용할 수 있는 아이디입니다.");
	}
	
	public void notAvailableID(){
		label.setText("이미 존재하는 아이디입니다.");
	}
	
	public void participateProject(){
		label.setText("프로젝트에 참가하였습니다.");
	}
	
	public void createProject() {
		 label.setText("프로젝트가 생성되었습니다.");	
	}
	
	public void notID(){
		label.setText("존재하지 않는 아이디입니다.");
	}
	
	public void notPW(){
		label.setText("비밀번호가 일치하지 않습니다.");
	}
	
	public void notIDCheck(){
		label.setText("아이디 중복확인을 해주세요.");
	}
	
	public void notFillInfo(){
		label.setText("모든 정보를 입력해주세요.");
	}
	public void notParticipateProject(){
		label.setText("올바른 프로젝트 정보를 입력하세요.");
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("확인")){
			this.dispose(); //창 끄기
		}
	}
}
