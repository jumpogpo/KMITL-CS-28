public class Plane22Seating extends PlaneSeating {
    private Flights flight;
    private PlaneSeating seating;

    public Plane22Seating(String args) {
        super();
        String[] tokens = args.split(",");
        int numRow = tokens.length;
        int numCol = tokens[0].length();
        super.seating = new char[numRow][numCol];

        for (int i = 0; i < tokens.length; i++) {
            super.seating[i] = tokens[i].toCharArray();
        }
    }

    private boolean isFull() {
        for (char[] row : super.seating) {
            for (char letter : row) {
                if (letter == '^') return false;
            }
        }

        return true;
    }

    public boolean reserveSeat(int row, int col) {
        char selectSeat = super.seating[row - 1][col - 1];

        if (selectSeat != '^') {
            showSeating();
            return false;
        }

        System.out.printf("seat %d, %d symbol is %s. Latest seat map is%n", row - 1, col - 1, selectSeat);
        super.seating[row - 1][col - 1] = 'x';
        showSeating();
        return true;
    }
}
