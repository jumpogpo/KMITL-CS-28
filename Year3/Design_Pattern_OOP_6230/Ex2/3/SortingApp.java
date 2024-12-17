public class SortingApp {
    ISorter sorter;

    public SortingApp(ISorter sorter) {
        this.sorter = sorter;
    }

    public void sort(int[] array) {
        this.sorter.sort(array);
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};

        SortingApp client = new SortingApp(new SelectionSort());
        client.sort(array);

        client = new SortingApp(new MergeSort());
        client.sort(array);

        client = new SortingApp(new InsertionSort());
        client.sort(array);
    }
}
