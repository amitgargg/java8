package lambda.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerUsingForEachExample {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");

		Consumer<String> consumer = s -> System.out.println(s);
		list.forEach(consumer);
		
		System.out.println("==================");
		
		Consumer<String> consumerMehodRef = System.out::println;
		list.forEach(consumerMehodRef);
	}
}

