package basic;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.Group;
import java.util.ArrayList;

public class CGBuilder extends Group{
	// class fields
	private ArrayList<Image> backgrounds;
	private ArrayList<Image> characters;
	private Image bNext;
	private Image cNext;
	private int backgroundIndex = -1;
	private int characterIndex = -1;
	//private Image background;
	//private Image character;
	private Canvas canvas;
	
	public CGBuilder(Canvas canvas, ArrayList<Image> backgrounds, ArrayList<Image> characters){
		this.canvas = canvas;
		this.backgrounds = backgrounds;
		this.characters = characters;
		addCanvas();
	}
	
	/*public CGBuilder(String background, String character, Canvas canvas){
		this.background = new Image(background, 1280, 720, false, false);
		if(character.length() > 0){
			this.character = new Image(character);
		}else{
			this.character = null;
		}
		this.canvas = canvas;
		addCanvas();
	}*/
	
	public void createCG(){
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		/*gc.drawImage(background, 0, 0);
		if(character != null){
			gc.drawImage(character, 60, 0);
		}*/
		gc.drawImage(getNextBackground(), 0, 0);
		gc.drawImage(getNextCharacter(), 60, 0);
		
		//getChildren().add(canvas);
	}
	
	/*Image getBackground(){
		return background;
	}
	
	Image getCharacter(){
		return character;
	}*/
	
	Image getNextBackground(){
		backgroundIndex++;
		if(backgroundIndex >= backgrounds.size()){
			backgroundIndex = 0;
		}
		return (bNext = backgrounds.get(backgroundIndex));
	}
	
	Image getNextCharacter(){
		characterIndex++;
		if(characterIndex >= characters.size()){
			characterIndex = 0;
		}
		return (cNext = characters.get(characterIndex));
	}
	
	public void addCanvas(){
		getChildren().add(canvas);
	}
	
	public Canvas getCanvas(){
		return canvas;
	}
}
