/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Perspective.java
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
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Observable;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Perspective extends Observable implements Serializable {
	
	private Image image;
	private double zoom;
	private Point translation;

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public Memento createMemento() {
		Memento nvMemento = new Memento(zoom, translation);
		return nvMemento;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void setMemento(Memento memento) {
		zoom = memento.getZoom();
		translation = memento.getTranslation();
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
	public void setImage(Image image) {
		this.image = image;
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
	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public Point getTranslation() {
		return translation;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void setTranslation(Point translation) {
		this.translation = translation;
	}
	
}
