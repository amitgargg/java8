package spliterator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyCustomspliterator {

	public static void main(String[] args) throws URISyntaxException {

		URL url = ClassLoader.getSystemResource("people.txt");

		Path path = Paths.get(url.toURI());

		try (Stream<String> line = Files.lines(path)) {
			Spliterator<String> lineSpliterator = line.spliterator();
			Spliterator<Person> personSpliterator = new PersonSpliterator(lineSpliterator);

			Stream<Person> personStream = StreamSupport.stream(personSpliterator, false);

			personStream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
