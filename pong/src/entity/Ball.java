package entity;

import java.awt.geom.Ellipse2D;
import java.util.Random;

import controls.Controller;
import main.GamePanel;

public class Ball {

	Ellipse2D ball = new Ellipse2D.Double();

	public Ellipse2D tick() {
		ball.setFrame(Controller.ballX, Controller.ballY, Controller.ballSize, Controller.ballSize);
		Player p = new Player();
		if (!Controller.pause) {
			if (ball.intersects(p.tick().get(0)) || ball.intersects(p.tick().get(1))) {
				Controller.ballHorizontalDirection = !Controller.ballHorizontalDirection;
			}
			
			if (ball.getMaxY() >= GamePanel.HEIGHT - 1 || ball.getMinY() <= 1) {
				Controller.ballVerticalDirection = !Controller.ballVerticalDirection;
			}
			
			if (Controller.ballHorizontalDirection) {
				Controller.ballX += (Controller.ballHorizontalSpeedMultiplier * Controller.ballHorizontalSpeed);
			}
			if (!Controller.ballHorizontalDirection) {
				Controller.ballX -= (Controller.ballHorizontalSpeedMultiplier * Controller.ballHorizontalSpeed);
			}
			if (Controller.ballVerticalDirection) {
				Controller.ballY += (Controller.ballVerticalSpeedMultiplier * Controller.ballVerticalSpeed);
			}
			if (!Controller.ballVerticalDirection) {
				Controller.ballY -= (Controller.ballVerticalSpeedMultiplier * Controller.ballVerticalSpeed);
			}
		}

		if (ball.getMinX() >= GamePanel.WIDTH || ball.getMaxX() <= 0) {
			Controller.ballX = GamePanel.WIDTH / 2 - 10;
			Controller.ballY = GamePanel.HEIGHT / 2 - 10;
			Controller.pause = true;
			Controller.pastTime = System.nanoTime();
			Controller.ballVerticalSpeedMultiplier = new Random().nextDouble() + (new Random().nextInt(3) / 10.0);
		}

		return ball;
	}

}
