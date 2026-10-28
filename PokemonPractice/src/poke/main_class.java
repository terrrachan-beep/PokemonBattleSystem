package poke;

import java.util.ArrayList;

public class main_class {

    public static void main(String[] args) {
    	Entry e1 =new Entry();
    	ArrayList<Pokemon> team1 = new ArrayList();
    	ArrayList<Pokemon> team2 = new ArrayList();
    	
        Pokemon P1 = new Pokemon("小火龍", "火", 50, 4, 45);
        P1.moves[0] = new Move(1, "火花", "火", 0, 40, 100, 25);
        P1.show_move(0);
        team1.add(P1);
        P1=new Pokemon("妙蛙種子", "草", 50, 1, 30);
        P1.moves[0] = new Move(22, "藤鞭", "草", 0, 45, 100, 25);
        P1.show_move(0);
        team1.add(P1);
        P1 = new Pokemon("皮卡丘", "電", 50, 3, 65);
        P1.moves[0] = new Move(84, "電擊", "電", 0, 40, 100, 25);
        P1.show_move(0);
        team1.add(P1);
        System.out.println(team1.size(0));
        
        P1=new Pokemon("小火龍","火",50,4,45);
		P1.moves[0]=new Move(1, "拍擊","一般",0,40,100,35);
		P1.show_move(0);
		team2.add(P1);
		P1=new Pokemon("皮卡丘","水",50,3,65);
		P1.moves[0]=new Move(84, "電擊","電",0,40,100,30);
		P1.show_move(0);
		team2.add(P1);
		P1=new Pokemon("走路草","草",30,4,55);
		P1.moves[0]=new Move(22, "藤鞭","草",0,45,100,25);
		P1.show_move(0);
		team2.add(P1);
		System.out.println(team2.size());
		
		int i1=0,i2=0;
		Pokemon currP1=team1.get(i1);
		Pokemon currP2=team2.get(i2);
		main_class m1=new main_class();
		Pokemon nextP1=m1.selectNextPokemon(team1, currP1);
		Pokemon nextP2=m1.selectNextPokemon(team2, currP2);
		
		do {
			while ((currP1.show_hp()>0)&(currP2.show_hp()>0)) {
				try {
					CircularBattleQueue sq=new CircularBattleQueue   (5);
					if (currP1.get_speed()>currP2.get_speed()) {
						BA a1=new AttackAction(currP1,currP2,currP1.moves[0]);
						BA a2=new AttackAction(currP2,currP1,currP2.moves[0]);
						sq.enqueue(a1);
						sq.enqueue(a2);
						BA a3=new HealAction(currP1,10);
						sq.enqueue(a3);
					}else {
						BA a2=new AttackAction(currP1,currP2,currP1.moves[0]);
						BA a1=new AttackAction(currP2,currP1,currP2.moves[0]);
						sq.enqueue(a1);
						sq.enqueue(a2);
					}
					for (int i=sq.front;i<sq.rear;i++) {
						BA run=sq.dequeue();
						run.execute();
						if (run.check_hp()==true) {
							break;
						}
					}
					if (currP1.show_hp()==0) {
						currP1=nextP1;
						nextP1=m1.selectNextPokemon(team1, nextP1);
					}else if (currP2.show_hp()==0) {
						currP2=nextP2;
						nextP2=m1.selectNextPokemon(team2, nextP2);
					}
				}catch (IllegalArgumentException e) {
					System.out.println("Wrong queue size!");
					System.exit(1);
				}
				if ((currP1==null)||(currP2==null))
					break;
			}
		}while ((nextP1!=null)&&(nextP2!=null));
		
		
        
//    while ((team1.size()>0)&&(team2.size()>0)) {
//        Pokemon currP1 = team1.remove(0);
//        System.out.println(team1.size(0));
//        Pokemon currP2 = team1.remove(0);
//        System.out.println(team2.size(0));
//        while ((curr1.show_hp()>0)&&(curr2.show_hp()>0)) {
//        try {
//        	CircularQueue sq = new CircularQueue(5);
//        	if(currP1.get_speed()>currP2.get_speed()) {
//        		BA a1 = new AttackAction(currP1,currP2,currP1);
//        		BA a2 = new AttackAction(currP2,currP1,currP2);
//        		sq.enqueue(a1);
//        		sq.enqueue(a2);
//        		BA a3 = new HealAction(currP1,10);
//        		sq.enqueue(a3);
//        	else {
//        		BA a2 = new AttackAction(currP1,currP2,currP1);
//        		BA a1 = new AttackAction(currP2,currP1,currP2);
//        		sq.enqueue(a1);
//        		sq.enqueue(a2);
//        	}
//        	for (int i = sq.front;i<sq.rear;i++) {
//        		BA run=sq.dequeue();
//        		run.execute();
//        		if (run.check_hp()==ture) {
//        			break
//        		}
//        	}
//        	if(currP1.show_hp()==0)
//        		if (team1.size()>0)
//        			currP1 = team1.remove(0);
//        			
//        		else 
//        			break;
//        	else if(currP2.show_hp()==0)
//        		if (team2.size()>0)
//        			currP2 = team2.remove(0);
//        			
//        		else 
//        			break;
//        	
//        }catch(IllegalArgumentException e) {
//        	System.out.println("Wrong queue size!");
//        	System.exit(1);
//        	
//        }
//        	
//        }
//        
//    }        
//        
//  }       
//        
        
        
        
        
//        //Queueを作成
//        SimpleQueue sq = new SimpleQueue(5);
//
//
//        //素早さを比較して、攻撃順を決める
//        BattleAction a1 =
//            new BattleAction(P1, P2, P1.moves[0]);
//
//        BattleAction a2 =
//            new BattleAction(P2, P1, P2.moves[0]);
//
//        if (P1.get_speed() >= P2.get_speed()) {
//            sq.enqueue(a1);
//            sq.enqueue(a2);
//        } else {
//            sq.enqueue(a2);
//            sq.enqueue(a1);
//        }
//
//        //peek()で先頭の攻撃を確認する
//        BattleAction next = sq.peek();
//
//        if (next != null) {
//            System.out.println(
//                "次の攻撃：" + next.attacker.show_name()
//            );
//        }
//
//        //Queueから順番に取り出して攻撃する
//        while (!sq.isEmpty()) {
//            BattleAction action = sq.dequeue();
//
//            int damage = action.perform();
//            action.defender.set_hp(
//                action.defender.show_hp() - damage
//            );
//
//            System.out.println(
//                action.attacker.show_name() + " の攻撃！"
//            );
//
//            System.out.println(
//                action.defender.show_name()
//                + " の残りHP："
//                + action.defender.show_hp()
//            );
//
//            System.out.println();
//        }
//
//
//        // 技を作る
//        Move waterGun = new Move(
//                55,
//                "水槍",
//                "水",
//                1,
//                40,
//                100,
//                25);
//
//        // 傑尼龜に水槍をセット
//        P2.set_move(waterGun);
//
//        // 傑尼龜の技を取得
//        Move attackMove = P2.get_move(0);
//
//        // 属性の番号を取得
//        Entry chart = new Entry();
//
//        int attackType = chart.checktype(attackMove.show_type());
//        int defenseType = chart.checktype(P1.show_type());
//
//        // 属性倍率を取得
//        double multiplier = chart.c_table(attackType, defenseType);
//
//        // ダメージ計算
//        int damage = (int) (attackMove.show_power() * multiplier);
//
//        // 結果を表示
//        System.out.println("================================");
//        System.out.println("       Pokemon Type Battle");
//        System.out.println("================================");
//
//        System.out.println("攻擊者：" + P2.show_name());
//        System.out.println("防守者：" + P1.show_name());
//
//        System.out.println("使用招式：" + attackMove.show_name());
//        System.out.println("招式屬性：" + attackMove.show_type());
//        System.out.println("防守屬性：" + P1.show_type());
//
//        System.out.println("招式威力：" + attackMove.show_power());
//        System.out.println("屬性倍率：" + multiplier);
//
//        if (multiplier == 2.0) {
//            System.out.println(">>> 效果絕佳！");
//        } else if (multiplier == 0.5) {
//            System.out.println(">>> 效果不佳……");
//        } else if (multiplier == 0.0) {
//            System.out.println(">>> 沒有效果！");
//        } else {
//            System.out.println(">>> 普通效果。");
//        }
//
//        System.out.println(">>> 造成了" + damage + "點傷害！");
//        System.out.println("================================");
    }
}