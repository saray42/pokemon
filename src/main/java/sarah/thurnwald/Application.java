package sarah.thurnwald;

import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.attack.AttackCategory;
import sarah.thurnwald.data.player.Bag;
import sarah.thurnwald.data.player.Player;
import sarah.thurnwald.data.player.Pokedex;
import sarah.thurnwald.data.player.PokedexType;
import sarah.thurnwald.data.pokemon.*;
import sarah.thurnwald.logic.LevelUpChecker;
import sarah.thurnwald.logic.calculator.LevelCalculatorManager;
import sarah.thurnwald.logic.calculator.StatCalculator;
import sarah.thurnwald.logic.calculator.levelcalculator.*;
import sarah.thurnwald.logic.generator.LevelCalculatorGenerator;
import sarah.thurnwald.logic.generator.PokedexGenerator;
import sarah.thurnwald.logic.generator.StatGenerator;

import java.util.*;

public class Application {
    //TODO: kiss lily
    //FIXME: lily is missing
    public static void main(String[] args) {
        LevelCalculatorGenerator levelCalculatorGenerator = new LevelCalculatorGenerator();
        PokedexGenerator pokedexGenerator = new PokedexGenerator();
        StatGenerator statGenerator = new StatGenerator();
        StatCalculator statCalculator = new StatCalculator();
        LevelUpChecker levelUpChecker = new LevelUpChecker();
        Pokedex pokedex = new Pokedex(pokedexGenerator.generate());
        Bag bag = new Bag();

        Map<ExpType, LevelCalculator> levelCalculators = levelCalculatorGenerator.generate();
        Map<PokemonStats, Map<PokemonBaseStats, Integer>> lilyStats = statGenerator.generate(PokemonData.LILY);

        LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

        List<Attack> lilyAttacks = new ArrayList<>(
                List.of(
                        new Attack("Judgment", 100, PokemonType.NORMAL, AttackCategory.SPECIAL, 15, 100)
                )
        );

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

        Player player = new Player("Sarah", bag, pokedex, new ArrayList<>(List.of(lily)), 100_000);

        System.out.println(player);
    }
}