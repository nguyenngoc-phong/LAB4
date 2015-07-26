/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: PanelPerspective.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import controleur.Controleur;
import modele.Perspective;
import modele.Vignette;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class PanelPerspective extends PanelVignette implements MouseListener, MouseMotionListener, MouseWheelListener {
	
	private Controleur controleur;
	private char indexPerspective;
	private Point coordTranslation;
	private double echelleZoom;
	private boolean sourisDansPanel;
	private boolean cliqueSurPanel;
	private Dimension dimension;
	
	/**
	 * Constructeur
	 */
	public PanelPerspective(Controleur controleur, char indexPerspective) {
		dimension = new Dimension(100, 100);
		
		this.controleur = controleur;
		this.indexPerspective = indexPerspective;
		
		image = null;
		coordTranslation = null;
		echelleZoom = 0;
		sourisDansPanel = false;
		cliqueSurPanel = false;
		
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		// g.translate(translationX, translationY);
		g2D.scale(echelleZoom, echelleZoom);
		g.drawImage(image, 0, 0, null);
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		image = ((Perspective) arg0).getImage();
		coordTranslation = ((Perspective) arg0).getCoordTranslation();
		echelleZoom = ((Perspective) arg0).getEchelleZoom();
		repaint();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		if(cliqueSurPanel) {
			controleur.zoomer(indexPerspective, ((double) arg0.getWheelRotation())/10);
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Écrire le code de la méthode.
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Écrire le code de la méthode.
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(sourisDansPanel) {
			cliqueSurPanel = true;
		}
		else {
			cliqueSurPanel = false;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		sourisDansPanel = true;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		sourisDansPanel = false;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Écrire le code de la méthode.
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Écrire le code de la méthode.
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}
}
