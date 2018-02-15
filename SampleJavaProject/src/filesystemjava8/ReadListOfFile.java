package filesystemjava8;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadListOfFile {
	
	public static List<String> listFilesForFolder(final File folder) {
		List<String> fileName = new ArrayList<String>();
		int count=0;
	    for (final File fileEntry : folder.listFiles()) {
	    	count = count+1;
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(count+") "+fileEntry.getName());
	            fileName.add(fileEntry.getName());
	        }
	    }
	    return fileName;
	}
	public static void main(String[] args) {
		final File folder = new File("C:/Users/prutech/Downloads/Simhachalam/Task Data/Files Directory/");
		System.out.println("Total Files are : "+listFilesForFolder(folder).size());
	}
}
