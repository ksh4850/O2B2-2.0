package mini;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import java.awt.Font;
import java.awt.Graphics;

public class MasterReservationCheck {
  
   public JFrame frame ;
   private JTable ReserveInfoTable;
   ImageIcon icon;  
   
   public MasterReservationCheck(JFrame frame) {
	  
	   icon = new ImageIcon("src/Images/11.png");
	   
	   
	  JPanel panel11 = new JPanel() {
		  
		  public void paintComponent(Graphics g) {
			  
			  g.drawImage(icon.getImage(), 0,0,null);
			  
			  
			  setOpaque(false);
			  super.paintComponent(g);
			  
			  
		  }
		  
	  };
      
      this.frame = new JFrame();      
	  frame.getContentPane().add(panel11);
      frame.setPreferredSize(new Dimension(1600,900));
	  frame.pack();
	  

      
      String[] headings = {"ID", "이름 ", "생년월일", "성별", "가입일", "예약시간" , "금액", "주소"};
      int index =  0;
      
      for(int i = 0 ; i < MemberDB.listDB.size() ; i++) {
         if( !(MemberDB.listDB.get(i).getRevTime().equals("없음"))) {
            index++; 
         }
      }
      
      Object[][] reservation = new Object[index][8];

      int j = 0;
      for(int i = 0 ; i < MemberDB.listDB.size() ; i ++ ) {
         
         if( !(MemberDB.listDB.get(i).getRevTime().equals("없음"))) {
        	 	
        	 
        	   reservation[j][0] = MemberDB.listDB.get(i).getId();
               reservation[j][1] = MemberDB.listDB.get(i).getName();
               reservation[j][2] = MemberDB.listDB.get(i).getBirthDate();
               reservation[j][3] = MemberDB.listDB.get(i).getGender();
               reservation[j][4] = MemberDB.listDB.get(i).getSignupDate();
               reservation[j][5] = MemberDB.listDB.get(i).getRevTime();
               reservation[j][6] = MemberDB.listDB.get(i).getPrice();
               reservation[j][7] = MemberDB.listDB.get(i).getAdrr();
               
               j++;
            
         }
      }
      ReserveInfoTable = new JTable(reservation,headings);
      ReserveInfoTable.setFont(new Font("굴림", Font.PLAIN, 13));
      ReserveInfoTable.setBounds(1, 27, 500, 0);
      panel11.add(ReserveInfoTable);
      
      ReserveInfoTable.setVisible(true);
      panel11.setLayout(null);
      

      ReserveInfoTable.setPreferredScrollableViewportSize(new Dimension(500, 500));
      
      
      JScrollPane scrollPane = new JScrollPane(ReserveInfoTable);
      scrollPane.setBounds(328, 91, 905, 528);
      panel11.add(scrollPane);
      
      JButton HomeBtn = new JButton("New button"){
			
		    @Override public void setBorder(Border border) {
		        // 테두리 없애기
		    	
		    }
		};
      HomeBtn.setForeground(Color.BLACK);
      HomeBtn.setBounds(1485, 28, 71, 61);
      HomeBtn.setIcon(new ImageIcon("src/buttonImages/admin home.png"));
      panel11.add(HomeBtn);
      HomeBtn.setOpaque(false);
      HomeBtn.setContentAreaFilled(false);
      HomeBtn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*로그인 페이지로 이동*/
				frame.getContentPane().removeAll();
				MemberManager.loginTrue = false;
				ManagerFrame mf = new ManagerFrame(frame);
			}
			
			 public void mouseExited(MouseEvent e) { 
//				 
				 HomeBtn.setIcon(new ImageIcon("src/buttonImages/admin home.png"));
//				 
//				 
			 }
//
			 public void mouseEntered(MouseEvent e) { 
//				 
				 HomeBtn.setIcon(new ImageIcon("src/buttonImages/admin home mouse enter.png"));
//			 
//			 
			 }
			 
		});
      

      
      
      
      
      
      
      
      
      

   
      
      
   }
}