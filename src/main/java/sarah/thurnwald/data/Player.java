package sarah.thurnwald.data;

import java.util.List;

public class Player {
    private final String name;

    private final String id;

    private final Bag bag;

    private List<Pokemon> party;

    private int money;

    public Player(String name, String id, Bag bag, List<Pokemon> party, int money) {
        this.name = name;
        this.id = id;
        this.bag = bag;
        this.party = party;
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

    public List<Pokemon> getParty() {
        return party;
    }

    public void addPokemonToParty(Pokemon pokemon) {
        if (party.size() < 6) this.party.add(pokemon);
    }

    public void removePokemonFromParty(Pokemon pokemon) {
        if (party.size() > 1) this.party.remove(pokemon);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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
