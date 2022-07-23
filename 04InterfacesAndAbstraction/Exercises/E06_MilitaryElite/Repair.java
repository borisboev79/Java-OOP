package E06_MilitaryElite;

public class Repair {
    private String partName;
    private int workedHours;

    public Repair(String partName, int workedHours) {
        this.partName = partName;
        this.workedHours = workedHours;
    }

    public String getPartName() {
        return partName;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    @Override
    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d", getPartName(), getWorkedHours());
    }
}
