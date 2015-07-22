/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: ICopie.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package controleur;

import java.awt.Point;

/**
* Description de l'interface.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public interface ICopie {
	
	public double zoom = 0;
	public Point translation = new Point();

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public abstract void copier(double zoom, Point translation);
	
}
