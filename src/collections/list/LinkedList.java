package collections.list;

import java.util.*;
public class LinkedList {

	public static void main(String[] args) {
		/** 1.Create a LinkedList of integers.
		Add elements to the list at various positions.
		Remove an element by value and by index.
		Check if an element exists in the list.
		Print the size of the list.
		 */
		List<Integer> linkedList=new java.util.LinkedList<>();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(6);
		linkedList.add(7);
		linkedList.add(8);
		linkedList.add(9);
		linkedList.add(10);

		linkedList.remove(4);
		linkedList.remove((int) 6);
		if(linkedList.contains(10)) {
			System.out.println("This element contains the list");
		}
		System.out.println(linkedList.size());

		//2 Write a method to traverse and print all elements of a LinkedList using:
		for(Integer i:linkedList) {
			System.out.print(i + " ");
		}
		System.out.println();

		Iterator<Integer> itlist=linkedList.iterator();
		while(itlist.hasNext()) {
			System.out.print(itlist.next() + " ");
		}

		System.out.println();
		linkedList.stream().forEach(x-> System.out.print(x + " "));
		System.out.println();
		/**
		 * 3.Use the LinkedList as a deque to:
           Add elements to the front and rear of the list.
           Remove elements from the front and rear.
           Peek at the first and last elements without removing them
		 */
		java.util.LinkedList<Integer> li=new java.util.LinkedList<>();
		li.addFirst(10);  // 10 , 10->40, 40, 40->85, 40, 40->81, 90->40->81, 90,81
		li.addLast(40);
		li.removeFirst();
		li.add(85);
		li.removeLast();
		System.out.println(li);
		System.out.println(li.peek());
		li.addLast(81);
		li.addFirst(90);
		System.out.println(li.peekFirst());
		System.out.println(li.peekLast());
		
		System.out.println("------------------------------------");

		/**
		 * 4. Stack Operations
             Use the LinkedList as a stack:
             Push elements onto the stack.
             Pop elements from the stack.
             Peek at the top element without removing it.
		 */
		
		java.util.LinkedList<Integer> stack=new java.util.LinkedList<>();
		stack.push(12);
		stack.push(14);
		stack.push(18);
		stack.push(2);
		
		System.out.println(stack.peekFirst());
		System.out.println(stack.peekLast());
		
		stack.pop();
		
		while(!stack.isEmpty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
		System.out.println("Queue Operations --------------------------");
		
		
		/**
		 * 5. Queue Operations
          Use the LinkedList as a queue:
          Add elements to the queue.
          Poll elements from the queue.
          Peek at the front of the queue.
		 */
		java.util.LinkedList<Integer> queue=new java.util.LinkedList<>();
		queue.offer(12);
		queue.offer(14);
		queue.offer(18);
		queue.offer(2);
		
		System.out.println(queue.peek());
		System.out.println(queue.peekLast());
		
		queue.poll();
		
		while(!queue.isEmpty()) {
			System.out.println(queue.peekFirst());
			queue.pollLast();
		}
		
		System.out.println("reversing --------------------");
		
		
		//6. reverse the list
		Collections.reverse(linkedList);
		System.out.print(linkedList);
		
		//7. Sort the list in ascending,descending order.
		System.out.println("ascending order sort --------------------");
		Collections.sort(queue);
		System.out.print(queue);
		System.out.println("descending order sort --------------------");
		Collections.sort(linkedList,Collections.reverseOrder());
		System.out.print(linkedList);
		
		System.out.println("Intersection of two lists --------------------");
		//8. Intersections of two lists
		linkedList.retainAll(stack);
		System.out.print(linkedList);
		
		System.out.println("Shuffling --------------------");
		//9. shuffling of elements
		Collections.shuffle(stack);
		System.out.print(stack);

	}

}
