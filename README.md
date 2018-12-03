# MinhNam
Joueur class a tester avec ce code dans le main : 
	public static void main(String[] args) {
		joueur j1 = new joueur();
		Map l=listeDominos();
		Set set = l.entrySet();
		ArrayList myArrayList = (ArrayList) l.get(3);
		j1.setJoueurTour(3,myArrayList);
		System.out.println(j1.getJoueurTour());
		
	}
