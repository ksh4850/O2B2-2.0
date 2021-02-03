package mini;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class JoinFrame  {
	
	
	public static boolean isIdCheck;
	private JTextField getIdField ;
	private JPasswordField getPwdField;
	private JPasswordField getPwd2Field;
	private JTextField getNameField;
	private JTextField getBirthField;
	private JTextField getAddrField;
	private String getGender ;
	private JFrame frame;
	
	public JoinFrame(JFrame frame) {	
		
		this.frame = new JFrame();
		MemberManager memberManager = new MemberManager();
		ImagePanel panel3 = new ImagePanel(new ImageIcon("src/Images/3.png").getImage());
		frame.getContentPane().add(panel3);
		frame.pack();
		
		
		
		/**** 입력 필드 & 라벨 시작 ****/
		
		
		/* id 입력필드 */
		getIdField = new JTextField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		getIdField.setBounds(415, 290, 250, 55);
		getIdField.setFont(new Font("굴림", Font.PLAIN, 28));
		getIdField.setOpaque(false);
		panel3.add(getIdField);
		getIdField.setColumns(10);

		
		/* 비밀번호 입력 필드 */		
		getPwdField = new JPasswordField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		getPwdField.setOpaque(false);
		getPwdField.setBounds(415, 443, 358, 59);
		getPwdField.setFont(new Font("굴림", Font.PLAIN, 28));
		panel3.add(getPwdField);
		getPwdField.setColumns(10);

		/* pwd 반복입력 확인 필드 */
		getPwd2Field = new JPasswordField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		/* 비밀번호 중복 입력 필드 */
		getPwd2Field.setOpaque(false);
		getPwd2Field.setBounds(415, 565, 358, 55);
		getPwd2Field.setFont(new Font("굴림", Font.PLAIN, 28));
		panel3.add(getPwd2Field);
		getPwd2Field.setColumns(10);

		
		/* 이름 입력 필드 */ 
		getNameField = new JTextField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		getNameField.setOpaque(false);
		getNameField.setBounds(845, 290, 358, 59);
		getNameField.setFont(new Font("굴림", Font.PLAIN, 28));
		panel3.add(getNameField);
		getNameField.setColumns(10);

		/* 생년월일 입력 필드*/
		getBirthField = new JTextField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		getBirthField.setOpaque(false);
		getBirthField.setBounds(845, 442, 358, 59);
		getBirthField.setFont(new Font("굴림", Font.PLAIN, 28));
		panel3.add(getBirthField);
		getBirthField.setColumns(10);

		
		getAddrField = new JTextField(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		getAddrField.setOpaque(false);
		getAddrField.setBounds(845, 565, 358, 55);
		getAddrField.setFont(new Font("굴림", Font.PLAIN, 28));
		panel3.add(getAddrField);
		getAddrField.setColumns(10);

		
		/**** 입력 필드 끝 ****/
		
		
		
		/**** 버튼 시작 ****/		
		
		/* 성별 선택 라디오 버튼 */
		
		
		JRadioButton genWomBtn = new JRadioButton("여자");
		genWomBtn.setFont(new Font("굴림", Font.BOLD, 22));
		genWomBtn.setBounds(538, 768, 134, 38);
		panel3.add(genWomBtn);
		
		
		
		JRadioButton genManbtn = new JRadioButton("남자");
		genManbtn.setFont(new Font("굴림", Font.BOLD, 22));
		genManbtn.setBounds(413, 768, 121, 38);
		panel3.add(genManbtn);
		
		
		
		ButtonGroup group = new ButtonGroup();
		
		group.add(genManbtn);
		group.add(genWomBtn);
		

		getGender = "없음";
		
		genWomBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				genWomBtn.setActionCommand("여자");
				getGender = group.getSelection().getActionCommand();
			}
		});
		
		
		
		genManbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				genManbtn.setActionCommand("남자");
				getGender = group.getSelection().getActionCommand();
			}
		});
		
		
		
		
//		String getGender = group.getSelection().getActionCommand();
		
		JButton joinHomeBtn = new JButton(""){ //홈버튼
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};	
		joinHomeBtn.setForeground(Color.WHITE);
		joinHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		joinHomeBtn.setOpaque(false);
		joinHomeBtn.setContentAreaFilled(false);
		joinHomeBtn.setBounds(1503, 27, 60, 54);
		panel3.add(joinHomeBtn);
		joinHomeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*로그인 페이지로 이동*/
				frame.getContentPane().removeAll();
				LoginFrame lf = new LoginFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 joinHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 joinHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼 마우스 엔터.png"));
			 
			 
			 }
			 
		});

		
		JButton idCheck = new JButton(""){ //중복확인버튼
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};			
		idCheck.setIcon(new ImageIcon("src/buttonImages/중복확인.png"));
		idCheck.setBounds(670, 292, 103, 55);
		idCheck.setContentAreaFilled(false);
		idCheck.setOpaque(false);		
		panel3.add(idCheck);
				
		idCheck.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*멤버 매니저를 호출해 입력한 ID와 중복되는지 확인 */
				

				memberManager.idCheck(getIdField.getText());
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 idCheck.setIcon(new ImageIcon("src/buttonImages/중복확인.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 idCheck.setIcon(new ImageIcon("src/buttonImages/중복확인 마우스 엔터.png"));
			 
			 
			 }
			 
		});
				
		
		idCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				memberManager.idCheck(getIdField.getText());
				
			}
			
		});
	
	
		JButton joinBtn = new JButton(""){	//회원가입버튼
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		joinBtn.setIcon(new ImageIcon("src/buttonImages/회원가입.png"));
		joinBtn.setBounds(837, 725, 371, 62);
		panel3.add(joinBtn);
		
		joinBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				
				String id = getIdField.getText(); 
				String pwd = getPwdField.getText();
				String pwd2 = getPwd2Field.getText();
				String name = getNameField.getText(); 
				String birthDate = getBirthField.getText(); 
				String addr = getAddrField.getText(); 				
				String signupDate = date.format(new Date());
							
				if(!(isIdCheck)) {
					
					JOptionPane.showInternalMessageDialog(null, "아이디 중복체크를 해주세요.");
					
				}else if(getGender.equals("없음")) {
					JOptionPane.showInternalMessageDialog(null, "성별체크를해주세요.");
					
				}else {
					
					if(memberManager.pwdCheck(pwd,pwd2) && 
							memberManager.isBlankCheck(id, pwd2, name, birthDate, addr) && 
							memberManager.birthDateCheck(birthDate)) {					
								
								memberManager.Join(id, pwd, name, 
								addr, birthDate, getGender);
											
						frame.getContentPane().removeAll();
						LoginFrame loginFrame = new LoginFrame(frame);	
					
					}
				
				}

			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 joinBtn.setIcon(new ImageIcon("src/buttonImages/회원가입.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 joinBtn.setIcon(new ImageIcon("src/buttonImages/회원가입 마우스 엔터.png"));
			 			 
			 }
			 
		});
		
	}
	

}
