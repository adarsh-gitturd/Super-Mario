package game.mario.bros.entites;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.Collision;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Goomba extends Entity{
	private boolean right = false;
	private boolean left = false;
	
	public Goomba(Game game, float x, float y) {
		super(game, EntityID.goomba, x, y, 50, 50);
	}

	public void update() {
		for(int i = 0; i < game.getLevel().getItems().size(); i++){
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getLeftBounds())){
				left = true;
				right = false;
			}
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getRightBounds())){
				right = true;
				left = false;
			}
		}
		for(int i = 0; i < game.getPipeSpawner().getItems().size(); i++){
			if(Collision.isTouching(game.getPipeSpawner().getItems().get(i).getBounds(), getLeftBounds())){
				left = true;
				right = false;
			}
			if(Collision.isTouching(game.getPipeSpawner().getItems().get(i).getBounds(), getRightBounds())){
				right = true;
				left = false;
			}
		}
		if(right){
			x--;
		}else if(left){
			x++;
		}else if(!right && !left){
			x++;
		}
	}

	public void render(Graphics g) {
		g.drawImage(Assets.goomba, (int)x, (int)y, width, height, null);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int)x + width, (int)y, 1, height - 4);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int)x, (int)y, 1, height - 4);
	}
	
	public Rectangle getTopBounds(){
		return new Rectangle((int)x, (int)y, width, height - 40);
	}
}