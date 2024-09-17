package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import controls.InputHandler;

public class GamePanel extends JPanel implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final String TITLE = "Pong";
	public static final int WIDTH = 800, HEIGHT = 600;
	public boolean running;

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
		
		Graphics2D g2 = (Graphics2D) g;
		g2.fill(getBounds());
	}

	public void tick() {
		game.tick(InputHandler.key);
	}

}
