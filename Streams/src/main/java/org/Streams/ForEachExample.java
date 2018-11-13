package org.Streams;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class ForEachExample {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

		Consumer<String> consumer = s -> System.out.println(s);

		stream.forEach(consumer);

	}
}
