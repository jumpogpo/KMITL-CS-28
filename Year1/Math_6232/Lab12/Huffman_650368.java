import java.util.*;
import java.io.*;

public class Huffman_650368 {
    public static void main(String[] args) {
        char[] charArray = new char[256];
        int[] charFreq = new int[256];
        int n = charArray.length;
        int sumBit = 0, sumChar = 0;

        try {
            mergeBooks();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
        buildCharFreqFromFile(charArray, charFreq);
    
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(
            n,
            new MyComparator()
        );
    
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.data = charFreq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }
    
        HuffmanNode root = null;
    
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();
    
            HuffmanNode y = q.peek();
            q.poll();
    
            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.left = x;
            f.right = y;
            q.add(f);
        }

        root = q.peek();
    
        int[] charBitLength = new int[n];
        printCode(root, "");
        countLengths(root, charBitLength, 0);
    
        for (int i = 0; i < n; i++) {
            sumBit += (charBitLength[i] * charFreq[i]);
            sumChar += charFreq[i];
        }

        System.out.println("Average bits per char: " + (double) Math.round((sumBit / (double) sumChar) * 10000) / 10000);
    }

    public static void printCode(HuffmanNode root, String s) {
        if (root.left == null && root.right == null) {
            System.out.println("ascii(" + (int) root.c + ") : " + s);
            return;
        }
    }

    public static void countLengths(HuffmanNode root, int[] charBitLength, int length) {
        if (root.left == null && root.right == null) {
            charBitLength[(int) root.c] = length;
            return;
        }

        countLengths(root.left, charBitLength, length + 1);
        countLengths(root.right, charBitLength, length + 1);
    }

    static String Choices() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select the Book to compress a file");
        System.out.println("1. Book 1 - The Philosopher's Stone");
        System.out.println("2. Book 2 - The Chamber of Secrets");
        System.out.println("3. Book 3 - The Prisoner of Azkaban");
        System.out.println("4. Book 4 - The Goblet of Fire");
        System.out.println("5. Book 5 - The Order of the Phoenix");
        System.out.println("6. Book 6 - The Half Blood Prince");
        System.out.println("7. Book 7 - The Deathly Hallows");
        System.out.print("Your Choice: ");
    
        int choice = sc.nextInt();
        sc.close();
        String book = "";

        switch (choice) {
            case 1:
                book = "Book 1 - The Philosopher's Stone.txt";
                break;
            case 2:
                book = "Book 2 - The Chamber of Secrets.txt";
                break;
            case 3:
                book = "Book 3 - The Prisoner of Azkaban.txt";
                break;
            case 4:
                book = "Book 4 - The Goblet of Fire.txt";
                break;
            case 5:
                book = "Book 5 - The Order of the Phoenix.txt";
                break;
            case 6:
                book = "Book 6 - The Half Blood Prince.txt";
                break;
            case 7:
                book = "Book 7 - The Deathly Hallows.txt";
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }

        return book;
    }

    static void mergeBooks() throws IOException {
        String[] books = {
            "Book 1 - The Philosopher's Stone.txt",
            "Book 2 - The Chamber of Secrets.txt",
            "Book 3 - The Prisoner of Azkaban.txt",
            "Book 4 - The Goblet of Fire.txt",
            "Book 5 - The Order of the Phoenix.txt",
            "Book 6 - The Half Blood Prince.txt",
            "Book 7 - The Deathly Hallows.txt",
        };

        FileWriter fw = new FileWriter("all books.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (String book : books) {
            FileReader fr = new FileReader(book);
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
            }

            br.close();
            fr.close();
        }

        bw.close();
        fw.close();
    }

    static void buildCharFreqFromFile(char[] charArray, int[] charFreq) {
        try {
            String book = Choices();
            FileInputStream fis = new FileInputStream(book);
            int c;
      
            for (int i = 0; i < charArray.length; i++) {
                charArray[i] = (char) i;
            }

            while ((c = fis.read()) != -1) {
                charFreq[c]++;
            }

            fis.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        System.out.println("Total characters: " + Arrays.stream(charFreq).sum());
    }
}

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left;
    HuffmanNode right;
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}