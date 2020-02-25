public class Demo4 {
    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.interrupted());
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        thread.start();
        thread.interrupt();
    }
}
/*
运行结果：
true     //只有一开始是 true，后面都是 false，因为 标志位被清
false
false
false
false
false
false
false
false
false
 */