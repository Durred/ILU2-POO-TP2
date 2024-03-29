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
		System.out.println("Quel produit voulez-vous acheter ?\n");
		String produit = scan.nextLine();
		String[] vendeursProduit = controlAcheterProduit.trouverVendeursProduit(produit);
		if(vendeursProduit == null) {
			System.out.println("Désolé, personne ne vend ce produit au marché.\n");
		}
		else {
			System.out.println("Chez quel commerçant voulez-vous acheter des "+produit+" ?\n");
			for(int i = 1; i<vendeursProduit.length; i++) {
				System.out.println(i+" - "+vendeursProduit[i-1]+"\n");
			}
			int nEtal = scan.nextInt();
			if (nEtal>= vendeursProduit.length || nEtal < 0) {
				System.out.println("Il n'y a pas votre produit à cette étal.");
			} else {
				System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur " + vendeursProduit[nEtal]);
				System.out.println("Combien de "+produit +" voulez-vous acheter ?\n");
				int quantityToBuy = scan.nextInt();
				if (controlAcheterProduit.getNombreProduit(vendeursProduit[nEtal])>=quantityToBuy) {
					System.out.println(nomAcheteur+" achète " + quantityToBuy + " "+ produit+" à "+ vendeursProduit[nEtal]+".\n");
					controlAcheterProduit.
				} else {
					if (controlAcheterProduit.getNombreProduit(vendeursProduit[nEtal])<quantityToBuy && controlAcheterProduit.getNombreProduit(vendeursProduit[nEtal])>0 ) {
						System.out.println(nomAcheteur+" achète " + quantityToBuy + " "+ produit+" à "+ vendeursProduit[nEtal]+".\n");
					} else {
						
					}
				}
				
			}		
		}
	}
}
