import external.GUI;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String TITLE = "SLogo";
    private static final Dimension2D SIZE = new Dimension2D(800, 600);

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(TITLE);
        GUI gui = new GUI();
        primaryStage.setScene(new Scene(gui, SIZE.getWidth(), SIZE.getHeight()));
        primaryStage.show();
    }
}
