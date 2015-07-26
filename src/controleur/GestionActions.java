/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: GestionActions.java
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
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class GestionActions {
	
	private static GestionActions uniqueInstance;
	private ArrayList<AbstractAction> tabActionsA, tabActionsB;
	private final int MAX_ACTIONS = 10;
	
	/**
	 * Constructeur
	 */
	private GestionActions() {
		tabActionsA = new ArrayList<AbstractAction>();
		tabActionsB = new ArrayList<AbstractAction>();
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public static GestionActions getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new GestionActions();
		}
		return uniqueInstance;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void ajouterAction(char indexPerspective, char typeAction, Object param, PropertyChangeListener unObservateur) {
		AbstractAction nvAction;
		
		switch(typeAction) {
			case('T'):
				nvAction = new Translation(indexPerspective, unObservateur);
				nvAction.putValue("coordTranslation", (Point) param);
				break;
			case('Z'):
				nvAction = new Zoom(indexPerspective, unObservateur);
				nvAction.putValue("echelleZoom", (double) param);
				break;
			default: nvAction = null;
		}
		
		if(nvAction != null) {
			
			switch(indexPerspective) {
				case('A'):
					tabActionsA.add(nvAction);
					if(tabActionsA.size() > MAX_ACTIONS) {
						tabActionsA.remove(0);
						tabActionsA.trimToSize();
					};
					break;
				case('B'):
					tabActionsB.add(nvAction);
					if(tabActionsB.size() > MAX_ACTIONS) {
						tabActionsB.remove(0);
						tabActionsB.trimToSize();
					};
					break;
			}
		}
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void enleverDerniereAction(char indexPerspective) {
		
		AbstractAction derniereAction = null;
		
		switch(indexPerspective) {
			case('A'):
				if(tabActionsA.size() != 0) {
					derniereAction = tabActionsA.get(tabActionsA.size() - 1);
					tabActionsA.remove(derniereAction);
					tabActionsA.trimToSize();
				}
				break;
			case('B'):
				if(tabActionsB.size() != 0) {
					derniereAction = tabActionsB.get(tabActionsB.size() - 1);
					tabActionsB.remove(derniereAction);
					tabActionsB.trimToSize();
				}
				break;
		}
		
		if(derniereAction != null) {
			
			derniereAction.setEnabled(false);
			
			if(derniereAction instanceof Translation) {
				Point coordTranslation = (Point) derniereAction.getValue("coordTranslation");
				coordTranslation = new Point(-(coordTranslation.x), -(coordTranslation.y));
				derniereAction.putValue("coordTranslation", coordTranslation);
			}
			else if(derniereAction instanceof Zoom) {
				double echelleZoom = (double) derniereAction.getValue("echelleZoom");
				echelleZoom = -(echelleZoom);
				derniereAction.putValue("echelleZoom", echelleZoom);
			}
		}
	}
	
}
