package lazy.operations.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LazyOperationStreamExample {

	public static void main(String[] args) {

		Stream<String> stream = Stream.of("one", "two", "three", "four", "five");

		List<String> list = new ArrayList<>();

		Consumer<String> addConsumer = s -> list.add(s);

		stream = stream.peek(addConsumer); // Lazy Operation intermediary operations

		System.out.println("Before for each Size = " + list.size());

		stream.forEach(System.out::println); // Final Operation, when Stream Execute

		System.out.println("After for each Size = " + list.size());
	}
}


