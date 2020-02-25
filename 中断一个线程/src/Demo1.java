public class Demo1 {
    private static class MyRunnable implements Runnable{
        public volatile boolean isQuit=false;

        @Override
        public void run() {
            while(!isQuit){
                System.out.println(Thread.currentThread().getName()
                +"：别管我，我忙着转账呢！");
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()
                    +"差点出事了！");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target=new MyRunnable();
        Thread thread=new Thread(target,"李四");
        System.out.println(Thread.currentThread().getName()
                +"：让李四开始转账。");
        thread.start();
        Thread.sleep(10*1000);
        System.out.println(Thread.currentThread().getName()
                +"：李四是个骗子！");
        target.isQuit=true;
    }
}
