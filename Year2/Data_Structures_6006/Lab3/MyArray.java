public class MyArray {
    private int[] array;
    private int index;

    MyArray() {
        this.array = new int[999999999];
        this.index = 0;
    }

    void add(int d) {
        this.array[index++] = d;
    }
}
