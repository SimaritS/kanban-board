import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import java.util.LinkedList;
import java.util.Stack;

public class kanbanBoard extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LinkedList<Task> todoList = new LinkedList<Task>();
        LinkedList<Task> inProgressList = new LinkedList<Task>();
        LinkedList<Task> completedList = new LinkedList<Task>();
        Stack<Task> history = new Stack<Task>();



    }
}
