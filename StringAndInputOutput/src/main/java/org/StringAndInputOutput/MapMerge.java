package org.StringAndInputOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapMerge {
	
	public static void main(String[] args) {
		List<Person> firstGroup = getFirstGroupOfPerson();
		List<Person> secondGroup = getSecondGroupOfPerson();
		Map<Integer, List<Person>> map1 = mapByAge(firstGroup);
		Map<Integer, List<Person>> map2 = mapByAge(secondGroup);

		// If key already Present in Map1
		BiFunction<List<Person>, List<Person>, List<Person>> mergeFunction = 
				(map1ListValue, map2listValue) -> {
					map1ListValue.addAll(map2listValue);
					return map1ListValue;
				};

		Consumer<Entry<Integer, List<Person>>> map2EntryConsumer = map2Entry -> 
				map1.merge(map2Entry.getKey(), map2Entry.getValue(), mergeFunction);

		map2.entrySet().stream().forEach(map2EntryConsumer);

		// Map Print Using For Each Function
		BiConsumer<Integer, List<Person>> forEachConsumer = (age, listOfPerson) -> 
				System.out.println("AGE: " + age + " Person List: " + listOfPerson);

		map1.forEach(forEachConsumer);
	}

	
	private static Map<Integer, List<Person>> mapByAge(List<Person> persons) {
		Stream<Person> stream = persons.stream();
		Function<Person, Integer> getAgeFunction = (Person person) -> person.getAge();
		Collector<Person, ?, Map<Integer, List<Person>>> collector
											= Collectors.groupingBy(getAgeFunction);
		Map<Integer, List<Person>> personMapByAge = stream.collect(collector);
		// return persons.stream().collect(Collectors.groupingBy(Person::getAge));
		return personMapByAge;
	}

	private static List<Person> getFirstGroupOfPerson() {
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

	private static List<Person> getSecondGroupOfPerson() {
		Person p1 = new Person("AMIT2nd", 25, "M");
		Person p2 = new Person("SUMIT2nd", 50, "M");
		Person p3 = new Person("RAM2nd", 90, "M");
		Person p4 = new Person("LXMAN2nd", 30, "M");
		Person p5 = new Person("POOJA2nd", 20, "F");
		Person p6 = new Person("KAPIL2nd", 80, "M");
		Person p7 = new Person("SHIVANI2nd", 60, "F");
		Person p8 = new Person("KHUSHI2nd", 60, "F");
		Person p9 = new Person("SHARDA2nd", 10, "F");
		Person p10 = new Person("VIPIN2nd", 25, "M");
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
	}

}
