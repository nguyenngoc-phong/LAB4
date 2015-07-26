/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: FenetrePrincipale.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import modele.Perspective;
import modele.Vignette;
import controleur.Controleur;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class FenetrePrincipale extends JFrame {
	
	private FenetreImage fenetreImage;
	
	/**
	 * Constructeur
	 */
	public FenetrePrincipale(Controleur controleur, Vignette vignette, Perspective perspectiveA, Perspective perspectiveB) {
		final MenuFenetre menu = new MenuFenetre(controleur);
		fenetreImage = new FenetreImage(controleur, vignette, perspectiveA, perspectiveB);

		this.setTitle("Application Image");
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH); 
		this.add(fenetreImage, BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
