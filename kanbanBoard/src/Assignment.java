public class Assignment extends Task{
    private Date dueDate;
    private double points;

    public Assignment(String title, String description, String status, int m, int d, int y, double points){
        super(title, description, status);
        this.dueDate = new Date(m,d,y);
        this.points = points;
    }

    public Assignment(String title, String description, int m, int d, int y, double points){
        super(title, description);
        this.dueDate = new Date(m,d,y);
        this.points = points;
    }

    public Assignment(String title, String description, double points){
        super(title, description);
        this.dueDate = new Date();
        this.points = points;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public double getPoints(){
        return points;
    }

    public void setDueDate(int m, int d, int y){
        dueDate.setMonth(m);
        dueDate.setDay(d);
        dueDate.setYear(y);
    }

    public void setPoints(double p){
        this.points = p;
    }

    @Override
    public void displayDetails(){
        System.out.printf("Title: %s\nDescription: %s\nStatus: %s\nDue Date: %s\nPoints: %s\n",getTitle(), getDescription(), getStatus(), dueDate.displayDate(), points);
    }

}
