class StackForConcurrent {
    Node top;
    int size;
    
    StackForConcurrent() {
        top = null; size = 0;
    } // constructor
 
    synchronized void push(int n) {
        top = new Node(n, top);
        size++;
        
        if (top.next == null) {
            /* Q1 */
            notifyAll();
        }
        /* no_longer_empty */
    } // push

    public synchronized int pop() {
        try {
            while (top == null) {
                System.out.println("empty stack");
                /* Q3 */
                wait();
            }
            /* choose between Q4.1 or
            Q4.2 inside or outside try block */
            // size--; /* Q4.1 */
        } catch (InterruptedException ie) {
            System.out.println("error");
            return 1;
        }
        size--; /* Q4.2 */
        int n = top.val;
        top = top.next;
        return n;
    } // pop
} // class
 // Stack