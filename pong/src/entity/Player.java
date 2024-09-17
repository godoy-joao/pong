package entity;

import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import main.GamePanel;

public class Player{

	Rectangle rect = new Rectangle();
	
	public List<Rectangle> tick() {
		List<Rectangle> rects = new ArrayList<Rectangle>();
		
			rect.setBounds(0, 0, 10, (GamePanel.HEIGHT / 5));	
			Rectangle left = rect;
		
		
		
		return rects;
	}
	
}
