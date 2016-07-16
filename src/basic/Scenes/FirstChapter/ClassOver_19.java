package basic.Scenes.FirstChapter;
import basic.DialogueBuilder;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class ClassOver_19 extends Group {
	// initialize global variables
	private DialogueBuilder dialogue;
    
    // class constructor
	public ClassOver_19(){
		String content = "(I kept talking to him until the class begin. It feels not bad when you know somebody in a new place.)";
		dialogue = new DialogueBuilder("Me", content);
		create();
		getChildren().add(dialogue);
		dialogue.getAnimation().play();
	}
	
	public void create(){	
		Canvas canvas = new Canvas(1280, 720);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Image image = new Image("classroom.bmp", 1280, 720, false, false);
	
		gc.drawImage(image, 0, 0);
		getChildren().add(canvas);
	}
}