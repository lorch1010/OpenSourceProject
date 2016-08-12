package basic;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.canvas.GraphicsContext;

public interface Controller extends EventHandler<Event>{
	public void draw(GraphicsContext context);

	public Controller invoke();

	public Group getDialogue();
}