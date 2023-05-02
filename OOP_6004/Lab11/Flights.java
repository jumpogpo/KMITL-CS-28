public class Flights {
    private String code;
    private City soruce;
    private City destination;
    private DayOfWeek day;
    private Time departTime;

    public Flights(String code, City startCity, City goToCity, DayOfWeek mon, Time time) {
        this.code = code;
        soruce = startCity;
        destination = goToCity;
        this.day = mon;
        departTime = time;
    }

    public String toString() {
        return String.format("Flights [%s, %s to %s, %s, Time=%s]", code, soruce, destination, day, departTime);
    }
}
