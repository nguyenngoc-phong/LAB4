/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: ApplicationImage.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import modele.Perspective;
import modele.Vignette;
import controleur.Controleur;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class ApplicationImage {
	
	/**
	 * Méthode main() de l'application.
	 * @param
	 */
	public static synchronized void main(String[] args) {
		ApplicationImage application = new ApplicationImage();
	}
	
	/**
	 * Constructeur
	 */
	public ApplicationImage() {
		
		Vignette vignette = new Vignette();
		
		Perspective perspectiveA = new Perspective();
		Perspective perspectiveB = new Perspective();
		
		Controleur controleur = new Controleur(vignette, perspectiveA, perspectiveB);
		
		FenetrePrincipale fenetre = new FenetrePrincipale(controleur, vignette, perspectiveA, perspectiveB);
	}
	
}