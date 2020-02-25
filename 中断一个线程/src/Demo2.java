public class Demo2 {
    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            // 两种方法均可以
            while (!Thread.interrupted()) {
                //while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread().getName()
                        + ": 别管我，我忙着转账呢!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()
                            + ": 有内鬼，终止交易！");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName()
                    + ": 啊！险些误了大事");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName()
                + ": 让李四开始转账。");
        thread.start();
        Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName()
                + ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        thread.interrupt();
    }
}
/*
1. 通过 thread 对象调用 interrupt() 方法通知该线程停止运行
2. thread 收到通知的方式有两种：
        1.如果线程调用了 wait/join/sleep 等方法而阻塞挂起，则以 InterruptedException 异常的形式通知，
          清除中断标志
        2.否则，只是内部的一个中断标志被设置，thread 可以通过
              1.Thread.interrupted()
                判断当前线程的中断标志被设置，清除中断标志
              2.Thread.currentThread().isInterrupted()
                判断指定线程的中断标志被设置，不清除中断标志
*/