public class Date {
    private int month;
    private int day;
    private int year;

    public Date(){
        this.month = 1;
        this.day = 1;
        this.year = 2000;
    }

    public Date(int month, int day, int year){
        this.month = month;
        this.day = day;
        this.year = year;
    }

    public int getMonth(){
        return month;
    }

    public int getDay(){
        return day;
    }

    public int getYear(){
        return year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String displayDate(){

        String monthPrint = String.valueOf(month);
        String dayPrint = String.valueOf(day);
        String yearPrint = String.valueOf(year);

        if(month < 10){
            monthPrint = "0" + String.valueOf(month);
        }

        if(day < 10){
            dayPrint = "0" + String.valueOf(day);
        }

        String finalDate = monthPrint + "/" + dayPrint + "/" + yearPrint;

        return finalDate;
    }
}
