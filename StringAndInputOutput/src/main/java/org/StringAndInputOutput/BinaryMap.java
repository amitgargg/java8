package org.StringAndInputOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class BinaryMap {

	public static void main(String[] args) {
		explainFunction(null);
		singleLineFunction(null);
	}

	public static void explainFunction(String[] args) {
		List<Person> persons = getListOfPerson();

		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();

		Function<Integer, Map<String, List<Person>>> mappingFunction = (age) -> {
			return new HashMap<>();
		};

		persons.forEach(person -> biMap.computeIfAbsent(person.getAge(), mappingFunction));

		biMap.forEach((age, map) -> System.out.println(age + " -> " + map));

		persons.forEach(person -> biMap.get(person.getAge()).merge(person.getGender(),
				new ArrayList<>(Arrays.asList(person)), (currentValue, newValue) -> {
					currentValue.addAll(newValue);
					return currentValue;
				}));

		biMap.forEach((age, map) -> System.out.println(age + " -> " + map));
	}

	public static void singleLineFunction(String[] args) {
		List<Person> persons = getListOfPerson();
		Map<Integer, Map<String, List<Person>>> biMap = new HashMap<>();
		persons.forEach(person -> biMap.computeIfAbsent(person.getAge(), HashMap::new).merge(person.getGender(),
				new ArrayList<>(Arrays.asList(person)), (currentList, biMapList) -> {
					currentList.addAll(biMapList);
					return currentList;
				}));
		biMap.forEach((age, map) -> System.out.println(age + " -> " + map));
	}

	private static List<Person> getListOfPerson() {
		Person p1 = new Person("AMIT", 25, "M");
		Person p2 = new Person("SUMIT", 50, "M");
		Person p3 = new Person("RAM", 90, "M");
		Person p4 = new Person("LXMAN", 30, "M");
		Person p5 = new Person("POOJA", 20, "F");
		Person p6 = new Person("KAPIL", 80, "M");
		Person p7 = new Person("SHIVANI", 50, "F");
		Person p8 = new Person("KHUSHI", 60, "F");
		Person p9 = new Person("SHARDA", 10, "F");
		Person p10 = new Person("VIPIN", 25, "M");
		Person p11 = new Person("INDIVER", 60, "M");
		return Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11);
	}
}
