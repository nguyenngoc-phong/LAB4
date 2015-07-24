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

import javax.swing.Action;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class GestionActions {
	
	private GestionActions uniqueInstance;
	private ArrayList<Action> tabActionsA;
	private ArrayList<Action> tabActionsB;
	private final int MAX_ACTIONS = 10;
	
	/**
	 * Constructeur
	 */
	private GestionActions() {
		tabActionsA = new ArrayList<Action>();
		tabActionsB = new ArrayList<Action>();
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public GestionActions getInstance() {
		uniqueInstance = new GestionActions();
		return uniqueInstance;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void ajouterAction(char indexPerspective, char typeAction, Object param, PropertyChangeListener observateur) {
		Action nvAction = null;
		
		switch(typeAction) {
			case('T'):	nvAction = new Translation(indexPerspective, (Point) param);
				break;
			case('Z'):	nvAction = new Zoom(indexPerspective, (double) param);
				break;
		}
		
		if(nvAction != null) {
			
			nvAction.addPropertyChangeListener(observateur);
			
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
		Action derniereAction;
		
		switch(indexPerspective) {
			case('A'):
				if(tabActionsA.size() > 0) {
					derniereAction = tabActionsA.get(tabActionsA.size() - 1);
					derniereAction.setEnabled(false);
					tabActionsA.remove(derniereAction);
					tabActionsA.trimToSize();
				}
				break;
			case('B'):
				if(tabActionsB.size() > 0) {
					derniereAction = tabActionsB.get(tabActionsB.size() - 1);
					derniereAction.setEnabled(false);
					tabActionsB.remove(derniereAction);
					tabActionsB.trimToSize();
				}
				break;
		}
	}
	
}
