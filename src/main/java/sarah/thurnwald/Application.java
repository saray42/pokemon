package sarah.thurnwald;

import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.attack.AttackCategory;
import sarah.thurnwald.data.player.Bag;
import sarah.thurnwald.data.player.Player;
import sarah.thurnwald.data.player.Pokedex;
import sarah.thurnwald.data.player.PokedexType;
import sarah.thurnwald.data.pokemon.*;
import sarah.thurnwald.logic.LevelCalculatorManager;
import sarah.thurnwald.logic.LevelUpChecker;
import sarah.thurnwald.logic.StatCalculator;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.*;

public class Application {
    //TODO: kiss lily
    //FIXME: lily is missing
    public static void main(String[] args) {
        Map<ExpType, LevelCalculator> levelCalculators = new HashMap<>(
                Map.of(
                        ExpType.ERRATIC, new CalculateErratic(),
                        ExpType.FAST, new CalculateFast(),
                        ExpType.MEDIUM_FAST, new CalculateMediumFast(),
                        ExpType.MEDIUM_SLOW, new CalculateMediumSlow(),
                        ExpType.SLOW, new CalculateSlow(),
                        ExpType.FLUCTUATING, new CalculateFluctuating()
                )
        );

        List<Attack> lilyAttacks = new ArrayList<>(
                List.of(
                        new Attack("Judgment", 100, PokemonType.NORMAL, AttackCategory.SPECIAL, 15, 100)
                )
        );

        Map<PokemonStats, Map<PokemonBaseStats, Integer>> lilyStats = Map.of(
                PokemonStats.HP, Map.of(
                        PokemonBaseStats.BASE, PokemonData.LILY.getHp(),
                        PokemonBaseStats.IV, 0,
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.ATTACK, Map.of(
                        PokemonBaseStats.BASE, PokemonData.LILY.getAttack(),
                        PokemonBaseStats.IV, 0,
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.DEFENSE, Map.of(
                        PokemonBaseStats.BASE, PokemonData.LILY.getDefense(),
                        PokemonBaseStats.IV, 0,
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.SPECIALATTACK, Map.of(
                        PokemonBaseStats.BASE, PokemonData.LILY.getSpecialAttack(),
                        PokemonBaseStats.IV, 0,
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.SPECIALDEFENSE, Map.of(
                        PokemonBaseStats.BASE, PokemonData.LILY.getSpecialDefense(),
                        PokemonBaseStats.IV, 0,
                        PokemonBaseStats.EV, 0
                ),
                PokemonStats.SPEED, Map.of(
                        PokemonBaseStats.BASE, PokemonData.LILY.getSpeed(),
                        PokemonBaseStats.IV, 0,
                        PokemonBaseStats.EV, 0
                )
        );

        LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

        StatCalculator statCalculator = new StatCalculator();

        LevelUpChecker levelUpChecker = new LevelUpChecker();

        Pokemon lily = new Pokemon(
                PokemonData.LILY,
                PokemonOwnership.SARAH,
                100,
                levelCalculatorManager,
                PokemonGender.FEMALE,
                PokemonNature.CUTE,
                statCalculator.calculate(List.of(PokemonStats.values()), lilyStats, 100, PokemonNature.CUTE),
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                lilyAttacks
        );

        Player player = new Player("Sarah", new Bag(), new Pokedex(new LinkedHashMap<>(Map.of(PokemonData.LILY, new HashMap<>(Map.of(PokedexType.SEEN, false, PokedexType.CAUGHT, false))))), new ArrayList<>(List.of(lily)), 100_000);

        player.getPokedex().setPokemonSeen(lily.getData());

        System.out.println(player);
    }
}