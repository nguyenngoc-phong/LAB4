/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
Étudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: PanelImage.java
Date créé: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modele.Vignette;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class PanelVignette extends JPanel implements Observer {
	
	protected BufferedImage image;
	private Dimension dimension;
	
	public PanelVignette() {
		image = null;
		dimension = new Dimension(100, 100);
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, null);
	}
	
	/**
	 * Description de la méthode.
	 * @param
	 * @return
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		image = ((Vignette) arg0).getImage();
		repaint();
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
