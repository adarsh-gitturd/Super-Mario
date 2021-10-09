package game.mario.bros.entites;

import java.awt.Graphics;

import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Chomper extends Entity {
	public boolean attackable = false;
	
	public Chomper(Game game, float x, float y) {
		super(game, EntityID.chomper, x, y, 50, 50);
		yVel = 1;
	}

	public void update() {
		y += yVel;
		if(y > 500){
			yVel = -1;
		}
		if(y > 400)
			attackable = true;
		if(y < 390){
			attackable = false;
			yVel = 1;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.chomper, (int)x, (int)y, width, height, null);
	}

}
