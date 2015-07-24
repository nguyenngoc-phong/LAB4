/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: GestionRefaire.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package controleur;

import java.util.ArrayList;

import modele.Memento;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class GestionRefaire {
	
	private ArrayList<Memento> tabMementoA;
	private ArrayList<Memento> tabMementoB;
	private int indexMementoA;
	private int indexMementoB;
	private int indexDernierMementoA;
	private int indexDernierMementoB;
	private final int MAX_MEMENTOS = 10;
	
	/**
	 * Constructeur
	 */
	public GestionRefaire() {
		indexMementoA = 0;
		indexMementoB = 0;
		indexDernierMementoA = 0;
		indexDernierMementoB = 0;
	}
	
	public void ajouterMemento(char indexPerspective, Memento nvMemento) {
		
		switch(indexPerspective) {
			case('A'):
				if(indexMementoA < indexDernierMementoA) {
					tabMementoA = (ArrayList<Memento>) tabMementoA.subList(0, indexMementoA + 1);
				}
				
				tabMementoA.add(nvMemento);
			
				if(tabMementoA.size() > MAX_MEMENTOS) {
					tabMementoA.remove(0);
					tabMementoA.trimToSize();
				}
				else {
					indexDernierMementoA = ++indexMementoA;
				}
				break;
			case('B'):
				if(indexMementoB < indexDernierMementoA) {
					tabMementoB = (ArrayList<Memento>) tabMementoB.subList(0, indexMementoB + 1);
				}
				
				tabMementoB.add(nvMemento);
			
				if(tabMementoB.size() > MAX_MEMENTOS) {
					tabMementoB.remove(0);
					tabMementoB.trimToSize();
				}
				else {
					indexDernierMementoB = ++indexMementoB;
				}
				break;
		}
	}
	
	public Memento mementoPrecedent(char indexPerspective) {
		
		switch(indexPerspective) {
			case('A'):
				if(indexMementoA > 0) {
					return tabMementoA.get(--indexMementoA);
				}
				break;
			case('B'):
				if(indexMementoB > 0) {
					return tabMementoB.get(--indexMementoB);
				}
				break;
		}
		
		return null;
	}
	
	public Memento mementoSuivant(char indexPerspective) {
		
		switch(indexPerspective) {
			case('A'):
				if(indexMementoA < indexDernierMementoA) {
					return tabMementoA.get(++indexMementoA);
				}
				break;
			case('B'):
				if(indexMementoB < indexDernierMementoB) {
					return tabMementoB.get(++indexMementoB);
				}
				break;
		}
	
		return null;
	}
}
