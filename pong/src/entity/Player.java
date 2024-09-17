package entity;

import java.awt.Rectangle;
import java.util.List;

import controls.Controller;

import java.util.ArrayList;

public class Player {

	Rectangle rect = new Rectangle();

	public List<Rectangle> tick() {
		List<Rectangle> rects = new ArrayList<Rectangle>();

		rect.setBounds(Controller.leftX, (int) (Controller.leftY + ((System.currentTimeMillis() % 10000) / 50)), 10, Controller.leftHeight);
		rects.add(rect);
		rect.setBounds(Controller.rightX, Controller.rightY, 10, Controller.rightHeight);
		rects.add(rect);
		return rects;
	}

}
