package cn.dwyane.designpattern.factory;

/**
 * 工厂模式适合：凡是出现了大量的产品需要创建，并且具有共同的接口时，可以通过工厂方法模式进行创建
 *
 * 2、抽象工厂模式（Abstract Factory）
 *
 * 但是普通工厂,静态工厂,违背了开闭原则,如果有新的类需要实例化,就去修改工厂类？
 * 这时候就用到抽象工厂模式，创建多个工厂类，这样一旦需要增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码。
 */
public class SenderFactory {

    public static Sender produceSms(){
        return new SmsSender();
    }

    public static Sender produceMail(){
        return new MailSender();
    }
}
