package militaryElite.soldiers;

import militaryElite.interfaces.LieutenantGeneral;
import militaryElite.interfaces.Private;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new LinkedHashSet<>();
    }

    @Override
    public void addPrivate(Private priv) {
        privates.add(priv);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append(super.toString())
                .append(System.lineSeparator())
                .append("Privates:");

        if(!privates.isEmpty()) {
            sb.append(System.lineSeparator())
                    .append(privates.stream()
                            .sorted(Comparator
                                    .comparing(Private::getFirstName)
                                    .reversed())
                            .map(p -> "  " + p)
                            .collect(Collectors.joining(System.lineSeparator())));
        }
        return sb.toString();
    }

}
