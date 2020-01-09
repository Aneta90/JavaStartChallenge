package Logic;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import Model.Names;

public class Analyzer {

    public static Map<String, Long> theMostPopularNames(List<Names> dataFromCsv) {

        List<String> nameList = dataFromCsv.stream().map(Names::getFirstName).collect(Collectors.toList());
        Map<String, Long> theMostPopularMap = nameList.stream().collect(groupingBy(Function.identity(), counting()));

        return theMostPopularMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(10).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> {
                    throw new IllegalStateException();
                },
                LinkedHashMap::new
        ));
    }

    public static Map<String, Long> theMostPopularWomenName(List<Names> dataFromCsv) {

        List<String> nameList = dataFromCsv.stream().map(Names::getFirstName).filter(a -> a.substring(a.length() - 1).equals("a")).collect(Collectors.toList());
        Map<String, Long> theMostPopularWomenName = nameList.stream().collect(groupingBy(Function.identity(), counting()));

        return theMostPopularWomenName.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(1).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> {
                    throw new IllegalStateException();
                },
                LinkedHashMap::new
        ));
    }

    public static Map<Character, Long> namesStartedAtTheMostPopularLetters(List<Names> dataFromCsv) {

        StringBuilder stringBuilder = new StringBuilder();
        for (Names names : dataFromCsv) {
            stringBuilder.append(names.getFirstName().charAt(0));
        }

        return stringBuilder.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .limit(3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}