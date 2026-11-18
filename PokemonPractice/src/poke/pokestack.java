package poke;
import java.io.*;
import java.util.*;

public class pokestack {
	
	pablic pokestack() {
		
	}
	
	public static void main(String[] args) {
		
		Stack<BattleState> history = new Stack<>();
		
		history.push(new BattleState(50,50));
		history.push(new BattleState(40,40));
		
		BattleStare recall = history.pop();
		
		System.out.println("Attacker HP: "+ recall.attackerHP);
		System.out.println("Defender HP: "+ recall.DefenderHP);
	}
}
