package game.mario.bros.graphics;

import java.awt.image.BufferedImage;

public class Assets {
	public static BufferedImage s_m_r = ImageLoader.loadImage("/mario_animations/s_mario_right.png");
	public static BufferedImage s_m_l = ImageLoader.loadImage("/mario_animations/s_mario_left.png");
	
	public static BufferedImage j_m_r = ImageLoader.loadImage("/mario_animations/j_mario_right.png");
	public static BufferedImage j_m_l = ImageLoader.loadImage("/mario_animations/j_mario_left.png");
	
	public static BufferedImage r_m_r = ImageLoader.loadImage("/mario_animations/r_mario_right.png");
	public static BufferedImage r_m_l = ImageLoader.loadImage("/mario_animations/r_mario_left.png");

	public static BufferedImage tile = ImageLoader.loadImage("/tiles/tile.png");
	public static BufferedImage coin = ImageLoader.loadImage("/entities/coin.png");
	public static BufferedImage background = ImageLoader.loadImage("/entities/background.jpg");

	public static BufferedImage cloud = ImageLoader.loadImage("/entities/clouds.png");
	public static BufferedImage goomba = ImageLoader.loadImage("/entities/goomba.png");
	
	public static BufferedImage chomper = ImageLoader.loadImage("/entities/chomper.png");
	public static BufferedImage pipe = ImageLoader.loadImage("/tiles/pipe.png");
	
	public static BufferedImage mushroom = ImageLoader.loadImage("/entities/mushroom.png");
	public static BufferedImage mushroom_tile = ImageLoader.loadImage("/tiles/mushroom_powerup.png");
	
	public static BufferedImage turtle_right = ImageLoader.loadImage("/entities/turtle_right.png");
	public static BufferedImage turtle_left = ImageLoader.loadImage("/entities/turtle_left.png");
	public static BufferedImage turtle_shell = ImageLoader.loadImage("/entities/turtle_shell.png");

	public static BufferedImage portal = ImageLoader.loadImage("/portal/portal.png");
	public static BufferedImage portal_bg = ImageLoader.loadImage("/portal/portal_bg.jpg");
}
