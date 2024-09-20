package entity;

import java.awt.geom.Ellipse2D;

import controls.Controller;
import main.GamePanel;

public class Ball {

	Ellipse2D ball = new Ellipse2D.Double();

	public Ellipse2D tick() {
		ball.setFrame(Controller.ballX, Controller.ballY, Controller.ballSize, Controller.ballSize);
		Player p = new Player();
		if (ball.intersects(p.tick().get(0)) || ball.intersects(p.tick().get(1))) {
			Controller.ballHorizontalDirection = !Controller.ballHorizontalDirection;
		}
		if (ball.getMaxY() >= GamePanel.HEIGHT - 1 || ball.getMinY() <= 1) {
			Controller.ballVerticalDirection = !Controller.ballVerticalDirection;
			System.out.println("Vertical Direction:  "+Controller.ballVerticalDirection);
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
		
		return ball;
	}

}
