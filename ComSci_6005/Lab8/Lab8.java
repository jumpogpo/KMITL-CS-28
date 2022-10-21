import java.util.Arrays;

public class Lab8 {
    public static void main(String[] args) {
        int[][] adja ={
            { 0, 2, 6, 711, 711, 711, 711 },
            { 2, 0, 711, 5, 711, 711, 711 },
            { 6, 711, 0, 8, 711, 711, 711 },
            { 711, 5, 8, 0, 10, 15, 711 },
            { 711, 711, 711, 10, 0, 6, 2 },
            { 711, 711, 711, 15, 6, 0, 6 },
            { 711, 711, 711, 711, 2, 6, 0 } 
        };
        int[] dist ={ 0, 711, 711, 711, 711, 711, 711 };
        int tmp = 0;

        for (int city = 0; city < adja.length; city++) {
            for (int dest = 1; dest < adja.length; dest++) {
                if (dist[dest] < 711)
                    System.out.println("dest " + dest + " dist " + dist[dest]); //q1
                    
                    if ( dist[city] + adja[city][dest] < dist[dest] ) { /* q2 */
                        tmp++; // System.out.println(" new cost for " + dest);
                        dist[dest] = dist[city] + adja[city][dest];
                    }
                }
            System.out.println("------------------------");
        }

        System.out.println(tmp); /* q3 */
        System.out.println(Arrays.toString(dist)); /* q4 */
    }
}