package basic.Scenes;
import basic.DialogueBuilder;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class ClassOver_5 extends Group {
	// initialize global variables
	private DialogueBuilder dialogue;
    
    // class constructor
	public ClassOver_5(){
		String content = "God, I cannot believe that Mr. Peng'd talked so much about the college entrance test during the first day of school."
				+ " I feel kind of stupid that I was expecting a beautiful high school life.";
		dialogue = new DialogueBuilder("Ouyang", content);
		create();
		getChildren().add(dialogue);
		dialogue.getAnimation().play();
	}
	
	public void create(){	
		Canvas canvas = new Canvas(1280, 720);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image image = new Image("classroom.bmp", 1280, 720, false, false);
		Image charImage = new Image("male.jpg");
		
		gc.drawImage(image, 0, 0);
		gc.drawImage(charImage, 80, 20);
		getChildren().add(canvas);
	}
}