package streams.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamsEasy {

	public static void main(String[] args) {
		
		// 1. Write a program to filter even numbers from a list of integers using streams.
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(numbers.stream().filter(num->num%2==0).collect(Collectors.toList()));
       
		// 2. Given a list of integers, find the maximum and minimum values using streams.
		List<Integer> numbers2 = Arrays.asList(5, 12, 7, 19, 3, 1, 15);
		System.out.println(numbers2.stream().max(Comparator.comparingInt(x->x)).get());
		// min number
		System.out.println(numbers2.stream().min(Comparator.comparingInt(x->x)).get());
		//System.out.println(numbers2.stream()
		
		//3 convert a list of strings to uppercase using the map operation.
		List<String> words = Arrays.asList("java", "streams", "practice", "lambda");
		System.out.println(words.stream().map(x->x.toUpperCase()).collect(Collectors.toList()));
		
		//4. Group words from a list based on their lengths using the Collectors.groupingBy
		
		List<String> words2 = Arrays.asList("cat", "dog", "elephant", "ant", "bat");
		
		System.out.println(words2.stream().collect(Collectors.groupingBy(word->word.length())));
		
		//5. calculate Average
		List<Integer> numbersAvg = Arrays.asList(10, 20, 30, 40, 50);
		System.out.println(numbersAvg.stream().collect(Collectors.averagingDouble(x->x.doubleValue())));
		
		//6. Find the first string that starts with the letter "s" from a list of strings.
		List<String> wordsMatch = Arrays.asList("apple", "banana", "strawberry", "orange", "spinach");
		
		System.out.println(wordsMatch.stream().filter(word->word.startsWith("s")).findFirst().get());
		
		//7. Count the number of words in a list that have more than 5 characters.
		
		List<String> wordsCount = Arrays.asList("stream", "java", "programming", "lambda", "functions");
		
		System.out.println(wordsCount.stream().filter(word->word.length()>5).count());
		
		//8. Find the distinct elements in a list of integers.
		
		List<Integer> numbersdistinct = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6);
		
		System.out.println(numbersdistinct.stream().distinct().collect(Collectors.toList()));
		
		//9. Partition the numbers into even and odd categories using streams.
		
		List<Integer> numbersPartition = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		
		System.out.println(numbersPartition.stream().collect(Collectors.partitioningBy(num->num%2==0)));
		
		//10. Find the Second Maximum and Second Minimum
		List<Integer> numberssecMaxmin = Arrays.asList(5, 12, 7, 19, 3, 1, 15, 7);
		// sort the list
		numberssecMaxmin=numberssecMaxmin.stream().distinct().sorted().collect(Collectors.toList());
		// sec min value
		System.out.println(numberssecMaxmin.size()>1?numberssecMaxmin.get(1):Integer.MIN_VALUE);
		// sec max value
		System.out.println(numberssecMaxmin.size()>1?numberssecMaxmin.get(numberssecMaxmin.size()-2):Integer.MAX_VALUE);
		//System.out.println(numberssecMaxmin.stream().max(Comparator.comparingInt(x->x).thenComparingInt(y->y)));
		
		// 11. Find the maximum and minimum values from a subset of integers that meet a specific condition.
		// For example, only consider numbers greater than 10
		List<Integer> numbersmaxminsubset = Arrays.asList(5, 12, 7, 19, 3, 1, 15);
		// max element from  set  from number more than 10
		System.out.println(numbersmaxminsubset.stream().filter(x->x>10).max(Comparator.comparingInt(x->x)).get());
		
		// min element from  set  from number more than 10 
		System.out.println(numbersmaxminsubset.stream().filter(x->x>10).min(Comparator.comparingInt(x->x)).get());
		
		// 12. Maximum Length String
		List<String> wordsmaxlength = Arrays.asList("apple", "banana", "cherry", "watermelon", "kiwi");
		System.out.println(wordsmaxlength.stream().max(Comparator.comparingInt(x->x.length())).get());
		
		// 13. Find the top 3 maximum numbers from a list of integers.
		List<Integer> numberstop3 = Arrays.asList(10, 15, 25, 30, 20, 40, 50);
		numberstop3 =numberstop3.stream().distinct().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
		System.out.println(numberstop3);
		
		//14 Given a string, find the character with the maximum frequency.
		String input = "streamingstreams";
		Map.Entry<Character, Long> maxFrequencyChar = input.chars()
                .mapToObj(c -> (char) c) // Convert each int to char
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group by character and count
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue()) // Find the entry with the maximum value
                .orElseThrow(() -> new RuntimeException("No characters in the string"));

        // Printing the result
        System.out.println("Character with Maximum Frequency: " + maxFrequencyChar.getKey());
        System.out.println("Frequency: " + maxFrequencyChar.getValue());
		
		//15. Given a list of strings, find the longest and shortest words.
		List<String> wordsls = Arrays.asList("stream", "java", "programming", "lambda", "functions");
		//longest word
		System.out.println(wordsls.stream().max(Comparator.comparingInt(x->x.length())).get());
		// shortest word
		System.out.println(wordsls.stream().min(Comparator.comparingInt(x->x.length())).get());
	}

}
