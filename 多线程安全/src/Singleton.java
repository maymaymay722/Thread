public class Singleton {
    private static volatile Singleton instance=null;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }

    /*
    懒汉模式
    private static Singleton instance=null;
    private Singleton(){}
    public synchronized static Singleton getInstance(){
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }
    */

    /*
    饿汉模式
    private static Singleton instance=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return instance;
    }
    */
}
