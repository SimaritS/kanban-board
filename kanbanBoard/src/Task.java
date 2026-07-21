public class Task {
    private String title;
    private String description;
    private String status; //to do, in-progress, complete!

    public Task(String title, String description, String status){
        this.title = title;
        this.description = description;
        this.status = status;
    }

    //if status not provided then auto sets to To-Do
    public Task(String title, String description){
        this.title = title;
        this.description = description;
        this.status = "To-Do";
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getStatus(){
        return status;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void displayDetails(){
        System.out.printf("Title: %s\nDescription: %s\nStatus: %s\n",title, description, status);
    }

}
