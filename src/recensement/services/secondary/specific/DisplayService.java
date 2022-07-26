package recensement.services.secondary.specific;

import java.util.List;

import recensement.entities.GeographicEntity;

/**
 * Non-instantiable class containing methods used to
 * display specific messages to the user relating to
 * the different functions within the app.
 * 
 * @author DorianBoel
 */
public final class DisplayService {
	
	/**
	 * Don't let anyone instantiate this class.
	 */
	private DisplayService() {}

	/**
	 * Displays a single line as part of a
	 * selection menu or a list of results.
	 * 
	 * @param i The index of the current list line
	 * @param value The value to display
	 */
	public static void displayListLine(int i, String value) {
		System.out.println(" " + i + ". " + value);
	}
	
	/**
	 * Displays a list showing the first 10 elements
	 * from a given list of {@link GeographicEntity GeographicEntities}.
	 * 
	 * @param list A list of {@link GeographicEntity GeographicEntities}
	 * to iterate through
	 */
	public static void displayList(List<? extends GeographicEntity> list) {
		displayList(list, 10);
	}
	
	/**
	 * Displays a list showing the elements
	 * from a given list of {@link GeographicEntity GeographicEntities},
	 * with up to a given maximum amount of lines.
	 * 
	 * @param list A list of {@link GeographicEntity GeographicEntities}
	 * to iterate through
	 * @param limit The maximum amount of list elements
	 * that can be displayed
	 */
	public static void displayList(List<? extends GeographicEntity> list, int limit) {
		for (int i = 0; i < limit; i++) {				
			displayListLine(i + 1, list.get(i).toString());
		}
		System.out.println();
	}
	
