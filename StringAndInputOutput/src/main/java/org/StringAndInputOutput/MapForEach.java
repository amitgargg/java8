package org.StringAndInputOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapForEach {
	public static void main(String[] args) {
		List<Person> persons = getListOfPerson();
		Map<Integer, List<Person>> map1 = mapByAge(persons);
		BiConsumer<Integer, List<Person>> action = (age, listOfPerson) -> System.out
				.println("AGE: " + age + " Person List: " + listOfPerson);
		map1.forEach(action);
	}

	private static Map<Integer, List<Person>> mapByAge(List<Person> persons) {
		Stream<Person> stream = persons.stream();
		Function<Person, Integer> getAgeFunction = (Person person) -> person.getAge();
		Collector<Person, ?, Map<Integer, List<Person>>> collector = Collectors.groupingBy(getAgeFunction);
		Map<Integer, List<Person>> personMapByAge = stream.collect(collector);
		return personMapByAge;
//		========= One Line Return Statement as for Above ===========
//		return persons.stream().collect(Collectors.groupingBy(Person::getAge));
	}

	private static List<Person> getListOfPerson() {
		Person p1 = new Person("AMIT", 25, "M");
		Person p2 = new Person("SUMIT", 50, "M");
		Person p3 = new Person("RAM", 90, "M");
		Person p4 = new Person("LXMAN", 30, "M");
		Person p5 = new Person("POOJA", 20, "F");
		Person p6 = new Person("KAPIL", 80, "M");
		Person p7 = new Person("SHIVANI", 60, "F");
		Person p8 = new Person("KHUSHI", 60, "F");
		Person p9 = new Person("SHARDA", 10, "F");
		Person p10 = new Person("VIPIN", 25, "M");
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
	}
}
