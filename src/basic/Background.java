package basic;
import javafx.scene.image.Image;

public class Background{
	private Image bgImage;
	private int x;
	private int y;

	public Background(String bgName, int x, int y){
		this.bgImage = ResourceManager.loadBackground(bgName);
		this.x = x;
		this.y = y;
	}

	public Image getImage(){
		return bgImage;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
}