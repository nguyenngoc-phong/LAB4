/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Memento.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package modele;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Memento {

	private double zoom;
	private int translation;
	
	/**
	 * Constructeur
	 */
	public Memento(double zoom, int translation) {
		this.zoom = zoom;
		this.translation = translation;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public double getZoom() {
		return zoom;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public int getTranslation() {
		return translation;
	}
	
}
