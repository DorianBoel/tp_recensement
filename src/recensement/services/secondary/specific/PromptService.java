package recensement.services.secondary.specific;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PromptService {
	
	public static String acceptInput(Scanner scanner) {
		return scanner.nextLine();
	}

	public static String acceptInput(Scanner scanner, String ...options) {
		String option = "0";
		while (!Arrays.asList(options).contains(option)) {
			option = scanner.nextLine();
		}
		return option;
	}
	
	public static String acceptInput(Scanner scanner, List<String> optionList) {
		String option = "0";
		while (!optionList.contains(option)) {
			option = scanner.nextLine();
		}
		return option;
	}
	
}
