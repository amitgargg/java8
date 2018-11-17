package org.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamIllegalStateException {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two");

		Stream<String> stream = list.stream();

		Consumer<String> consumer = s -> System.out.println(s);
		Consumer<String> consumer2 = System.out::println;

		stream.forEach(consumer);

		// 2nd time calling final operation over same stream
		// IllegalStateException: stream has already been operated upon or closed
		stream.forEach(consumer2);
	}
}

