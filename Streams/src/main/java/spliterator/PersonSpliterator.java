package spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class PersonSpliterator implements Spliterator<Person> {

	private Spliterator<String> lineSpliterator;
	private String name;
	private String age;
	private String city;

	public PersonSpliterator(Spliterator<String> lineSpliterator) {
		this.lineSpliterator = lineSpliterator;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Person> action) {

		if (lineSpliterator.tryAdvance(line -> this.name = line) && lineSpliterator.tryAdvance(line -> this.age = line)
				&& lineSpliterator.tryAdvance(line -> this.city = line)) {
			Person person = new Person(name, age, city);
			action.accept(person);
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<Person> trySplit() {
		return null;
	}

	@Override
	public long estimateSize() {
		return lineSpliterator.estimateSize() / 3;
	}

	@Override
	public int characteristics() {
		return lineSpliterator.characteristics();
	}

}