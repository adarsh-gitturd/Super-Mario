package game.mario.bros.tiles;

import java.awt.Graphics;

import game.mario.bros.entites.Entity;
import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Pipe extends Entity{
	
	public Pipe(Game game,float x, float y) {
		super(game, EntityID.pipe, x, y, 50, 110);
	}
	
	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.pipe, (int)x, (int)y, width, height, null);
	}

}
