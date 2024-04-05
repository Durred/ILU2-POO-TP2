package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	
	private Village village;
	private Chef abraracourcix;
	private ControlVerifierIdentite controlVerif;

	@BeforeEach
	public void init() {
		System.out.println("Initialisation\n");
		village = new Village("VillageTest", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 2, village);
		controlVerif = new ControlVerifierIdentite(village);
		Gaulois mike = new Gaulois("Mike", 1);
		village.setChef(abraracourcix);
		village.ajouterHabitant(mike);
		village.installerVendeur(mike, "banane", 10);
	}
	
	@Test
	void testControlPrendreEtal() {
		ControlPrendreEtal control = new ControlPrendreEtal(controlVerif, village);
		assertNotNull(control, "constructeur ne return pas NULL\n");
	}

	@Test
	void testResteEtals() {
		fail("Not yet implemented");
	}

	@Test
	void testPrendreEtal() {
		fail("Not yet implemented");
	}

	@Test
	void testVerifierIdentite() {
		fail("Not yet implemented");
	}

}
