package mini;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class LoginFrame {
	
	private JFrame frame;
	private JTextField loginIdT;
	private JPasswordField loginPwdT;
	
	public LoginFrame(JFrame frame) {

		MemberManager memberManager = new MemberManager();
		
		this.frame = new JFrame();
		
		ImagePanel panel1 = new ImagePanel(new ImageIcon("src/Images/1.png").getImage());
		frame.getContentPane().add(panel1);
		frame.pack();
		
		/* 아이디 입력 필드 */	
		loginIdT = new JTextField()	{
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		loginIdT.setFont(new Font("굴림", Font.PLAIN, 28));
		loginIdT.setBounds(170, 487, 480, 64);
		panel1.add(loginIdT);
		loginIdT.setColumns(10);
		loginIdT.setOpaque(false);
		loginIdT.setText("Your ID");
		
		loginIdT.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent e) {
		        JTextField source = (JTextField)e.getComponent();
		        source.setText("");
		        source.removeFocusListener(this);
		    }
		    
		});
		
		
		/* 비밀번호 입력 필드 */ 
		loginPwdT = new JPasswordField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		loginPwdT.setFont(new Font("굴림", Font.PLAIN, 28));
		loginPwdT.setBounds(170, 575, 540, 64);
		panel1.add(loginPwdT);
		loginPwdT.setColumns(10);
		loginPwdT.setOpaque(false);		
		loginPwdT.setText("      Your Password");		
		
		loginPwdT.addFocusListener(new FocusAdapter() {
		    public void focusGained(FocusEvent e) {
		        JTextField source = (JTextField)e.getComponent();
		        source.setText("");
		        source.removeFocusListener(this);
		    }
		    
		});
				
		
		/* 로그인 버튼 */
		JButton loginBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		loginBtn.setIcon(new ImageIcon("src/buttonImages/로그인.png"));
		loginBtn.setBounds(95, 659, 566, 62);
		panel1.add(loginBtn);
		
		loginBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (loginIdT.getText().isBlank() || loginPwdT.getText().isBlank()) {
					
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 공란입니다. 확인 후 다시 로그인 해주세요.");
				
				}
				else if (memberManager.MangerLogin(loginIdT.getText(), loginPwdT.getText())) {
					
					frame.getContentPane().removeAll();	
					ManagerFrame mrf = new ManagerFrame(frame);
					
				} else if (memberManager.login(loginIdT.getText(), loginPwdT.getText())) {

					frame.getContentPane().removeAll();				
					AfterLoginFrame alf = new AfterLoginFrame(frame);
				}	
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 loginBtn.setIcon(new ImageIcon("src/buttonImages/로그인.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 loginBtn.setIcon(new ImageIcon("src/buttonImages/로그인 버튼 마우스 엔터.png"));
				 
			 }
		
		});
		
		/* 회원 가입 버튼 */
		JButton loginJoinBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		loginJoinBtn.setIcon(new ImageIcon("src/buttonImages/새 계정 만들기.png"));
		loginJoinBtn.setOpaque(false);	
		loginJoinBtn.setBounds(69, 726, 174, 55);
		panel1.add(loginJoinBtn);
		
		loginJoinBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*회원 가입 페이지로 이동*/
				frame.getContentPane().removeAll();
				JoinFrame jf = new JoinFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 loginJoinBtn.setIcon(new ImageIcon("src/buttonImages/새 계정 만들기.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 loginJoinBtn.setIcon(new ImageIcon("src/buttonImages/새 계정 만들기 마우스 엔터.png"));
				 
			 }
		
		});
		
		/* 비밀번호 변경 버튼 */
		JButton loginPwdResetBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		loginPwdResetBtn.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경.png"));
		loginPwdResetBtn.setOpaque(false);	
		loginPwdResetBtn.setBounds(449, 727, 221, 54);
		panel1.add(loginPwdResetBtn);
		
		loginPwdResetBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				//비번 변경 페이지로 이동
				frame.getContentPane().removeAll();

				FindPassWord brf = new FindPassWord(frame);

				

				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 loginPwdResetBtn.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경.png"));
				 				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 loginPwdResetBtn.setIcon(new ImageIcon("src/buttonImages/비밀번호 변경 마우스 엔터.png"));
				 
			 }
		
		});
		
		
	}
}
