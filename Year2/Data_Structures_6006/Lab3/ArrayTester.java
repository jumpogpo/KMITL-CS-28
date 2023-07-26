public class ArrayTester {
    public static void main(String args[]) {
        for(int N=10000000; N<=100000000; N+=10000000) {
            long totalTime = 0;
            System.out.print(N);

            for (int i = 0; i < 5; i++) {
                long start = System.currentTimeMillis();
                MyArray mArray = new MyArray();
                
                for(int n=1; n<N; n++) {
                    mArray.add((int)(Math.random()*1000));
                }
            
                long time = (System.currentTimeMillis()-start);
                totalTime += time;
                System.out.print(" \t"+time);
            }

            long avgTime = totalTime / 5;
            System.out.println(" \t" + avgTime + " \t" + (float) avgTime / N);
        }
    }
}