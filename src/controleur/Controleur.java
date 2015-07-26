/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Controleur.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package controleur;

import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;

import modele.Memento;
import modele.Vignette;
import modele.Perspective;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Controleur extends Observable implements PropertyChangeListener {

	private Vignette vignette;
	private Perspective perspectiveA, perspectiveB;
	private GestionActions gestionActions;
	private GestionRefaire gestionRefaire;
	private CopieColle copieColle;
	private boolean fichierCharge, defairePossible, refairePossible, copiePossible, collePossible;

	/**
	 * Constructeur
	 */
	public Controleur(Vignette nvVignette, Perspective nvPerspectiveA, Perspective nvPerspectiveB) {
		vignette = nvVignette;
		perspectiveA = nvPerspectiveA;
		perspectiveB = nvPerspectiveB;
		gestionActions = gestionActions.getInstance();
		gestionRefaire = new GestionRefaire();
		copieColle = new CopieColle();
		fichierCharge = false;
		defairePossible = false;
		refairePossible = false;
		copiePossible = false;
		collePossible = false;
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 * @throws IOException 
	 */
	public void chargerImage(File cheminImage) throws IOException {
		BufferedImage image = ImageIO.read(cheminImage);
		
		vignette.setImage(image);
		perspectiveA.setImage(image);
		perspectiveB.setImage(image);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void chargerPerspective(File cheminPerspective) throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream(cheminPerspective);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Vignette[] tabVignettes = (Vignette[]) ois.readObject();

		ois.close();
		fis.close();
		
		Vignette nvVignette = tabVignettes[0];
		Perspective nvPerspectiveA = (Perspective) tabVignettes[1];
		Perspective nvPerspectiveB = (Perspective) tabVignettes[2];
		
		vignette.setImage(nvVignette.getImage());
		
		perspectiveA.setImage(nvPerspectiveA.getImage());
		perspectiveA.setCoordTranslation(nvPerspectiveA.getCoordTranslation());
		perspectiveA.setEchelleZoom(nvPerspectiveA.getEchelleZoom());
		
		perspectiveB.setImage(nvPerspectiveB.getImage());
		perspectiveB.setCoordTranslation(nvPerspectiveB.getCoordTranslation());
		perspectiveB.setEchelleZoom(nvPerspectiveB.getEchelleZoom());
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 * @throws IOException 
	 */
	public void enregistrerPerspective(File cheminPerspective) throws IOException {
		Vignette[] tabVignettes = {vignette, perspectiveA, perspectiveB};
		
		FileOutputStream fos = new FileOutputStream(cheminPerspective);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(tabVignettes);;

		oos.close();
		fos.close();
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void zoomer(char indexPerspective, double echelleZoom) {
		gestionActions.ajouterAction(indexPerspective, 'Z', echelleZoom, this);
		ajouterMemento(indexPerspective);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void translater(char indexPerspective, Point translation) {
		gestionActions.ajouterAction(indexPerspective, 'T', translation, this);
		ajouterMemento(indexPerspective);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void defaire(char indexPerspective) {
		gestionActions.enleverDerniereAction(indexPerspective);
		gestionRefaire.mementoPrecedent(indexPerspective);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void refaire(char indexPerspective) {
		Memento mementoSuivant = gestionRefaire.mementoSuivant(indexPerspective);
		Perspective perspective = null;
		
		switch(indexPerspective) {
			case('A'): perspective = perspectiveA;
				break;
			case('B'): perspective = perspectiveB;
				break;
		}
		
		if(perspective != null) {
			
			if(!(mementoSuivant.getCoordTranslation().equals(perspective.getCoordTranslation()))) {
				Point coordTranslationMemento = mementoSuivant.getCoordTranslation();
				Point coordTranslationPerspective = perspective.getCoordTranslation();
				
				int x = coordTranslationMemento.x - coordTranslationPerspective.x;
				int y = coordTranslationMemento.y - coordTranslationPerspective.y;
				
				gestionActions.ajouterAction(indexPerspective, 'T', new Point(x, y), this);
			}
			else if(!(mementoSuivant.getEchelleZoom() != perspective.getEchelleZoom())) {
				double nvEchelleZoom = mementoSuivant.getEchelleZoom() - perspective.getEchelleZoom();
				
				gestionActions.ajouterAction(indexPerspective, 'Z', nvEchelleZoom, this);
			}
			
			perspective.setMemento(mementoSuivant);
		}
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void copier(char indexPerspective) {
		// TODO Écrire le code de la méthode.
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void coller(char indexPerspective) {
		// TODO Écrire le code de la méthode.
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void propertyChange(PropertyChangeEvent arg0) {
		char typeAction = arg0.getPropertyName().charAt(0);
		char indexPerspective = (char) arg0.getOldValue();
		
		switch(typeAction) {
			case('T'):
				Point coordTranslationAction = (Point) arg0.getNewValue();
				Point coordTranslation;
				int x, y;
				
				switch(indexPerspective) {
					case('A'):
						coordTranslation = perspectiveA.getCoordTranslation();
						x = coordTranslation.x + coordTranslationAction.x;
						y = coordTranslation.y + coordTranslationAction.y;
						perspectiveA.setCoordTranslation(new Point(x, y));
						break;
					case('B'):
						coordTranslation = perspectiveB.getCoordTranslation();
						x = coordTranslation.x + coordTranslationAction.x;
						y = coordTranslation.y + coordTranslationAction.y;
						perspectiveB.setCoordTranslation(new Point(x, y));
						break;
				}
				
				break;
			case('Z'):
				double echelleZoomAction = (double) arg0.getNewValue();
				
				switch(indexPerspective) {
					case('A'): perspectiveA.setEchelleZoom(perspectiveA.getEchelleZoom() - echelleZoomAction);
						break;
					case('B'): perspectiveB.setEchelleZoom(perspectiveB.getEchelleZoom() - echelleZoomAction);
						break;
				}
				
			break;
		}
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	private void ajouterMemento(char indexPerspective) {
		Memento memento = null;
		
		switch(indexPerspective) {
			case('A') :
				memento = perspectiveA.creerMemento();
				break;
			case('B') :
				memento = perspectiveB.creerMemento();
				break;
		}
		
		if(memento != null) {
			gestionRefaire.ajouterMemento(indexPerspective, memento);
		}
	}
	
}
