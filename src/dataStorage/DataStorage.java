package dataStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
	
public class DataStorage{
	private static final URL RESOURCEDIR_URL = ClassLoader.class.getResource("Resources");
	private static final String TEMPDIR_PATH = FileUtils.getTempDirectoryPath();
	private static final String RES_DIR = System.getProperty("user.dir") + "\\src\\Resources\\";
	private static String[] tempfiles;
	
	public static void main(String[] args) throws IOException{
		DataStorage.indexFiles();
		DataStorage.saveFiles();
	}
	
	public static String[] indexFiles() throws IOException{
		// URL Indexer for Project Cuttlefish
//		Document doc = Jsoup.connect("http://www.CuttlefishWebServerURL").get();
//		for(Element file : doc.select("td.right td a")) {
//			System.out.println(file.attr("href"));
//		}
        
        // Interim temp directory reader
		tempfiles = new File(System.getProperty("java.io.tmpdir") + "/ProjectCuttlefish/").list(new SuffixFileFilter("cuttlefish"));
		try{
			for(String s : tempfiles){
				System.out.println(/* FileUtils.getTempDirectoryPath() + */ new File(s).getName());
			}
		}catch(Exception e){
			System.out.println("Empty Array!");
		}
		return tempfiles;
    }
	
	public static void saveFiles(){
		try{
			int length;
			Date date = new Date();
			byte[] buffer = new byte[1024];
			FileInputStream backupInputStream;
			FileOutputStream backupOutputStream;
			ZipOutputStream backupZipOutputStream;
			DateFormat dateFormat = new SimpleDateFormat("MM dd, yyyy @ HH:mm:ss");
			backupOutputStream = new FileOutputStream(new File(RES_DIR + "\\Backups\\" + "Data Backup " + dateFormat.format(date) + ".zip"));
			backupZipOutputStream = new ZipOutputStream(backupOutputStream);
			for(String s : tempfiles){
				backupInputStream = new FileInputStream(s);
				File f = new File(s);
				backupInputStream.read();
				System.out.println("Packing entry " + s + " to ZIP Backup");
				backupZipOutputStream.putNextEntry(new ZipEntry(s));
				while((length = backupInputStream.read(buffer)) > 0){
					backupZipOutputStream.write(buffer, 0, length);
					System.out.println("Writing bytes...");
				}
				backupZipOutputStream.closeEntry();
				System.out.println("Entry " + s + " has been closed");
			}
			backupZipOutputStream.close();
		}catch(Exception e){
			System.out.println("Exception: ");
			e.printStackTrace();
		}
	}
	
	public static int getNum() throws IOException{
		indexFiles();
		return 0;
	}
}