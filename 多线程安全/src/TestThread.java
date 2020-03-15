class MyThread implements Runnable{
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag,Object object){
        super();
        this.flag=flag;
        this.obj=obj;
    }
    private void waitMethod() {
        synchronized(obj){
            try{
                while(true){
                    System.out.println("wait() 方法开始..."+Thread.currentThread().getName());
                    obj.wait();
                    System.out.println("wait() 方法结束..."+Thread.currentThread().getName());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void notifyMethod() {
        synchronized(obj){
            try{
                System.out.println("notify() 方法开始..."+Thread.currentThread().getName());
                //obj.notify();
                obj.notifyAll();
                System.out.println("notify() 方法结束..."+Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        if(flag){
            this.waitMethod();
        }else{
            this.notifyMethod();
        }
    }
}
public class TestThread {
    public static void main(String[] args) throws InterruptedException {
        //notifyAll()
        Object object=new Object();
        MyThread waitThread1=new MyThread(true,object);
        MyThread waitThread2=new MyThread(true,object);
        MyThread waitThread3=new MyThread(true,object);
        MyThread waitThread4=new MyThread(true,object);
        MyThread notifyThread=new MyThread(false,object);
        Thread thread1=new Thread(waitThread1,"wait线程A");
        Thread thread2=new Thread(waitThread2,"wait线程B");
        Thread thread3=new Thread(waitThread3,"wait线程C");
        Thread thread4=new Thread(notifyThread,"notify线程");
        thread1.start();
        thread2.start();
        thread3.start();
        Thread.sleep(1000);
        thread4.start();
        System.out.println("main方法结束！！");

        /*
        //notify()
        Object object=new Object();
        MyThread waitThread1=new MyThread(true,object);
        MyThread notifyThread=new MyThread(false,object);
        Thread thread1=new Thread(waitThread,"wait线程");
        Thread thread2=new Thread(notifyThread,"notify线程");
        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        System.out.println("main方法结束！！");
         */
    }
}
