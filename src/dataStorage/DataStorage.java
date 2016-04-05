package dataStorage;
import java.io.File;
import java.util.HashMap;
import org.yaml.*;
import org.yaml.snakeyaml.Yaml;

public class DataStorage{
	public static String extension = "\\src\\Resources\\FilesToConvert";
	
	public static void main(String[]args){
		System.out.println("Working Directory: " + System.getProperty("user.dir"));
		DataStorage.indexFiles();
	}
	
	public static HashMap<Integer, File> h = new HashMap<Integer, File>();	
	public static void indexFiles(){
		h.clear();
		String filePath = new File(System.getProperty("user.dir")).getAbsolutePath();
		String specificFilePath = filePath + extension;
		File[] folder = new File(specificFilePath).listFiles();
		for(int i=0; i<folder.length; i++){
			System.out.println(folder[i].getName());
			h.put(i,folder[i]);
		}
	}
	
	public void testDump() 
	{
	    HashMap<String, Object> data = new HashMap<String, Object>();
	    data.put("name", "Silenthand Olleander");
	    data.put("race", "Human");
	    data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });
	    Yaml yaml = new Yaml();
	    String output = yaml.dump(data);
	    System.out.println(output);
	}
}