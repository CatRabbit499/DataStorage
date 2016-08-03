package dataStorage;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ClassFileWriter{
	public static final Font uniFont = new Font("Verdana", Font.PLAIN, 40);
	public static JButton submitButton = new JButton("Submit");
	public static JButton cancelButton = new JButton("Cancel");
	public static JButton runButton = new JButton("Run");
	public static JPanel buttonPanel = new JPanel();
	public static JTextPane tp = new JTextPane();
	public static File classFile;
	public static File javaFile;
	public static FileWriter outputFileWriter;
	
    public static void main(String[] args) throws IOException{
		tp.setFont(new Font("Verdana", Font.PLAIN, 40));
		setUpButtons();
		createRunnableCode("C:/users/canon/desktop/test");
    }
    
    

	public static void createRunnableCode(String filename) throws IOException{
    	classFile = new File("C:/users/canon/desktop/test.class");
    	javaFile = new File("C:/users/canon/desktop/test.java");
    	if(javaFile.exists()) javaFile.delete();
    	if(classFile.exists()) classFile.delete();
    	outputFileWriter = new FileWriter(javaFile);
			
		JFrame frame = new JFrame("File Writer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(640, 480);
    		frame.setLocationRelativeTo(null);
    		frame.add(tp);
    		frame.add(buttonPanel, BorderLayout.SOUTH);
    		frame.setVisible(true);
    }
    
    public static void writeCode(String code) throws IOException{
    	outputFileWriter.write(code + "\n");
    }
    public static void writeCode() throws IOException{
    	outputFileWriter.write("\n");
    }
    private static void setUpButtons(){
    	buttonPanel = new JPanel();
		runButton = new JButton("Run");
		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		submitButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
			    	writeCode(tp.getText());
					outputFileWriter.close();
					buttonPanel.removeAll();
					buttonPanel.add(runButton);
				}catch(IOException e1){
					e1.printStackTrace();
				}
			}
		});
		cancelButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				tp.setText("");
			}
		});
		buttonPanel.add(submitButton);
		buttonPanel.add(cancelButton);
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}