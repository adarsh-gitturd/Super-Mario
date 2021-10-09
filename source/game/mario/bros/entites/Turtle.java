package game.mario.bros.entites;

import java.awt.Graphics;
import java.awt.Rectangle;

import game.mario.bros.graphics.Assets;
import game.mario.bros.handlers.Collision;
import game.mario.bros.handlers.EntityID;
import game.mario.bros.main.Game;

public class Turtle extends Entity{
	private int facing; // 1 - right || 0 - left
	private boolean right = false;
	private boolean left = false;
	
	private int state;
	// 0 - moving
	// 1 - stop
	// 2 - rocking
	
	public Turtle(Game game, float x, float y) {
		super(game, EntityID.turtle, x, y, 60, 60);
		facing = 1;
		state = 0;
	}

	public void update() {
		for(int i = 0; i < game.getLevel().getItems().size(); i++){
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getLeftBounds())){
				left = true;
				right = false;
				facing = 1;
			}
			if(Collision.isTouching(game.getLevel().getItems().get(i).getBounds(), getRightBounds())){
				right = true;
				left = false;
				facing = 0;
			}
		}
		for(int i = 0; i < game.getPipeSpawner().getItems().size(); i++){
			if(Collision.isTouching(game.getPipeSpawner().getItems().get(i).getBounds(), getLeftBounds())){
				left = true;
				right = false;
				facing = 1;
			}
			if(Collision.isTouching(game.getPipeSpawner().getItems().get(i).getBounds(), getRightBounds())){
				right = true;
				left = false;
				facing = 0;
			}
		}
		if(state == 0){
			if(right){
				x--;
			}else if(left){
				x++;
			}else if(!right && !left){
				x++;
			}
		}
		if(state == 2){
			if(right){
				x -= 4;
			}else if(left){
				x += 4;
			}else if(!right && !left){
				x += 4;
			}
		}
		if(game.getMario().getBottomBounds().intersects(getBounds())){
			switch(state){
			case 0: // moving
				state = 1;
				break;
			case 1: // rest
				state = 2;
				break;
			case 2:
				state = 1;
				break;
			}
		}
	}

	public void render(Graphics g) {
		if(state == 0){
			if(facing == 1){
				g.drawImage(Assets.turtle_right, (int)x, (int)y, width, height, null);
			}
			if(facing == 0){
				g.drawImage(Assets.turtle_left, (int)x, (int)y, width, height, null);
			}
		}
		if(state == 1 || state == 2){
			g.drawImage(Assets.turtle_shell, (int)x, (int)y, width, height, null);
		}
	}
	
	public int getState(){
		return state;
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle((int)x, (int)y, 1, height);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((int)x + width, (int)y, 1, height);
	}

}