	/**
	 * Displays a specific message based on a current given state
	 * represented by a flag argument.
	 * <p>
	 * 		The flags are the following:
	 * </p>
	 * <ul>
	 * 		<li>
	 * 			<strong>city-prompt</strong>: Asks the user to input a city name.
	 * 		</li>
	 * 		<li>
	 * 			<strong>department-prompt</strong>: Asks the user to input a department code.
	 * 		</li>
	 * 		<li>
	 * 			<strong>department-top-10</strong>: Shows the header for the top 10 departments list.
	 * 		</li>
	 * 		<li>
	 * 			<strong>exit</strong>: Indicates that the program has ended.
	 * 		</li>
	 * 		<li>
	 * 			<strong>first-10</strong>: Indicates that only the first 10 results of a list are being displayed.
	 * 		</li>
	 * 		<li>
	 * 			<strong>invalid</strong>: Indicated that the user input does not match any available options.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu</strong>: Shows the main menu.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu-opt</strong>: Informs the user that the main menu can be displayed again.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu-opt-1</strong>: Informs the user that a new city search can be done.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu-opt-2</strong>: Informs the user that a new department search can be done.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu-opt-3</strong>: Informs the user that a new region search can be done.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu-opt-6</strong>: Informs the user that a new department city search can be done.
	 * 		</li>
	 * 		<li>
	 * 			<strong>menu-opt-7</strong>: Informs the user that a new region city search can be done.
	 * 		</li>
	 * 		<li>
	 * 			<strong>no-department</strong>: Informs the user that no matching department was found.
	 * 		</li>
	 * 		<li>
	 * 			<strong>no-result</strong>: Informs the user that no matching cities were found.
	 * 		</li>
	 * 		<li>
	 * 			<strong>region-prompt</strong>: Asks the user to select a city within the list.
	 * 		</li>
	 * 		<li>
	 * 			<strong>region-top-10</strong>: Shows the header for the top 10 regions list.
	 * 		</li>
	 * 		<li>
	 * 			<strong>start</strong>: Indicates that the program has started.
	 * 		</li>
	 * </ul>
	 * 
	 * @param state A flag describing a specific state determining
	 * which message to display
	 */
	public static void displayMessage(String state) {
		switch (state) {
			case ("city-prompt") : 
				System.out.println("Veuillez rentrer le nom d'une ville (Appuyer sur retour pour annuler)");
				break;
			case ("department-prompt") :
				System.out.println("Veuillez rentrer le numéro d'un département (Appuyer sur retour pour annuler)");
				break;
			case ("department-top-10") :
				System.out.println("Les 10 départements de France les plus peuplés:");
				return;
			case ("exit") :
				System.out.println("Fermeture du programme");
				return;
			case ("first-10") :
				System.out.println("Affichage des 10 premiers résultats");
			return;
			case ("invalid") :
				System.out.println("Option invalide");
				break;
			case ("menu") :
				System.out.println("Choissisez une option parmi les suivantes:");
				System.out.println(" 1. Obtenir la population d'une ville");
				System.out.println(" 2. Obtenir la population d'un département");
				System.out.println(" 3. Obtenir la population d'une région");
				System.out.println(" 4. Voir les 10 régions les plus peuplées");
				System.out.println(" 5. Voir les 10 départements les plus peuplés");
				System.out.println(" 6. Voir les 10 villes les plus peuplées d'un département");
				System.out.println(" 7. Voir les 10 villes les plus peuplées d'une région");
				System.out.println(" 8. Voir les 10 villes les plus peuplées de France");
				System.out.println(" 9. Fermer l'application");
				System.out.println();
				displayMessage("menu-opt");
				break;
			case ("menu-opt") :
				System.out.println("M pour réafficher le menu");
				break;
			case ("menu-opt-1") :
				System.out.println("1 pour effectuer une nouvelle recherche");
				displayMessage("menu-opt");
				return;
			case ("menu-opt-2") :
				System.out.println("2 pour effectuer une nouvelle recherche");
				displayMessage("menu-opt");
				return;
			case ("menu-opt-3") :
				System.out.println("3 pour sélectionner à nouveau");
				displayMessage("menu-opt");
				return;
			case ("menu-opt-6") :
				System.out.println("6 pour effectuer une nouvelle recherche");
				displayMessage("menu-opt");
				return;
			case ("menu-opt-7") :
				System.out.println("7 pour sélectionner à nouveau");
				displayMessage("menu-opt");
				return;
			case ("no-department") : 
				System.out.println("Aucun département correspondant");
				break;
			case ("no-result") : 
				System.out.println("Aucun résultat trouvé");
				break;
			case ("region-prompt") :
				System.out.println("Veuillez sélectionner une région (Appuyer sur retour pour annuler)");
				break;
			case ("region-top-10") :
				System.out.println("Les 10 régions de France les plus peuplées:");
				return;
			case ("start") : 
				System.out.println("Recensement des villes de France");
				System.out.println("________________________________");
				break;
			default :
				return;
		}
		System.out.println();
	}
	
	/**
	 * Displays a specific message based on a current given state
	 * represented by a flag argument and displaying a given {@code String} value.
	 * <p>
	 * 		The flags are the following:
	 * </p>
	 * <ul>
	 * 		<li>
	 * 			<strong>results-total</strong>: Shows the total amount of matching city results.
	 * 		</li>
	 * 		<li>
	 * 			<strong>department-cities</strong>: Shows the header for the top 10 cities within a department 
	 * 		</li>
	 * 		<li>
	 * 			<strong>region-cities</strong>: Shows the header for the top 10 cities within a region.
	 * 		</li>
	 * 		<li>
	 * 			<strong>display-string</strong>: Displays the given {@code String}.
	 * 		</li>
	 * </ul>
	 * 
	 * @param state A flag describing a specific state determining
	 * which message to display
	 * @param value The value to be displayed as part of the message
	 */
	public static void displayMessage(String state, String value) {
		switch (state) {
			case ("results-total") :
				System.out.println(value + " résultats trouvés: ");
				return;
			case ("department-cities") :
				System.out.println("Les 10 villes les plus peuplées dans le département " + value + " :");
				return;
			case ("region-cities") :
				System.out.println("Les 10 villes les plus peuplées dans la région " + value + " :");
				return;
			case ("display-string") :
				System.out.println(value);
				break;
			default :
				return;
		}
		System.out.println();
	}
	
}
