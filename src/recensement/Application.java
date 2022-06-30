package recensement;

import java.io.IOException;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) throws IOException, CancelSearchException, NoResultsException {
		
		Census census = Census.getInstance();
		
		Scanner menuPrompt = new Scanner(System.in);
		String menuSelect = "0";
		
		MainService.start();
		
		while (!menuSelect.equals("9")) {
			try {
				menuSelect = menuPrompt.nextLine();
				switch (menuSelect) {
					case ("M") :
						MainService.displayMenu();
						break;
					case ("1") :
						MainService.displayCityPopulation(census, menuPrompt);
						break;
					case ("2") :
						MainService.displayDepartmentPopulation(census, menuPrompt);
						break;
					case ("3") :
						MainService.displayRegionPopulation(census, menuPrompt, true);
						break;
					case ("4") :
						MainService.displayRegionTop10(census);
						break;
					case ("5") :
						MainService.displayDepartmentTop10(census);
						break;
					case ("6") :
						MainService.displayDepartmentCityTop10(census, menuPrompt);
						break;
					case ("7") :
						MainService.displayRegionCityTop10(census, menuPrompt, true);
						break;
					case ("8") :
						MainService.displayCityTop10(census);
						break;
					case ("9") :
						MainService.exit();
					 	break;
					default :
						MainService.defaultOption();
				}
			} catch(CancelSearchException e) {
				MainService.displayMenu();
			}
		}
		menuPrompt.close();

	}

}
