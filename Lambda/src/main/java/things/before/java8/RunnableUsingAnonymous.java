package things.before.java8;

public class RunnableUsingAnonymous {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Using Anonymous class");
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}
}
