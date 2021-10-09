package game.mario.bros.tiles;

import java.awt.Graphics;

import game.mario.bros.entites.Entity;
import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.Collision;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Portal extends Entity{
	private int portal_mode;
	// 0 -> level - 1
	// 1 -> level - 2
	
	public Portal(Game game, float x, float y) {
		super(game, EntityID.portal, x, y, 50, 100);
		portal_mode = 1;
	}

	public void update() {
		if(Collision.isTouching(getBounds(), game.getMario().getBounds())){
			portal_mode = 2;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.portal, (int)x, (int)y, width, height, null);
	}
		
	public int getPortalMode(){
		return portal_mode;
	}

	public void setPortalMode(int i) {
		portal_mode = i;
	}
}
