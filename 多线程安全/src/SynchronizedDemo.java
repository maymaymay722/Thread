public class SynchronizedDemo {
    public void method() {
        // 进入代码块会锁 SynchronizedDemo.class 指向对象中的锁；
        // 出代码块会释放 SynchronizedDemo.class 指向的对象中的锁
        synchronized (SynchronizedDemo.class) {

        }

        // 进入代码块会锁 this 指向对象中的锁；
        // 出代码块会释放 this 指向的对象中的锁
        synchronized (this) {

        }
    }
    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method();
    }

    /* 类的对象
    public synchronized static void method() {
    }
    public static void main(String[] args) {
        method();	// 进入方法会锁 SynchronizedDemo.class 指向对象中的锁；出方法会释放SynchronizedDemo.class 指向的对象中的锁
    }*/

    /*对象
    public synchronized void method() {
    }

    public static void main(String[] args) {
        SynchronizedDemo demo = new SynchronizedDemo();
        demo.method();	// 进入方法会锁 demo 指向对象中的锁；
                        // 出方法会释放 demo 指向对象中的锁.
    }*/
}
