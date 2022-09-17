package numberbaseball;

import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {
		init();
	}

	private static void init() throws IOException {
		Game game = new Game();
		game.run();
	}
}
