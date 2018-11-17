package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class OptionalExampleUsingReduction {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(-10);

		BinaryOperator<Integer> maxFunction = (arg1, arg2) -> arg1 > arg2 ? arg1 : arg2;

		Integer identity = 0;
		Integer maxResult = list.stream().reduce(identity, maxFunction);

		// Output: 0 because Max function do not require Identity Object and
		// If we pass identity Object then it compare Identity object as first argument,
		// and the actual argument as second and compare
		System.out.println(maxResult); // Output: 0

		// Solution:do not pass identity Object.
		// But this function Return Optional Object in place of Normal,
		// because Stream can be empty
		Optional<Integer> max = list.stream().reduce(maxFunction);

		System.out.println(max); // OutPut: Optional[-10]

		List<Integer> List2 = Arrays.asList();
		max = List2.stream().reduce(maxFunction);
		System.out.println(max); // OutPut: Optional.empty

	}

}
