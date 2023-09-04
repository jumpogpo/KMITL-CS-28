public class L7_Thread_demo1 {
    public static void main(String[] args) {
        L7_Obj x = new L7_Obj();
        Thread t1 = new Thread(new WorkerDemo1(x));
        t1.start();
        Thread t2 = new Thread(new WorkerDemo2(x));
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (Exception e) { System.out.println(e); }
        System.out.println("from main x value is " + x.getValue());
    }
}

class WorkerDemo1 implements Runnable {
    private L7_Obj o;
    WorkerDemo1(L7_Obj y) { o = y; }
    public void run() {
        o.inc(3);
        System.out.println("From worker1 thread " +
            Thread.currentThread().getId() +
            " x value is " + o.getValue());
    }
}

class L7_Obj {
    private int value;
    L7_Obj() { value = 0; }
    void inc(int x) {value += x; }
        int getValue() { return value; }
    }
    
    class WorkerDemo2 implements Runnable {
        private L7_Obj o;
        WorkerDemo2(L7_Obj y) { o = y; }
        public void run() {
            o.inc(4);
            System.out.println("From worker2 thread " +
                Thread.currentThread().getId() +
                " x value is " + o.getValue());
        }
}