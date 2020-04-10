package MvcCalculatriceV2.Vue;

import javax.swing.*;

public class IntroCalculetteV2 extends JFrame{

	private JPanel pane = new JPanel();
	
	private int ht = 1024;
	private int lg = 768;
	
	public IntroCalculetteV2() {
						    
		//regler la taille
		setSize(ht,lg);
		setLocationRelativeTo(null);
		
		//localisation de l'image
		ImageIcon icone = new ImageIcon("image.jpg"); 
		JLabel image = new JLabel(icone);
		pane.add(image);
		setVisible(true);
		
		//attribuer ce panel a la fenetre
		this.setContentPane(pane);
	}
	
} //fin


