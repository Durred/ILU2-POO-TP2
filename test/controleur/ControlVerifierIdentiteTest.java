package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void init() {
		System.out.println("Initialisation\n");
		village = new Village("VillageTest", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 2, village);
		village.setChef(abraracourcix);
		village.ajouterHabitant(new Gaulois("Mike", 1));
		village.ajouterHabitant(new Gaulois("Oxlong", 2));
	}
	
	@Test
	void testControlVerifierIdentite() {
		ControlVerifierIdentite control = new ControlVerifierIdentite(village);
		assertNotNull(control, "Controller not NULL\n");
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite control = new ControlVerifierIdentite(village);
		assertFalse(control.verifierIdentite(" "));
		assertTrue(control.verifierIdentite("Mike"));
		assertFalse(control.verifierIdentite("MiKE"));
		assertTrue(control.verifierIdentite("Oxlong"));
	}

}
