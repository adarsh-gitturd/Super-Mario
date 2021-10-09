package game.mario.bros.graphics;

import java.awt.Graphics;

import game.mario.bros.entites.Entity;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Cloud extends Entity{

	public Cloud(Game game, float x, float y) {
		super(game, EntityID.cloud, x, y, 200, 200);
		xVel = 1;
	}

	public void update() {
		x += xVel;
	}

	public void render(Graphics g) {
		g.drawImage(Assets.cloud, (int)x, (int)y, width, height, null);
	}

}
