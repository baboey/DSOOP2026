public class App {
	public void main() {
		TrapDoor one = new TrapDoor("Hallway");
		one.info();
		one.interact();
		one.interact();
	}
}

interface Interactions {
	abstract boolean pull(boolean status);
	abstract boolean swing(boolean status);
}

class InteractDoor implements Interactions {
	@Override
	public boolean pull(boolean isOpen) {
		System.out.println("\nSwoosh~");

		if (isOpen == true) System.out.println("It closes..");
		else System.out.println("It opens!");

		return !isOpen;	
	}

	@Override
	public boolean swing(boolean isOpen) {
		System.out.println("\nCreaak~");

		if (isOpen == true) System.out.println("It closes..");
		else System.out.println("It opens!");

		return !isOpen;
	}
}

abstract class Door {
	protected String name;
	protected String type;
	protected boolean isOpen;
	protected InteractDoor interact = new InteractDoor();

	Door(String N) {
		name = N;
		isOpen = false;
	}

	public String get(String attr) {
		if (attr == "name" || attr == "N")		{ return name; }
		else if (attr == "type" || attr == "T")		{ return type; }
		else return "Not Found";
	}

	public void set(String attr, String value) {
		if (attr == "name" || attr == "N") 		{ name = value; }
		else if (attr == "type" || attr == "T") 	{ type = value; }
	}

	public void info() {
		System.out.println("Name:\t" + name);
		System.out.println("Type:\t" + type);
		System.out.println("IsOpen:\t" + isOpen);
	}

	abstract void interact();
}

class PanelDoor extends Door {
	PanelDoor(String N) {
		super(N);
		type = "PanelDoor";
		isOpen = false;
	}

	@Override
	public void interact() {
		isOpen = interact.swing(isOpen);
	}
}


class TrapDoor extends Door {
	TrapDoor(String N) {
		super(N);
		type = "TrapDoor";
		isOpen = false;
	}

	@Override
	public void interact() {
		isOpen = interact.pull(isOpen);
	}
}

