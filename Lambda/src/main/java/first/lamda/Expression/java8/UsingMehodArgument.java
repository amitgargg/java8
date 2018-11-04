package first.lamda.Expression.java8;

public class UsingMehodArgument {

	public static void main(String[] args) {
		PrintMe<String> printMe = (String t) -> System.out.println(t);
		printMe.print("Print Using Method Argument Implementation");
	}
}

interface PrintMe<T> {

	public void print(T t);

}