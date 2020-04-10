package MvcCalculatriceV2.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueCalculatriceV2 extends JFrame{

	//attributs
	//creation d'une toile
	private JPanel pane = new JPanel();
	
	//creation de l'affichage de texte
	private JLabel labelNombre = new JLabel("Le chiffre saisie est : ");
	private JLabel labelChiffre1 = new JLabel("0");
	
	//creation des boutons de controle
	private JButton boutonIncrementation1 = new JButton("Ajouter");
	private JButton boutonDecrementation1 = new JButton("Retirer");
	private JButton boutonComparer = new JButton("Calculer");

	//creation part milieu
	private JLabel labelChiffreR1 = new JLabel("0");
	private JLabel labelCalcul = new JLabel("?");
	private JLabel labelChiffreR2 = new JLabel("0");
	private JLabel labelTotal = new JLabel("=");
	private JLabel labelChiffre1Bis = new JLabel("0");
	private JLabel labelResultat = new JLabel(" ");

	
	//la classe prend le nom du fichier mere	
	public VueCalculatriceV2() {

//option du cadre
		//definir un titre pour le cadre
		setTitle("Calculatrice Enfant");
		//definir une taille (1er longeur, 2er hauteur)
		setSize(600, 200);
		//fenetre centrer
		setLocationRelativeTo(null);
		// ne termine pas le processus lorsque l'on clique "fermer"
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//visibilite
		setVisible(true);
		//ajoute et placement des elements (controle panel)
		//option du panel
		pane.setLayout(new BorderLayout());
		
		//option du construct pour l'objet
		//attribuer ce panel a la fenetre
		this.setContentPane(pane);
		
//positionnement des labels
		//positionnement des boutons en haut avec changement de style de police et de couleur
		JPanel north = new JPanel();
		//creation de l'objet police qui fait appel a la classe font de java
		Font police = new Font("Tahoma", Font.BOLD, 16);
		//attribution de l'objet police
		labelNombre.setFont(police);
		labelNombre.setForeground(Color.blue);
		labelChiffre1.setFont(police);
	    labelChiffre1.setForeground(Color.red);
	    
	    north.add(labelNombre);
	    north.add(labelChiffre1);
	    pane.add(north, BorderLayout.NORTH);

		labelChiffreR1.setFont(police);
		labelChiffreR1.setForeground(Color.green);
		labelCalcul.setFont(police);
		labelCalcul.setForeground(Color.gray);
		labelChiffreR2.setFont(police);
		labelChiffreR2.setForeground(Color.green);
		labelTotal.setFont(police);
		labelTotal.setForeground(Color.gray);
		labelChiffre1.setFont(police);
	    labelChiffre1.setForeground(Color.red);
	    labelChiffre1Bis.setFont(police);
	    labelChiffre1Bis.setForeground(Color.red);
	    boutonComparer.setFont(police);
	    boutonComparer.setForeground(Color.black);
	    labelResultat.setFont(police);
	    labelResultat.setForeground(Color.orange);
	    
	    north.add(labelNombre);
	    north.add(labelChiffre1);
	    pane.add(north, BorderLayout.NORTH);
	    
	    //position centrer
	    JPanel center = new JPanel();
	    
	    center.add(labelChiffreR1);
	    center.add(labelCalcul);
	    center.add(labelChiffreR2);
	    center.add(labelTotal);
	    center.add(labelChiffre1Bis);
	    center.add(labelResultat);
	    pane.add(center, BorderLayout.CENTER);

		
	    //positionnement des boutons en bas
	    JPanel south = new JPanel();
	    south.add(boutonIncrementation1);
	    south.add(boutonDecrementation1);
	    south.add(boutonComparer);

	    pane.add(south, BorderLayout.SOUTH);
	} //fin de presentation du panel
	
	
/*
 *Changement de procedure pour liberer la vue
// si les boutons sont clickes, on execute la methode dans le controleur nomme actionPerformed
	public void addBoutonIncremListener1(ActionListener listenForCalcButton){
		boutonIncrementation1.addActionListener(listenForCalcButton);
	}

	public void addBoutonDecremListener1(ActionListener listenForCalcButton){
		boutonDecrementation1.addActionListener(listenForCalcButton);
	}
	
	public void addBoutonComparer(ActionListener action){
		boutonComparer.addActionListener(action);
	}
*/
//creation des boutons de controle

	public JButton getBoutonComparer() {
		return boutonComparer;
	}
		
	public void infoLabelResultat(String resultat) {
		setLabelResultat(resultat);
	}
	
	//getter & setter
	
//integration de la valuer int pour le label
	public int getLabelChiffre1() {
		return Integer.parseInt(labelChiffre1.getText());
	}
//lui demander la valeur en string car changement de valeur avec le get en int

	public void setLabelChiffre1(String solution) {
		labelChiffre1.setText(solution);
	}
	
	public void setLabelChiffre1(int resultat) {
		labelChiffre1.setText(Integer.toString(resultat));
	}
	
	public int getLabelChiffre1Bis() {
		return Integer.parseInt(labelChiffre1Bis.getText());
	}
	
	public void setLabelChiffre1Bis(int resultat) {
		labelChiffre1Bis.setText(Integer.toString(resultat));
	}

	public JButton getBoutonIncrementation1() {
		return boutonIncrementation1;
	}

	public void setBoutonIncrementation1(JButton boutonIncrementation1) {
		this.boutonIncrementation1 = boutonIncrementation1;
	}
	//le bouton decrement retourne un entier
	public JButton getBoutonDecrementation1() {
		return boutonDecrementation1; 
	}

	public void setBoutonDecrementation1(JButton boutonDecrementation1) {
		this.boutonDecrementation1 = boutonDecrementation1;
	}
	
	public void setLabelChiffreR1(int result) {
		labelChiffreR1.setText(Integer.toString(result));
	}
	
	public void setLabelChiffreR2(int result) {
		labelChiffreR2.setText(Integer.toString(result));
	}

	public void setLabelCalcul(String string) {
		labelCalcul.setText(string);
	}
	
	public String getLabelCalcul() {
		return labelCalcul.getText();
	}
	
	public void setLabelResultat(String solution) {
		labelResultat.setText(solution);
	}

	
} //fin
