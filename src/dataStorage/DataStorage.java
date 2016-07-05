package dataStorage;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DataStorage{

	
	public static void main(String[] args) throws FileNotFoundException{
		DataStorage.indexFiles();
	}
	
	public static void indexFiles() throws FileNotFoundException{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream()));
	}
}