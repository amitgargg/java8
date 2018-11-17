package optional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamComparatorOptionalExample {

	public static void main(String[] args) {
		List<Person> persons = getPersons();

		Stream<Person> personStream = persons.stream();
		Comparator<Person> elderComparator = 
				(arg1, arg2) -> arg1.getAge() > arg2.getAge() ? 0 : 1;
		Optional<Person> elderPerson = personStream.min(elderComparator);
		System.out.println("Elder Person: " + elderPerson);

		Function<Person, Integer> getAge = (person) -> person.getAge();
		Comparator<Person> personComparator = Comparator.comparing(getAge);
		Optional<Person> youngerPerson = persons.stream().min(personComparator);
		System.out.println("Younger Person: " + youngerPerson);

		personComparator = Comparator.comparing(Person::getAge);
		elderPerson = persons.stream().max(personComparator);
		System.out.println("Elder Person: " + elderPerson);

	}

	private static List<Person> getPersons() {
		Person p1 = new Person("AMIT", 100);
		Person p2 = new Person("SUMIT", 50);
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
