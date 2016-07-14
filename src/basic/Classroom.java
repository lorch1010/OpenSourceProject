package basic;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Classroom extends Group {
	private DialogueBuilder dialogue;
    
    // class constructor
	public Classroom(){
		String content = "(So many people here. The seat at the window seems nice. Guess I'll just sit there.)";
		dialogue = new DialogueBuilder(content);
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
