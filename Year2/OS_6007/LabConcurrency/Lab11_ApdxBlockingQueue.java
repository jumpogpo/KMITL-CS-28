import java.util.concurrent.locks.*;

class Lab11_ApdxBlockingQueue<E> {
    private final Object[] items;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private int putPointer;
    private int takePointer;
    // curSize is shared among putters
    private static int curSize;

    public Lab11_ApdxBlockingQueue(int capacity) {
        items = new Object[capacity];
    } // constructor

    public void put(E value) throws InterruptedException {
        lock.lock();

        try {
            while (curSize == items.length) {
                System.out.println("Full, waiting");
                notFull.await();
                System.out.println("Stop waiting");
            }
            
            items[putPointer++] = value; /* put here */
            
            if (putPointer == items.length) {
                putPointer = 0;
            }
                
            synchronized (items) {
                curSize++;
            } // multi putters
        
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        } /* try */
    }

    public E take() throws InterruptedException {
        lock.lock();

        try {
            while (curSize == 0) {
                System.out.println("Empty, waiting");
                notEmpty.await();
                System.out.println("Stop waiting");
            }
        
            @SuppressWarnings("unchecked")
            E result = (E) items[takePointer++];

            /* take here */
            if (takePointer == items.length) {
                takePointer = 0;
            }

            synchronized (items) {
                curSize--;
            } // multi takers

            notFull.signalAll();
            return result;
        } finally {
            lock.unlock();
        }
    } /* take */

    int size() { 
        return curSize; 
    } 
}
// put
