package game.mario.bros.graphics;

import java.awt.Graphics;

import game.mario.bros.entites.Entity;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Background extends Entity{
//	private int frames = 0;
//	private int frameCount = 0;
	
	public Background(Game game, float x, float y) {
		super(game,EntityID.background, x, y, Game.WIDTH + 100000, Game.HEIGHT);
	}

	public void update() {
//		frames = frames + 2;
//		if(frames > 100){
//			frameCount++;
//			frames = 0;
//		}
//		System.out.println("Frames : " + frames);
//		System.out.println("Frame Count : " + frameCount);
	}

	public void render(Graphics g) {
		if(game.getPortal().getPortalMode() == 1){
			g.drawImage(Assets.background, (int)x, (int)y, width, height, null);
		}
		if(game.getPortal().getPortalMode() == 2){
			g.drawImage(Assets.portal_bg, (int)x, (int)y, width, height, null);
		}	
	}
}