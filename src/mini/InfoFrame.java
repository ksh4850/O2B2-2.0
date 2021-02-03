package mini;


import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.border.Border;

public class InfoFrame {
	
	private JTextField infoIdT;
	private JTextField infoBirthDateT;
	private JPasswordField infoPwdChT1;
	private JPasswordField infoPwdChT2;
	private JFrame frame;

	
	public InfoFrame(JFrame frame) {  
		
		this.frame = new JFrame();
		MemberManager memberManager = new MemberManager();
		ImagePanel panel4 = new ImagePanel(new ImageIcon("src/images/4.png").getImage());
		frame.add(panel4);		
		frame.pack();
		
		
		JLabel infoNameL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName());
		infoNameL.setFont(new Font("굴림", Font.BOLD, 28));
		infoNameL.setBounds(500, 160, 310, 50);
		panel4.add(infoNameL);
		
		
		JLabel infoBirthDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getBirthDate());
		infoBirthDateL.setFont(new Font("굴림", Font.BOLD, 28));
		infoBirthDateL.setBounds(500, 280, 310, 50);
		panel4.add(infoBirthDateL);
		
		JLabel infoAdrrL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getAdrr());
		infoAdrrL.setFont(new Font("굴림", Font.BOLD, 28));
		infoAdrrL.setBounds(500, 397, 310, 50);
		panel4.add(infoAdrrL);
		
		JLabel infoJoinDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getSignupDate());
		infoJoinDateL.setFont(new Font("굴림", Font.BOLD, 28));
		infoJoinDateL.setBounds(500, 517, 310, 50);
		panel4.add(infoJoinDateL);
		
		JLabel infoRevDateL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getRevDate());
		infoRevDateL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevDateL.setBounds(500, 640, 150, 50);
		panel4.add(infoRevDateL);
		
		JLabel infoRevTimeL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getRevTime());
		infoRevTimeL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevTimeL.setBounds(651, 640, 150, 50);
		panel4.add(infoRevTimeL);
		
		JLabel infoRevPriceL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getPrice() + "원");
		infoRevPriceL.setFont(new Font("굴림", Font.BOLD, 20));
		infoRevPriceL.setBounds(811, 640, 150, 50);
		panel4.add(infoRevPriceL);
		

		JLabel infoMemberla = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");		//회원정보 라벨
		infoMemberla.setFont(new Font("굴림", Font.BOLD, 19));
		infoMemberla.setBounds(1242, 21, 214, 42);
		panel4.add(infoMemberla);
//		infoMemberla.setText(MemberDB.listDB.get(MemberManager.memberNumber).getName() + "님 환영합니다.");
		
	
		
		memberManager.Info();
		
		JButton infoHomeBtn = new JButton(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		
		infoHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
		infoHomeBtn.setBounds(1193, 25, 33, 33);
		infoHomeBtn.setOpaque(false);
		panel4.add(infoHomeBtn);
		
		infoHomeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*비번 변경 페이지로 이동*/
				frame.getContentPane().removeAll();
				AfterLoginFrame alf = new AfterLoginFrame(frame); 
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 infoHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼.png"));
							 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 infoHomeBtn.setIcon(new ImageIcon("src/buttonImages/홈버튼 마우스 엔터.png"));
						 
			 }
			 
		});
		
		
		
		
		
		
		
		infoHomeBtn.addActionListener(new ActionListener() { //비번변경 전 정보확인창 가는 버튼
			public void actionPerformed(ActionEvent e) {
				
				
				frame.getContentPane().removeAll();
				AfterLoginFrame alf = new AfterLoginFrame(frame); 

			
			}
		});
		
		
		JButton infoLogout = new JButton(){//로그아웃 버튼
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};		
		
		infoLogout.setIcon(new ImageIcon("src/buttonImages/로그아웃.png"));
		infoLogout.setBounds(1388, 73, 156, 30);
		panel4.add(infoLogout);
		
		infoLogout.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*비번 변경 이전 정보확인 페이지로 이동*/
				frame.getContentPane().removeAll();
				MemberManager.loginTrue = false;
				LoginFrame loginframe = new LoginFrame(frame);
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 infoLogout.setIcon(new ImageIcon("src/buttonImages/로그아웃.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 infoLogout.setIcon(new ImageIcon("src/buttonImages/로그아웃 마우스 엔터.png"));
			 			 
			 }
			 
		});

		
		JButton pwdchBtn = new JButton(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		pwdchBtn.setIcon(new ImageIcon("src/buttonImages/정보페이지 비번변경.png"));
		pwdchBtn.setBounds(492, 736, 192, 29);
		panel4.add(pwdchBtn);
		pwdchBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*비번 변경 이전 정보확인 페이지로 이동*/
				frame.getContentPane().removeAll();
				BeforeResetPassWord brp = new BeforeResetPassWord(frame);
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 pwdchBtn.setIcon(new ImageIcon("src/buttonImages/정보페이지 비번변경.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 pwdchBtn.setIcon(new ImageIcon("src/buttonImages/정보페이지 비번변경 마우스 엔터.png"));
			 
			 
			 }
			 
		});
		
		JButton memberDelBtn = new JButton(){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};		
		memberDelBtn.setIcon(new ImageIcon("src/buttonImages/회원탈퇴.png"));
		memberDelBtn.setBounds(913, 736, 129, 29);
		panel4.add(memberDelBtn);		
		memberDelBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*비번 변경 이전 정보확인 페이지로 이동*/
				frame.getContentPane().removeAll();
				MembershipQuit mq = new MembershipQuit(frame);
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 memberDelBtn.setIcon(new ImageIcon("src/buttonImages/회원탈퇴.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 memberDelBtn.setIcon(new ImageIcon("src/buttonImages/회원탈퇴 마우스 엔터.png"));
			 
			 
			 }
			 
		});

		
		JButton cancelBookBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};		
		cancelBookBtn.setIcon(new ImageIcon("src/buttonImages/예약취소.png"));
		cancelBookBtn.setBounds(973, 640, 140, 50);
		panel4.add(cancelBookBtn);
		
		cancelBookBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*예약 정보 취소하고 "없음"으로 만듦*/
				memberManager.resvervationCancel();
				infoRevDateL.setText("없음");
				infoRevTimeL.setText("없음");
				infoRevPriceL.setText("없음");
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 cancelBookBtn.setIcon(new ImageIcon("src/buttonImages/예약취소.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 cancelBookBtn.setIcon(new ImageIcon("src/buttonImages/예약취소 마우스 엔터.png"));
			 
			 
			 }
			 
		});

	}





}