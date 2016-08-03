import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class ClassFileWriter{
	public static File javaFile = new File("C:/users/canon/desktop/test.java");
	public static File classFile = new File("C:/users/canon/desktop/test.class");
	public static FileWriter f1;
    public static void main(String[] args) throws IOException, InterruptedException{
    	if(javaFile.exists()) javaFile.delete();
    	if(classFile.exists()) classFile.delete();
    	f1 = new FileWriter(javaFile);
    	JLabel notifierLabel = new JLabel("", SwingConstants.CENTER);
			notifierLabel.setFont(new Font("Verdana", Font.PLAIN, 40));
			notifierLabel.setOpaque(false);
		final JTextPane tp = new JTextPane();
		tp.setFont(new Font("Verdana", Font.PLAIN, 40));
		JButton submitButton = new JButton("Submit");
			submitButton.setFont(new Font("Verdana", Font.PLAIN, 40));
			submitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						TestBench.writeCode(tp.getText());
						f1.close();
						System.out.println(tp.getText());
					}catch(Exception e1){
						System.out.println(e1);
					}
				}
			});
		JButton cancelButton = new JButton("Cancel");
			cancelButton.setFont(new Font("Verdana", Font.PLAIN, 40));
			cancelButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					tp.setText("");
				}
			});
			
		JPanel buttonPanel = new JPanel();
			buttonPanel.add(submitButton);
			buttonPanel.add(cancelButton);
		    		
		JFrame frame = new JFrame("File Writer");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(640, 480);
    		frame.setLocationRelativeTo(null);
    		frame.add(tp);
    		notifierLabel.setText("Test Text");
    		frame.add(notifierLabel);
    		frame.add(buttonPanel, BorderLayout.SOUTH);
    		frame.setVisible(true);
    }
    public static void writeCode(String code) throws IOException{
    	f1.write(code + "\n");
    }
    public static void writeCode() throws IOException{
    	f1.write("\n");
    }
}