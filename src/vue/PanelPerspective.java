/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: PanelPerspective.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import java.util.Observable;
import java.util.Observer;

import controleur.Controleur;
import modele.Perspective;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class PanelPerspective implements Observer {
	
	private Controleur controleur;
	private Perspective perspective;
	
	/**
	 * Constructeur
	 */
	public PanelPerspective(Controleur controleur) {
		this.controleur = controleur;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Écrire le code de la méthode.
	}
	
}
