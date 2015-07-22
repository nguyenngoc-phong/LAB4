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
	private ArrayList<Action> tabActions1;
	private ArrayList<Action> tabActions2;
	private final int MAX_ACTIONS = 10;
	
	/**
	 * Constructeur
	 */
	private GestionActions() {
		tabActions1 = new ArrayList<Action>();
		tabActions2 = new ArrayList<Action>();
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
	public void ajouterAction(int numPerspective, char typeAction, Object param, PropertyChangeListener observateur) {
		Action nvAction;
		
		if (typeAction == 'T') {
			nvAction = new Translation((Point) param);
		}
		else {
			nvAction = new Zoom((double) param);
		}
		
		nvAction.addPropertyChangeListener(observateur);
		
		if(numPerspective == 1) {
			tabActions1.add(nvAction);
			
			if(tabActions1.size() > 10) {
				tabActions1.remove(0);
			}
		}
		else {
			tabActions2.add(nvAction);
			
			if(tabActions2.size() > 10) {
				tabActions2.remove(0);
			}
		}
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void enleverDerniereAction(int numPerspective) {
		if(numPerspective == 1) {
			tabActions1.remove(tabActions1.size() - 1);
		}
		else {
			tabActions2.remove(tabActions2.size() - 1);
		}
	}
	
}
