package game;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ListDominos {

	private Map<Integer, Object> listeDominos = new HashMap<Integer, Object>();
	private ArrayList<String> domParametre1 = new ArrayList<String>();
	private ArrayList<String> domParametre2 = new ArrayList<String>();
	private ArrayList<Object> domParametre = new ArrayList<Object>();
	String csvFile ="./dominos.csv"; // chemin du fichier
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

	{
		// créer la map de la liste des dominos
		try {

			br = new BufferedReader(new FileReader(csvFile));
			br.readLine(); // on skip la ligne 1
			while ((line = br.readLine()) != null) {

				// utilise une virgule comme séparateur
				String[] dominos = line.split(cvsSplitBy);
				// parametre de la moitié du domino
				domParametre1.add(dominos[0]);
				domParametre1.add(dominos[1]);
				domParametre1.add("x");
				domParametre1.add("y");

				// parametre de l'autre moitié du domino
				domParametre2.add(dominos[2]);
				domParametre2.add(dominos[3]);
				domParametre2.add("x");
				domParametre2.add("y");
				// le domino avec des clones des paramètres pour pouvoir "clear " les listes à
				// chaque boucle
				domParametre.add(domParametre1.clone());
				domParametre.add(domParametre2.clone());
				listeDominos.put(Integer.parseInt(dominos[4]), domParametre.clone()); // on ajoute le domino à la map
																						// listeDominos
				// on vide les listes pour les réutiliser
				domParametre.clear();
				domParametre1.clear();
				domParametre2.clear();
				
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public  ListDominos(){
		this.listeDominos=listeDominos;
	}
	
	/*---------------------------------------------*/
	
	// Choisir le nombre de dominos en fonction du nb de joueur.
	
	public Map<Integer,Object> ListeDepart(int nbJoueur) {
	if (nbJoueur == 2) {
		Set keys = listeDominos.keySet();
		while (keys.size()>12*2) {
			Random r = new Random();
			int valeur = 1 + r.nextInt(48);
			if (keys.contains(valeur)){
				listeDominos.remove(valeur);
			}		
		}
		return(listeDominos);
	}
	else if (nbJoueur == 3) {
		Set keys = listeDominos.keySet();
		while (keys.size()>12*3) {
			Random r = new Random();
			int valeur = 1 + r.nextInt(48);
			if (keys.contains(valeur)){
				listeDominos.remove(valeur);
			}		
		}
		return(listeDominos);

	}
	else {
		Set keys = listeDominos.keySet();
		return(listeDominos);

	}
	}
}
