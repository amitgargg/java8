package reduce.or.reduction.or.aggregation;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class AggregationSumExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		Integer identity = 0;

		BinaryOperator<Integer> sumLogic = (arg1, arg2) -> arg1 + arg2;

		Stream<Integer> stream = list.stream();
		Integer sum = stream.reduce(identity, sumLogic);
		System.out.println(sum); // Output : 10

		stream = Stream.empty();
		System.out.println(stream.reduce(identity, sumLogic)); // Output: 0

		stream = Stream.of(2);
		System.out.println(stream.reduce(identity, sumLogic)); // Output: 2

		stream = Stream.of(-20);
		System.out.println(stream.reduce(identity, sumLogic)); // Output: -20

	}

}

	
