import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/** FINAL PROJECT GUIDELINES
 *
 * It must follow good coding practices and habits and be as efficient as possible,
 * including ample commenting and efficient logic and control structures.
 *
 *      Comments are sprinkled throughout. The main program and
 *      helper methods are used within of the program.
 *
 * It MUST be a JavaFX application.
 *
 *      This is a Kanban Board Application where students can basically
 *      create tasks/log their homework. THere are buttons to add a custom task,
 *      move forward the task, delete, and undo delete.
 *
 * It must use at least one BorderPane layout and at least one HBox and one VBOX
 * in at least one of the BorderPane element areas.
 *
 *      BorderPane is used.
 *      HBox is used to contain the Undo and Add buttons at the bottom.
 *      Vbox is used for the 3 columns.
 *
 * It must demonstrate inheritance to at least one child from one parent.
 *
 *      Task is the super class from which Assignment and StudySession inherit.
 *
 * It must use at least two different implementations of the following: List, LinkedList, Set, Map, Stack or Queue.
 *
 *      The 2 date structures that were used were Lists and Stack.
 *
* */

public class kanbanBoard extends Application {

    //two data types chosen wher Lists and Stacks
    private List<Task> toDo = new LinkedList<>();
    private List<Task> inProgress = new LinkedList<>();
    private List<Task> done = new LinkedList<>();

    private Stack<TaskHistory> undo = new Stack<>();

