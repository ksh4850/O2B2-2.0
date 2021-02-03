package mini;


import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class JFrame1{
	
	
	public JFrame1() {
		
		JFrame frame = new JFrame("안녕하세요 O2B2 헤어샵입니다.");
		frame.setBounds(100, 100, 1600, 900);
		frame.setPreferredSize(new Dimension(1600,900));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		Image image = null; 
		try { image = ImageIO.read(new File("src/Images/fabicon.png")); 
		
		} catch (IOException e) {
			
			e.printStackTrace(); 
		
		} frame.setIconImage(image);

		
		
		
		LoginFrame lf = new LoginFrame(frame);
		
	}

}
