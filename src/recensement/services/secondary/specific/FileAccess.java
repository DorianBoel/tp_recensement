package recensement.services.secondary.specific;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileAccess {

	private static final Path PATH_FILE = Paths.get("recensement.csv");
	
	public static List<String> getLines() throws FileNotFoundException {
		try {
			return Files.readAllLines(PATH_FILE, StandardCharsets.UTF_8);
		} catch(IOException e) {
			throw new FileNotFoundException("Fichier \"" + System.getProperty("user.dir") + "/recensement.csv\" non trouvé");
		}
	}
	
}
