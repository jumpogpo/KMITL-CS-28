import java.util.Random;

class Pusher extends Thread {
    int turns;
    StackForConcurrent concurStack;
    
    Pusher(int t, StackForConcurrent s) {
        turns = t; concurStack = s;
    } // constructor
    
    public void run() {
        Random rand = new Random();
        
        try {
            sleep(rand.nextInt(100));
        } catch (InterruptedException ie) { }
        
        for (int i = 0; i < turns; i++)
            concurStack.push(i);
    } // run 
}