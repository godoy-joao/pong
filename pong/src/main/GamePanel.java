package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JPanel;

import controls.Controller;
import controls.InputHandler;
import entity.Ball;
import entity.Player;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String TITLE = "Pong";
	public static final int WIDTH = 800, HEIGHT = 600;
	public boolean running;
	public Ball ball;

	private Thread thread;
	private InputHandler handler;
	private Game game;

	public GamePanel() {
		Dimension bounds = new Dimension(WIDTH, HEIGHT);
		setPreferredSize(bounds);
		setMinimumSize(bounds);
		setMaximumSize(bounds);
		handler = new InputHandler();
		game = new Game();
		addKeyListener(handler);
		addFocusListener(handler);
		setFocusable(true);
	}

	public void start() {
		if (running)
			return;
		thread = new Thread(this);
		running = true;
		thread.start();
	}

	public void stop() {
		if (!running)
			return;
		try {
			thread.join();
		} catch (Exception e) {
			System.out.println("Algo ocorreu");
			System.exit(0);
		}
	}

	@Override
	public void run() {
		while (running) {
			tick();
			repaint();
		}
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Player p = new Player();
		Ball ball = new Ball();
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, WIDTH, HEIGHT);
		List<Rectangle> players = p.tick();
		for (int i = 0; i < players.size(); i++) {
			g2.setColor(Color.WHITE);
			g2.fill(players.get(i));
		}
		g2.setColor(Color.white);
		
		g2.fill(ball.tick());
		System.out.println("controller:"+Controller.ballX + " : " + Controller.ballY);
		g2.dispose();
	}

	public void tick() {
		game.tick(InputHandler.key);
	}

}
