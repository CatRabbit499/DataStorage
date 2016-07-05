package dataStorage;

import java.io.InputStream;

public class saveHelper implements Runnable{
	public InputStream Resource_Folder = getClass().getResourceAsStream("Resources");
	
	public void run(){
		
	}
	
	public InputStream getRes(){
		return Resource_Folder;
	}
}
