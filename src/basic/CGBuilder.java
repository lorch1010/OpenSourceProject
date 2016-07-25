package basic;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Group;

public class CGBuilder extends Group{
	// class fields
	private Image background;
	private Image character;
	private Canvas canvas;
	
	public CGBuilder(String background, String character, Canvas canvas){
		this.background = new Image(background, 1280, 720, false, false);
		this.character = new Image(character);
		this.canvas = canvas;
		addCanvas();
	}
	
	public void createCG(){
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		gc.drawImage(background, 0, 0);
		gc.drawImage(character, 60, 0);
		
		//getChildren().add(canvas);
	}
	
	Image getBackground(){
		return background;
	}
	
	Image getCharacter(){
		return character;
	}
	
	public void addCanvas(){
		getChildren().add(canvas);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
}
