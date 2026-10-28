package poke;
import java.util.*;
public class Poketeam {
	ArrayList<Pokemon> team=new ArrayList();
	Pokemon activePokemon;
	public Poketeam() {
		// TODO Auto-generated constructor stub
	}
	void add(Pokemon p1) {
		this.team.add(p1);
	}
	Pokemon get(int index) {
		return this.team.get(index);
	}
	Pokemon selectNextPokemon() {
		  for (int i = 0; i < team.size(); i++) {
		    Pokemon p = team.get(i);
		    if (p.show_hp() > 0 && p != activePokemon)
		      return p;
		  }
		  return null;
	}
	void switchPokemon() {
	    Pokemon next = selectNextPokemon();
	    if (next != null) {
	        activePokemon = next;
	        System.out.println(next.show_name()+ " 進入了!");
	    } else {
	        activePokemon = null;
	        System.out.println("沒有可用的寶可夢了，你昏倒了..");
	    }
	}
	void setActive(Pokemon p) {
	    activePokemon = p;
	}

}
