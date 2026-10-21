package poke;

public class main_class {

    public static void main(String[] args) {

        // 1. 1匹目のポケモンを設定
        Pokemon P1 = new Pokemon("小火龍", "火", 39, 1, 52);

        System.out.println(P1.show_hp());
        P1.moves[0] = new Move(1, "火花", "火", 0, 40, 100, 25);
        P1.show_move(0);

        // 2. 2匹目のポケモンを設定
        Pokemon P2 = new Pokemon("妙蛙種子", "草", 50, 1, 30);

        System.out.println(P2.show_hp());
        P2.moves[0] = new Move(22, "藤鞭", "草", 0, 45, 100, 25);
        P2.show_move(0);

        // 3. Queueを作成
        SimpleQueue sq = new SimpleQueue(5);


        // 4. 素早さを比較して、攻撃順を決める
        BattleAction a1 =
            new BattleAction(P1, P2, P1.moves[0]);

        BattleAction a2 =
            new BattleAction(P2, P1, P2.moves[0]);

        if (P1.get_speed() >= P2.get_speed()) {
            sq.enqueue(a1);
            sq.enqueue(a2);
        } else {
            sq.enqueue(a2);
            sq.enqueue(a1);
        }

        // 5. peek()で先頭の攻撃を確認する
        BattleAction next = sq.peek();

        if (next != null) {
            System.out.println(
                "次の攻撃：" + next.attacker.show_name()
            );
        }

        // 6. Queueから順番に取り出して攻撃する
        while (!sq.isEmpty()) {
            BattleAction action = sq.dequeue();

            int damage = action.perform();
            action.defender.set_hp(
                action.defender.show_hp() - damage
            );

            System.out.println(
                action.attacker.show_name() + " の攻撃！"
            );

            System.out.println(
                action.defender.show_name()
                + " の残りHP："
                + action.defender.show_hp()
            );

            System.out.println();
        }


        // 技を作る
        Move waterGun = new Move(
                55,
                "水槍",
                "水",
                1,
                40,
                100,
                25);

        // 傑尼龜に水槍をセット
        P2.set_move(waterGun);

        // 傑尼龜の技を取得
        Move attackMove = P2.get_move(0);

        // 属性の番号を取得
        Entry chart = new Entry();

        int attackType = chart.checktype(attackMove.show_type());
        int defenseType = chart.checktype(P1.show_type());

        // 属性倍率を取得
        double multiplier = chart.c_table(attackType, defenseType);

        // ダメージ計算
        int damage = (int) (attackMove.show_power() * multiplier);

        // 結果を表示
        System.out.println("================================");
        System.out.println("       Pokemon Type Battle");
        System.out.println("================================");

        System.out.println("攻擊者：" + P2.show_name());
        System.out.println("防守者：" + P1.show_name());

        System.out.println("使用招式：" + attackMove.show_name());
        System.out.println("招式屬性：" + attackMove.show_type());
        System.out.println("防守屬性：" + P1.show_type());

        System.out.println("招式威力：" + attackMove.show_power());
        System.out.println("屬性倍率：" + multiplier);

        if (multiplier == 2.0) {
            System.out.println(">>> 效果絕佳！");
        } else if (multiplier == 0.5) {
            System.out.println(">>> 效果不佳……");
        } else if (multiplier == 0.0) {
            System.out.println(">>> 沒有效果！");
        } else {
            System.out.println(">>> 普通效果。");
        }

        System.out.println(">>> 造成了" + damage + "點傷害！");
        System.out.println("================================");
    }
}