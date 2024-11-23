package collections.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;

public class ArrayList {

	public static void main(String[] args) {
		/**
		 * 1. Create an ArrayList of integers.
           Add 10 numbers to the list.
           Remove the number at index 5.
           Replace the 3rd number with 100.
           Print the entire list.
		 */
		List<Integer> li=new java.util.ArrayList<>();
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(6);
		li.add(7);
		li.add(8);
		li.add(9);
		li.add(10);
		// remove number at index 5
		li.remove(5);
		// replace 3rd number with 100
		li.set(3, 100);
		System.out.println(li);
		
		//2. Write a method to sort the elements of an ArrayList in place.
		// ie in ascending and descending order.
		// ascending order
		Collections.sort(li);
		System.out.println(li);
		// descending order
		Collections.sort(li,Comparator.reverseOrder());
		System.out.println(li);
		
		//3. Given an ArrayList of strings, identify and print the duplicate elements.
		List<String> words=Arrays.asList("apple", "banana", "apple", "cherry", "banana");
		//words.stream().dis
		
		//4. Merge two arraylist and remove duplicates.
		List<Integer> list2=Arrays.asList(1,2,6,7,9,12,16,18);
		li.addAll(list2);
		System.out.println(li);
		Set<Integer> hset=new LinkedHashSet<>(li);
		List<Integer> mergedList=new java.util.ArrayList<Integer>(hset);
		System.out.println(Arrays.asList(mergedList));
		
		//5 write a method to reverse element of arraylist
		Collections.reverse(mergedList);
		// or
		for(int i=0; i<mergedList.size()/2; i++) {
			int temp=mergedList.get(i);
			mergedList.set(i, mergedList.get(mergedList.size()-i-1));
			mergedList.set(mergedList.size()-i-1, temp);
		}
		System.out.println(mergedList);
	}

}
