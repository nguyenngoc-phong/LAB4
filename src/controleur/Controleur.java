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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

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
	private Perspective perspectiveA;
	private Perspective perspectiveB;
	private GestionActions gestionActions;
	private GestionRefaire gestionRefaire;
	private CopieColle copieColle;
	private boolean fichierCharge;
	private boolean defairePossible;
	private boolean refairePossible;
	private boolean copiePossible;
	private boolean collePossible;

	public Controleur() {
		vignette = new Vignette();
		perspectiveA = new Perspective();
		perspectiveB = new Perspective();
		gestionActions = gestionActions.getInstance();
		gestionRefaire = new GestionRefaire();
		copieColle = new CopieColle();
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 * @throws IOException 
	 */
	public void chargerImage() throws IOException {
		JFileChooser fichierImage = new JFileChooser();
		FileFilter filtreFichier = new FileNameExtensionFilter("JPEG", "JPG", "PNG");
		fichierImage.setFileFilter(filtreFichier);
		
		int valeurRetour = fichierImage.showOpenDialog(null);
		
		if(valeurRetour == JFileChooser.APPROVE_OPTION) {
			Image image = ImageIO.read(fichierImage.getSelectedFile().getAbsoluteFile());
			vignette.setImage(image);
			perspectiveA.setImage(image);
			perspectiveB.setImage(image);
		}
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void chargerPerspective() throws IOException, ClassNotFoundException {
		JFileChooser fichierPerspective = new JFileChooser();
		
		int valeurRetour = fichierPerspective.showOpenDialog(null);
		
		if(valeurRetour == JFileChooser.APPROVE_OPTION) {
			FileInputStream fis = new FileInputStream(fichierPerspective.getSelectedFile().getAbsolutePath());
			ObjectInputStream oos = new ObjectInputStream(fis);
			
			Vignette[] tabVignettes = (Vignette[]) oos.readObject();
			
			fis.close();
			oos.close();
			
			Vignette nvVignette = tabVignettes[0];
			Perspective nvPerspectiveA = (Perspective) tabVignettes[1];
			Perspective nvPerspectiveB = (Perspective) tabVignettes[2];
			
			vignette.setImage(nvVignette.getImage());
			
			perspectiveA.setImage(nvPerspectiveA.getImage());
			perspectiveA.setTranslation(nvPerspectiveA.getTranslation());
			perspectiveA.setZoom(nvPerspectiveA.getZoom());
			
			perspectiveB.setImage(nvPerspectiveB.getImage());
			perspectiveB.setTranslation(nvPerspectiveB.getTranslation());
			perspectiveB.setZoom(nvPerspectiveB.getZoom());
		}
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
		Memento memento = null;
		
		switch(indexPerspective) {
			case('A') :
				perspectiveA.setZoom(echelleZoom);
				memento = perspectiveA.createMemento();
				break;
			case('B') :
				perspectiveB.setZoom(echelleZoom);
				memento = perspectiveB.createMemento();
				break;
		}
		
		gestionActions.ajouterAction(indexPerspective, 'Z', echelleZoom, this);
		gestionRefaire.ajouterMemento(indexPerspective, memento);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void translater(char indexPerspective, Point translation) {
		Memento memento = null;
		
		switch(indexPerspective) {
			case('A') :
				perspectiveA.setTranslation(translation);
				memento = perspectiveA.createMemento();
				break;
			case('B') :
				perspectiveB.setTranslation(translation);
				memento = perspectiveB.createMemento();
				break;	
		}

		gestionActions.ajouterAction(indexPerspective, 'T', translation, this);
		gestionRefaire.ajouterMemento(indexPerspective, memento);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void defaire(char indexPerspective) {
		gestionActions.enleverDerniereAction(indexPerspective);
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
		Action derniereAction = (Action) arg0.getSource();
		char indexPerspective = (char) derniereAction.getValue("indexPerspective");
		
		if(derniereAction instanceof Translation) {
			Point coordTranslationDefait = (Point) derniereAction.getValue("coordTranslation");
			
			switch(indexPerspective) {
				case('A'): perspectiveA.setTranslation(coordTranslationDefait);
					break;
				case('B'): perspectiveB.setTranslation(coordTranslationDefait);
					break;
			}
		}
		else if(derniereAction instanceof Zoom) {
			double echelleZoomDefait = (double) derniereAction.getValue("echelleZoom");
			
			switch(indexPerspective) {
				case('A'): perspectiveA.setZoom(echelleZoomDefait);
					break;
				case('B'): perspectiveB.setZoom(echelleZoomDefait);
					break;
			}
		}
	
		gestionRefaire.mementoPrecedent(indexPerspective);
	}
	
}
