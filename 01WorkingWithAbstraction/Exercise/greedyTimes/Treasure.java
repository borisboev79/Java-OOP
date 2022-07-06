package greedyTimes;

import java.util.*;

public class Treasure {
    private final Map<String, LinkedHashMap<String, Long>> gold;
    private final Map<String, LinkedHashMap<String, Long>> gems;
    private final Map<String, LinkedHashMap<String, Long>> cash;

    Treasure() {
        this.gold = new LinkedHashMap<>();
        this.gold.put("Gold", new LinkedHashMap<>());
        this.gems = new LinkedHashMap<>();
        this.gems.put("Gem", new LinkedHashMap<>());
        this.cash = new LinkedHashMap<>();
        this.cash.put("Cash", new LinkedHashMap<>());
    }

    public void addToGold(String name, Long amount) {
        this.gold.get("Gold").putIfAbsent(name, 0L);
        this.gold.get("Gold").put(name, gold.get("Gold").get(name) + amount);
    }

    public void addToGems(String name, Long amount) {
        this.gems.get("Gem").putIfAbsent(name, 0L);
        this.gems.get("Gem").put(name, gems.get("Gem").get(name) + amount);
    }

    public void addToCash(String name, Long amount) {
        this.cash.get("Cash").putIfAbsent(name, 0L);
        this.cash.get("Cash").put(name, cash.get("Cash").get(name) + amount);
    }

    public long getTotalGold() {
        return gold.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    public long getTotalGems() {
        return gems.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    public long getTotalCash() {
        return cash.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum();
    }

    public long getTotalTreasure() {
        return getTotalGold() + getTotalGems() + getTotalCash();
    }

    public void printTreasures() {
        Map[] treasures = {gold, gems, cash};

        for (Map<String, LinkedHashMap<String, Long>> asset : treasures) {
            for (Map.Entry<String, LinkedHashMap<String, Long>> treasure : asset.entrySet()) {
                long sumValues = treasure.getValue().values().stream().mapToLong(l -> l).sum();

                if (sumValues > 0) {
                    System.out.printf("<%s> $%s%n", treasure.getKey(), sumValues);
                }
                treasure.getValue().entrySet().stream()
                        .filter(e -> e.getValue() > 0)
                        .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                        .forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
            }
        }
    }
}