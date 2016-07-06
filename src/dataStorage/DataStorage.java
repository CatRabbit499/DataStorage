package dataStorage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
	
public class DataStorage{
	private static final URL RESOURCEDIR_URL = ClassLoader.class.getResource("Resources");
	private static final String TEMPDIR_PATH = FileUtils.getTempDirectoryPath();
	
	public static void main(String[] args) throws IOException{
		DataStorage.indexFiles();
	}
	
	public static void indexFiles() throws IOException{
		// URL Indexer for Project Cuttlefish
//		Document doc = Jsoup.connect("http://www.CuttlefishWebServerURL").get();
//		for(Element file : doc.select("td.right td a")) {
//			System.out.println(file.attr("href"));
//		}
        
        // Interim temp directory reader
       String[] files= FileUtils.getTempDirectory().list(new SuffixFileFilter("cuttlefish"));
       for(String s : files){
    	   System.out.println(new File(s).getName());
       }
    }
}