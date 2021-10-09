package game.mario.bros.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import game.mario.bros.clones.CloudSpawner;
import game.mario.bros.clones.CoinSpawner;
import game.mario.bros.clones.GoombaSpawner;
import game.mario.bros.clones.MushroomTileSpawner;
import game.mario.bros.clones.PipeSpawner;
import game.mario.bros.clones.TurtleSpawner;
import game.mario.bros.entites.Mario;
import game.mario.bros.graphics.Background;
import game.mario.bros.handlers.CollisionManager;
import game.mario.bros.handlers.KeyInput;
import game.mario.bros.tiles.Portal;
import game.mario.bros.tiles.Tile;

public class Game extends Canvas implements Runnable{
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	// Dimensions //
	private final Dimension size;
	public static final int WIDTH = 900;
	public static final int HEIGHT = 600;

	// Handlers //
	private KeyInput keyInput;
	private CollisionManager collisionManager;
	private Camera camera;
	private TextRenderer textRenderer;
	
	// Spawners //
	private CloudSpawner cloudSpawner;
	private GoombaSpawner goombaSpawner;
	private MushroomTileSpawner mushroomTileSpawner;
	private PipeSpawner pipeSpawner;
	private TurtleSpawner turtleSpawner;
	private CoinSpawner coinSpawner;
	
	// Entities //
	private Background background;
	private Portal portal;
	private Level level;
	private Mario mario;
	
	public Game(){
		size = new Dimension(WIDTH,HEIGHT);
		super.setPreferredSize(size);
		frame = new JFrame();
		
		// Initialization of Handlers //
		keyInput = new KeyInput(this);
		camera = new Camera(this);
		textRenderer = new TextRenderer();
		portal = new Portal(this,2400,HEIGHT-Tile.tile_size-100-Tile.tile_size-Tile.tile_size);
		
		// Initialization of Spawners //
		level = new Level(this);
		cloudSpawner = new CloudSpawner(this);
		goombaSpawner = new GoombaSpawner(this);
		mushroomTileSpawner = new MushroomTileSpawner(this);
		pipeSpawner = new PipeSpawner(this);
		coinSpawner =  new CoinSpawner(this);
		turtleSpawner = new TurtleSpawner(this);
		
		// Initialization of Entities //
		background = new Background(this,0,0);
		mario = new Mario(this,0,0);
		collisionManager = new CollisionManager(this);
		
		super.addKeyListener(keyInput);
		super.requestFocus();
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	}
	
	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		while(running == true){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle(updates + " updates, " + frames + " frames");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	// Update //
	private void update() {
		level.update();
		cloudSpawner.update();
		goombaSpawner.update();
		mushroomTileSpawner.update();
		pipeSpawner.update();
		coinSpawner.update();
		turtleSpawner.update();
		collisionManager.update();
		
		camera.update();
		background.update();
		mario.update();
		portal.update();
	}

	// Render //
	public void render(){
		BufferStrategy bs = super.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		String text = "Points : " + mario.points + " Lives : " + mario.lives + " Platforms : " + mario.getPlatforms();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.translate((int)camera.getX(),(int)camera.getY());
		
		background.render(g);
		pipeSpawner.render(g);
		level.render(g);
		cloudSpawner.render(g);
		goombaSpawner.render(g);
		mushroomTileSpawner.render(g);
		coinSpawner.render(g);
		turtleSpawner.render(g);
		mario.render(g);
		portal.render(g);
		textRenderer.render(g, text, -(int)camera.getX() + 300, 100, Color.RED);
		
		g.dispose();
		bs.show();
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		game.start();
	}
	
	// Getters //
	public KeyInput getKeyInput(){
		return keyInput;
	}
	public Mario getMario(){
		return mario;
	}
	public Level getLevel(){
		return level;
	}
	public GoombaSpawner getGoombaSpawner(){
		return goombaSpawner;
	}
	public MushroomTileSpawner getMushroomTileSpawner(){
		return mushroomTileSpawner;
	}
	public PipeSpawner getPipeSpawner(){
		return pipeSpawner;
	}
	public CoinSpawner getCoinSpawner(){
		return coinSpawner;
	}
	public TurtleSpawner getTurtleSpawner(){
		return turtleSpawner;
	}
	public Portal getPortal(){
		return portal;
	}
}