package cn.dwyane.designpattern.singleton;

/**
 * 单例模式（Singleton Pattern）这种类型的设计模式属于创建型模式,它提供了一种创建对象的最佳方式。
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 * 优点：
 * 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例
 * 2、避免对资源的多重占用（比如写文件操作
 * 缺点：
 * 没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 * 使用场景：
 * 1、要求生产唯一序列号。
 * 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
 * 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 */
public class Singleton {
    /**
     * 静态内部类,有lazyloading效果.
     * 线程安全:虚拟机会保证一个类的构造器<clinit>()方法在多线程环境中被正确地加载，同步，
     * 如果多个线程同时去初始化一个类，那么只有一个线程去执行这个类的
     */
   private static class SingletonHolder{
       private static Singleton singleton = new Singleton();
   }
   public static Singleton getInstance(){
       return SingletonHolder.singleton;
   }
    /**
     * 最佳实例方式
     * 用enum类
     * 解决自由序列化问题.
     * enum Singleton{
     *     INSTANCE;
     * }
     */
}
