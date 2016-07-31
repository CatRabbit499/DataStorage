package dataStorage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class DatabaseInterface{
	public static final int HEIGHT = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
	public static final int WIDTH = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static final ImageIcon BG_IMG = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Cuttlefish.jpg"));
	public static final int BG_IMG_W = BG_IMG.getIconWidth();
	public static final int BG_IMG_H = BG_IMG.getIconWidth();
	public static final boolean isUHD = WIDTH > 1920 && HEIGHT > 1080;
	
	public static void derp(){
		
		// Layer 1 panel
		JButton buttonOne = new JButton();
			buttonOne.setText("Click the button!");
			if(isUHD) buttonOne.setFont(new Font("Arial", Font.PLAIN, 40));
		JLabel labelOne = new JLabel();
			labelOne.setText("<html><font color='black'>Label Text OMG</font></html>");
			if(isUHD) labelOne.setFont(new Font("Verdana", Font.PLAIN, 40));
			labelOne.setBackground(Color.DARK_GRAY);
			labelOne.setOpaque(true);
		JPanel layerOnePanel = new JPanel();
			layerOnePanel.setLayout(new BorderLayout());
			layerOnePanel.setSize(BG_IMG_W, BG_IMG_H - (1000 * labelOne.getHeight()));
			layerOnePanel.add(labelOne, BorderLayout.SOUTH);
			layerOnePanel.setBackground(Color.GRAY);

		// Background image
		JLabel backgroundLabel = new JLabel();
			//backgroundLabel.setIcon(new ImageIcon(BG_IMG.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
			backgroundLabel.setIcon(BG_IMG);
			backgroundLabel.setSize(BG_IMG_W, BG_IMG_H);
		JPanel backgroundPanel = new JPanel();
			backgroundPanel.add(backgroundLabel);
			backgroundPanel.setSize(BG_IMG_W, BG_IMG_H);
		
		// Main content pane
		JLayeredPane mainContentPane = new JLayeredPane();
			mainContentPane.add(backgroundPanel, new Integer(1));
			mainContentPane.add(layerOnePanel, new Integer(2));
		
		// Main frame
		JFrame mainFrame = new JFrame("Cuttlefish Database Interface");
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setSize(BG_IMG.getIconWidth(), BG_IMG.getIconHeight() + (BG_IMG.getIconHeight() / 15));
			//System.out.println(BG_IMG.getIconWidth() +", "+ BG_IMG.getIconHeight());
			//System.out.println(mainFrame.getWidth() + ", " + mainFrame.getHeight());
			mainFrame.setContentPane(mainContentPane);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setVisible(true);
	}
}
