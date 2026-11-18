package poke;

import java.io.*;
import java.util.*;

public class SimpleTree {

    SimpleTree 父;
    ArrayList<SimpleTree> 子 = new ArrayList<SimpleTree>();
    String 名字;

    public SimpleTree() {
        this.父 = null;
        this.子 = new ArrayList<SimpleTree>();
        this.名字 = "";
    }

    public SimpleTree(SimpleTree p, ArrayList<SimpleTree> c, String name) {
        this.父 = p;
        this.子 = c;
        this.名字 = name;
    }

    boolean 根結點() {
        return this.父 == null;
    }

    boolean 葉節點() {
        return this.子.isEmpty();
    }
    
    String showname() {
        return this.名字;
    }
//    void bfs_showall() {
//    	System.out.println(this.showname());
//        if (!葉節點()) {
//            for (SimpleTree item : this.子) {
//            	item.showall();
//    }
    void showall() {
        System.out.println(this.showname());

        if (!葉節點()) {
            for (SimpleTree item : this.子) {
                item.showall();
            }
        }
    }




    public static void main(String[] args) {

    	// Root
        SimpleTree 伊布家族 = new SimpleTree(null,//父
                new ArrayList<SimpleTree>(),//子
                "伊布");//名字
        
        // Children
        SimpleTree 葉伊布 = new SimpleTree(null,//父
                new ArrayList<SimpleTree>(),//子
                "葉伊布");//名字
        
        葉伊布.子.add(new SimpleTree(葉伊布,//父
                new ArrayList<SimpleTree>(),//子
                "葉伊布仙子"));//名字
        葉伊布.子.add(葉伊布);
        
        SimpleTree 水伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "水伊布");
        SimpleTree 雷伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "雷伊布");
        SimpleTree 火伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "火伊布");
        SimpleTree 太陽伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "太陽伊布");
        SimpleTree 月亮伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "月亮伊布");
        SimpleTree 冰伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "冰伊布");
        SimpleTree 妖精伊布 = new SimpleTree(伊布家族,
                new ArrayList<SimpleTree>(),
                "仙子伊布");

        
    }
}
