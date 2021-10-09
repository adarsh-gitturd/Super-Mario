package game.mario.bros.entites;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.Collision;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Mushroom extends Entity {
	private float gravity = 0.3f;
	private boolean touchingGround = true; 

	public Mushroom(Game game, float x, float y) {
		super(game, EntityID.mushroom, x, y, 50, 50);
	}
	
	public void update() {
		x += xVel;
		if(!touchingGround){
			y += yVel;
			yVel += gravity;
		}
		for(int i = 0; i < game.getLevel().getItems().size(); i++){
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getBottomBounds())){
				touchingGround = true;
			}
		}	
	}

	public void render(Graphics g) {
		g.drawImage(Assets.mushroom, (int)x, (int)y, width, height, null);
		//g.drawRect(getBottomBounds().x,getBottomBounds().y,getBottomBounds().width,getBottomBounds().height);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle((int)x, (int)y + 50, width, 1);
	}
	
	public void setTG(boolean tg){
		this.touchingGround = tg;
	}
}
