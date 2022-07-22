package OOP.WorkingWithAbstraction_Exercise.E05_JedyGalaxy;

public class Galaxy {
    private StarsField field;

    public Galaxy(StarsField field) {
        this.field = field;
    }

    public void moveEvil(int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {
            if (field.isInBounds(evilRow, evilCol)) {
                field.setValue(evilRow, evilCol, 0);
            }
            evilRow--;
            evilCol--;
        }
    }

    public long moveJedi(int jediRow, int jediCol) {
        long starsCollected = 0;
        while (jediRow >= 0 && jediCol < this.field.getColLength()) {
            if (field.isInBounds(jediRow, jediCol)) {
                starsCollected += field.getValue(jediRow, jediCol);
            }
            jediCol++;
            jediRow--;
        }
        return starsCollected;
    }
}
