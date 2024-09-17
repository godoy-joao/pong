package controls;

import main.GamePanel;

public class Controller {

	public static int ballX, ballY, leftY, rightY, ballVerticalDirection, ballHorizontalDirection;
	public static final int leftX = 50, rightX = GamePanel.WIDTH - 60;
	public static double ballVerticalSpeed = 1.0, ballHorizontalSpeed = 1.0;
	public static double rightSpeedMultiplier = 1.0, leftSpeedMultiplier = 1.0, ballVerticalSpeedMultiplier = 1.0,
			ballHorizontalSpeedMultiplier = 1.0;

	public void tick(boolean w, boolean s, boolean up, boolean down) {
		if (w && !s) {
			leftY -= 2 * leftSpeedMultiplier;
		}

		if (s && !w) {
			leftY += 2 * leftSpeedMultiplier;
		}

		if (up && !down) {
			rightY -= 2 * rightSpeedMultiplier;
		}

		if (down && !up) {
			rightY += 2 * rightSpeedMultiplier;
		}

		if (ballVerticalDirection == 1) {
			ballY += ballVerticalSpeedMultiplier * ballVerticalSpeed;
		}

		if (ballVerticalDirection == 0) {
			ballY -= ballVerticalSpeedMultiplier * ballVerticalSpeed;
		}

		if (ballHorizontalDirection == 1) {
			ballY += ballHorizontalSpeedMultiplier * ballHorizontalSpeed;
		}

		if (ballHorizontalDirection == 0) {
			ballY += ballHorizontalSpeedMultiplier * ballHorizontalSpeed;
		}
	}

}
