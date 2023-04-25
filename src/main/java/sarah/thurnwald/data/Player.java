package sarah.thurnwald.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Player {
    private final String name;

    private final String id;

    private final Bag bag;

    private final LinkedHashMap<String, Pokemon> party;

    private int money;

    public Player(String name, String id, Bag bag, List<Pokemon> party, int money) {
        this.name = name;
        this.id = id;
        this.bag = bag;
        this.party = party.stream().collect(Collectors.toMap(Pokemon::getId, Function.identity(), (v1,v2)->v1, LinkedHashMap::new));
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Bag getBag() {
        return bag;
    }

    public LinkedHashMap<String, Pokemon> getParty() {
        return party;
    }

    public void addPokemonToParty(Pokemon pokemon) {
        if (party.size() < 6) this.party.put(pokemon.getId(), pokemon);
    }

    public void removePokemonFromParty(Pokemon pokemon) {
        if (party.size() > 1) this.party.remove(pokemon.getId(), pokemon);
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int moneyToAdd) {
        this.money += moneyToAdd;
    }

    public void removeMoney(int moneyToRemove) {
        this.money -= moneyToRemove;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", bag=" + bag +
                ", party=" + party +
                ", money=" + money +
                '}';
    }
}
