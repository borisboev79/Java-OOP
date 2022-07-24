package militaryElite.soldiers;

import militaryElite.enums.Corps;
import militaryElite.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
       this.corps = corps;
           }


    @Override
    public Corps getCorps() {
        return corps;
    }




}
