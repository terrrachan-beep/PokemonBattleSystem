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
        int damage = move.show_power();
        return damage;
    }
    
}