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
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class DatabaseInterface{
	public static final int HEIGHT = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
	public static final int WIDTH = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static final ImageIcon BG_IMG = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Cuttlefish.jpg"));
	public static final Font FONT = new Font("Verdana", Font.PLAIN, 40);
	public static final int BG_IMG_W = BG_IMG.getIconWidth();
	public static final int BG_IMG_H = BG_IMG.getIconHeight();
	public static final boolean isUHD = WIDTH > 1920 && HEIGHT > 1080;
	private static final int CENTER = 0;
	public static int PAD_U = 9001;
	public static int PAD_D = 9001;
	public static int PAD_L = 9001;
	public static int PAD_R = 9001;
	
	public static void derp(){
		
		// Jframe derp
		JFrame derp = new JFrame();
			derp.setLocation(-WIDTH,-HEIGHT);
			derp.setVisible(true);
			PAD_U = derp.getInsets().top;
			PAD_D = derp.getInsets().bottom;
			PAD_L = derp.getInsets().left;
			PAD_R = derp.getInsets().right;
			
			derp.setVisible(false);
			derp.dispose();
	
		// Menu bar
		JMenu cuttefishMenu = new JMenu(genHTML("Cuttlefish", "Verdana", "black", 40));
		JMenuItem cuttlefish1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
		JMenuItem cuttlefish2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
		JMenuItem cuttlefish3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
		JMenuItem cuttlefish4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			cuttefishMenu.add(cuttlefish1);
			cuttefishMenu.add(cuttlefish2);
			cuttefishMenu.add(cuttlefish3);
			cuttefishMenu.add(cuttlefish4);
		JMenu fileMenu = new JMenu(genHTML("File", "Verdana", "black", 40));
		JMenuItem file1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
		JMenuItem file2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
		JMenuItem file3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
		JMenuItem file4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			fileMenu.add(file1);
			fileMenu.add(file2);
			fileMenu.add(file3);
			fileMenu.add(file4);
			
		JMenu editMenu = new JMenu(genHTML("Edit", "Verdana", "black", 40));
		JMenuItem edit1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
		JMenuItem edit2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
		JMenuItem edit3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
		JMenuItem edit4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			editMenu.add(edit1);
			editMenu.add(edit2);
			editMenu.add(edit3);
			editMenu.add(edit4);
		JMenu viewMenu = new JMenu(genHTML("View", "Verdana", "black", 40));
		JMenuItem view1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
		JMenuItem view2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
		JMenuItem view3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
		JMenuItem view4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			viewMenu.add(view1);
			viewMenu.add(view2);
			viewMenu.add(view3);
			viewMenu.add(view4);
			
		JMenuBar jmb = new JMenuBar();
			jmb.add(cuttefishMenu);
			jmb.add(fileMenu);
			jmb.add(editMenu);
			jmb.add(viewMenu);
			jmb.setVisible(true);
			
		// Layer 1 panel
		JButton buttonOne = new JButton(genHTML("Click the button!", "Verdana", "black", 40));
			if(isUHD) buttonOne.setFont(FONT);
		JLabel label = new JLabel(genHTML("Label text OMG", "Verdana", "black", 40));
			if(isUHD) label.setFont(FONT);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setOpaque(true);
		JPanel layerOnePanel = new JPanel();
			layerOnePanel.setLayout(new BorderLayout());
			layerOnePanel.setSize(BG_IMG_W, BG_IMG_H);
			layerOnePanel.add(jmb, BorderLayout.NORTH);
			layerOnePanel.setBackground(Color.GRAY);

		// Background image
		JLabel backgroundLabel = new JLabel();
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
		JFrame mainFrame = new JFrame();
			mainFrame.setFont(FONT);
			mainFrame.setTitle("Cuttlefish Database Interface");
			mainFrame.setIconImage(new ImageIcon(BG_IMG.getImage().getScaledInstance(3840, 2160, Image.SCALE_DEFAULT)).getImage());
			mainFrame.setSize(BG_IMG.getIconWidth(), BG_IMG.getIconHeight() + (BG_IMG.getIconHeight() / 15));
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setContentPane(mainContentPane);
			mainFrame.setLocationRelativeTo(null);
			mainFrame.setVisible(true);
	}
	
	public static String genHTML(String text, String face, String color, int size){
		return("<html><font face='"+ face +"' color='"+ color +"' size='"+ size +"'>"+ text +"</font></html>");
	}
}
