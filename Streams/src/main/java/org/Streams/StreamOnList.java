package org.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamOnList {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");

		Stream<String> stream = list.stream();

		Consumer<String> consumer = s -> System.out.println(s);

		stream.forEach(consumer);

	}
}
