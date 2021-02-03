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

public class ManagerFrame {
	
	private JFrame frame;
	
	
	public ManagerFrame(JFrame frame) {//마스터게정 관리자 페이지
		
		this.frame = new JFrame();
		
		ImagePanel panel7 = new ImagePanel(new ImageIcon("src/Images/M.png").getImage());
		frame.getContentPane().add(panel7);
		frame.pack();

		JLabel masterMemberL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName());
		masterMemberL.setFont(new Font("굴림", Font.BOLD, 28));
		masterMemberL.setForeground(Color.WHITE);
		masterMemberL.setBounds(255, 530, 362, 32);
		panel7.add(masterMemberL);
		
		
		
		JButton homeLogoutBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};		
		homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/홈로그아웃.png"));
		homeLogoutBtn.setOpaque(false);
		homeLogoutBtn.setBounds(75, 722, 158, 59);
		panel7.add(homeLogoutBtn);
		
		homeLogoutBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*메인 로그인 페이지로 이동*/
				frame.getContentPane().removeAll();
				LoginFrame lf = new LoginFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/홈로그아웃.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 homeLogoutBtn.setIcon(new ImageIcon("src/buttonImages/홈로그아웃 마우스 엔터.png"));
				 
			 }
		
		});
		
		
		JButton checkRevBtn = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};		
		checkRevBtn.setIcon(new ImageIcon("src/buttonImages/예약현황.png"));
		checkRevBtn.setOpaque(false);
		checkRevBtn.setBounds(95, 645, 566, 62);
		panel7.add(checkRevBtn);
		
		checkRevBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*예약 확인 페이지만들어야함*/
				frame.getContentPane().removeAll();				
				MasterReservationCheck mrc = new MasterReservationCheck(frame);
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 checkRevBtn.setIcon(new ImageIcon("src/buttonImages/예약현황.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 checkRevBtn.setIcon(new ImageIcon("src/buttonImages/예약현황 마우스 엔터.png"));
				 
			 }
		
		});

		
	}
	

	
}
