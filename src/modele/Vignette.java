/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
�tudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: Image.java
Date cr��: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package modele;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Observable;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class Vignette extends Observable implements ActionListener, Serializable {
	
	private Image image;
	
	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO �crire le code de la m�thode.
	}
	
}
