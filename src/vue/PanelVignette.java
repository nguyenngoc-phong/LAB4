/******************************************************
Cours: LOG121
Session: E2015
Groupe: 01
Projet: Laboratoire #4
�tudiant(e)s: Carole Fabeleu, Dam-Hissey Kantchil et Ngoc-Phong Nguyen
              
              
Professeur: Francis Cardinal
Nom du fichier: PanelImage.java
Date cr��: 2015-07-17
Date dern. modif.: 2015-07-17
*******************************************************
Historique des modifications
*******************************************************
@author Ngoc-Phong Nguyen
2015-07-17 Version initiale
*******************************************************/

package vue;

import java.awt.Image;
import java.util.Observable;
import java.util.Observer;

import modele.Vignette;

/**
* Description de la classe.
* @author Ngoc-Phong Nguyen
* @date 2015/07/17
*/
public class PanelVignette implements Observer {
	
	private Vignette vignette;
	
	/**
	 * Description de la m�thode.
	 * @param
	 * @return
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO �crire le code de la m�thode.
	}
	
}
