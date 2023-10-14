public class Lab11_Q3DriverSol {
    public static void main(String[] args) {
        int numPopper = 1; int numPusher = 1;
        int numTurns = 10;
        StackForConcurrent stack = new StackForConcurrent();
        Pusher[] pushArr = new Pusher[numPusher];
        Popper[] poppArr = new Popper[numPopper];
        
        for (int i = 0; i < numPusher; i++) {
            pushArr[i] = new Pusher(numTurns, stack);
            poppArr[i] = new Popper(numTurns, stack);
            pushArr[i].start();
            poppArr[i].start();
        }
 
        for (int i = 0; i < numPusher; i++) {
            try {
                pushArr[i].join();
                poppArr[i].join();
            } catch (InterruptedException ie) { }
        }
    }
}