package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes d�j� un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("�tes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					int force;
					System.out.println("Bienvenue villageois "+nomVisiteur);
					force = Clavier.entrerEntier("Quelle est votre force ?\n");
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int force;
		int forceMaxPotion;
		int forceMinPotion;
		System.out.println("Bienvenue druide "+ nomVisiteur);
		force = Clavier.entrerEntier("Quelle est votre force ?\n");
		do {
			forceMinPotion = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produisez ?\n");
			forceMaxPotion = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produisez ?\n");
			if(forceMaxPotion < forceMinPotion) {
				System.out.println("Attention Druide, vous vous �tes tromp� entre le minimum et le maximum\n");
			}
		} while (forceMaxPotion < forceMinPotion);
		controlEmmenager.ajouterDruide(nomVisiteur, force, forceMinPotion, forceMaxPotion);
	}
}
