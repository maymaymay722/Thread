class MyRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName()
                +"这里是线程运行的代码");
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Thread t=new Thread(new MyRunnable());
        t.start();    //线程开始运行
    }
}
