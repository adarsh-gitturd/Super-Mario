package game.mario.bros.main;

public class Camera {
	private float x;
	private float y;
	Game game;
	
	public Camera(Game game) {
		this.game = game;
	}

	public void update(){
		setX(-game.getMario().getX() + Game.WIDTH/2);
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
}
