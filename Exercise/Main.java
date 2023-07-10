import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bc", "wde", "dewe", "etwte");
        System.out.println(list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));
    }
}