    //the boxes to the separate tasks
    private VBox todoBox;
    private VBox inProgessBox;
    private VBox doneBox;

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(15));

        Label header = new Label("Kanban Board");
        root.setTop(header);
        BorderPane.setAlignment(header, Pos.CENTER);


        HBox colHBox = new HBox(15);
        colHBox.setPadding(new Insets(10, 0, 10, 0));
        colHBox.setAlignment(Pos.CENTER);

        //creating the 3 cols for 3 lists
        VBox todoColumn = createColumns("To Do");
        VBox doingColumn = createColumns("In Progress");
        VBox doneColumn = createColumns("Done");
        todoBox = (VBox) todoColumn.getChildren().get(1);
        inProgessBox = (VBox) doingColumn.getChildren().get(1);
        doneBox = (VBox) doneColumn.getChildren().get(1);
        colHBox.getChildren().addAll(todoColumn, doingColumn, doneColumn);
        root.setCenter(colHBox);

        //the functionality stuff (to add a new assignment or study sesh)
        HBox bottomHBox = new HBox(12);
        bottomHBox.setPadding(new Insets(15, 0, 0, 0));
        bottomHBox.setAlignment(Pos.CENTER);
        Button addTask = new Button("Add New Task");
        addTask.setOnAction(e -> addTask());
        Button undo = new Button("Undo Last Delete");
        undo.setOnAction(e -> undoDelete());
        bottomHBox.getChildren().addAll(addTask, undo);
        root.setBottom(bottomHBox);

        sampleData();
        updateBoard();

        Scene scene = new Scene(root, 1000, 650);
        primaryStage.setTitle("Kanban Task Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //method needed to make 3 cols
    private VBox createColumns(String title) {
        VBox column = new VBox(10);
        column.setPadding(new Insets(10));
        Label columnHeader = new Label(title);
        VBox taskBox = new VBox(10);
        taskBox.setPadding(new Insets(5));
        column.getChildren().addAll(columnHeader, taskBox);
        return column;
    }

    //remove and push to undo
    private void deleteTask(Task task, List<Task> currList) {
        currList.remove(task);
        undo.push(new TaskHistory(task, currList));
        updateBoard();
    }

    //gets task back from deletion via the pop
    private void undoDelete() {
        if (!undo.isEmpty()) {
            TaskHistory entry = undo.pop(); //pop!
            entry.getOgList().add(entry.getTask()); //add bakc
            updateBoard();
        }
    }

    //function needed to update
    private void updateBoard() {
        todoBox.getChildren().clear();
        inProgessBox.getChildren().clear();
        doneBox.getChildren().clear();

        for (Task task : toDo) {
            todoBox.getChildren().add(createTask(task, toDo, inProgress));
        }
        for (Task task : inProgress) {
            inProgessBox.getChildren().add(createTask(task, inProgress, done));
        }
        for (Task task : done) {
            doneBox.getChildren().add(createTask(task, done, null));
        }
    }

    //func that generates all the tasks
    private VBox createTask(Task t, List<Task> currentList, List<Task> nextList) {
        VBox task = new VBox(6);
        task.setPadding(new Insets(10));

        //labels
        Label title = new Label(t.getTitle());
        Label description = new Label(t.getDescription());
        description.setWrapText(true); //wrap if to long
        Label detail = new Label(t.getDetails());

        //buttons for each task
        HBox taskControls = new HBox(8);
        taskControls.setAlignment(Pos.CENTER_RIGHT);
        taskControls.setPadding(new Insets(5, 0, 0, 0));

        if (nextList != null) {
            Button move = new Button("Move Forward");

            move.setOnAction(e -> { //update status
                if (nextList == inProgress) {
                    t.setStatus("In Progress");
                } else if (nextList == done) {
                    t.setStatus("Done");
                }

                //remove + refresh
                currentList.remove(t);
                nextList.add(t);
                updateBoard();

            });

            taskControls.getChildren().add(move);
        }

        Button delete = new Button("Delete");
        delete.setOnAction(e -> deleteTask(t, currentList));
        taskControls.getChildren().add(delete);
        task.getChildren().addAll(title, description, detail, taskControls);

        return task;
    }

    //add a new task
    private void addTask() {
        Stage dialog = new Stage();
        dialog.setTitle("Add New Task");

        VBox form = new VBox(10);
        form.setPadding(new Insets(15));

        //title, description, and type
        TextField titleField = new TextField();
        titleField.setPromptText("Task Title");
        TextField descField = new TextField();
        descField.setPromptText("Description");
        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Assignment", "Study Session");
        typeBox.setValue("Assignment");

        //date
        HBox dateBox = new HBox(5);
        TextField monthField = new TextField();
        monthField.setPromptText("MM");
        monthField.setPrefWidth(50);
        TextField dayField = new TextField();
        dayField.setPromptText("DD");
        dayField.setPrefWidth(50);
        TextField yearField = new TextField();
        yearField.setPromptText("YYYY");
        yearField.setPrefWidth(70);

        dateBox.getChildren().addAll(monthField, dayField, yearField);

        //begins as assignment
        TextField details = new TextField();
        details.setPromptText("Points Possible");

        //dynamic binding! for study sesh
        typeBox.setOnAction(e -> {
            if ("Assignment".equals(typeBox.getValue())) {
                details.setPromptText("Points Possible");
                dateBox.setDisable(false);
            } else {
                details.setPromptText("Estimated Hours");
                dateBox.setDisable(true);//disable date for study
            }
        });

        Button submit = new Button("Create Task");
        submit.setOnAction(e -> {
            String title = titleField.getText().trim();
            String desc = descField.getText().trim();

            if ("Assignment".equals(typeBox.getValue())) {
                int month = 1, day = 1, year = 2000;
                double points = 0.0;
                toDo.add(new Assignment(title, desc, month, day, year, points));
            } else {
                int hours = 0;
                toDo.add(new StudySession(title, desc, hours, "General Topic"));
            }
            updateBoard();
            dialog.close();
        });

        //create
        form.getChildren().addAll(
                new Label("Task Type:"), typeBox,
                new Label("Title:"), titleField,
                new Label("Description:"), descField,
                new Label("Due Date (MM/DD/YYYY):"), dateBox,
                new Label("Details:"), details,
                submit
        );

        dialog.setScene(new Scene(form, 320, 420));
        dialog.show();
    }

    //example data to demonstrate
    private void sampleData() {
        toDo.add(new Assignment("Calc II Homework", "Finish Taylor Series worksheet", 8, 15, 2026, 100.0));
        inProgress.add(new Assignment("Chemistry Lab Report", "Transfer the data that was collected in lab", "In Progress", 8, 2, 2026, 50.0));
        done.add(new StudySession("Physics I Midterm", "Review right hand rule and terminal velocity", 3, "PHYS 101"));
    }
}