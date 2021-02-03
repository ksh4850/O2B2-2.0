package mini;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.Border;


public class ReservationFrame  {
   
   
   private String revTime ;
   private int revPrice;
   private JLabel rvePriceL = new JLabel();
   private JFrame frame;
   boolean isTime;

   public ReservationFrame(JFrame frame) {
      
      this.frame = new JFrame();
      ImagePanel panel6 = new ImagePanel(new ImageIcon("src/images/6.png").getImage());
      frame.add(panel6);
      frame.pack();
      
      JLabel revMemberL = new JLabel(MemberDB.listDB.get(MemberManager.memberNumber).getName());
      revMemberL.setFont(new Font("굴림", Font.BOLD, 28));
      revMemberL.setBounds(1310, 28, 224, 32);
      panel6.add(revMemberL);
      
      rvePriceL = new JLabel();
      rvePriceL.setFont(new Font("굴림", Font.BOLD, 25));
      rvePriceL.setBounds(1406, 670, 130, 32);
      panel6.add(rvePriceL);
      
      //============================미용가격 체크 박스 버튼 ========================
      
      JCheckBox[] revPriceCk = new JCheckBox[8]; 
      
      for(int i = 0 ; i < 8 ; i++) {
         revPriceCk[i] = new JCheckBox("");
         panel6.add(revPriceCk[i]);
      }
      
      revPriceCk[0].setBounds(1231, 213, 21, 23);
      revPriceCk[1].setBounds(1231, 261, 21, 23);
      revPriceCk[2].setBounds(1232, 305, 21, 23);
      revPriceCk[3].setBounds(1231, 360, 21, 23);
      revPriceCk[4].setBounds(1232, 409, 21, 23);
      revPriceCk[5].setBounds(1232, 459, 21, 23);
      revPriceCk[6].setBounds(1232, 506, 21, 23);
      revPriceCk[7].setBounds(1232, 550, 21, 23);
                  
      revPriceCk[7].setSelected(true);
      
      int[] price = {10 , 30, 25, 110, 110, 70, 130, 0};
      
      
      for(int i = 0 ; i < revPriceCk.length ; i++) {
      
         revPriceCk[i].addItemListener(new ItemListener() {   
            
            
            @Override
            public void itemStateChanged(ItemEvent e) {
               int sum  = 0;
               for(int i = 0 ; i < revPriceCk.length ; i++) {
                     
                  if(revPriceCk[i].isSelected()) {
                     sum += price[i];
                  }
               }
               
               
               if(sum==0) {
                  
                  rvePriceL.setText("0");
                  
               } else {
                  
                  rvePriceL.setText(sum + ",000원");
               }
               
               revPrice = sum;
            }
               
            });
         }   
         

      
      //============================예약시간 라디오 버튼 ==============================

      
      ButtonGroup group = new ButtonGroup();
      JRadioButton[] rveTimebtn = new JRadioButton[6];
      
      for(int i = 0 ; i < rveTimebtn.length ; i++) {
         rveTimebtn[i] = new JRadioButton("");
         group.add(rveTimebtn[i]);
         panel6.add(rveTimebtn[i]);
         
      }
      
      rveTimebtn[0].setBounds(387, 707, 22, 23);
      rveTimebtn[1].setBounds(611, 707, 22, 23);
      rveTimebtn[2].setBounds(840, 707, 22, 23);
      rveTimebtn[3].setBounds(387, 781, 22, 23);
      rveTimebtn[4].setBounds(611, 781, 22, 23);
      rveTimebtn[5].setBounds(840, 781, 22, 23);
      
      for(int i = 0 ; i < rveTimebtn.length ; i++) {
      
      rveTimebtn[i].addActionListener(new ActionListener() {
         
         @Override
         public void actionPerformed(ActionEvent e) {
            
            
            if(rveTimebtn[0].isSelected()) {
               rveTimebtn[0].setActionCommand("10시"); 
               
            }else if(rveTimebtn[1].isSelected()) {
               rveTimebtn[1].setActionCommand("11시");
               
            }else if(rveTimebtn[2].isSelected()) {
               rveTimebtn[2].setActionCommand("12시");
               
            }else if(rveTimebtn[3].isSelected()) {
               rveTimebtn[3].setActionCommand("2시");
               
            }else if(rveTimebtn[4].isSelected()) {
               rveTimebtn[4].setActionCommand("3시");
               
            }else if(rveTimebtn[5].isSelected()) {
               rveTimebtn[5].setActionCommand("4시");
            }
               
            revTime = group.getSelection().getActionCommand();
            System.out.println(revTime);
            boolean isTrue = false;
            for(int i = 0 ; i < MemberDB.listDB.size() ; i++ ) {
               if(MemberDB.listDB.get(i).getRevTime().equals(revTime)) {
                  isTrue = true;
               }
            }
            
            if(isTrue) {
               JOptionPane.showInternalMessageDialog(null, "이미 예약된시간입니다. 다른시간에 예약 부닥드립니다.");
               isTime = false;
            }else {
               JOptionPane.showInternalMessageDialog(null, "예약 가능한 시간입니다.");
               isTime = true;
            }
         }
      });
      }
      
   
      /* 예약페이지 홈버튼 */
      JButton reserveHomeBtn = new JButton(""){
         
          @Override public void setBorder(Border border) {
              // 테두리 없애기
             
          }
      };
      
      reserveHomeBtn.setIcon(new ImageIcon("src/buttonImages/예약페이지 홈버튼.png"));
      reserveHomeBtn.setBounds(1196, 28, 25, 29);
      reserveHomeBtn.setContentAreaFilled(false);
      panel6.add(reserveHomeBtn);
      
      reserveHomeBtn.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            
            frame.getContentPane().removeAll();
            AfterLoginFrame alf = new AfterLoginFrame(frame);
         }
         
