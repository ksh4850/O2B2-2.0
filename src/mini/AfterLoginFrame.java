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
import javax.swing.JLabel;
import javax.swing.border.Border;

public class AfterLoginFrame {//이니셜 3이었던 부분
	
	private JFrame frame;
	
	public AfterLoginFrame(JFrame frame) {
		
		this.frame = new JFrame();
		ImagePanel panel2 = new ImagePanel(new ImageIcon("src/Images/2.png").getImage());
		frame.getContentPane().add(panel2);
		frame.pack();
		
		/* 로그인한 멤버의 이름 출력하는 라벨 */
		JLabel homeMemberL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName());
		homeMemberL.setFont(new Font("굴림", Font.BOLD, 28));
		homeMemberL.setForeground(Color.WHITE);
		homeMemberL.setBounds(255, 530, 362, 32);
		panel2.add(homeMemberL);
		
		
		JButton homeRevBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		homeRevBtn.setIcon(new ImageIcon("src/buttonImages/예약하기.png"));
		homeRevBtn.setOpaque(false);
		homeRevBtn.setBounds(92, 630, 277, 62);
		panel2.add(homeRevBtn);
		
		homeRevBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*회원 가입 페이지로 이동*/
				frame.getContentPane().removeAll();
				ReservationFrame rf = new ReservationFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 homeRevBtn.setIcon(new ImageIcon("src/buttonImages/예약하기.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 homeRevBtn.setIcon(new ImageIcon("src/buttonImages/예약하기 마우스 엔터.png"));
				 
			 }
		
		});

		JButton homeinfoBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		homeinfoBtn.setIcon(new ImageIcon("src/buttonImages/회원정보.png"));
		homeinfoBtn.setOpaque(false);
		homeinfoBtn.setBounds(381, 631, 277, 62);
		panel2.add(homeinfoBtn);
		
		homeinfoBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*회원 정보 페이지로 이동*/
				frame.getContentPane().removeAll();
				InfoFrame infoframe = new InfoFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 homeinfoBtn.setIcon(new ImageIcon("src/buttonImages/회원정보.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 homeinfoBtn.setIcon(new ImageIcon("src/buttonImages/회원정보 마우스 엔터.png"));
				 
			 }
		
		});

		JButton homeLogoutBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/홈로그아웃.png"));
		homeLogoutBtn.setOpaque(false);
		homeLogoutBtn.setBounds(64, 696, 158, 59);
		panel2.add(homeLogoutBtn);
		
		homeLogoutBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*메인 로그인 페이지로 이동*/
				frame.getContentPane().removeAll();
				MemberManager.loginTrue = false;
				LoginFrame lf = new LoginFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/홈로그아웃.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/홈로그아웃 마우스 엔터.png"));
				 
			 }
		
		});
		
		
		
		
		
		
		/* 로그아웃 버튼 라벨처리 */
		
		JLabel homeLogoutLabel = new JLabel("");
		homeLogoutLabel.setBounds(101, 698, 154, 37);
		panel2.add(homeLogoutLabel);
		homeLogoutLabel.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {//클릭시 개인정보 페이지로 이동
			
				frame.getContentPane().removeAll();
				LoginFrame lf = new LoginFrame(frame);
					
			}
			
		});
		
		
	}
}