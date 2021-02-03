package mini;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

public class MembershipQuit {

	private JFrame frame;
	
	
	public MembershipQuit(JFrame frame) {
		
		
		ImagePanel panel5 = new ImagePanel(new ImageIcon("src/images/5.png").getImage());
		frame.add(panel5);
		frame.pack();
		
		JButton pwdYes = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		pwdYes.setIcon(new ImageIcon("src/buttonImages/예.png"));
		pwdYes.setBounds(530, 487, 211, 67);
		panel5.add(pwdYes);
		
		pwdYes.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				MemberManager memberManager = new MemberManager();
				memberManager.MemberDelete();
				
				frame.getContentPane().removeAll();
				LoginFrame loginframe = new LoginFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 pwdYes.setIcon(new ImageIcon("src/buttonImages/예.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 pwdYes.setIcon(new ImageIcon("src/buttonImages/예 마우스 엔터.png"));
				 
			 }
		
		});
		
		
		JButton pwdNo = new JButton(""){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
		pwdNo.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
		pwdNo.setBounds(845, 487, 211, 67);
		panel5.add(pwdNo);
		
		
		pwdNo.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showInternalMessageDialog(null, "발전하는 O2B2가 되겠습니다.");
				frame.getContentPane().removeAll();
				InfoFrame iff = new InfoFrame(frame);
				
			}
			
			 public void mouseExited(MouseEvent e) { 
				 
				 pwdNo.setIcon(new ImageIcon("src/buttonImages/아니요.png"));
				 
				 
			 }

			 public void mouseEntered(MouseEvent e) { 
				 
				 pwdNo.setIcon(new ImageIcon("src/buttonImages/아니요 마우스 엔터.png"));
				 
			 }
		
		});
		

	}
	
}
