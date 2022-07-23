package E06_MilitaryElite;

import E06_MilitaryElite.enums.MissionStates;

public class Mission {
    private String codeName;
    private MissionStates state;

    public Mission(String codeName, MissionStates state) {
        this.codeName = codeName;
        this.state = state;
    }

    public void completeMission() {
        this.state = MissionStates.finished;
    }

    public String getCodeName() {
        return codeName;
    }

    public MissionStates getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s", getCodeName(), getState());
    }
}
