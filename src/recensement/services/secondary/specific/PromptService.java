package recensement.services.secondary.specific;

import java.util.Scanner;

/**
 * Non-instantiable class containing methods used to
 * prompt the user and retrieve the input.
 * 
 * @author DorianBoel
 */
public final class PromptService {
	
	/**
	 * Don't let anyone instantiate this class.
	 */
	private PromptService() {}
	
	/**
	 * Allows the user to enter an input then returns it.
	 * 
	 * @param scanner The main input {@link java.util.Scanner Scanner}
	 * @return The value input by the user
	 */
	public static String acceptInput(Scanner scanner) {
		return scanner.nextLine();
	}
	
}
