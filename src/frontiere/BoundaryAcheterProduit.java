package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (controlAcheterProduit.isAcheteurFromVillage(nomAcheteur)) {
			System.out.println("Quel produit voulez-vous acheter ?\n");
			String produit = scan.nextLine();
			String[] vendeursProduit = controlAcheterProduit.trouverVendeursProduit(produit);
			if (vendeursProduit.length == 0) {
				System.out.println("D�sol�, personne ne vend ce produit au march�.\n");
			} else {
				System.out.println("Chez quel commer�ant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < vendeursProduit.length; i++) {
					System.out.println((i+1) + " - " + vendeursProduit[i] + "\n");
				}
				int nEtal = scan.nextInt()-1;
				if (nEtal > vendeursProduit.length || nEtal < 0) {
					System.out.println("Il n'y a pas votre produit � cette �tal.");
				} else {
					System.out.println(
							nomAcheteur + " se d�place jusqu'� l'�tal du vendeur " + vendeursProduit[nEtal]);
					System.out.println("Combien de " + produit + " voulez-vous acheter ?\n");
					int quantityToBuy = scan.nextInt();
					int quantityAvailable = controlAcheterProduit.getNombreProduit(vendeursProduit[nEtal]);
					if (quantityAvailable >= quantityToBuy) {
						System.out.println(nomAcheteur + " ach�te " + quantityToBuy + " " + produit + " � "
								+ vendeursProduit[nEtal] + ".\n");
						controlAcheterProduit.acheterProduit(quantityToBuy, vendeursProduit[nEtal]);
					} else {
						if (quantityAvailable < quantityToBuy && quantityAvailable <= 0) {
							System.out.println(nomAcheteur + " veut acheter " + quantityToBuy + " " + produit
									+ ", malheureusement il n'y en a plus !\n");
						} else {
							System.out.println(nomAcheteur + " veut acheter " + quantityToBuy + " " + produit
									+ ", malheureusement " + vendeursProduit[nEtal] + " n'en a plus que "
									+ quantityAvailable + ". " + nomAcheteur + " achète tout le stock de "
									+ vendeursProduit[nEtal] + "\n");
							controlAcheterProduit.acheterProduit(quantityAvailable, vendeursProduit[nEtal]);
						}
					}
				}
			}
		} else {
			System.out.println("Il faut faire partie du village pour acheter des produits\n");
		}
	}
}
