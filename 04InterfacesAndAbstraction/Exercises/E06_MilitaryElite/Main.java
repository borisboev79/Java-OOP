package E06_MilitaryElite;

import E06_MilitaryElite.enums.Corps;
import E06_MilitaryElite.enums.MissionStates;
import E06_MilitaryElite.interfaces.*;
import E06_MilitaryElite.soldiers.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        List<Private> privates = new ArrayList<>();
        List<Soldier> soldiers = new LinkedList<>();

        while (!"End".equals(input = scanner.nextLine())) {

            String[] soldierAttributes = input.split("\\s+");
            String rank = soldierAttributes[0];
            int id = Integer.parseInt(soldierAttributes[1]);
            String firstName = soldierAttributes[2];
            String lastName = soldierAttributes[3];
            double salary = Double.parseDouble(soldierAttributes[4]);

            switch (rank) {
                case "Private":
                    Private priv = new PrivateImpl(id, firstName, lastName, salary);
                    privates.add(priv);
                    soldiers.add(priv);
                    break;
                case "LieutenantGeneral":
                    LieutenantGeneral lieutenant = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < soldierAttributes.length; i++) {
                        int privateId = Integer.parseInt(soldierAttributes[i]);
                        Private underLieutenant = privates.stream().filter(prv -> prv.getId() == privateId).findFirst().orElse(null);
                        lieutenant.addPrivate(underLieutenant);
                    }
                    soldiers.add(lieutenant);
                    break;
                case "Engineer":
                    String engineerCorps = soldierAttributes[5];

                    try {
                        Corps corps = Corps.valueOf(engineerCorps);

                        Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);

                        for (int i = 6; i < soldierAttributes.length; i += 2) {
                            String part = soldierAttributes[i];
                            int hoursWorked = Integer.parseInt(soldierAttributes[i + 1]);
                            engineer.addRepair(new Repair(part, hoursWorked));
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException ignored) {
                    }
                    break;
                case "Commando":
                    String commandoCorps = soldierAttributes[5];

                    try {
                        Corps corps = Corps.valueOf(commandoCorps);
                        Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                        for (int i = 6; i < soldierAttributes.length; i += 2) {
                            String codeName = soldierAttributes[i];
                            String missionState = soldierAttributes[i + 1];
                            try {
                                MissionStates state = MissionStates.valueOf(missionState);
                                commando.addMission(new Mission(codeName, state));
                            } catch (IllegalArgumentException ignored) {
                            }
                        }
                        soldiers.add(commando);
                    } catch (IllegalArgumentException ignored) {
                    }
                    break;
                case "Spy":
                    String codeName = soldierAttributes[4];
                    Soldier spy = new SpyImpl(id, firstName, lastName, codeName);
                    soldiers.add(spy);
                    break;
            }
        }
        soldiers.forEach(System.out::println);
    }


}
