public class StudySession extends Task{
    private int hours;
    private String subject;

    public StudySession(String title, String description, String status, int hours, String subject){
        super(title, description, status);
        this.hours = hours;
        this.subject = subject;
    }

    public StudySession(String title, String description, int hours, String subject){
        super(title, description);
        this.hours = hours;
        this.subject = subject;
    }

    public int getHours(){
        return hours;
    }

    public String getSubject(){
        return subject;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public void displayDetails(){
        System.out.printf("Title: %s\nDescription: %s\nStatus: %s\nHours: %s\nSubject: %s\n",getTitle(), getDescription(), getStatus(), hours, subject);
    }
}
