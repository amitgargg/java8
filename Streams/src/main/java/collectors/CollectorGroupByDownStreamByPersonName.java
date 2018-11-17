package collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import optional.Person;

public class CollectorGroupByDownStreamByPersonName {

	public static void main(String[] args) {
		List<Person> persons = getPersons();

		Function<Person, String> mapper = (person) -> person.getName();
		Collector<String, ?, List<String>> downstream = Collectors.toList();
		Collector<Person, ?, List<String>> personNameCollector 
									= Collectors.mapping(mapper, downstream);

		Function<Person, Integer> collectFunction = (person) -> person.getAge();
		Collector<Person, ?, Map<Integer, List<String>>> collector = 
				Collectors.groupingBy(collectFunction, personNameCollector);

		Map<Integer, List<String>> personmap = persons.stream().collect(collector);

		System.out.println(personmap);
	}

	
	private static List<Person> getPersons() {
		Person p1 = new Person("AMIT", 100);
		Person p2 = new Person("SUMIT", 100);
		Person p3 = new Person("RAM", 90);
		Person p4 = new Person("LXMAN", 30);
		Person p5 = new Person("POOJA", 20);
		Person p6 = new Person("KAPIL", 80);
		Person p7 = new Person("SHIVANI", 60);
		Person p8 = new Person("KHUSHI", 10);
		Person p9 = new Person("SHARDA", 70);
		Person p10 = new Person("VIPIN", 40);
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
	}
}
