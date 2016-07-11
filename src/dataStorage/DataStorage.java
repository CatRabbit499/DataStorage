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
	private static int numBackups;
	private static Date date = new Date();
	private static DateFormat dFmt = new SimpleDateFormat("MM dd yyyy @ HH;mm;ss");
	private static String backupDirString =  System.getProperty("user.dir") + "\\src\\Resources\\Backups\\";
	private static File archiveName = new File(backupDirString + "Cuttlefish backup from " + dFmt.format(date) + ".zip");
	private static File backupDirFile = new File(backupDirString);

	public static void main(String[] args) throws IOException, CuttlefishException{
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
	
	public static void truncateBackups(int num) throws IOException, CuttlefishException{
		int count = 0;
		File[] backupList = new File(System.getProperty("user.dir") + "\\src\\Resources\\Backups\\").listFiles();
		File[] backupKeepArray;
		if(backupList.length > num){
			backupKeepArray = new File[num];
			System.arraycopy(backupList, backupList.length-num, backupKeepArray, 0, num);
			System.out.println(backupList.length + " backups total, " + backupKeepArray.length + " backups to keep, " + (backupList.length - backupKeepArray.length) + " files will be deleted");
			ArrayList<File> backupKeepArrayList = new ArrayList<File>(Arrays.asList(backupKeepArray));
			for(File f : backupList){
			if(!backupKeepArrayList.contains(f)){
					f.delete();
					count++;
				}
			}
			System.out.println("Deleted " + count + " backups!");
		}
		else{
			throw new CuttlefishException("Attempted to truncate nonexistant backup!");
		}
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
}