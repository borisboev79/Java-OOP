package OOP.WorkingWithAbstraction_Exercise.E05_JedyGalaxy;

public class StarsField {
    private int[][] starsField;

    public StarsField(int rows, int cols) {
        this.starsField = new int[rows][cols];
        this.fillInStarsField(rows, cols, this.starsField);
    }

    public  int getValue(int row, int col) {
        return this.starsField[row][col];
    }

    public void setValue(int row, int col, int newValue) {
        this.starsField[row][col] = newValue;
    }

    public int getColLength() {
        return this.starsField[1].length;
    }

    private void fillInStarsField(int rows, int cols, int[][] galaxy) {
        int value = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }

    public boolean isInBounds(int row, int col) {
        return row >= 0 && col >= 0 && row < this.starsField.length && col < this.starsField[row].length;
    }
}
