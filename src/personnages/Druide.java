package personnages;
import java.util.Random;


public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	protected int forcePotion = 1;
	
	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		super();
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + '"' + texte + '"');
	}
	
	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void preparerPotion() {
		Random rnd = new Random();
		int fp = rnd.nextInt(effetPotionMax - effetPotionMin +1) + effetPotionMin;
		if (fp > 7) {
			parler("J'ai préparé une super potion de force " + fp);
		}else {
			parler("Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force" + fp);
		}
		this.forcePotion = fp;
	}
	
	public void booster(Gaulois gaulois) {
		if (gaulois.getNom() == "Obélix") {
			parler("Non, Obélix !... Tu n’auras pas de potion magique !");
		}
		else {
			gaulois.boirePotion(this.forcePotion);
		}
	}
		
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		panoramix.preparerPotion();
		panoramix.parler("ma barbe est tarpin longue");
	}
}
