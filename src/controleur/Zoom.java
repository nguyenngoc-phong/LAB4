/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Zoom.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package controleur;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.Action;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Zoom implements Action {

	private char indexPerspective;
	private double echelleZoom;
	private ArrayList<PropertyChangeListener> tabObservateurs;
	private boolean enabled;
	
	/**
	 * Constructeur
	 * @param
	 * @return
	 */
	public Zoom(char nvIndexPerspective, double nvEchelleZoom, PropertyChangeListener unObservateur) {
		indexPerspective = nvIndexPerspective;
		echelleZoom = nvEchelleZoom;
		tabObservateurs = new ArrayList<PropertyChangeListener>();
		tabObservateurs.add(unObservateur);
		enabled = true;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		notify();
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void addPropertyChangeListener(PropertyChangeListener arg0) {
		tabObservateurs.add(arg0);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public Object getValue(String arg0) {
		if(arg0.equals("indexPerspective")) {
			return indexPerspective;
		}
		else if(arg0.equals("echelleZoom")) {
			return echelleZoom;
		}
		else {
			return null;
		}
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void putValue(String arg0, Object arg1) {
		if(arg0.equals("indexPerspective")) {
			indexPerspective = (char) arg1;
		}
		else if(arg0.equals("echelleZoom")) {
			echelleZoom = (double) arg1;
		}
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void removePropertyChangeListener(PropertyChangeListener arg0) {
		tabObservateurs.remove(arg0);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void setEnabled(boolean arg0) {
		enabled = arg0;
	}
	
}
