package dataStorage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class DatabaseInterface{
	public static final int HEIGHT = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight())).intValue());
	public static final int WIDTH = Integer.valueOf(new Long(Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth())).intValue());
	public static final ImageIcon BG_IMG = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Cuttlefish.jpg"));
	public static final Font FONT = new Font("Verdana", Font.PLAIN, 40);
	public static final boolean isUHD = WIDTH > 1920 && HEIGHT > 1080;
	public static ClassFileWriter cfl = new ClassFileWriter();
	public static final int BG_IMG_H = BG_IMG.getIconHeight();
	public static final int BG_IMG_W = BG_IMG.getIconWidth();
	public static final int CENTER = 0;
	public static int PAD_U = 9001;
	public static int PAD_D = 9001;
	public static int PAD_L = 9001;
	public static int PAD_R = 9001;
	
	public static void derp() throws IOException{
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
			cuttlefish1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem cuttlefish2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
			cuttlefish2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem cuttlefish3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
			cuttlefish3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem cuttlefish4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			cuttlefish4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
			cuttefishMenu.add(cuttlefish1);
			cuttefishMenu.add(cuttlefish2);
			cuttefishMenu.add(cuttlefish3);
			cuttefishMenu.add(cuttlefish4);
		JMenu fileMenu = new JMenu(genHTML("File", "Verdana", "black", 40));
		JMenuItem file1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
			file1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem file2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
			file2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem file3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
			file3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem file4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			file4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
			fileMenu.add(file1);
			fileMenu.add(file2);
			fileMenu.add(file3);
			fileMenu.add(file4);
			
		JMenu editMenu = new JMenu(genHTML("Edit", "Verdana", "black", 40));
		JMenuItem edit1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
			edit1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem edit2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
			edit2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem edit3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
			edit3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem edit4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			edit4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
			editMenu.add(edit1);
			editMenu.add(edit2);
			editMenu.add(edit3);
			editMenu.add(edit4);
		JMenu viewMenu = new JMenu(genHTML("View", "Verdana", "black", 40));
		JMenuItem view1 = new JMenuItem(genHTML("Item 1", "Verdana", "black", 40));
			view1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem view2 = new JMenuItem(genHTML("Item 2", "Verdana", "black", 40));
			view2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem view3 = new JMenuItem(genHTML("Item 3", "Verdana", "black", 40));
			view3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JMenuItem view4 = new JMenuItem(genHTML("Item 4", "Verdana", "black", 40));
			view4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
			viewMenu.add(view1);
			viewMenu.add(view2);
			viewMenu.add(view3);
			viewMenu.add(view4);
			
		JMenuBar jmb = new JMenuBar();
			JMenu[] menus = {cuttefishMenu, fileMenu, editMenu, viewMenu};
			for(JMenu j : menus) jmb.add(j);
			
		// Layer 1 panel
		JLabel l1 = new JLabel("ID");
		JTextField t1 = new JTextField(15);
		JLabel l2 = new JLabel("Teacher");
		JTextField t2 = new JTextField(15);	
		JLabel l3 = new JLabel("Supervisor");
		JTextField t3 = new JTextField(15);	
		// TODO Make expandable classes section	
		if(isUHD){
			l1.setFont(FONT);
			t1.setFont(FONT);
			l2.setFont(FONT);
			t2.setFont(FONT);
			l3.setFont(FONT);
			t3.setFont(FONT);
		}
		
		SpringLayout sl = new SpringLayout();
		JPanel cLayer1Content = new JPanel();
			cLayer1Content.setLayout(sl);
			cLayer1Content.add(l1);
			
			// ID
			sl.putConstraint(SpringLayout.WEST, l1, BG_IMG.getIconWidth()/4, SpringLayout.WEST, cLayer1Content); // L Label -> L Panel
			sl.putConstraint(SpringLayout.NORTH, l1, 25, SpringLayout.NORTH, cLayer1Content);                    // T Label -> T Panel
			sl.putConstraint(SpringLayout.NORTH, t1, 25, SpringLayout.NORTH, cLayer1Content);                    // T Field -> T Panel	
			sl.putConstraint(SpringLayout.WEST, t1, 20, SpringLayout.EAST, l1);                                  // R Field -> L Label
			
			// Teacher
			cLayer1Content.add(t2);
			cLayer1Content.add(t2);
			
			sl.putConstraint(SpringLayout.WEST, l2, BG_IMG.getIconWidth()/4, SpringLayout.WEST, cLayer1Content); // L Label -> L Panel
			sl.putConstraint(SpringLayout.NORTH, l2, 25, SpringLayout.NORTH, l1);                                // T Label -> T Panel
			sl.putConstraint(SpringLayout.NORTH, t2, 25, SpringLayout.NORTH, l1);                                // T Field -> T Panel	
			sl.putConstraint(SpringLayout.WEST, t2, 20, SpringLayout.EAST, l2);                                  // R Field -> L Label
			
			// Supervisor
			cLayer1Content.add(t3);
			cLayer1Content.add(l3);
			
		JPanel cLayer1 = new JPanel();
			cLayer1.setLayout(new BorderLayout());
			cLayer1.setSize(BG_IMG_W, BG_IMG_H);
			cLayer1.add(jmb, BorderLayout.NORTH);
			cLayer1.add(cLayer1Content);
			cLayer1.setOpaque(false);

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
			mainContentPane.add(cLayer1, new Integer(2));
		
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
