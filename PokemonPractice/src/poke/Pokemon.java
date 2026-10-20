package poke;

import java.util.Scanner;

public class Pokemon {
    // feature
    private String name;
    private String type;
    private int hp;
    private int number;
    private int speed;
    Move moves[] = new Move[4];
    int count = 4;

    // function
    public Pokemon(String name, String type, int hp, int number,int speed) {

        this.name = name;
        this.type = type;
        this.hp = hp;
        Scanner sc = new Scanner(System.in);
        if (this.check_valid_hp() == false) {
            System.out.println("Wrong hp value");
            while (this.check_valid_hp() == false) {
                System.out.print("please enter new hp>");
                hp = sc.nextInt();
                this.hp = hp;
            }
        }
        this.number = number;
        this.speed = speed;
        // this.set_move();
    }

    private boolean check_valid_hp() {
        if ((hp > 0) & (hp < 400))
            return true;
        else
            return false;
    }

    public int show_hp() {
        return this.hp;
    }
    
    public void set_hp(int damage) {
        this.hp = this.hp - damage;

        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void set_move() {
        for (int i = 0; i < 1; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.print("請輸入招式編號>");
            int number = sc.nextInt();
            System.out.print("請輸入招式名稱>");
            String name = sc.next();
            System.out.print("請輸入招式類別>");
            String type = sc.next();
            System.out.print("請輸入招式分類>");
            int cate = sc.nextInt();
            System.out.print("請輸入招式威力>");
            int power = sc.nextInt();
            System.out.print("請輸入招式命中>");
            int accuracy = sc.nextInt();
            System.out.print("請輸入招式PP>");
            int pp = sc.nextInt();
            this.moves[i] = new Move(number,
                    name,
                    type,
                    cate,
                    power,
                    accuracy,
                    pp);

        }
    }

    public void set_move(Move m) {
        this.moves[0] = m;
    }

    public String show_name() {
        return this.name;
    }
    
    public Move get_move(int i) {
        return this.moves[i];
    }
    
    public String show_type() {
        return this.type;
    }
    
    public int get_speed() {
        return this.speed;
    }

    void show_move(int i) {
        System.out.println("編號:" + this.moves[i].show_number());
        System.out.println("名稱:" + this.moves[i].show_name());
        System.out.println("類別:" + this.moves[i].show_type());
        System.out.println("分類:" + this.moves[i].show_cate());
        System.out.println("威力:" + this.moves[i].show_power());
        System.out.println("命中:" + this.moves[i].show_accuracy());
        System.out.println("PP:" + this.moves[i].show_pp());
        System.out.println("目前PP:" + this.moves[i].show_curr_pp());
    }
}
