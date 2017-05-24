package visual;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.shape.Rectangle;
import javafx.geometry.VPos;

public class DialogueBuilder extends Group {
    // declare global variables
    final double BASE_WIDTH = 1280;
    final double BASE_HEIGHT = 720;
    final double MARGIN = 25;

    // class fields
    private String content;
    private String name;
    private Rectangle textRect = new Rectangle();
    private Rectangle nameRect = new Rectangle();
    private Text text = new Text();
    private Text nameText = new Text(65, 440, "");

    // class constructor
    public DialogueBuilder(String name, String content) {
        this.name = name;
        this.content = content;
        //this.textRect = getRect();
        //this.text = getText();
        setName(name);
        setText(content);
        createDialogue();
        addAllContents();
    }

    public DialogueBuilder() {
        //createDialogue();
        addAllContents();
    }

    public Rectangle getRect() {
        return textRect;
    }

    public void createRectangle() {
        // declare textRect parameters
        textRect.setX(MARGIN * 2);
        textRect.setY(BASE_HEIGHT * 2 / 3 - MARGIN);
        textRect.setWidth(BASE_WIDTH - MARGIN * 4);
        textRect.setHeight(200);
        textRect.setArcWidth(30);
        textRect.setArcHeight(30);
        textRect.setFill(Color.BLACK);

        // declare nameRect parameters
        nameRect.setX(50);
        nameRect.setY(400);
        nameRect.setWidth(200);
        nameRect.setHeight(200);
        nameRect.setArcWidth(30);
        nameRect.setArcHeight(30);
        nameRect.setFill(Color.BLACK);
    }

    public void createText() {
        //Declare and initialize variables for name and text fonts
        Font textFont = null;
        Font nameFont = null;
        //Detect user's OS first
        String osName = "";
        // Getting OS name
        osName = System.getProperty("os.name");

//Set fonts for different Operating Systems
        if (osName.toLowerCase().indexOf("win") >= 0) {
            textFont = Font.font("Microsoft YaHei", FontWeight.THIN, 30);
            nameFont = Font.font("Microsoft YaHei", FontWeight.BOLD, 32);
        } else if (osName.toLowerCase().indexOf("mac") >= 0) {
            textFont = Font.font("PingFang SC", FontWeight.THIN, 30);
            nameFont = Font.font("PingFang SC", FontWeight.BOLD, 32);
        } else if (osName.toLowerCase().indexOf("nix") >= 0 || osName.toLowerCase().indexOf("nux") >= 0 || osName.toLowerCase().indexOf("aix") > 0) {
            textFont = Font.font("Courier", FontWeight.THIN, 30);
            nameFont = Font.font("DejaVu Sans", FontWeight.BOLD, 32);
        }

        nameText.setFont(nameFont);
        nameText.setFill(Color.WHITE);

        text.setX(textRect.getX() + MARGIN);
        text.setY(textRect.getY() + MARGIN);
        text.setWrappingWidth(textRect.getWidth() - MARGIN * 2);
        text.setTextOrigin(VPos.TOP);
        text.setFont(textFont);
        text.setFill(Color.WHITE);
    }

    public void setName(String name) {
        nameText.setText(name);
    }

    public void setText(String content) {
        text.setText(content);
    }

    public Text getText() {
        return text;
    }

    public void createDialogue() {
        createRectangle();
        createText();
    }

    public void addAllContents() {
        getChildren().addAll(textRect, nameRect);
        getChildren().addAll(text, nameText);
    }
}