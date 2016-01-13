import java.util.Arrays;


public class Agent {
	
	private int posX;
	private int posY;
	private int dirX;
	private int dirY;
	private Environnement env;
	private int[] localEnv;
	
	public Agent(int posX, int posY, int direction, Environnement env){
		this.posX = posX;
		this.posY = posY;
//		this.direction = direction;
		this.dirX = 1;
		this.dirY = 1;
		this.env = env;
		this.localEnv = env.getLocalEnv(posX, posY);
	}
	
	public void decide() throws Exception{

		if(env.update(this, (posX+dirX)%10, (posY+dirY)%10)){
			this.posX+=dirX;
			this.posX%=10;	
			this.posY+=dirY;
			this.posY%=10;
		}
	}

	

	@Override
	public String toString() {
		return "Agent [posX=" + posX + ", posY=" + posY + ", dirX=" + dirX
				+ ", dirY=" + dirY + ", env=" + env + ", localEnv="
				+ Arrays.toString(localEnv) + "]";
	}

	public int getPosX() {
		return this.posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setDirX(int x) {
		this.dirX = x;
	}

	public void setDirY(int y) {
		this.dirY = y;
	}
	
	public int getDirX(){
		return this.dirX;
	}
	
	public int getDirY(){
		return this.dirY;
	}
	
	
	
}
