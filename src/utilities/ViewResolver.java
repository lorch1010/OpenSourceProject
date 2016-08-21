package utilities;
import java.util.ArrayList;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;

public class ViewResolver implements EventHandler<Event>{
	private Controller controller;
	
	public ViewResolver(Controller controller){
		this.controller = controller;
	}

	public void renderView(GraphicsContext context){
		controller.draw(context);
		controller = controller.invoke();
	}

	@Override
	public void handle(Event event){
		controller.handle(event);
	}

	public Group getDialogue(){
		return controller.getDialogue();
	}
	
	public Group getChoice(){
		return controller.getChoice();
	}
	
	public ArrayList<Button> getButtons(){
		return controller.getButtons();
	}
}