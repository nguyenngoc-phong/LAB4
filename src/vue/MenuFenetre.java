/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: MenuFenetre.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controleur.Controleur;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class MenuFenetre extends JMenuBar {
	
	private Controleur controleur;
	
	/**
	 * Constructeur
	 */
	public MenuFenetre(Controleur controleur) {
		this.controleur = controleur;
		addMenuFichier();
		addMenuModifier();
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	private void addMenuFichier() {
		JMenu fichier = new JMenu("Fichier");
		fichier.add(new JMenuItem("Ouvrir Image"));
		fichier.add(new JMenuItem("Ouvrir Perspective"));
		fichier.add(new JMenuItem("Sauvegarder Perspective"));
		fichier.add(new JMenuItem("Quitter"));
		
		fichier.getItem(0).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						JFileChooser fichierImage = new JFileChooser();
						FileFilter filtreFichier = new FileNameExtensionFilter("JPEG", "JPG", "PNG");
						fichierImage.setFileFilter(filtreFichier);
						
						int valeurRetour = fichierImage.showOpenDialog(null);
						
						if(valeurRetour == JFileChooser.APPROVE_OPTION) {
							try {
								controleur.chargerImage(fichierImage.getSelectedFile().getAbsoluteFile());
							} 
							catch (IOException e) {
								
							}
						}
					}
				}
		);
		
		fichier.getItem(1).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JFileChooser fichierPerspective = new JFileChooser();
						
						int valeurRetour = fichierPerspective.showOpenDialog(null);
						
						if(valeurRetour == JFileChooser.APPROVE_OPTION) {
							try {
								controleur.chargerPerspective(fichierPerspective.getSelectedFile().getAbsoluteFile());
							}
							catch (ClassNotFoundException | IOException e) {
								
							}
						}
					}
				}
		);
		
		fichier.getItem(2).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		fichier.getItem(3).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		// fichier.getItem(0).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		// fichier.getItem(1).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		fichier.getItem(2).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		
		this.add(fichier);
	}

	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	private void addMenuModifier() {
		JMenu modifier = new JMenu("Modifier");
		modifier.add(new JMenuItem("Translater"));
		modifier.add(new JMenuItem("Zoomer"));
		modifier.add(new JMenuItem("Défaire"));
		modifier.add(new JMenuItem("Refaire"));
		modifier.add(new JMenuItem("Copier"));
		modifier.add(new JMenuItem("Coller"));
		
		modifier.getItem(0).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		modifier.getItem(1).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		modifier.getItem(2).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		modifier.getItem(3).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		modifier.getItem(4).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		modifier.getItem(5).addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				}
		);
		
		modifier.getItem(0).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		// modifier.getItem(1).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		modifier.getItem(2).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		modifier.getItem(3).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		modifier.getItem(4).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		modifier.getItem(5).setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		
		this.add(modifier);
	}
	
}
