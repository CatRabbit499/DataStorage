package dataStorage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
	
public class DataStorage{
	private static File[] tmpFiles;
	private static int numBackups = 10;
	private static Date date = new Date();
	private static DateFormat dFmt = new SimpleDateFormat("MM dd yyyy @ HH;mm;ss");
	private static String backupDirString =  System.getProperty("user.dir") + "\\src\\Resources\\Backups\\";
	private static File archiveName = new File(backupDirString + "Cuttlefish backup from " + dFmt.format(date) + ".zip");
	private static File backupDirFile = new File(backupDirString);

	public static void main(String[] args) throws IOException{
		DataStorage.indexFiles();
		DataStorage.saveFiles();
		DataStorage.truncateBackups(10);
		// DataStorage.truncateBackups(System.currentTimeMillis() - 9001);
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
		System.out.println("Indexed files!");
		return tmpFiles;
    }
	
	public static boolean saveFiles(){
		try{
			int length;
			byte[] buffer = new byte[1024];
			FileInputStream backupInputStream;
			ZipOutputStream backupZipOutputStream;
			backupZipOutputStream = new ZipOutputStream(new FileOutputStream(archiveName));
			for(File f : tmpFiles){
				backupInputStream = new FileInputStream(f);
				backupZipOutputStream.putNextEntry(new ZipEntry(f.getName()));
				while((length = backupInputStream.read(buffer)) > 0){
					backupZipOutputStream.write(buffer, 0, length);
				}
				backupZipOutputStream.closeEntry();
			}
			backupZipOutputStream.close();
			System.out.println("Saved files!");
			return true;
		}catch(Exception e){
			System.out.println("Exception: ");
			e.printStackTrace();
			return false;
		}
	}
	
	public static void truncateBackups(int num) throws IOException{
		int count = 0;
		if(backupDirFile.listFiles().length > numBackups){
			for(int i=0; i<num; i++){
				File[] backupList = new File[num];
				for(File f : backupDirFile.listFiles()){
					
				}
			}
			
			tmpFiles = new File(System.getProperty("user.dir") + "\\src\\Resources\\Backups\\").listFiles(new FilenameFilter(){
				public boolean accept(File directory, String fileName){
					return fileName.endsWith(".cuttlefish");
				}
			});
			for(File f : new File(System.getProperty("user.dir") + "\\src\\Resources\\Backups\\").listFiles()){
				if(f.exists() && !(new ArrayList<File>(Arrays.asList(tmpFiles)).contains(f))){
					f.delete();
				}
			}
			for(File f : backupDirFile.listFiles()){
				f.renameTo(new File(f.getAbsolutePath().replace(".cuttlefish.tentacle", ".cuttlefish")));
			}
		}
		System.out.println("Deleted " + count + " backups!");
	}
	
	public static void truncateBackups(long date){
		int count = 0;
		for(File f : backupDirFile.listFiles()){
			if(f.getName().endsWith("zip") && f.lastModified() < date){
				f.delete();
				count++;
			}
		}
		System.out.println("Deleted " + count + " backups!");
	}
	
	public static int getNum() throws IOException{
		indexFiles();
		return 0;
	}
}