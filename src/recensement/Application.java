package recensement;

import java.io.FileNotFoundException;
import java.util.Scanner;

import recensement.entities.Census;
import recensement.entities.exceptions.CancelSearchException;
import recensement.entities.exceptions.NoResultsException;
import recensement.services.MainService;

/**
 * App entry point.
 *
 * @author DorianBoel
 */
public class Application {

	/**
	 * Main app method.
	 * Once called, show the main menu then 
	 * asks the user for for a prompt using a
	 * {@link java.util.Scanner Scanner},
	 * then calls the corresponding method from the 
	 * {@link recensement.services.MainService MainService} class
	 * as long as the user doesn't choose to quit the program.
	 * 
	 * <p>
	 * 		The valid prompts are as follows:
	 * </p>
	 * <ul>
	 * 		<li>
	 * 			<strong>M</strong> : display the main menu
	 * 		</li>
	 * 		<li>
	 * 			<strong>1</strong> : display the population of a given city
	 * 		</li>
	 * 		<li>
	 * 			<strong>2</strong> : display the population of a given department
	 * 		</li>
	 * 		<li>
	 * 			<strong>3</strong> : display the population of a given region
	 * 		</li>
	 * 		<li>
	 * 			<strong>4</strong> : display the top 10 most populated regions
	 * 		</li>
	 * 		<li>
	 * 			<strong>5</strong> : display the top 10 most populated departments
	 * 		</li>
	 * 		<li>
	 * 			<strong>6</strong> : display the top 10 most populated cities in a given department
	 * 		</li>
	 * 		<li>
	 * 			<strong>7</strong> : display the top 10 most populated cities in a given region
	 * 		</li>
	 * 		<li>
	 * 			<strong>8</strong> : display the top 10 most populated cities
	 * 		</li>
	 * 		<li>
	 * 			<strong>9</strong> : exit the game loop and close the program
	 * 		</li>
	 * </ul>
	 * 
	 * @param args Array of command line arguments
	 * @throws NoResultsException If one of the search methods doesn't return
	 * any matching results.
	 */
	public static void main(String[] args) throws NoResultsException {
		
		try {
			
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
			
		} catch (FileNotFoundException e) {
			System.err.println("ERR: " + e.getMessage());
		}

	}

}
