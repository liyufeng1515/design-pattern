package cn.dwyane.designpattern.builder;

import cn.dwyane.designpattern.factory.Sender;

public class BuilderTest {
    public static void main(String[] args){
        Basketball basketballA = new Basketball.BasketballBuilder().build();
        Basketball basketballB = new Basketball.BasketballBuilder().setColor("red").setSize(5).build();
        Basketball basketballC = new Basketball.BasketballBuilder().setColor("blue").setSize(6).build();

    }
}
