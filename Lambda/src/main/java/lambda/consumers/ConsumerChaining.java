package lambda.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerChaining {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("one", "two", "three", "four", "five");

		Consumer<String> consumer = s -> System.out.println(s);
		Consumer<String> consumerMehodRef = System.out::println;

		List<String> newList = new ArrayList<>();
		Consumer<String> addConsumer = s -> newList.add(s);
		Consumer<String> addUsingMethodRef = newList::add;

		list.forEach(consumer.andThen(addConsumer));

		System.out.println("==================");

		list.forEach(consumerMehodRef.andThen(addUsingMethodRef));

		System.out.println("==================");

		newList.forEach(consumer);

	}
}
