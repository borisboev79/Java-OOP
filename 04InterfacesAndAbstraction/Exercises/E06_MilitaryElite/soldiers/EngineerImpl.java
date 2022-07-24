package militaryElite.soldiers;

import militaryElite.enums.Corps;
import militaryElite.interfaces.Engineer;
import militaryElite.Repair;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return repairs;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Corps: ")
                .append(getCorps())
                .append(System.lineSeparator())
                .append("Repairs:");

        if (!repairs.isEmpty()) {
            sb.append(System.lineSeparator())
                    .append(repairs.stream().map(Repair::toString).collect(Collectors.joining(System.lineSeparator())));
        }

        return sb.toString();
    }


}
