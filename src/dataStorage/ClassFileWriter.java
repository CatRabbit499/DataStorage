package dataStorage;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class ClassFileWriter{
	public static final Font uniFont = new Font("Verdana", Font.PLAIN, 40);
	public static final String ENV_VARS = System.getenv("PATH");
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
    	tp.setFont(new Font("Verdana", Font.PLAIN, 40));
		createRunnableCode("C:\\users\\canon\\desktop\\", "test");
    }

	public static void createRunnableCode(String filepath, String filename) throws IOException{
		cFile = new File(filepath + filename + ".class");
		jFile = new File(filepath + filename + ".java");
		outputWriter = new FileWriter(jFile);
    	if(jFile.exists()) jFile.delete();
    	if(cFile.exists()) cFile.delete();
		compileButton = new JButton("Compile");
		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");
		runButton = new JButton("Run");
		buttonPanel = new JPanel();
		buttonPanel.add(submitButton);
		buttonPanel.add(cancelButton);
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
		compileButton.setFont(uniFont);
		compileButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					Runtime.getRuntime().exec("javac \"" + filepath + filename + ".java\"");
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		runButton.setFont(uniFont);
		runButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					runCmd(new String[]{"cd " + filepath, "java " + filename});
				}catch(IOException e1) {
					e1.printStackTrace();
				}
			}
		});
    	
		JFrame frame = new JFrame("File Writer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1280, 960);
    		frame.setLocationRelativeTo(null);
    		frame.add(tp);
    		frame.add(buttonPanel, BorderLayout.SOUTH);
    		frame.setVisible(true);
    }
	
	public static void runCmd(String[] strings) throws IOException{
		ProcessBuilder builder = new ProcessBuilder();
		builder.redirectErrorStream(true);
		builder.command("bash", "-c", String.format(null, strings));
		Process p = builder.start();
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while((line = r.readLine())!= null) System.out.println(line);
	}
	
	public static void writeCode(String code) throws IOException{
    	outputWriter.write(code + "\n");
    }
    public static void writeCode() throws IOException{
    	outputWriter.write("\n");
    }
}