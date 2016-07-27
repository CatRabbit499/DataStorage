package dataStorage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DatabaseInterface{
	public static final int HEIGHT = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
	public static final int WIDTH = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static final ImageIcon BG_IMG = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Cuttlefish.jpg"));
	public static final boolean isUHD = WIDTH > 1920 && HEIGHT > 1080;
	
	public static void derp(){
		// Upper label panel
		JLabel upperButtonPanelLabel = new JLabel();
			if(isUHD) upperButtonPanelLabel.setFont(new Font("Arial", Font.PLAIN, 40));
			upperButtonPanelLabel.setText("Label Text OMG");
		JPanel upperLabelPanel = new JPanel();
			upperLabelPanel.setSize(WIDTH/4, HEIGHT/4);
			upperLabelPanel.add(upperButtonPanelLabel);
			upperLabelPanel.setBackground(Color.GRAY);
			
		// Background image
		JLabel backgroundImageLabel = new JLabel(BG_IMG);
			backgroundImageLabel.setIcon(new ImageIcon(BG_IMG.getImage().getScaledInstance(WIDTH/3, HEIGHT/3, Image.SCALE_DEFAULT)));
		JPanel backgroundPanel = new JPanel();
			backgroundPanel.add(backgroundImageLabel);	
			
		// Lower button panel
		JButton lowerButtonPanelButton = new JButton();
			lowerButtonPanelButton.setText("Click the button!");
			if(isUHD) lowerButtonPanelButton.setFont(new Font("Arial", Font.PLAIN, 40));
		JPanel lowerButtonPanel = new JPanel();
			lowerButtonPanel.setSize(WIDTH/4, HEIGHT/4);
			lowerButtonPanel.add(lowerButtonPanelButton);
			
		// Main frame
		JFrame mainFrame = new JFrame("Cuttlefish Database Interface");
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.add(backgroundPanel, BorderLayout.CENTER);
			mainFrame.add(lowerButtonPanel, BorderLayout.SOUTH);
			mainFrame.add(upperLabelPanel, BorderLayout.NORTH);
			mainFrame.setLocation(WIDTH/4, HEIGHT/4);
			mainFrame.setSize(WIDTH/2, HEIGHT/2);
			mainFrame.setVisible(true);
	}
}
