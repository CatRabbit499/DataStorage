package dataStorage;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class ClassFileWriter{
	public static JavaCompiler javac = ToolProvider.getSystemJavaCompiler();
	public static final Font uniFont = new Font("Verdana", Font.PLAIN, 40);
	public static JPanel buttonPanel = new JPanel();
	public static JTextPane tp = new JTextPane();
	public static PrintStream compileErrorStream;
	public static FileWriter outputWriter;
	public static JButton compileButton;
	public static JButton submitButton;
	public static JButton cancelButton;
	public static JButton runButton;
	public static File cFile;
	public static File jFile;
	
    public static void main(String[] args) throws IOException{
    	setUpButtons();
		tp.setFont(new Font("Verdana", Font.PLAIN, 40));
		createRunnableCode("C:/users/canon/desktop/test");
    }

	public static void createRunnableCode(String filename) throws IOException{
		compileErrorStream = new PrintStream(""); // Figure out printstreams
		cFile = new File(filename + ".class");
		jFile = new File(filename + ".java");
		outputWriter = new FileWriter(jFile);
    	if(jFile.exists()) jFile.delete();
    	if(cFile.exists()) cFile.delete();
    	compileButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		compileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				javac.run(null, null, compileErrorStream, filename);
			}
		});
		runButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
    	
		JFrame frame = new JFrame("File Writer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(640, 480);
    		frame.setLocationRelativeTo(null);
    		frame.add(tp);
    		frame.add(buttonPanel, BorderLayout.SOUTH);
    		frame.setVisible(true);
    }
	
	public static void writeCode(String code) throws IOException{
    	outputWriter.write(code + "\n");
    }
    public static void writeCode() throws IOException{
    	outputWriter.write("\n");
    }
    private static void setUpButtons(){
    	buttonPanel = new JPanel();
		runButton = new JButton("Run");
		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		compileButton = new JButton("Compile");
		submitButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
			    	writeCode(tp.getText());
					outputWriter.close();
					buttonPanel.removeAll();
					buttonPanel.add(compileButton);
					buttonPanel.add(runButton);
					buttonPanel.revalidate();
					buttonPanel.repaint();
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
		compileButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		compileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
				jc.run(null, null, null, "");
			}
		});
		runButton.setFont(new Font("Verdana", Font.PLAIN, 40));
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
			}
		});
	}
}