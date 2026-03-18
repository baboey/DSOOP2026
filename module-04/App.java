public class App {
	public void main() {
		Human a = new Human("Abe");

		System.out.println(a.getName());

		a.setHumanDesire("being kind", 5);
		a.setPrimalDesire("Want pizza", "Extreme Hunger");

		a.printHumanDesire();
		a.printPrimalDesire();
	}
}

class Human {
	private String name;
	private HumanDesire hDesire = new HumanDesire();
	private PrimalDesire pDesire = new PrimalDesire();

	Human(String N) { name = N; }

	public void setName(String N) { name = N; }

	public String getName() { return name; }

	public void setHumanDesire(String title, int morality) {
		hDesire.set(title, morality);
	}

	public void setPrimalDesire(String title, String necessity) {
		pDesire.set(title, necessity);
	}

	public void printHumanDesire() {
		System.out.println(hDesire.getTitle() + "\nMorality: " + hDesire.getMorality());
	}

	public void printPrimalDesire() {
		System.out.println(pDesire.getTitle() + "\nNecessity: " + pDesire.getNecessity());
	}
		
}

abstract class Desire {
	protected String title;
	protected String kind;

	Desire() {}
	Desire(String T, String K) {
		title = T;
		kind = K;
	}

	public String getTitle() { return title; }

	public String getKind() { return kind; }
}

class PrimalDesire extends Desire {
	private String necessity;

	PrimalDesire() {}
	PrimalDesire(String T, String N) {
		super(T,"Primal");
		necessity = N;
	}

	public void set(String T, String N) {
		title 		= T;
		necessity 	= N;
	}

	public String getNecessity() { return necessity; }
}

class HumanDesire extends Desire {
	private int morality;

	HumanDesire() {}
	HumanDesire(String T, int M) {
		super(T,"Human");
		morality = M;
	}

	public void set(String T, int M) {
		title = T;
		morality = M;
	}

	public int getMorality() { return morality; }
}

