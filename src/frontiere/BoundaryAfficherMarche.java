package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.\n");
		} else {
			System.out.println(nomAcheteur + ", vous trouvez au marché : ");
			int i = 0;
			String vendeur, quantite, produit;
			while(i<infosMarche.length) {
				vendeur = infosMarche[i++];
				quantite = infosMarche[i++];
				produit = infosMarche[i++];
				System.out.println("- "+vendeur+" qui vend "+quantite+" "+ produit);
			}
		}
	}
}
