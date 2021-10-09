package game.mario.bros.entites;

import java.awt.Graphics;

import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Coin extends Entity{

	public Coin(Game game, float x, float y) {
		super(game, EntityID.coin, x, y, 40, 40);
	}

	public void update() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.coin, (int)x, (int)y, width, height, null);
	}

}
