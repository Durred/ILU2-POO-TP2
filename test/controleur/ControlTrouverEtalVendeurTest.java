package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {

	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void init() {
		System.out.println("Initialisation\n");
		village = new Village("VillageTest", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 2, village);
		Gaulois mike = new Gaulois("Mike", 1);
		village.setChef(abraracourcix);
		village.ajouterHabitant(mike);
		village.installerVendeur(mike, "banane", 10);
	}
	
	@Test
	void testControlTrouverEtalVendeur() {
		ControlTrouverEtalVendeur control = new ControlTrouverEtalVendeur(village);
		assertNotNull(control, "Constructeur ne renvoie pas null");
	}

	@Test
	void testTrouverEtalVendeur() {
		ControlTrouverEtalVendeur control = new ControlTrouverEtalVendeur(village);
		assertNull(control.trouverEtalVendeur("oxlong"));
		assertNotNull(control.trouverEtalVendeur("Mike"));
	}

}
