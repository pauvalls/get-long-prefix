import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class GetLongestPrefixTest {

  @Test
  void should_return_exception_when_input_have_a_word_with_21_characters() {
    // given
    final List<String> listOfWords = Arrays.asList("flower", "ihaveMoreThan21characters", "flight");
    // when
    final Exception exception = assertThrows(Exception.class, () -> GetLongestPrefix.checkContstrains(listOfWords));
    // then
    assertEquals(exception.getMessage(), "Constrains executed: the words can't be more than 20 characters");
  }

  @Test
  void should_return_exception_when_input_have_a_empty_list() {
    // given
    final List<String> listOfWords = Collections.EMPTY_LIST;
    // when
    final Exception exception = assertThrows(Exception.class, () -> GetLongestPrefix.checkContstrains(listOfWords));
    // then
    assertEquals(exception.getMessage(), "Constrains executed: the list can't be  empty");
  }

  @Test
  void should_return_exception_when_input_have_more_than_200_elements() {
    // given
    final var intArray = IntStream.rangeClosed(0, 200).toArray();// From 0 to 100
    final var listOfWords = Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.toList());
    // when
    final var exception = assertThrows(Exception.class, () -> GetLongestPrefix.checkContstrains(listOfWords));
    // then
    assertEquals(exception.getMessage(), "Constrains executed: the list can't be more than 200 words");
  }

  @Test
  void should_return_exception_when_input_have_a_word_with_not_english_letters() {
    // given
    final List<String> listOfWords = Arrays.asList("flower", "comeré", "flight");
    // when
    final Exception exception = assertThrows(Exception.class, () -> GetLongestPrefix.checkContstrains(listOfWords));
    // then
    assertEquals(
        exception.getMessage(),
        "Constrains executed: the word only can use the english  letters and to lower case letters"
    );
  }

  @Test
  void should_return_exception_when_input_have_a_word_with_uppercase_letters() {
    // given
    final List<String> listOfWords = Arrays.asList("flower", "FLOWER", "flight");
    // when
    final Exception exception = assertThrows(Exception.class, () -> GetLongestPrefix.checkContstrains(listOfWords));
    // then
    assertEquals(
        exception.getMessage(),
        "Constrains executed: the word only can use the english  letters and to lower case letters"
    );
  }

  @Test
  void should_return_empty_when_list_does_not_have_any_prefix() {
    // given
    final var listOfWords = Arrays.asList("flower", "ihaveMoreThan21characters", "floght");
    // when
    final var result = GetLongestPrefix.getLongestPrefix(listOfWords);
    // then
    assertEquals(result, "");
  }

  @Test
  void should_return_empty_when_list_has_empty_string() {
    // given
    final var listOfWords = Arrays.asList("flower", "", "flight");
    // when
    final var result = GetLongestPrefix.getLongestPrefix(listOfWords);
    // then
    assertEquals(result, "");
  }

  @Test
  void should_return_flo_when_list_has_a_prefix() {
    // given
    final var listOfWords = Arrays.asList("flower", "flowerpower", "flight");
    // when
    final var result = GetLongestPrefix.getLongestPrefix(listOfWords);
    // then
    assertEquals(result, "fl");
  }

  @Test
  void should_return_flower_when_list_has_a_word_like_a_prefix() {
    // given
    final var listOfWords = Arrays.asList("flower", "flowerpower", "flowerpowerpower");
    // when
    final var result = GetLongestPrefix.getLongestPrefix(listOfWords);
    // then
    assertEquals(result, "flower");
  }

}