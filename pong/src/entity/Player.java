package entity;

import java.awt.Rectangle;
import java.util.List;

import controls.Controller;

import java.util.ArrayList;

public class Player {

	public List<Rectangle> tick() {
		List<Rectangle> rects = new ArrayList<Rectangle>();
		Rectangle left  = new Rectangle();
		left.setBounds(Controller.leftX, (int) Controller.leftY, 15, Controller.leftHeight);
		rects.add(left);
		Rectangle right = new Rectangle();
		right.setBounds(Controller.rightX, (int) Controller.rightY, 15, Controller.rightHeight);
		rects.add(right);
		return rects;
	}
}
