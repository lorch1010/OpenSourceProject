package utilities;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

public interface Controller extends EventHandler<Event>{
	public void draw(GraphicsContext context);

	public Controller invoke();

	public Group getDialogue();
	
	public Group getChoice();
	
	public ArrayList<Button> getButtons();
	
	//public boolean buttonEmpty();
}