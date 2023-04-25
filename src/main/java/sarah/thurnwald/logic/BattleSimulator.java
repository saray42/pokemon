package sarah.thurnwald.logic;

import sarah.thurnwald.data.Pokemon;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class BattleSimulator {

    private Scanner scanner;
    public void simulateBattle(LinkedHashMap<String, Pokemon> playerPokemon, LinkedHashMap<String, Pokemon> enemyPokemon, Scanner scanner) {
        this.scanner = scanner;
    }
}
