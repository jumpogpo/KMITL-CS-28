public class MyArray {
    int MAX_SIZE = 999999999;
    int data[] = new int[MAX_SIZE];
    int size = 0;

    public int getAt(int i) {
        return data[i];
    }

    public void setAt(int d, int i) {
        data[i] = d;
    }

    public void add(int d) {
        data[size++] = d;
    }

    public void insert(int d, int index) {
        data[size++] = data[index];
        data[index] = d;
    }

    public void delete(int index) {
        data[index] = data[--size];
    }

    public int find(int d) {
        for (int i=0; i<size; i++) {
            if (data[i] == d) {
                return i;
            }
        }

        return -1;
    }

    public int binarySearch(int d) {
        int a = 0, b = size-1;
        while (a <= b) {
            int m = (a+b) / 2;
            if (data[m] == d) return m;
            if (d < data[m]) b = m-1;
            else a = m+1;
        }
        return - 1;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        
        for (int i=0; i < size - 1; i++) {
            sb.append(data[i]);
            sb.append(",");
        }

        if (size > 0) sb.append(data[size-1]);
        sb.append("]");
        return sb.toString();
    }
}