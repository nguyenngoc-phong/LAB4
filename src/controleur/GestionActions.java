/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
�tudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: GestionActions.java
Date cr��: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package controleur;

import java.awt.Point;
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
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public GestionActions getInstance() {
		uniqueInstance = new GestionActions();
		return uniqueInstance;
	}
	
	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void ajouterAction(char perspective, char typeAction, Object param) {
		Action nvAction;
		
		if (typeAction == 'T') {
			nvAction = new Translation((Point) param);
		}
		else {
			nvAction = new Zoom((double) param);
		}
		
		if(perspective == 'A') {
			tabActionsA.add(nvAction);
			
			if(tabActionsA.size() > 10) {
				tabActionsA.remove(0);
			}
		}
		else {
			tabActionsB.add(nvAction);
			
			if(tabActionsB.size() > 10) {
				tabActionsB.remove(0);
			}
		}
	}
	
	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	public void enleverDerniereAction(char perspective) {
		if(perspective == 'A') {
			tabActionsA.remove(tabActionsA.size() - 1);
		}
		else {
			tabActionsB.remove(tabActionsB.size() - 1);
		}
	}
	
}
