package dataStorage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class DatabaseInterface{
//	public static final int HEIGHT = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
//	public static final int WIDTH = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static final int HEIGHT = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
	public static final int WIDTH = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static final ImageIcon BG_IMG = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Cuttlefish.jpg"));
	public static final int BG_IMG_W = BG_IMG.getIconWidth();
	public static final int BG_IMG_H = BG_IMG.getIconWidth();
	public static final boolean isUHD = WIDTH > 1920 && HEIGHT > 1080;
	
	public static void derp(){
		
		// Upper label panel
		JLabel upperLabelPanelLabel = new JLabel();
			if(isUHD) upperLabelPanelLabel.setFont(new Font("Arial", Font.PLAIN, 40));
			upperLabelPanelLabel.setText("Label Text OMG");
		JPanel upperLabelPanel = new JPanel();
			upperLabelPanel.setSize(WIDTH/4, HEIGHT/4);
			upperLabelPanel.add(upperLabelPanelLabel);
			upperLabelPanel.setBackground(Color.GRAY);
			
		// Lower button panel
		JButton lowerButtonPanelButton = new JButton();
			lowerButtonPanelButton.setText("Click the button!");
			if(isUHD) lowerButtonPanelButton.setFont(new Font("Arial", Font.PLAIN, 40));
		JPanel lowerButtonPanel = new JPanel();
			lowerButtonPanel.setSize(WIDTH/4, HEIGHT/4);
			lowerButtonPanel.add(lowerButtonPanelButton);

		// Background image
		JLabel backgroundLabel = new JLabel();
			//backgroundLabel.setIcon(new ImageIcon(BG_IMG.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
			backgroundLabel.setIcon(BG_IMG);
			backgroundLabel.setSize(BG_IMG_W, BG_IMG_H);
		JPanel backgroundPanel = new JPanel();
			backgroundPanel.add(backgroundLabel);
			backgroundPanel.setSize(BG_IMG_W, BG_IMG_H);
		
		// Panel 1 test
		JPanel panelTest = new JPanel();
			panelTest.add(upperLabelPanel, BorderLayout.NORTH);
			panelTest.add(lowerButtonPanel, BorderLayout.SOUTH);
			panelTest.setSize(BG_IMG_W, BG_IMG_H);
			panelTest.setOpaque(false);
			
		// Main content pane
		JLayeredPane mainContentPane = new JLayeredPane();
			mainContentPane.add(backgroundPanel, new Integer(1));
			mainContentPane.add(panelTest, new Integer(2));
			//mainContentPane.add(iFrame, new Integer(3));
		
		// Internal frame test
		JInternalFrame iFrame = new JInternalFrame();
		JDesktopPane desktop = new JDesktopPane();
			desktop.add(iFrame);
		JPanel panel = new JPanel(new BorderLayout());
			panel.setBorder(new TitledBorder("DesktopPane"));
			panel.add(desktop);
			
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
