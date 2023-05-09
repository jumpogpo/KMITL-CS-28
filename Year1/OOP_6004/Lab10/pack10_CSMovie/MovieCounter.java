package pack10_CSMovie;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovieCounter {
    ArrayList<CSMovie> mList = new ArrayList<>();
    Set<String> uniqueTitle = new HashSet<>();
    public MovieCounter() {
        String row;
        int rowCount = 1;
        int incompleteCount = 0;
        String title;
        String rating;
        String genre;
        Integer year;
        String skipped_released;
        Double score;
        Integer votes;
        String director;
        String skipped_writer;
        String star;
        String country;
        Integer budget;
        Long gross;
        String company;
        Integer runtime;

        try(Scanner input = new Scanner(Paths.get("pack10_CSMovie/movies.csv"))) {
            input.nextLine(); //skip header row
            while (input.hasNext()) {
                row = input.nextLine();
                rowCount++;
                String[] tokens = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                if (tokens.length < 15) {
                    incompleteCount++;
                    System.out.println(rowCount + " " + incompleteCount + " is incompleted");
                    continue; //skip this row
                } 
                title = tokens[0];   
                rating = tokens[1];
                genre = tokens[2];
                year = Integer.parseInt(tokens[3]);
                score = Double.parseDouble(parseDouble(tokens[5]));
                votes = (int) (Double.parseDouble(parseDouble(tokens[6])));
                director = tokens[7];
                star = tokens[9];
                country = tokens[10];
                budget = (int) (Double.parseDouble(parseDouble(tokens[11])));
                gross = (long) (Double.parseDouble(parseDouble(tokens[12])));
                company = tokens[13];
                runtime = (int) (Double.parseDouble(parseDouble(tokens[14])));
                if (!uniqueTitle.contains(title)) {
                    mList.add(new CSMovie(title, rating, genre, 
                    year, score, votes, 
                    director, star, country, 
                    budget, gross, company, 
                    runtime));
                }   
                uniqueTitle.add(title);
            }
            System.out.print("There are " + incompleteCount + " rows of incompleted data ");
            System.out.println("from " + rowCount + " rows. (" + uniqueTitle.size()+ ") unique titles.");
            System.out.println("list size is " + mList.size());
        } catch (IOException e) {
            System.out.println("from IO error");
            e.printStackTrace();
        }
    }

    private static String parseDouble(String str) {
        if (str.isEmpty())
            return ".0";
        return str;
    }

    public Double q1() {
        return mList.stream()
        .mapToDouble(e -> e.getScore()).average()
        .getAsDouble();
    }

    public List<CSMovie> q2() {
        return mList.stream()
        .filter(e -> e.getVotes() > 1900000)
        .collect(Collectors.toList());
    }

    public CSMovie q3() {
        return mList.stream()
        .max(Comparator.comparing(CSMovie::getGross))
        .get();
    }   

    public List<String> q4() {
        return mList.stream()
        .map(cs -> cs.getGenre())
        .distinct()
        .collect(Collectors.toList());
    }

    public List<String> q5() { 
        return mList.stream()
        .sorted(Comparator.comparing(CSMovie::getRuntime))
        .map(e -> String.format("%-55s --> %s",e.getTitle(), e.getRuntime()))
        .limit(5).collect(Collectors.toList());
    }

    public CSMovie[] q6() {
        CSMovie[] sorted = mList.stream()
        .sorted(Comparator.comparing(CSMovie::getBudget).reversed())
        .toArray(CSMovie[]::new);

        CSMovie[] result = {sorted[0], sorted[sorted.length - 1]};
        return result;
    }

    public List<CSMovie> q7(String genre) {
        return mList.stream()
        .filter(cs -> cs.getGenre().equals(genre))
        .sorted(Comparator.comparing(CSMovie::getScore).reversed())
        .limit(3)
        .collect(Collectors.toList());
    }

    public List<CSMovie> q8() {
        return mList.stream()
        .filter(cs -> cs.getGenre().equals("Action"))
        .sorted(Comparator.comparing(CSMovie::getScore).reversed()
        .thenComparing(Comparator.comparing(CSMovie::getTitle)))
        .limit(3)
        .collect(Collectors.toList());
    }

    public Map<String,Long> q9() {
        return mList.stream()
        .collect(Collectors.groupingBy(CSMovie::getGenre, Collectors.summingLong(CSMovie::getGross)));
    }

    public Map<String,Long> q10() {
        return mList.stream()
        .collect(Collectors.groupingBy(CSMovie::getCompany, Collectors.counting()))
        .entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(10)
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
    }

    public CSMovie q11() {
        // Function most 'a' 
        Function<CSMovie, Integer> countVowel = m -> {
            String title = m.getTitle().toLowerCase();
            int cnt = 0;
            for (int i = 0; i < title.length(); i++) {
                if (title.charAt(i) == 'a') cnt++;
            }
            return cnt;
        };

        Optional<CSMovie> m = mList.stream().max(Comparator.comparing(countVowel));
        return m.get();
    }
}
// https://www.baeldung.com/java-split-string-commas