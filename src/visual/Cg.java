package visual;
import javafx.scene.image.Image;
import utilities.ResourceManager;

public class Cg{
    private Image image;
    private int x;
    private int y;

    public Cg(String role, int x, int y){
        this.image = ResourceManager.loadImage(role);
        this.x = x;
        this.y = y;
    }

    public Image getImage(){
        return image;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}