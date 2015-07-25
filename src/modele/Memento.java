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

import java.awt.Point;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Memento {
	
	private double echelleZoom;
	private Point coordTranslation;
	
	/**
	 * Constructeur
	 */
	public Memento(double nvEchelleZoom, Point nvCoordTranslation) {
		echelleZoom = nvEchelleZoom;
		coordTranslation = nvCoordTranslation;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public double getEchelleZoom() {
		return echelleZoom;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public Point getCoordTranslation() {
		return coordTranslation;
	}
	
}
