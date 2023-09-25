import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ex0_650368 {
    public static void main(String[] args) {
        demo1();
        demo2();
        demo3();
        demo4();
        demo5();
    }

    static void demo1() {
        System.out.println("-demo1---");

        SillyLuckyNumber[] arr = {
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")
        };

        System.out.println(Arrays.toString(arr));

        // Comparator<SillyLuckyNumber> engine = new Comparator<>() {
        // @Override
        // public int compare(SillyLuckyNumber o1, SillyLuckyNumber o2) {
        // return Integer.compare(o1.getLuckyNumer(), o2.getLuckyNumer());
        // }
        // };

        Comparator<SillyLuckyNumber> engine = (h1, h2) -> Integer.compare(h1.getLuckyNumer(), h2.getLuckyNumer());
        Arrays.sort(arr, engine);
        System.out.println(Arrays.toString(arr));
    }

    static void demo2() {
        System.out.println("-demo2----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        Collections.sort(list, Comparator.comparingInt(SillyLuckyNumber::getLuckyNumer));
        System.out.println(list);
    }

    static void demo3() {
        System.out.println("-demo3----");
        ArrayList<SillyLuckyNumber> list = new ArrayList<>(Arrays.asList(
                new SillyLuckyNumber("Terrier"), new SillyLuckyNumber("Jack"),
                new SillyLuckyNumber("Pom"), new SillyLuckyNumber("Beagle")));
        System.out.println(list);
        list.sort(Comparator.comparing(SillyLuckyNumber::getLuckyNumer));
        System.out.println(list);
        // demo shallow copy
        ArrayList<SillyLuckyNumber> anotherList = new ArrayList<>(list.subList(0, list.size()));
        anotherList.get(0).setBreed("newBreed"); // Terrier
        System.out.println(list); // notice how Terrier in list is also effected
    }

    static void demo4() {
        System.out.println("-demo4----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        System.out.println(arr);
        arr.swap(1,3);
        System.out.println(arr);
    }

    static void demo5() {
        System.out.println("-demo5----");
        MyArrDemo<SillyLuckyNumber> arr = new MyArrDemo<>();
        arr.add(new SillyLuckyNumber("Terrier"));
        arr.add(new SillyLuckyNumber("Jack"));
        arr.add(new SillyLuckyNumber("Pom"));
        arr.add(new SillyLuckyNumber("Beagle"));
        arr.add(new SillyLuckyNumber("Cocker Spaniel"));
        arr.add(new SillyLuckyNumber("Basenji"));
        System.out.println(arr);
        selectionSort(arr);
        System.out.println(arr);
    }

    private static void selectionSort(MyArrDemo<SillyLuckyNumber> inputArr) {
        int n = inputArr.currentSize();
 
        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (inputArr.get(j).getLuckyNumer() < inputArr.get(min_idx).getLuckyNumer())
                    min_idx = j;
 
            inputArr.swap(i, min_idx);
        }
    }
}