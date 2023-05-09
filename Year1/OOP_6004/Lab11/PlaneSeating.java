public abstract class PlaneSeating {
    protected char[][] seating;

    public void showSeating() {
        for (int row = 0; row < seating.length; row++) {
            StringBuilder seat = new StringBuilder();

            for (int col = 0; col < seating[row].length; col++) {
                seat.append(seating[row][col]);
            }

            System.out.printf("row %d --> %s%n", row + 1, seat.toString());
        }
    }

    public abstract boolean reserveSeat(int row, int col);
}