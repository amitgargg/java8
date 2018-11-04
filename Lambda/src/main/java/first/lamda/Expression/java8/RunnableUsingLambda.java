package first.lamda.Expression.java8;

public class RunnableUsingLambda {

	public static void main(String[] args) {
		Runnable runnable = () -> System.out.println("Using Lambda Expression");
		Thread thread = new Thread(runnable);
		thread.start();
	}

}

