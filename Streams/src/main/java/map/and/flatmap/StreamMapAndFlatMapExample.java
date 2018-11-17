package map.and.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamMapAndFlatMapExample {

	public static void main(String[] args) {

		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		List<Integer> list2 = Arrays.asList(11, 12, 13);
		List<Integer> list3 = Arrays.asList(100);

		List<List<Integer>> listOfList = Arrays.asList(list1, list2, list3);

		Function<List<Integer>, Integer> function = list -> list.size();
		
		Function<List<Integer>, Stream<Integer>> flatMap = list -> list.stream();

		System.out.println("============Map with Example==============");
		listOfList.stream().map(function).forEach(System.out::println);
		
		System.out.println("============Map with flatmap Obejct Example==============");
		listOfList.stream().map(flatMap).forEach(System.out::println);
		
		System.out.println("============Map with flatmap Stream Example==============");
		listOfList.stream().flatMap(flatMap).forEach(System.out::println);

	}
}


