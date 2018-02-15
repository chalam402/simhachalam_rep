package filesystemjava8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadListOfFileJava8 {
	public static void main(String[] args) throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get("C:/Users/prutech/Downloads/Simhachalam/Task Data/Files Directory/"))) {
		    paths
		        .filter(Files::isRegularFile)
		        .forEach(System.out::println);
		} 
	}
}
