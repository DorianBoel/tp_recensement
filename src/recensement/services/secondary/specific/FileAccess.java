package recensement.services.secondary.specific;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Non-instanciable class allowing access to
 * the census data contained in the CSV file.
 * 
 * @author DorianBoel
 */
public final class FileAccess {

	/**
	 * The path to the "recensement.csv" file containing
	 * all the census data.
	 */
	private static final Path PATH_FILE = Paths.get("recensement.csv");
	
	/**
	 * Gets a list containing all lines from the {@link PATH_FILE} CSV file.
	 * 
	 * @return A list containing the CSV file lines
	 * @throws FileNotFoundException If the file is not found at 
	 * the expected path.
	 */
	public static List<String> getLines() throws FileNotFoundException {
		try {
			return Files.readAllLines(PATH_FILE, StandardCharsets.UTF_8);
		} catch(IOException e) {
			throw new FileNotFoundException("Fichier \"" + System.getProperty("user.dir") + "/recensement.csv\" non trouvé");
		}
	}
	
}
