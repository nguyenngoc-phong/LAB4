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

import controleur.Controleur;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class ApplicationImage {
	
	private FenetrePrincipale fenetre;
	private Controleur controleur;
	
	/**
	 * Constructeur
	 */
	public ApplicationImage() {
		this.controleur = new Controleur();
		this.fenetre = new FenetrePrincipale(controleur);
	}
	
}
