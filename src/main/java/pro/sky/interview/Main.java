package pro.sky.interview;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    List<String> names = List.of(
        "Евгений",
        "Валерия",
        "Ольга",
        "Максим",
        "Никита",
        "Алёна",
        "Софья"
    );
    System.out.println(removeFirstLetterAndSort(names));
  }

  public static List<String> removeFirstLetterAndSort(List<String> names) {
    return names.stream()
        .map(str -> str.substring(1))
        .sorted(Comparator.naturalOrder())
        .collect(Collectors.toList());
  }

}
