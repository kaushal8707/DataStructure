
public class SyncDemoTest{
    int i=0;
    public static void main (String[] args) {
        SyncDemoTest obj=new SyncDemoTest();
        SyncDemoTest obj1=new SyncDemoTest();

        Thread1 t1=new Thread1(obj);
        t1.start();
        Thread2 t2=new Thread2(obj1);
        t2.start();
    }

    public synchronized void increment(){
        i++;
    }

    public synchronized int get(){
        return i;
    }
}

class Thread1 extends Thread{
    SyncDemoTest obj=null;
    Thread1(SyncDemoTest obj){
        this.obj=obj;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());
        obj.increment();
        System.out.println(obj.get()+"   "+Thread.currentThread().getName());
    }
}

class Thread2 extends Thread{
    SyncDemoTest obj=null;
    Thread2(SyncDemoTest obj){
        this.obj=obj;
    }
    public void run(){
        System.out.println(Thread.currentThread().getName());

        obj.increment();
        System.out.println(obj.get()+"   "+Thread.currentThread().getName());
    }
}