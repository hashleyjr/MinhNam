import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class DominosTour {
	private TreeMap<Integer,Object> listeTour = new TreeMap<Integer,Object>();

	
	public DominosTour(){
		this.listeTour=listeTour;
		
	}

	public  TreeMap<Integer,Object> dominosNouveauTour(int nbJoueur, Map<Integer,Object> pioche) {
		Set keyNouveau = listeTour.keySet();
		Set entries = pioche.entrySet();
		Set key=pioche.keySet();
		if (nbJoueur==2 || nbJoueur==4) {
			
			while (listeTour.size()<4) {					//on veut 4 dominos
				Random r = new Random();
				Integer choisi = 1 + r.nextInt(48);			//nombre entre 1 et 48 pour choisir un domino
				if(key.contains(choisi)) {					//on verifie que le domino est dans la pioche
					Object value = pioche.get(choisi);
					listeTour.put(choisi, value);			//on ajoute le dom
					pioche.remove(key);				//on supprime le domino de la pioche
				}
			}
		}
		
		if (nbJoueur==3) {
			while (listeTour.size()<3) {					//on veut 3 dominos
				Random r = new Random();
				Integer choisi = 1 + r.nextInt(48);			//nombre entre 1 et 48 pour choisir un domino
				if(key.contains(choisi)) {					//on verifie que le domino est dans la pioche
					Object value = pioche.get(choisi);
					listeTour.put(choisi, value);			//on ajoute le dom
					pioche.remove(key);				//on supprime le domino de la pioche
				}
			}
		}
		return(listeTour);

	}
}
