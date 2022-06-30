package recensement;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileAccess {

	private static final Path PATH_FILE = Paths.get("/Users/macbook/Desktop/dev/diginamic/files/recensement.csv");
	
	public static List<String> getLines() throws IOException {
		return Files.readAllLines(PATH_FILE, StandardCharsets.UTF_8);
	}
	
}
