public class Lab11_Q2Consumer extends
    Thread {
    int id;
    // BlockingQueue<Element> queue;
    Lab11_ApdxBlockingQueue<Element> queue;
    // Lab11_Q2Consumer(
    //int x, BlockingQueue<Element> q) {
    Lab11_Q2Consumer(int x, Lab11_ApdxBlockingQueue<Element> q) {
        id = x;
        queue = q;
    } // constructor
 
    public void run() {
        try { // sleep(500);
            Element e = queue.take();
            System.out.println(id + " takes " + e.val);
        } catch (InterruptedException ie) { }
    }
}