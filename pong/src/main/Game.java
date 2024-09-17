package main;

import java.awt.event.KeyEvent;

import controls.Controller;

public class Game {

	int time = 0;

	public Controller controls;

	public Game() {
		controls = new Controller();
	}

	public void tick(boolean[] key) {
		time++;
		
		if (time >= Integer.MAX_VALUE)
			time = 0;
		
		boolean w = key[KeyEvent.VK_W];
		boolean s = key[KeyEvent.VK_S];
		System.out.print("");
		boolean up = key[KeyEvent.VK_UP];
		boolean down = key[KeyEvent.VK_DOWN];
		
		controls.tick(w, s, up, down);
	}
}
