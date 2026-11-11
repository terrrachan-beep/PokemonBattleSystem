package poke;

public class BattleAction {
    Pokemon attacker;
    Pokemon defender;
    Move move;
    

    BattleAction(
        Pokemon attacker,
        Pokemon defender,
        Move move
    ) {
        this.attacker = attacker;
        this.defender = defender;
        this.move = move;
        
    }

    int perform() {
    	Entry e1=new Entry();
    	System.out.print(this.attacker.show_name());
    	int k=e1.damage(this.attacker.get_move(0),
    			this.defender.get_type());
    	System.out.println(""+k+"點傷害");
    	return k;
    }
}