          public void mouseExited(MouseEvent e) { 
             
             reserveHomeBtn.setIcon(new ImageIcon("src/buttonImages/예약페이지 홈버튼.png"));
             
             
          }

          public void mouseEntered(MouseEvent e) { 
             
             reserveHomeBtn.setIcon(new ImageIcon("src/buttonImages/예약페이지 홈버튼 마우스 엔터.png"));
             
          }
      
      });

      
      JButton reserveResvervationBtn = new JButton(""){
         
          @Override public void setBorder(Border border) {
              // 테두리 없애기
             
          }
      };
            
      reserveResvervationBtn.setIcon(new ImageIcon("src/buttonImages/예약페이지 예약하기.png"));
      reserveResvervationBtn.setBounds(1234, 790, 337, 62);
      reserveResvervationBtn.setOpaque(false);
      panel6.add(reserveResvervationBtn);
      
      reserveResvervationBtn.addMouseListener(new MouseAdapter() {

         @Override
         public void mouseClicked(MouseEvent e) {
            
//            revTime = bg2.getSelection().getActionCommand();
//            revTime = bg.getSelection().getActionCommand();

            
            System.out.println(revTime);
//            || revTime.equals("선택되지 않음") 
            if(revTime == null || revPrice==0 ) {
               
               JOptionPane.showMessageDialog(null, "시간 혹은 메뉴를 선택하지 않으셨습니다. ");
                           
            } else {
               
//               MemberManager membermanager = new MemberManager();
////               revPrice = 0;
////               revTime = "선택되지 않음";
               if(isTime && revPrice != 0) { 
                  
                  
                  
                  //JOptionPane.showConfirmDialog(null, "경고 메시지 + 예/아니오 옵션", "제목표시줄", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
                  
                  int choose=JOptionPane.showConfirmDialog(null,"예약하시겠습니까?","예약 확인창입니다",JOptionPane.YES_NO_OPTION);
                  if(isTime && choose==JOptionPane.YES_OPTION){
                     
                     MemberManager membermanager = new MemberManager();
                     membermanager.resvervation(revPrice, revTime);
                     
                     /*예약 페이지로 이동*/
                     frame.getContentPane().removeAll();
                     InfoFrame iff = new InfoFrame(frame);
                     
                  }else if(choose==JOptionPane.NO_OPTION){}
                  
               }
               else {
                  
                  JOptionPane.showMessageDialog(null, "이미 예약된 시간입니다.\n 다른 시간을 선택해주세요.");
//                  
               }
               
            }

         }
         
          public void mouseExited(MouseEvent e) { 
             
             reserveResvervationBtn.setIcon(new ImageIcon("src/buttonImages/예약페이지 예약하기.png"));
             
          }

          public void mouseEntered(MouseEvent e) { 
             
             reserveResvervationBtn.setIcon(new ImageIcon("src/buttonImages/예약페이지 예약하기 마우스 엔터.png"));
             
          }
      
      });
   
   }

}