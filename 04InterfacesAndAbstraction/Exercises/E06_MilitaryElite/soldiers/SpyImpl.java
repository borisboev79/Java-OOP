package militaryElite.soldiers;

public class SpyImpl extends SoldierImpl {
    final private String spyCode;

    public SpyImpl(int id, String firstName, String lastName, String spyCode) {
        super(id, firstName, lastName);
        this.spyCode = spyCode;
    }

    public String getSpyCode() {
        return spyCode;
    }

    @Override
    public String toString() {
        return super.toString() + System.lineSeparator()
                + String.format("Code Number: %s", getSpyCode());
    }
}
