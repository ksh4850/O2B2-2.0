package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FindPassWord {
	

	private JFrame frame;
	
	public FindPassWord(JFrame frame) {
		
		
		ImagePanel panel7 = new ImagePanel(new ImageIcon("src/images/7.png").getImage());
		frame.getContentPane().add(panel7);	
		frame.pack();
		
		/*ID 입력 텍스트필드*/
		JTextField infoIdT = new JTextField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		infoIdT.setFont(new Font("굴림", Font.PLAIN, 28));
		infoIdT.setOpaque(false);
		infoIdT.setBounds(622, 262, 369, 54);
		panel7.add(infoIdT);
		infoIdT.setColumns(20);
		
		
		JTextField infoBirthDateT = new JTextField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		infoBirthDateT.setFont(new Font("굴림", Font.PLAIN, 28));
		infoBirthDateT.setOpaque(false);
		infoBirthDateT.setBounds(622, 401, 369, 54);
		panel7.add(infoBirthDateT);
		infoBirthDateT.setColumns(20);
		
		
		/* 개인정보 확인 버튼 - 비밀번호 변경으로 이동하는 버튼 */
		JButton infoCkBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
				
		infoCkBtn.setIcon(new ImageIcon("src/buttonImages/개인정보 확인.png"));
		infoCkBtn.setBounds(613, 533, 371, 62);
		panel7.add(infoCkBtn);
		
		infoCkBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*비번 변경 페이지로 이동*/
				frame.getContentPane().removeAll();
				ResetPassword rp = new ResetPassword(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 infoCkBtn.setIcon(new ImageIcon("src/buttonImages/개인정보 확인.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 infoCkBtn.setIcon(new ImageIcon("src/buttonImages/개인정보 확인 마우스 엔터.png"));
			 
			 
			 }
			 
		});
	
		
		infoCkBtn.addActionListener(new ActionListener() { // 비밀번호찾기
			
			public void actionPerformed(ActionEvent e) {
				
				MemberManager memberManager = new MemberManager();
				
				String pwd = memberManager.findpwd(infoIdT.getText(), infoBirthDateT.getText());
				
				if(!pwd.equals("없음")) {
				
				JOptionPane.showMessageDialog(null, infoIdT.getText() + "님의 비밀번호는 " + pwd + "입니다.");
					
				}
				
			}
		});
		
		/* 우측 상단 홈버튼 */
		JButton HomeBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		HomeBtn.setForeground(Color.WHITE);
		HomeBtn.setIcon(new ImageIcon("src/buttonImages/홉버튼.png"));
		HomeBtn.setOpaque(false);
		HomeBtn.setContentAreaFilled(false);
		HomeBtn.setBounds(1519, 12, 61, 54);
		panel7.add(HomeBtn);
		
		HomeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*로그인 페이지로 이동*/
				
			
			
				frame.getContentPane().removeAll();
				LoginFrame lf = new LoginFrame(frame);
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 HomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 HomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼 마우스 엔터.png"));
			 
			 
			 }
			 
		});
		
		
	}
	

}
