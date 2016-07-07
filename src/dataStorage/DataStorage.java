package dataStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
	
public class DataStorage{
	private static final URL RESOURCEDIR_URL = ClassLoader.class.getResource("Resources");
	private static final String TEMPDIR_PATH = FileUtils.getTempDirectoryPath();
	private static File[] tmpFiles;

	public static void main(String[] args) throws IOException{
		DataStorage.indexFiles();
		DataStorage.saveFiles();
	}
	
	public static File[] indexFiles() throws IOException{
//		URL Indexer for Project Cuttlefish
//		Document doc = Jsoup.connect("http://www.CuttlefishWebServerURL").get();
//		for(Element file : doc.select("td.right td a")) {
//			System.out.println(file.attr("href"));
//		}
		
//      Interim temp directory reader
		tmpFiles = new File(System.getProperty("java.io.tmpdir") + "\\ProjectCuttlefish\\").listFiles(new FilenameFilter(){
			public boolean accept(File directory, String fileName){
				return fileName.endsWith(".cuttlefish");
			}
		});
//		for(int i=0; i<tmpFiles.length; i++){
//			System.out.println(tmpFiles[i]);
//		}
		return tmpFiles;
    }
	
	public static void saveFiles(){
		try{
			int length;
			Date date = new Date();
			byte[] buffer = new byte[1024];
			FileInputStream backupInputStream;
			ZipOutputStream backupZipOutputStream;
			DateFormat dateFormat = new SimpleDateFormat("MM dd yyyy @ HH:mm:ss");
			String fileName = "Backup from " + dateFormat.format(date).replace("-", " ").trim() + " for Cuttlefish.zip";
			System.out.println(System.getProperty("user.dir") + "\\src\\Resources\\Backups\\");
			File backupZipFile = new File(System.getProperty("user.dir") + "\\src\\Resources\\Backups\\" + fileName );
			System.out.println(backupZipFile);
			backupZipOutputStream = new ZipOutputStream(new FileOutputStream(backupZipFile));
			System.out.println("Mark!");
			for(File f : tmpFiles){
				backupInputStream = new FileInputStream(f);
				System.out.println("Packing entry " + f.getName() + " to ZIP Backup");
				backupZipOutputStream.putNextEntry(new ZipEntry(f.getName()));
				while((length = backupInputStream.read(buffer)) > 0){
					backupZipOutputStream.write(buffer, 0, length);
					System.out.println("Writing bytes...");
				}
				backupZipOutputStream.closeEntry();
				System.out.println("Entry " + f + " has been closed");
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