public class FlightsReservation {
    private Flights flight;
    private PlaneSeating seating;

    public FlightsReservation(Flights flights) {
        this.flight = flights;
        seating = new Plane22Seating("xx_xx,xx_x^,^x_xx,x^_xx,xx_^x");
    }

    public void showSeating() {
        System.out.println(flight);
        seating.showSeating();
    }

    public boolean reserveSeat(int row, int col) {
        return seating.reserveSeat(row, col);
    }
}
