public class Lab11_Q2Producer extends Thread {
    int id;
    // protected BlockingQueue<Element> queue;
    protected Lab11_ApdxBlockingQueue<Element> queue;
    int numCook = 0;
    // Lab11_Q2Producer(
    //int x, BlockingQueue<Element> q) {
    Lab11_Q2Producer(int x, Lab11_ApdxBlockingQueue<Element> q) {
        id = x;
        queue = q;
    } // constructor
 
    public void run() {
        if (id % 2 == 0) {
            int i = -1;
            
            while (i < 30) { // last dish no.30
                i += 2;
                try { // sleep(7);
                    queue.put(new Element(i));
                    numCook++;
                    System.out.println("put " + i + " size = " + queue.size());
                } catch (InterruptedException ie) {
                    System.out.println("Chief INTERRUPTED");
                } //catch
            } // while
        } else {
            int i = 0;
            
            while (i < 29) { // before last dish
                i += 2;
            
                try { // sleep(4);
                    queue.put(new Element(i));
                    numCook++;
                    System.out.println("put " + i + " size = " + queue.size());
                } catch (InterruptedException ie) {
                    System.out.println("Diner INTERRUPTED");
                }
            } // while
        } // else
    } // run
}