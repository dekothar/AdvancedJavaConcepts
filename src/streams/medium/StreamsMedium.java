package streams.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsMedium {

	public static void main(String[] args) {
		//1.Filter out employees whose age is greater than 30 and collect them into a new list.
		List<Employee> employee=new ArrayList<>();
		
		employee.add(new Employee(1,"DK",25,98765432));
		employee.add(new Employee(2,"sK",30,765432));
		employee.add(new Employee(3,"MK",35,54320));
		employee.add(new Employee(4,"PK",40,785432));
		employee.add(new Employee(5,"KK",45,185432));
		employee.add(new Employee(6,"VK",31,85432));
		
		List<Employee> employeeGreaterThan30=employee.stream().filter(x->x.getAge()>30).collect(Collectors.toList());
		System.out.println(employeeGreaterThan30);
		
		/**
		 * 2.Given a list of Student objects with properties: id, name, and grade, 
		 * group students by their grades and count how many students are in each grade.
		 */
		
       List<Student> student=new ArrayList<>();
		
       student.add(new Student(1,"DK",'A'));
       student.add(new Student(2,"sK",'B'));
       student.add(new Student(3,"MK",'B'));
       student.add(new Student(4,"PK",'C'));
       student.add(new Student(5,"KK",'C'));
       student.add(new Student(6,"VK",'B'));
       
       System.out.println(student.stream().collect(Collectors.groupingBy(x->x.getGrade())));
       
       System.out.println(student.stream().collect(Collectors.groupingBy(Student::getGrade,Collectors.counting())));
       
       //3. Find the employee with the highest salary using streams.
       System.out.println(employee.stream().max(Comparator.comparingDouble(x->x.getSalary())).map(x->x.getName()).get());
       
       //4. You have a list of Employee objects with properties: id,name, age, and salary.
       //Sort the list by age in descending order and get the top 3 oldest people.
       Comparator<Employee> compOfMaxSalary=(e1,e2)->(int)(e2.getSalary()-e1.getSalary());
    	
       List<String> employeeWithMostSalary=employee.stream().sorted(compOfMaxSalary).limit(3).map(x->x.getName()).collect(Collectors.toList());
       System.out.println(employeeWithMostSalary);
       
       //5. Partition the list into two groups: numbers greater than 10 and numbers less than or equal to 10.
       List<Integer> li=List.of(1,11,21,2,34,12,9,122,8,6,89,34,7);
       Map<Boolean,List<Integer>> res=li.stream().collect(Collectors.partitioningBy(x->x>=10));
       System.out.println(res);
       System.out.println("No of elemnets greater than 10" +" "  + res.get(true));
       System.out.println("No of elemnets lesser than 10" + " " + res.get(false));
       
       //6. Use streams to calculate the sum, average, maximum, and minimum values in the list.
       System.out.println(li.stream().collect(Collectors.summarizingDouble(x->x)));
       
       //7. Use reduce to find the product of all numbers in the list.
       List<Integer> li2=List.of(1,11,72,4,8);
       System.out.println(li2.stream().reduce((x,y)->x*y).get());
       
       //8. Remove duplicate strings, sort them alphabetically, and collect them into a new list.
       List<String> words=List.of("deep","aman","nakori","pjuhy","wedrf","deep","nakori","chindi");
       List<String> sortedWord=words.stream().distinct().sorted().collect(Collectors.toList());
       System.out.println(sortedWord);
       
       //9. Group the strings by their first letter and collect the result into a map.
       Map<Character,List<String>> wordsByFirstChar=words.stream().collect(Collectors.groupingBy(x->x.charAt(0))); 
       System.out.println(wordsByFirstChar);
       

	}

}
