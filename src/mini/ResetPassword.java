package mini;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

public class ResetPassword {
		
	private JFrame frame;
	
	public ResetPassword(JFrame frame) {
				
		ImagePanel panel8 = new ImagePanel(new ImageIcon("src/images/8.png").getImage());
		frame.add(panel8);
		frame.pack();
		
		JPasswordField infoPwdChT1 = new JPasswordField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		infoPwdChT1.setBounds(623, 262, 369, 54);
		infoPwdChT1.setOpaque(false);
		panel8.add(infoPwdChT1);
		infoPwdChT1.setColumns(20);
		
				
		
		JPasswordField infoPwdChT2 = new JPasswordField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		infoPwdChT2.setBounds(623, 401, 369, 54);
		infoPwdChT2.setOpaque(false);
		panel8.add(infoPwdChT2);
		infoPwdChT2.setColumns(20);
		
		
		
		JLabel pwdEqualsOrNot = new JLabel();
		pwdEqualsOrNot.setBounds(616, 481, 369, 26);
		panel8.add(pwdEqualsOrNot);
		pwdEqualsOrNot.setText("");
	
		
		
		
		JButton pwdchbtn1 = new JButton(""); //비번 변경 버튼 
		pwdchbtn1.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경 확인.jpg"));
		pwdchbtn1.setBounds(613, 533, 371, 62);
		panel8.add(pwdchbtn1);
		
		pwdchbtn1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				MemberManager mm = new MemberManager();
				
				if(infoPwdChT1.getText().isBlank() || infoPwdChT2.getText().isBlank()) {
					
					JOptionPane.showInternalMessageDialog(null, "공란이 있습니다.\n 비밀번호를 다시 입력해주세요.");
					
				}else {
					
					
					if(mm.changedPwd(infoPwdChT1.getText(), infoPwdChT2.getText())) {
						
						//개인정보 페이지로 이동
						frame.getContentPane().removeAll();
						InfoFrame iff = new InfoFrame(frame);
						
					}
					
				}
	
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 pwdchbtn1.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경 확인.png"));
				 				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 pwdchbtn1.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경 확인 마우스 엔터.png"));
				 
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
		panel8.add(HomeBtn);
		
		HomeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*로그인 페이지로 이동*/
				frame.getContentPane().removeAll();
				AfterLoginFrame alf = new AfterLoginFrame(frame);
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
