package basic.Scenes;
import basic.DialogueBuilder;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameStart extends Group {
	private DialogueBuilder dialogue;
    
    // class constructor
	public GameStart(){
		String content = "Standing in front of this high school in which I'll be spending the next three years, I still cannot believe that I was a middle school student two months ago."
				+ " Time flies.";

		dialogue = new DialogueBuilder(content);
		create();
		getChildren().add(dialogue);
		dialogue.getAnimation().play();
	}
	
	public void create(){	
		Canvas canvas = new Canvas(1280, 720);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image image = new Image("schoolGate.jpg", 1280, 720, false, false);
		gc.drawImage(image, 0, 0);
		
		getChildren().add(canvas);
	}
  
}
