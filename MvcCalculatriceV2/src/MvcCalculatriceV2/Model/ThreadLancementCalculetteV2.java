package MvcCalculatriceV2.Model;

import MvcCalculatriceV2.Controleur.ControleurCalculatriceV2;
import MvcCalculatriceV2.Vue.IntroCalculetteV2;
import MvcCalculatriceV2.Vue.VueCalculatriceV2;

public class ThreadLancementCalculetteV2 extends Thread{
	private int sec;
	
	private int periodeFenetre = 10;
	private IntroCalculetteV2 intro;
	private ControleurCalculatriceV2 calc;
	
	public ThreadLancementCalculetteV2() {
		sec = 0;
	}
	
	public void run() {

		intro = new IntroCalculetteV2();
		
		while(true) {
			
			// Incrementer les secondes
			sec++;
						
			//fermer l'intro de lancement
			if(sec == periodeFenetre) {
				intro.dispose();
				CalculV2 calc = new CalculV2();
				VueCalculatriceV2 vue = new VueCalculatriceV2();
				ControleurCalculatriceV2 ctrl = new ControleurCalculatriceV2(calc, vue);
			}
				
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} //fin run
} //fin
