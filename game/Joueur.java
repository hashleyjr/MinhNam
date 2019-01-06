package game;
import java.util.*;

public class Joueur {
	String nom; 

	Map<Integer, ArrayList> joueurTour = new HashMap<Integer, ArrayList>();
	Map<Integer, Object> joueurProchainTour = new HashMap<Integer, Object>();

	public Joueur(String nom) {
		this.nom = nom;

	}

	public Map<Integer, ArrayList> getJoueurTour() {
		return joueurTour;
	}

	public void setJoueurTour(Integer key, ArrayList value) {
		joueurTour.put(key, value);
		this.joueurTour = joueurTour;
	}

	public Map<Integer, Object> getJoueurProchainTour() {
		return joueurProchainTour;
	}

	public void setJoueurProchainTour(Integer key, ArrayList value) {
		joueurProchainTour.put(key, value);
		this.joueurProchainTour = joueurProchainTour;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}

