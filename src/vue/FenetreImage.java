/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: FenetreImage.java
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
import java.awt.GridLayout;
import java.awt.LayoutManager;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import modele.Perspective;
import modele.Vignette;
import controleur.Controleur;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class FenetreImage extends JComponent {
	
	private PanelVignette panelVignette;
	private PanelPerspective panelPerspectiveA;
	private PanelPerspective panelPerspectiveB;
	
	/**
	 * Constructeur
	 */
	public FenetreImage(Controleur controleur, Vignette vignette, Perspective perspectiveA, Perspective perspectiveB) {
		panelVignette = new PanelVignette();
		panelPerspectiveA = new PanelPerspective(controleur, 'A');
		panelPerspectiveB = new PanelPerspective(controleur, 'B');
		
		vignette.addObserver(panelVignette);
		perspectiveA.addObserver(panelPerspectiveA);
		perspectiveB.addObserver(panelPerspectiveB);
		
		this.setLayout(new GridLayout(2, 1));
		this.add(panelVignette);
		JPanel panelPerspective = new JPanel(new GridLayout(1, 2));
		panelPerspective.add(panelPerspectiveA);
		panelPerspective.add(panelPerspectiveB);
		this.add(panelPerspective);
	}
	
}
