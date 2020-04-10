package MvcCalculatriceV2.Model;

import MvcCalculatriceV2.Controleur.ControleurCalculatriceV2;
import MvcCalculatriceV2.Model.CalculV2;
import MvcCalculatriceV2.Vue.IntroCalculetteV2;
import MvcCalculatriceV2.Vue.VueCalculatriceV2;

public class MainCalculatriceV2 {

	public static void main(String[] args) {
		
		ThreadLancementCalculetteV2 t = new ThreadLancementCalculetteV2();
		
		t.start();
	}
}
