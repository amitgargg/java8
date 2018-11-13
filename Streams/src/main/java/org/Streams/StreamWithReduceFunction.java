package org.Streams;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamWithReduceFunction {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

		Predicate<String> two = s -> s.equals("two");
		
		Predicate<String> three = Predicate.isEqual("three");
		
		Predicate<String> twoORthree = two.or(three);
		
		Consumer<String> consumer = s -> System.out.println(s);

		stream.filter(twoORthree).forEach(consumer);

	}
}
