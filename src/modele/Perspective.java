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

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Perspective extends Vignette {
	
	private static final long serialVersionUID = -2298967121346240971L;
	private double echelleZoom;
	private Point coordTranslation;
	
	/**
	 * Constructeur
	 */
	public Perspective() {
		super();
		echelleZoom = 0;
		coordTranslation = null;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public Memento creerMemento() {
		Memento nvMemento = new Memento(echelleZoom, coordTranslation);
		return nvMemento;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void setMemento(Memento unMemento) {
		echelleZoom = unMemento.getEchelleZoom();
		coordTranslation = unMemento.getCoordTranslation();
		this.setChanged();
		this.notifyObservers();
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
	public void setEchelleZoom(double nvEchelleZoom) {
		echelleZoom = nvEchelleZoom;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public Point getCoordTranslation() {
		return coordTranslation;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void setCoordTranslation(Point nvCoordTranslation) {
		coordTranslation = nvCoordTranslation;
		this.setChanged();
		this.notifyObservers();
	}
	
}
