import java.util.Arrays;
import java.util.Scanner;
public class Principale {
	static int scoreJoueur = 0;
	static int scoreOrdinateur = 0;
	static String pseudo = null;
	static boolean reloadgame = true;
	static String[] valeurs = {"pierre", "feuille", "ciseaux"};
	static String[] reponsePositive = {"yes"};
	static String[] reponseNegative = {"no"};
	
	
	
	public static void main(String[] args) {
		while(reloadgame) {
		
		
				
		choixPseudo(); //le joueur choisi son pseudo
		int manche = 0;
		while(manche < 3)
		{
		String choixDuJoueur = choixJ();
		
		int choixOrdinateur = (int) (Math.random() * valeurs.length);
		System.out.println("L'ordinateur à choisi "+valeurs[choixOrdinateur]);
		
		battle(choixOrdinateur, choixDuJoueur);
		
		
		manche++;
		}
	
		resultatPartie(scoreJoueur, scoreOrdinateur);
		manche = 0;
		pseudo = null;
		relancerPartie();
		}
		
	
	}
	
	public static String choixJ() {
		Boolean valeurEntree = false;
		String inputJoueur = null;
		while(!valeurEntree) {
				
				
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Veuillez faire votre choix (pierre, feuille ou ciseaux):");
		inputJoueur = inputReader.next();
			
		if (Arrays.asList(valeurs).contains(inputJoueur)) {
			valeurEntree = true;
		}
		else {
			System.out.println("Merci de saisir une entrée valide (pierre, feuille ou ciseaux)");	
		}
	
		}
		return inputJoueur;
		
	}
	//test les choix du joueur
	public static void battle(int choixOrdinateur, String choixDuJoueur) {	
		if (choixOrdinateur == 0 && choixDuJoueur.equals("pierre")) {
			System.out.println("Egalité!");
		
		}
		else if (choixOrdinateur == 0 && choixDuJoueur.equals("feuille")) {
			System.out.println("La feuille bat la pierre!");
			scoreJoueur++;
		}
		else if (choixOrdinateur==0 && choixDuJoueur.equals("ciseaux")){
			System.out.println("La pierre bat les ciseaux!");
			scoreOrdinateur++;
		}
		else if (choixOrdinateur == 1 && choixDuJoueur.equals("pierre")) {
			System.out.println("La feuille bat la pierre!");
			scoreOrdinateur++;
		}
		else if (choixOrdinateur==1 && choixDuJoueur.equals("feuille")) {
			System.out.println("Egalité!");
			
		}
		else if (choixOrdinateur==1 && choixDuJoueur.equals("ciseaux")) {
			System.out.println("Les ciseaux battent la feuille!");
			scoreJoueur++;
		}
		else if (choixOrdinateur==2 && choixDuJoueur.equals("pierre")) {
			System.out.println("La pierre bat les ciseaux!");
			scoreJoueur++;
		}
		else if (choixOrdinateur==2 && choixDuJoueur.equals("feuille")) {
			System.out.println("Les ciseaux battent la feuille!");
			scoreOrdinateur++;
		}
		else if (choixOrdinateur==2 && choixDuJoueur.equals("ciseaux")){
			System.out.println("Egalité!");	
		}
	}
		//donne le resultat de la partie
	public static void resultatPartie (int scoreJoueur, int scoreOrdinateur) {
		if (scoreJoueur == scoreOrdinateur) {
			System.out.println("Partie terminée");
			System.out.println("Le score de l'ordinateur est de "+scoreOrdinateur);
			System.out.print("Le score de "+pseudo+" est de "+scoreJoueur);
			System.out.println("Egalité!");
		}
		else if (scoreJoueur > scoreOrdinateur) {
			System.out.println("Partie terminée");
			System.out.println("Le score de l'ordinateur est de "+scoreOrdinateur);
			System.out.println("Le score de "+pseudo+ " est de "+scoreJoueur);
			System.out.println(pseudo+" gagne la partie!");
			
		}
			
		else {
			System.out.println("Partie terminée");
			System.out.println("Le score de l'ordinateur est de "+scoreOrdinateur);
			System.out.println("Le score de "+ pseudo +" est de "+scoreJoueur);
			System.out.println("L'ordinateur gagne la partie!");
		}
	}// permet au joueur de choisir son pseudo
	public static void choixPseudo() {
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Choisissez votre pseudo:");
		pseudo = inputReader.next();
		
			
		}// donne le choix au joueur de relancer ou non une partie
	public static void relancerPartie() {
		String reponse = null;
		Boolean bonneReponse = false;
		while(!bonneReponse) {
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Souhaitez-vous lancer une nouvelle partie?(yes or no)");
		reponse = inputReader.next();
		if (Arrays.asList(reponsePositive).contains(reponse)) {
			reloadgame = true;
			bonneReponse = true;
			scoreJoueur = 0;
			scoreOrdinateur = 0;
		}
		else if (Arrays.asList(reponseNegative).contains(reponse)) {
			System.out.println("Merci d'avoir joué, à bientôt!");
			reloadgame = false;
			bonneReponse = true;
			
					
		}
		}
	}
	}
	
	
	
	
	


