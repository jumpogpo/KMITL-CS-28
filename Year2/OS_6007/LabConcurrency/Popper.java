class Popper extends Thread {
    int turns;
    StackForConcurrent concurStack;
    Popper(int t, StackForConcurrent s) {
        turns = t; concurStack = s;
    }
    
    public void run() {
        int x = -1;
        for (int j = 0; j < turns; j++) {
            x = concurStack.pop();
            System.out.println("got " + x + " stack size = " + concurStack.size);
        }
    } // run
}