package game.mario.bros.entites;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public abstract class Entity {
	protected float x;
	protected float y;
	
	protected float xVel = 0;
	protected float yVel = 0;
	
	protected int width;
	protected int height;
	
	protected Game game;
	protected EntityID id;
	
	public Entity(Game game, EntityID id , float x, float y, int width, int height){
		this.id = id;
		this.game = game;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, width, height);
	}

	public float getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float f) {
		this.y = f;
	}

	public float getxVel() {
		return xVel;
	}

	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	public float getyVel() {
		return yVel;
	}

	public void setyVel(float yVel) {
		this.yVel = yVel;
	}
	
	public EntityID getID(){
		return id;
	}
}
