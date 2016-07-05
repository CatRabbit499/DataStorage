//import javax.swing.JFrame;
import java.awt.*;
public class MainWindow {
  public static void main(String[] args) { 
    if(isUHD()){
      System.out.println("Monitor is UHD");
    }
    else{
      System.out.println("Monitor is not UHD");
    }
  }
  
  public static String temp = " <-- w - 1080";
  w - 3840 -->
  public static boolean isUHD(){
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension d = tk.getScreenSize();
    System.out.println("Screen width = " + d.width);
    System.out.println("Screen height = " + d.height);
    System.out.println((d.width - 1080) + temp);
    System.out.println(d.width - 3840);
    if(d.width - 1080 < d.width - 3840){
      return true;
    }
    return false;
  }
}