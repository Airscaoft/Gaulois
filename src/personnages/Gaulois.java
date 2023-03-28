package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + '"' + texte + '"');
	}
	
	private String prendreParole() {
		return "Le Gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
		romain.recevoirCoup((force/3)*this.effetPotion);
	}
	
	public void boirePotion(int forcePopo) {
		parler("Merci Druide, je sens que ma force est " + forcePopo + " fois d�cupl�e");
		this.effetPotion = forcePopo;
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix",8);
		Romain rom1 = new Romain("Noopy",6);
		Druide d1 = new Druide("Panoramix", 2, 4);
		d1.preparerPotion();
//		System.out.println(asterix);
//		System.out.println(asterix.getNom());
//		System.out.println(asterix.prendreParole());
		asterix.parler("je suis le plus fort quand j'suis boosted � la popo");
		asterix.frapper(rom1);
		asterix.boirePotion(d1.forcePotion);
		asterix.frapper(rom1);
	}
}
