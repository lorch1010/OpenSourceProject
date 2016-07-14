package basic;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class ClassTalk2 extends Group {
	// initialize global variables
private DialogueBuilder dialogue;
    
    // class constructor
	public ClassTalk2(){
		String content = "You'll also have to learn how to address the relationships between each other because grades are not everything, as a matter of fact...";
		dialogue = new DialogueBuilder(content);
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

