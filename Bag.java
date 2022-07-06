package greedyTimes;

public class Bag {
    private long capacity;
    private Treasure treasure;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.treasure = new Treasure();
    }

    public long getCapacity() {
        return capacity;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public void dispatch(String treasure, long amount) {

        String treasureType = getTreasureGroup(treasure);

        if (treasureType != null) {

            if (capacity >= getTreasure().getTotalTreasure() + amount) {

                switch (treasureType) {
                    case "Gold":
                        this.treasure.addToGold(treasure, amount);
                        break;
                    case "Gem":
                        if (this.treasure.getTotalGems() + amount <= this.treasure.getTotalGold()) {
                            this.treasure.addToGems(treasure, amount);
                        }
                        break;
                    case "Cash":
                        if (this.treasure.getTotalCash() + amount <= this.treasure.getTotalGems()) {
                            this.treasure.addToCash(treasure, amount);
                        }
                        break;
                }
            }
        }
    }

    private static String getTreasureGroup(String treasureType) {
        String treasure = null;
        if (treasureType.length() == 3) {
            treasure = "Cash";
        } else if (treasureType.toLowerCase().endsWith("gem")) {
            treasure = "Gem";
        } else if (treasureType.equalsIgnoreCase("gold")) {
            treasure = "Gold";
        }
        return treasure;
    }

}
