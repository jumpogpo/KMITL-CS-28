import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class Lab8 {
    static List<Singer> singerList = new ArrayList<>();
    
    static {
        singerList.add(new Singer("Aba",Singstyle.POP));
        singerList.add(new Singer("Abi",Singstyle.ROCK));
        singerList.add(new Singer("Abo",Singstyle.POP));
        singerList.add(new Singer("Abe",Singstyle.ROCK));
    }

    public static void main(String[] args) {
        q1_halfEachNumber();
        System.out.println("-----------");
        q2_forEachSingerName();
        System.out.println("-----------");
        q3_lambda_comparator();
        System.out.println("-----------");
    }
    
    public static void q1_halfEachNumber() {
        List<Integer> nums = Arrays.asList(100, 105);
        HalfValueInterface halfVal = n -> System.out.println(n / 2);
        
        for (int n : nums) {
            halfVal.printHalf(n);
        } 
        
        Consumer<Integer> consumer = n -> System.out.println(n / 2);

        for (int n : nums) {
            consumer.accept(n);
        }
    
        Consumer<Integer> halfMe = n -> System.out.println(n / 2);
        nums.forEach(halfMe);
        nums.forEach(n -> System.out.println(n / 2));
        NumberProcessor np = new NumberProcessor();
        nums.forEach(np::printHalf);
    }

    public static void q2_forEachSingerName() {
        singerList.stream().map(n -> n.getName()).forEach(System.out::println);
        singerList.stream().map(Singer::getName).forEach(System.out::println);
    }

    public static void q3_lambda_comparator() {
        Comparator<Singer> byStyle1 = new Comparator<>() {
            @Override
            public int compare(Singer o1, Singer o2) {
                return o1.getStyle().compareTo(o2.getStyle());
            }
        };

        Collections.sort(singerList, byStyle1);
        singerList.forEach(System.out::println);

        Comparator<Singer> byStyle2 = (Singer o1, Singer o2) -> o1.getName().compareTo(o2.getName());
        Collections.sort(singerList, byStyle2);
        singerList.forEach(System.out::println);
    }

    public static void q4_method_reference_comparator() {
        Comparator<Singer> byName = Comparator.comparing(Singer::getName);
        Collections.sort(singerList, byName);
        singerList.forEach(System.out::println);
        System.out.println("--------");
        singerList.sort((Singer o1, Singer o2) -> o1.getStyle().compareTo(o2.getStyle()));
        singerList.forEach(System.out::println);
    }
}

interface HalfValueInterface {
    public void printHalf(int n);
}

class NumberProcessor {
    public void printHalf(int n) {
        System.out.println(n / 2);
    }
}

class Singer {
    String name;
    Singstyle Style = Singstyle.NON;

    public Singer(String name, Singstyle style) {
        this.name = name;
        Style = style;
    }

    public Singer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Singstyle getStyle() {
        return Style;
    }
    public void setStyle(Singstyle style) {
        Style = style;
    }

    @Override
    public String toString() {
        return "Singer [name=" + name + ", Style=" + Style + "]";
    }
}

enum Singstyle {
    NON,POP,ROCK
}