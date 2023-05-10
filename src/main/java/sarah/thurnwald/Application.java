package sarah.thurnwald;

import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.attack.AttackCategory;
import sarah.thurnwald.data.player.Bag;
import sarah.thurnwald.data.player.Player;
import sarah.thurnwald.data.player.Pokedex;
import sarah.thurnwald.data.pokemon.*;
import sarah.thurnwald.logic.LevelUpChecker;
import sarah.thurnwald.logic.calculator.LevelCalculatorManager;
import sarah.thurnwald.logic.calculator.StatCalculator;
import sarah.thurnwald.logic.calculator.levelcalculator.LevelCalculator;
import sarah.thurnwald.logic.generator.*;
import sarah.thurnwald.ui.OptionOutputManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {
    //TODO: kiss lily
    //FIXME: lily is missing
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LevelCalculatorGenerator levelCalculatorGenerator = new LevelCalculatorGenerator();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        IvGenerator ivGenerator = new IvGenerator(randomNumberGenerator);
        PokedexGenerator pokedexGenerator = new PokedexGenerator();
        StatGenerator statGenerator = new StatGenerator();
        OptionGenerator optionGenerator = new OptionGenerator();

        StatCalculator statCalculator = new StatCalculator();
        LevelUpChecker levelUpChecker = new LevelUpChecker();
        Pokedex pokedex = new Pokedex(pokedexGenerator.generate());
        Bag bag = new Bag();

        Map<ExpType, LevelCalculator> levelCalculators = levelCalculatorGenerator.generate();

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
                PokemonGender.FEMALE,
                PokemonNature.CUTE,
                levelCalculatorManager,
                statCalculator,
                statGenerator,
                ivGenerator,
                lilyAttacks
        );

        Player player = new Player("Sarah", bag, pokedex, new ArrayList<>(List.of(lily)), 100_000);

        OptionOutputManager optionOutputManager = new OptionOutputManager(optionGenerator.generate(), player, scanner);

        System.out.println(player);
    }
}