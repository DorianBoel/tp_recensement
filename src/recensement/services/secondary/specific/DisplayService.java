package recensement.services.secondary.specific;

import java.util.List;

import recensement.entities.GeographicEntity;

public class DisplayService {

	// Class methods
	public static void displayListLine(int i, String value) {
		System.out.println(" " + i + ". " + value);
	}
	
	public static void displayList(List<? extends GeographicEntity> list) {
		displayList(list, 10);
	}
	
	public static void displayList(List<? extends GeographicEntity> list, int limit) {
		for (int i = 0; i < limit; i++) {				
			DisplayService.displayListLine(i + 1, list.get(i).toString());
		}
		System.out.println();
	}
	
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
				System.out.println("M pour réafficher ce menu");
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
