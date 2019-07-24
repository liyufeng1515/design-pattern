package cn.dwyane.designpattern.builder;

/**
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，
 * 用来创建复合对象，复合对象就是指某个类具有不同的属性
 * 区别就是：工厂模式关注的是创建单个产品，而建造者模式则关注创建符合对象，多个部分。
 */
public class Basketball {
    private String color = null;
    private int size = 0;
    public Basketball(BasketballBuilder basketballBuilder){
        this.color = basketballBuilder.color;
        this.size = basketballBuilder.size;
        System.out.println("this  is a "+this.size+" inch and "+this.color+" basketball");
    }
    static class BasketballBuilder{
        private String color = null;
        private int size = 0;

        public BasketballBuilder setColor(String color){
            this.color = color;
            return this;
        }
        public BasketballBuilder setSize(int size){
            this.size = size;
            return this;
        }
        public Basketball build(){
            return new Basketball(this);
        }
    }
}
