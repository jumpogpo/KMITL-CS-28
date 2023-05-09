import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] size = sc.nextLine().split(" ");
    int column = Integer.parseInt(size[0]);
    int row = Integer.parseInt(size[1]);

    int arr[][] = new int[row][column];

    for (int i = 0; i < row; i++) {
      String[] data = sc.nextLine().split(" ");

      for (int j = 0; j < data.length; j++) {
        arr[i][j] = Integer.parseInt(data[j]);
      }
    }

    int position = sc.nextInt();
    sc.close();

    for (int y = 0; y < arr.length; y++) {
      for (int u = y + 1; u < arr.length; u++) {
        int[] storeArr = new int[column];

        if (arr[y][position] > arr[u][position]) {
          storeArr = arr[y];
          arr[y] = arr[u];
          arr[u] = storeArr;
        }
      }
    }

    for (int z = 0; z < arr.length; z++) {
      String text = "";
      for (int x = 0; x < arr[z].length; x++) {
        text = text + arr[z][x];

        if (x != arr[x].length - 1) text = text + " ";
      }
      System.out.println(text.trim());
    }
  }
}