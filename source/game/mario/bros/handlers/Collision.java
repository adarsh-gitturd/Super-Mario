package game.mario.bros.handlers;

import java.awt.Rectangle;

public class Collision {
	public static boolean isTouching(Rectangle a, Rectangle b){
		if(a.getBounds().intersects(b.getBounds())){
			return true;
		}
		return false;
	}
}
