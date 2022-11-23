import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class GetLongestPrefix {

  //  Using Java or C#, please write a working solution:
  //  to find the longest common prefix string amongst an array of strings. If there is no
  //  common prefix, return an empty string;.

  //1 <= strs.length <= 200
  //0 <= strs[i].length <= 20

  public static void main(final String[] args) throws Exception {
    final List<String> listOfWords = Arrays.asList("flower", "flowerpower", "floght");
    checkContstrains(listOfWords);
    final var prefix = getLongestPrefix(listOfWords);
    System.out.println("the longest prefix is " + prefix);
  }

  public static void checkContstrains(final List<String> listOfWords) throws Exception {
    if (listOfWords.stream().anyMatch(s -> s.length() > 20)) {
      throw new Exception("Constrains executed: the words can't be more than 20 characters");
    }
    if (listOfWords.size() > 200) {
      throw new Exception("Constrains executed: the list can't be more than 200 words");
    }
    if (listOfWords.stream().anyMatch(s -> !s.matches("^[a-z]+$"))) {
      throw new Exception("Constrains executed: the word only can use the english letters");
    }
  }

  public static String getLongestPrefix(final List<String> listOfWords) {
    var prefix = "";
    int i = 0;

    final var minLenghtWord = listOfWords
        .stream()
        .min(Comparator.comparingInt(String::length))
        .get()
        .length();

    while (i < minLenghtWord && listOfWords.get(0).charAt(i) == listOfWords.get(listOfWords.size() - 1).charAt(i)) {
      i++;
      prefix = listOfWords.get(0).substring(0, i);
    }

    final String finalPrefix = prefix;

    final var discrepancy = listOfWords
        .stream()
        .anyMatch(x -> !x.startsWith(finalPrefix));

    if (discrepancy) {
      return "";
    }
    return prefix;
  }

}