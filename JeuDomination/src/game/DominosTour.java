package game;
import java.util.*;

public class DominosTour {
	private TreeMap<Integer,ArrayList<ArrayList<String>>> listeTour = new TreeMap<Integer,ArrayList<ArrayList<String>>>();
	private ArrayList<TreeMap<Integer,ArrayList<ArrayList<String>>>> AllTourDomino = new ArrayList<TreeMap<Integer,ArrayList<ArrayList<String>>>>();
	ListDominos pioche= new ListDominos();
	ArrayList<ArrayList<ArrayList<ArrayList<String>>>> essay= new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();


	
	public DominosTour(){
		this.listeTour=listeTour;

	}

	public  ArrayList<Map<Integer,ArrayList<ArrayList<String>>>> dominosNouveauTour(int nbJoueur, Map<Integer,ArrayList<ArrayList<String>>> pioche) {
		Set entries = pioche.entrySet();
		Set key=pioche.keySet();
		Random r = new Random();

		if (nbJoueur==2 || nbJoueur==4) {
			
			while (listeTour.size()<4) {					//on veut 4 dominos
				Integer choisi = 1 + r.nextInt(48);			//nombre entre 1 et 48 pour choisir un domino
				if(key.contains(choisi)) {				//on verifie que le domino est dans la pioche
					ArrayList<ArrayList<String>> value = pioche.get(choisi);
					listeTour.put(choisi, value);			//on ajoute le dom
					pioche.remove(choisi);				//on supprime le domino de la pioche
				}
			}
		}
		
		if (nbJoueur==3) {
			while (listeTour.size()<3) {					//on veut 3 dominos
				Integer choisi = 1 + r.nextInt(48);			//nombre entre 1 et 48 pour choisir un domino
				if(key.contains(choisi)) {					//on verifie que le domino est dans la pioche
					ArrayList<ArrayList<String>> value = pioche.get(choisi);
					listeTour.put(choisi, value);			//on ajoute le dom
					pioche.remove(choisi);				//on supprime le domino de la pioche
				}
			}
		}
		ArrayList<Map<Integer,ArrayList<ArrayList<String>>>> list = new ArrayList<Map<Integer,ArrayList<ArrayList<String>>>>();
		list.add(pioche);
		list.add(listeTour);
		return(list);

	}
	public ArrayList<ArrayList<ArrayList<String>>> affichDominos(Map<Integer,ArrayList<ArrayList<String>>> listeTour){
		
		Set key = listeTour.keySet();
		Set entries = listeTour.entrySet();
		Iterator iterator = listeTour.entrySet().iterator();
		ArrayList<ArrayList<ArrayList<String>>> liste=new ArrayList<ArrayList<ArrayList<String>>>();
		ArrayList<ArrayList<ArrayList<ArrayList<String>>>> AllTour=new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();


		while (iterator.hasNext()) {
			Map.Entry mapentry = (Map.Entry) iterator.next();
			ArrayList<ArrayList<String>> element=(ArrayList<ArrayList<String>>)mapentry.getValue();
			liste.add(element);
		}
		return(liste);

	}
	
	public ArrayList<ArrayList<ArrayList<ArrayList<String>>>> AllDominoTour(int nbJoueur) {
		Map<Integer,ArrayList<ArrayList<String>>> map= pioche.ListeDepart(nbJoueur);

		for(int u=0;u<6;u++) {
			
			DominosTour DominosTour=new DominosTour();
			Map<Integer,ArrayList<ArrayList<String>>> tour2 =(DominosTour.dominosNouveauTour(nbJoueur,map)).get(1);
			Map<Integer,ArrayList<ArrayList<String>>> nouvellePioche2 =(DominosTour.dominosNouveauTour(nbJoueur,map)).get(0);
			map = nouvellePioche2;
			System.out.println(tour2); //les dominos tiré de la pioche
			System.out.println(nouvellePioche2); //les dominos tiré de la pioche
			System.out.println(DominosTour.affichDominos(tour2));
			System.out.println(map.size());
			System.out.println("  ");
			essay.add(DominosTour.affichDominos(tour2));



	}
		System.out.println("ess"+essay);
		for (int i=0; i<6;i++) {
			System.out.println("tour"+ i+" : "+ essay.get(i));
		}
		return(essay);
	}


		
}
	
	

