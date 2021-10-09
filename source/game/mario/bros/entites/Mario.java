package game.mario.bros.entites;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.Collision;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;
import game.mario.bros.tiles.Tile;

public class Mario extends Entity {
	private boolean jumping = false;
	public boolean touchingGround = false;
	
	private BufferedImage image;
	private float gravity = 0.3f;
	
	public int facing = 1; // 1 -- right || 0 -- left
	public int rank = 1;
	
	public int points = 0;
	public int lives = 3;
	private int platforms = 100;
	
	private boolean right = false;
	private boolean left = false;
	private boolean up = false;
	
	public Mario(Game game, float x, float y) {
		super(game, EntityID.mario, x, y, 50, 50);
		image = Assets.s_m_r;
	}

	public void update() {
		if(!right && !left){
			x += xVel;			
		}
		if(!touchingGround){
			y += yVel;
			yVel += gravity;
		}
		if(jumping && touchingGround){
			if(facing == 1)
				image = Assets.j_m_r;
			if(facing == 0)
				image = Assets.j_m_l;
			if(!up)
				yVel = -12;
				y += yVel;
				jumping = false;
		}
		if(up){
			if(rank == 1){
				yVel += 2;				
			}
			if(rank == 2){
				yVel += 6;
			}
		}
		if(rank == 1){
			height = 50;
		}
		if(rank == 2){
			height = 70;
		}
		collisionDetection();
	}
	
	private void collisionDetection(){
		for(int i = 0; i < game.getLevel().getItems().size(); i++){
			if(!Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getBottomBounds())){
				touchingGround = false;
			}
			if(!Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getLeftBounds())){
				left = false;
			}
			if(!Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getRightBounds())){
				right = false;
			}
			if(!Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getTopBounds())){
				up = false;
			}
		}
		for(int i = 0; i < game.getLevel().getItems().size(); i++){
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getBottomBounds())){
				touchingGround = true;
			}
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getLeftBounds())){
				left = true;
			}
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getRightBounds())){
				right = true;
			}
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getTopBounds())){
				if(rank == 1){
					up = true;
				}
				if(rank == 2){
					up = true;
					points += 10;
					game.getLevel().getItems().remove(i);
				}
			}
			
		}
		for(int i = 0; i < game.getMushroomTileSpawner().getMushrooms().size(); i++){
			if(Collision.isTouching(game.getMushroomTileSpawner().getMushrooms().get(i).getBounds(), getBounds())){
				game.getMushroomTileSpawner().getMushrooms().remove(i);
				rank = 2;
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, width, height, null);
		//g.drawRect(getBottomBounds().x,getBottomBounds().y,getBottomBounds().width,getBottomBounds().height);
	}
	
	public Rectangle getBottomBounds(){
		return new Rectangle((int)x,(int)y + height + 5,width,3);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int)x + height,(int)y,1,height-5);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int)x - 2,(int)y,1,height-5);
	}
	
	public Rectangle getTopBounds(){
		return new Rectangle((int)x, (int)y, width, 1);
	}
	
	public void setJumping(boolean b){
		jumping  = b;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public void pushRight() {
		xVel = 10;
		y -= 1;
	    yVel = -5;
		y += yVel;
	}
	public void pushLeft() {
		xVel = -10;
		y -= 1;
		yVel = -5;
		y += yVel;
	}
	
	public void jump(){
		yVel = -10;
		y += yVel;
	}
	
	public void begin(){
		setX(0);
		setY(100);
	}
	
	public void createPlatform() {
		if(platforms > 0){
			game.getLevel().getItems().add(new Tile(game, x, y + height + 10));
			platforms--;
		}
	}
	
	public int getPlatforms(){
		return platforms;
	}

}
