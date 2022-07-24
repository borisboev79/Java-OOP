package militaryElite.soldiers;

import militaryElite.interfaces.Soldier;

public class SoldierImpl implements Soldier {
    final private int id;
    final private String firstName;
    final private String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {

        return String.format("Name: %s %s Id: %d", getFirstName(), getLastName(), getId());
    }

}
