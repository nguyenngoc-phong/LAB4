/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
�tudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: FenetreImage.java
Date cr��: 2015-07-17
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
public class FenetreImage {
	
	private PanelVignette panelVignette;
	private PanelPerspective panelPerspectiveA;
	private PanelPerspective panelPerspectiveB;
	
	/**
	 * Constructeur
	 */
	public FenetreImage(Controleur controleur) {
		this.panelVignette = new PanelVignette();
		this.panelPerspectiveA = new PanelPerspective(controleur);
		this.panelPerspectiveB = new PanelPerspective(controleur);
	}
	
}
