package poke;

public class BA {
	Pokemon actor;
	public BA(Pokemon actor) {
		// TODO Auto-generated constructor stub
		this.actor =actor;
	}
	void execute() {
		System.out.println("Battle action");
		
	}
	boolean check_hp() {
		return false;
	}
}