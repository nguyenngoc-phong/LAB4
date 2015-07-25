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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
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
public class Controleur implements PropertyChangeListener {

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
		
		/*
		JFileChooser fichierImage = new JFileChooser();
		FileFilter filtreFichier = new FileNameExtensionFilter("JPEG", "JPG", "PNG");
		fichierImage.setFileFilter(filtreFichier);
		
		int valeurRetour = fichierImage.showOpenDialog(null);
		
		if(valeurRetour == JFileChooser.APPROVE_OPTION) {
			controleur.chargerImage(fichierImage.getSelectedFile().getAbsoluteFile());
		}
		*/
		
		Image image = ImageIO.read(cheminImage);
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
		
		/*
		JFileChooser fichierPerspective = new JFileChooser();
		
		int valeurRetour = fichierPerspective.showOpenDialog(null);
		
		if(valeurRetour == JFileChooser.APPROVE_OPTION) {
			controleur.chargerPerspective(fichierPerspective.getSelectedFile().getAbsoluteFile());
		}
		*/
		
		FileInputStream fis = new FileInputStream(cheminPerspective);
		ObjectInputStream oos = new ObjectInputStream(fis);
		
		Vignette[] tabVignettes = (Vignette[]) oos.readObject();

		oos.close();
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
	 */
	public void enregistrerPerspective() {
		// TODO Écrire le code de la méthode.
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
		// TODO Écrire le code de la méthode.
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
		Action action = (Action) arg0.getSource();
		char indexPerspective = (char) action.getValue("indexPerspective");
		
		if(action instanceof Translation) {

			Point coordTranslationAction = (Point) action.getValue("coordTranslation");
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
		}
		else if(action instanceof Zoom) {
			
			double echelleZoomAction = (double) action.getValue("echelleZoom");
			
			switch(indexPerspective) {
				case('A'): perspectiveA.setEchelleZoom(perspectiveA.getEchelleZoom() - echelleZoomAction);
					break;
				case('B'): perspectiveB.setEchelleZoom(perspectiveB.getEchelleZoom() - echelleZoomAction);
					break;
			}
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
