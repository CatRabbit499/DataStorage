package dataStorage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.text.AbstractDocument;

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
		((AbstractDocument)t1.getDocument()).setDocumentFilter(new NumericDocumentFilter());
		TextPrompt p1 = new TextPrompt("Numbers Only", t1);
		p1.setForeground(Color.GRAY);
		p1.changeAlpha(0.5f);
		
		JLabel l2 = new JLabel("Teacher");
		JTextField t2 = new JTextField(15);
		((AbstractDocument)t2.getDocument()).setDocumentFilter(new AlphabeticDocumentFilter());
		TextPrompt p2 = new TextPrompt("Letters Only", t2);
		p2.setForeground(Color.GRAY);
		p2.changeAlpha(0.5f);
		
		JLabel l3 = new JLabel("Supervisor");
		JTextField t3 = new JTextField(15);
		((AbstractDocument)t3.getDocument()).setDocumentFilter(new AlphabeticDocumentFilter());
		TextPrompt p3 = new TextPrompt("Letters Only", t3);
		p3.setForeground(Color.GRAY);
		p3.changeAlpha(0.5f);
		
		JLabel l4 = new JLabel("Classes");
		JTextField t4 = new JTextField(15);
		((AbstractDocument)t4.getDocument()).setDocumentFilter(new AlphabeticDocumentFilter());
		TextPrompt p4 = new TextPrompt("Letters & Commas Only", t4);
		p4.setForeground(Color.GRAY);
		p4.changeAlpha(0.5f);
		if(isUHD){
			p4.setFont(FONT);
		}
		
		JTextArea jta = new JTextArea(8,30);
		jta.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.GRAY,1), BorderFactory.createEmptyBorder(0, 4, 0, 0)));
		jta.setFont(FONT);
		
		JButton b1 = new JButton("Submit");
			b1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					
				}
			});
		JButton b2 = new JButton("Request");
			b2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					String s;
					s = CuttlefishSQL.submitSQL("select * from `teacher_list`");
					//s = CuttlefishSQL.submitSQL("");
					jta.setText(s);
				}
			});
		
		if(isUHD){
			p1.setFont(FONT);
			p2.setFont(FONT);
			p3.setFont(FONT);
			l1.setFont(FONT);
			t1.setFont(FONT);
			l2.setFont(FONT);
			t2.setFont(FONT);
			l3.setFont(FONT);
			t3.setFont(FONT);
			l4.setFont(FONT);
			t4.setFont(FONT);
			b1.setFont(FONT);
			b2.setFont(FONT);
		}
		
		SpringLayout sl = new SpringLayout();
		JPanel cLayer1Content = new JPanel();
			cLayer1Content.setLayout(sl);
			cLayer1Content.setOpaque(true); // <------- Is panel showing
			cLayer1Content.add(l1);
			cLayer1Content.add(t1);
			
			// ID
			sl.putConstraint(SpringLayout.WEST, l1, WIDTH/4 - WIDTH/16, SpringLayout.WEST, cLayer1Content);
			sl.putConstraint(SpringLayout.NORTH, l1, 25, SpringLayout.NORTH, cLayer1Content);
			sl.putConstraint(SpringLayout.NORTH, t1, 25, SpringLayout.NORTH, cLayer1Content);
			sl.putConstraint(SpringLayout.WEST, t1, 20, SpringLayout.EAST, l1);
			
			// Teacher
			cLayer1Content.add(l2);
			cLayer1Content.add(t2);
			
			sl.putConstraint(SpringLayout.WEST, t2, 0, SpringLayout.WEST, t1);
			sl.putConstraint(SpringLayout.NORTH, t2, 25 ,SpringLayout.SOUTH, t1);
			sl.putConstraint(SpringLayout.NORTH, l2, 28, SpringLayout.SOUTH, l1);
			sl.putConstraint(SpringLayout.EAST, l2, -20, SpringLayout.WEST, t2);
			
			// Supervisor
			cLayer1Content.add(t3);
			cLayer1Content.add(l3);
			
			sl.putConstraint(SpringLayout.WEST, t3, 0, SpringLayout.WEST, t2);
			sl.putConstraint(SpringLayout.NORTH, t3, 25, SpringLayout.SOUTH, t2);
			sl.putConstraint(SpringLayout.NORTH, l3, 28, SpringLayout.SOUTH, l2);
			sl.putConstraint(SpringLayout.EAST, l3, -20, SpringLayout.WEST, t3);
			
			cLayer1Content.add(t4);
			cLayer1Content.add(l4);
			
			sl.putConstraint(SpringLayout.WEST, t4, 0, SpringLayout.WEST, t3);
			sl.putConstraint(SpringLayout.NORTH, t4, 25, SpringLayout.SOUTH, t3);
			sl.putConstraint(SpringLayout.NORTH, l4, 28, SpringLayout.SOUTH, l3);
			sl.putConstraint(SpringLayout.EAST, l4, -20, SpringLayout.WEST, t4);
			
			cLayer1Content.add(b1);
			cLayer1Content.add(b2);
			
			sl.putConstraint(SpringLayout.WEST, b1, (WIDTH/32)-(WIDTH/128), SpringLayout.WEST, t4);
			sl.putConstraint(SpringLayout.NORTH, b1, 25, SpringLayout.SOUTH, t4);
			sl.putConstraint(SpringLayout.NORTH, b2, 25, SpringLayout.SOUTH, t4);
			sl.putConstraint(SpringLayout.WEST, b2, 20, SpringLayout.EAST, b1);
			
			cLayer1Content.add(jta);
			
			sl.putConstraint(SpringLayout.SOUTH, jta, -30, SpringLayout.SOUTH, cLayer1Content);
			sl.putConstraint(SpringLayout.WEST, jta, (WIDTH/4)-(WIDTH/8)-(WIDTH/64), SpringLayout.WEST, cLayer1Content);
			
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
