package basic.Scenes.FirstChapter;
import basic.DialogueBuilder;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class ClassTalk extends Group {
	// initialize global variables
	private DialogueBuilder dialogue;
    
    // class constructor
	public ClassTalk(){
		String content = "Hello, everyone. I'm your head teacher. You can call me Mr. Peng. I'm sure that you guys had a great summer. "
				+ "From now on, everybody's become a high school student, which means that you are becoming the grown-us while facing curel competitions at the same time.";
		//dialogue = new DialogueBuilder("Mr. Peng", content);
		create();
		getChildren().add(dialogue);
		//dialogue.getAnimation().play();
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
