package MvcCalculatriceV2.Controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import MvcCalculatriceV2.Model.CalculV2;
import MvcCalculatriceV2.Vue.IntroCalculetteV2;
import MvcCalculatriceV2.Vue.VueCalculatriceV2;

public class ControleurCalculatriceV2{

	//attributs
	private CalculV2 calc;
	private VueCalculatriceV2 vue;
	Timer wait = new Timer();
	
	private int resultat;
	private int compteur = 0;
	private int erreur =0;
	
	//constructeur
	public ControleurCalculatriceV2 (CalculV2 c, VueCalculatriceV2 v) {
		this.calc = c;
		vue = v;

		vue.getBoutonComparer().addActionListener(new BoutonComparer());
		vue.getBoutonIncrementation1().addActionListener(new BoutonIncremListener1());
		vue.getBoutonDecrementation1().addActionListener(new BoutonDecreListener1());
	
		vue.addWindowListener(new java.awt.event.WindowAdapter() {	    	
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	procedureDeFermeture();
		    }
		});
		this.genererCalcul();
	}
	
	//methodes
	public void procedureDeFermeture() {
		IntroCalculetteV2 intro1 = new IntroCalculetteV2();
    	Timer fermeture = new Timer();
		fermeture.schedule(new TimerTask() {
			
			public void run() {
				System.exit(0);
			}
		},5000 // les secondes du délais (1000 = 1sec)
		);
	}
	
	public void genererCalcul() {
		//genere un calcul aleatoire de 5 additions sur 6 soustractions
		int r  = (int)(Math.random() * 10);
		if(r > 4 ) {
			this.valeurRanAddition();
		}else {
			this.valeurRanSoustraction();
		}
		
	}

	public void valeurRanAddition() {
		//genere chiffres et envoi vers l'addition
		int num1 = calc.getNum1();
		int num2 = calc.getNum2();
		num1 = (int)(Math.random()*((9 - 0)+1));
		num2 = (int)(Math.random()*(10 - num1) + 1);
		calc.setNum1(num1);
		calc.setNum2(num2);
		
		vue.setLabelChiffreR1(calc.getNum1());
		vue.setLabelChiffreR2(calc.getNum2());
		vue.setLabelCalcul("+");
	}

	
	public void valeurRanSoustraction() {
		//genere chiffres et envoi vers la soustraction
		int num1 = calc.getNum1();
		int num2 = calc.getNum2();
		num1 = (int)(Math.random()*((9 - 0)+1));
		num2 = (int)(Math.random()*(num1 - 1) +1);
		calc.setNum1(num1);
		calc.setNum2(num2);
		
		vue.setLabelChiffreR1(calc.getNum1());
		vue.setLabelChiffreR2(calc.getNum2());
		vue.setLabelCalcul("-");
	}
	
	public void verifierAddition() {
		//valeur du resultat verifie avec le resultat de l'operation choisi
		if(resultat == calc.additionRandom()) {
			vue.infoLabelResultat("Bien joué mais te la péte pas trop!");
			wait.schedule(new TimerTask() {
				
				public void run() {
					procedureDeFermeture();
				}
			},2000 // les secondes du délais (1000 = 1sec)
			);
			
		}else {
			//res permet d'afficher le nombre d'essai restant
			int res;
			erreur++;
			res = 3 - erreur;
			vue.setLabelResultat("T'es mauvais Jack, tu sais pas jouer! Recommence "+res);
			if(res == 0) {
				vue.infoLabelResultat("Le resultat était : "+calc.additionRandom()+" entraine toi plus!");
				wait.schedule(new TimerTask() {
					
					public void run() {
						procedureDeFermeture();
					}
				},2000 // les secondes du délais (1000 = 1sec)
				);
				
			}
		}
	}
	
	public void verifierSoustraction() {
		//valeur du resultat verifie avec le resultat de l'operation choisi
		if(resultat == calc.soustractionRandom()) {
			vue.infoLabelResultat("Bien joué mais te la péte pas trop!");
			wait.schedule(new TimerTask() {
				
				public void run() {
					procedureDeFermeture();
				}
			},2000 // les secondes du délais (1000 = 1sec)
			);
			
		}else {
			int res;
			erreur++;
			res = 3 - erreur;
			vue.infoLabelResultat("T'es mauvais Jack, tu sais pas jouer! Recommence "+res);
			if(res == 0) {
				vue.infoLabelResultat("Le resultat était : "+calc.soustractionRandom()+" entraine toi plus!");
				wait.schedule(new TimerTask() {
					
					public void run() {
						procedureDeFermeture();
					}
				},2000 // les secondes du délais (1000 = 1sec)
				);
				
			}
		}
	}
		

	//Classe écoutant
	class BoutonIncremListener1 implements ActionListener{
		
	//Redéfinition de la méthode actionPerformed()
	//note perso : l'action performed prend la 1er valeur qui lui vient comme la sienne
		public void actionPerformed(ActionEvent e) {
			//creation du compteur bloqué entre 0 et 10
			if(compteur >= 0 && compteur < 10) {
				compteur++;
				resultat = compteur;

				vue.setLabelChiffre1(resultat);
				vue.setLabelChiffre1Bis(resultat);
			}
		}
	}
	
	//Classe écoutant notre second bouton
	class BoutonDecreListener1 implements ActionListener{
		
	//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			if(compteur > 0 && compteur <= 10) {
				compteur--;
				resultat = compteur;

				vue.setLabelChiffre1(resultat);
				vue.setLabelChiffre1Bis(resultat);
			}
		}
	} 

	//Classe écoutant notre bouton comparer
	class BoutonComparer implements ActionListener{
		
	//Redéfinition de la méthode actionPerformed()
		public void actionPerformed(ActionEvent e) {
			String symbole;
			//valeur du resultat verifie avec le resultat de l'operation choisi
			symbole = vue.getLabelCalcul();
			
			if(symbole == "+") {
				verifierAddition();
			}
			else if(symbole == "-") {
				verifierSoustraction();
			}
		
		}
	}
/*	
	 fonction utile
		public static void fermetureProgramme() {
			
			Timer fermetureApresResultat = new Timer();  
			fermetureApresResultat.schedule(new TimerTask() {
				
				public void run() {
					System.exit(0);
				}
			},1 // les secondes du délais (1000 = 1sec)
			);
		}
		
		public void pauseProgramme() {

			try {
				TimeUnit.SECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
*/
} //fin
