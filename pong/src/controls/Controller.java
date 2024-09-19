package controls;

import main.GamePanel;

public class Controller {

	public static double ballX = GamePanel.WIDTH / 2 - 10, ballY = GamePanel.HEIGHT / 2 - 10, leftY, rightY, ballSize = 20;
	public static boolean ballVerticalDirection = true, ballHorizontalDirection = true;
	public static final int leftX = 50, rightX = GamePanel.WIDTH - 60;
	public static double ballVerticalSpeed = 1.0, ballHorizontalSpeed = 1.0;
	public static double rightSpeedMultiplier = 1.0, leftSpeedMultiplier = 1.0, ballVerticalSpeedMultiplier = 1.0,
			ballHorizontalSpeedMultiplier = 1.0;
	public static int rightHeight = GamePanel.HEIGHT/5 + 50, leftHeight = GamePanel.HEIGHT/5 + 50;
	
	

	public void tick(boolean w, boolean s, boolean up, boolean down) {
		if (w && !s && leftY !=) {
			leftY -= (2 * leftSpeedMultiplier) /30000;
		}

		if (s && !w) {
			leftY += (2 * leftSpeedMultiplier) /30000;
		}

		if (up && !down) {
			rightY -= (2 * rightSpeedMultiplier) /30000;
		}

		if (down && !up) {
			rightY += (2 * rightSpeedMultiplier) /30000;
		}

	}

}
