package basic.Scenes;
import basic.DialogueBuilder;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class ClassTalk3 extends Group {
	// initialize global variables
	private DialogueBuilder dialogue;
    
    // class constructor
	public ClassTalk3(){
		String content = "Hope you would have a happy and meaningful high school life.";
		dialogue = new DialogueBuilder("Mr. Peng", content);
		create();
		getChildren().add(dialogue);
		dialogue.getAnimation().play();
	}
	
	public void create(){	
		Canvas canvas = new Canvas(1280, 720);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image image = new Image("classroom.bmp", 1280, 720, false, false);
		Image charImage = new Image("teacher.png");
		
		gc.drawImage(image, 0, 0);
		gc.drawImage(charImage, 60, 0);
		
		getChildren().add(canvas);
	}
}


