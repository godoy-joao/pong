package controls;

import java.util.Random;

import main.GamePanel;

public class Controller {

	static Random random = new Random();

	public static double ballX = GamePanel.WIDTH / 2 - 10, ballY = GamePanel.HEIGHT / 2 - 10,
			leftY = (GamePanel.HEIGHT / 2 - ((GamePanel.HEIGHT / 5 + 50) / 2)),
			rightY = (GamePanel.HEIGHT / 2 - ((GamePanel.HEIGHT / 5 + 50) / 2)), ballSize = 20;
	public static boolean ballVerticalDirection = random.nextBoolean(), ballHorizontalDirection = random.nextBoolean(),
			pause = true;
	public static final int leftX = 50, rightX = GamePanel.WIDTH - 60;
	public static double ballVerticalSpeed = 1.0, ballHorizontalSpeed = 1.0;
	public static double rightSpeedMultiplier = 1.5, leftSpeedMultiplier = 1.5, ballVerticalSpeedMultiplier = random.nextDouble() + 0.1,
			ballHorizontalSpeedMultiplier = 2;
	public static int rightHeight = GamePanel.HEIGHT / 5 + 50, leftHeight = GamePanel.HEIGHT / 5 + 50, leftPoints = 0,
			rightPoints = 0;
	public static long pastTime = 0, second = 1000000000;

	public void tick(boolean w, boolean s, boolean up, boolean down) {
		if (w && !s && leftY > 0) {
			leftY -= (2 * leftSpeedMultiplier) / 30000;
		}

		if (s && !w && leftY < GamePanel.HEIGHT - Controller.leftHeight) {
			leftY += (2 * leftSpeedMultiplier) / 30000;
		}

		if (up && !down && rightY > 0) {
			rightY -= (2 * rightSpeedMultiplier) / 30000;
		}

		if (down && !up && rightY < GamePanel.HEIGHT - Controller.rightHeight) {
			rightY += (2 * rightSpeedMultiplier) / 30000;
		}
		
		if (pause && (System.nanoTime() - pastTime) >= 5 * second) {
			System.out.println("Resume game");
			pause = false;
			ballVerticalDirection = random.nextBoolean();
			ballHorizontalDirection = random.nextBoolean();
		}
	}

}
