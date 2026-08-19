# Data Structures Final Project: Kanban Board

This is my final project for my Data Structures course. The objective of the project was to create an application that met a specific set of criteria. 

I chose to design a Kanban Board where students can keep track of various tasks, such as Assignments and Study Sessions. The board includes the following buttons: 

* **Add** – create a task from user input
* **Move Forward** – advance a task to the next stage
* **Delete** – delete a task from the board
* **Undo Deletion** – return a deleted task to the board

## Final Project Guidelines

The requirements are as follows:

1. The code must follow good programming practices, be well-commented, and use efficient logic and control structures.
2. It must be a JavaFX application.
3. It must use at least one `BorderPane` layout, as well as at least one `HBox` and one `VBox` within one of the `BorderPane` regions.
4. `Task` must serve as the superclass from which `Assignment` and `StudySession` inherit.
5. The two data structures used must be a `List` and a `Stack`.

## How Were the Objectives Met?

1. Comments are included throughout the code. The program uses a clean main class along with helper methods.
2. This is a JavaFX Kanban Board application where students can create tasks and log their homework. It includes buttons to add a custom task, advance the task, delete it, and undo a deletion.
3. A `BorderPane` layout is implemented: an `HBox` holds the Undo and Add buttons at the bottom, and `VBox` layouts are used for the three columns.
4. `Task` is the superclass from which `Assignment` and `StudySession` inherit.
5. The two data structures implemented are a `List` and a `Stack`.
