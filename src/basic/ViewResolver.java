package basic;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

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
}