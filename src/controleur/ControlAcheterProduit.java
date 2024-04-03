package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] trouverVendeursProduit(String produit) {
		Gaulois[] gaulois = village.rechercherVendeursProduit(produit);
		String[] vendeursProduits = new String[gaulois.length];
		if (gaulois.length != 0) {
			for (int i = 0; i < gaulois.length; i++) {
				vendeursProduits[i] = gaulois[i].getNom();
			}
		}
		return vendeursProduits;
	}

	public int getNombreProduit(String vendeur) {
		return village.rechercherEtal(village.trouverHabitant(vendeur)).getQuantite();
	}

	public void acheterProduit(int quantity, String vendeur) {
		if (controlVerifierIdentite.verifierIdentite(vendeur)) {
			controlTrouverEtalVendeur.trouverEtalVendeur(vendeur).acheterProduit(quantity);
		}
	}

	public Boolean isAcheteurFromVillage(String nom) {
		return controlVerifierIdentite.verifierIdentite(nom);
	}
}
