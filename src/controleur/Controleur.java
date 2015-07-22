/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
�tudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Controleur.java
Date cr��: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package controleur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import modele.Vignette;
import modele.Perspective;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Controleur implements Observer, PropertyChangeListener {

	private Vignette image;
	private Perspective perspectiveA;
	private Perspective perspectiveB;
	private GestionActions gestionActions;
	private GestionRefaire gestionRefaire;
	private CopieColle copieColle;

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void chargerImage() {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void chargerPerspective() {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void enregistrerPerspective() {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void zoomer(int numPerspective) {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void translater(int numPerspective) {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void defaire(int numPerspective) {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void refaire(int numPerspective) {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void copier(int numPerspective) {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void coller(int numPerspective) {
		// TODO �crire le code de la m�thode.
	}
	
	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO �crire le code de la m�thode.
	}

	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		// TODO �crire le code de la m�thode.
	}
	
}
