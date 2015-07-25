/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Image.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package modele;

import java.awt.Image;
import java.io.Serializable;
import java.util.Observable;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Vignette extends Observable implements Serializable {
	
	private static final long serialVersionUID = -2291997349113388136L;
	private Image image;
	
	/**
	 * Constructeur
	 */
	public Vignette() {
		image = null;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void setImage(Image nvImage) {
		image = nvImage;
		notify();
	}
	
}
