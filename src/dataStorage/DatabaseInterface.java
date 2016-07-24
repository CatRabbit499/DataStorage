package dataStorage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DatabaseInterface{
	public static int height = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
	public static int width = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static boolean isUHD = false;
	
	public static void derp(){
		if(width > 1920 && height > 1080) isUHD = true;
		// Upper label panel
		JLabel upperButtonPanelLabel = new JLabel();
			if(isUHD) upperButtonPanelLabel.setFont(new Font("Arial", Font.PLAIN, 40));
			upperButtonPanelLabel.setText("Label Text OMG");
		JPanel upperLabelPanel = new JPanel();
			upperLabelPanel.setSize(width/4, height/4);
			upperLabelPanel.add(upperButtonPanelLabel);
		// Lower button panel
		JButton lowerButtonPanelButton = new JButton();
			lowerButtonPanelButton.setText("Click the button!");
			if(isUHD) lowerButtonPanelButton.setFont(new Font("Arial", Font.PLAIN, 40));
		JPanel lowerButtonPanel = new JPanel();
			lowerButtonPanel.setSize(width/4, height/4);
			lowerButtonPanel.add(lowerButtonPanelButton);
		// Main frame
		JFrame mainFrame = new JFrame("Cuttlefish Database Interface");
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.add(lowerButtonPanel, BorderLayout.SOUTH);
			mainFrame.add(upperLabelPanel, BorderLayout.NORTH);
			mainFrame.setLocation(width/4, height/4);
			mainFrame.setSize(width/2, height/2);
			mainFrame.setVisible(true);
	}
}
