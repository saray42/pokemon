package sarah.thurnwald;

import sarah.thurnwald.data.attack.Attack;
import sarah.thurnwald.data.attack.AttackCategory;
import sarah.thurnwald.data.player.Bag;
import sarah.thurnwald.data.player.Player;
import sarah.thurnwald.data.pokemon.*;
import sarah.thurnwald.logic.LevelCalculatorManager;
import sarah.thurnwald.logic.LevelUpChecker;
import sarah.thurnwald.logic.StatCalculator;
import sarah.thurnwald.logic.levelcalculator.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
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

        List<Attack> gengarAttacks = new ArrayList<>(
                List.of(
                        new Attack("Dark Pulse", 80, PokemonType.DARK, AttackCategory.SPECIAL, 15, 100),
                        new Attack("Shadow Ball", 80, PokemonType.GHOST, AttackCategory.SPECIAL, 15, 100),
                        new Attack("Shadow Punch", 60, PokemonType.GHOST, AttackCategory.PHYSICAL, 20, -1),
                        new Attack("Shadow Claw", 70, PokemonType.GHOST, AttackCategory.PHYSICAL, 15, 100)
                )
        );

        List<Attack> lilyAttacks = new ArrayList<>(
                List.of(
                        new Attack("Judgment", 100, PokemonType.NORMAL, AttackCategory.SPECIAL, 15, 100)
                )
        );

        Map<PokemonStats, Map<PokemonStatNames, Integer>> gengarStats = Map.of(
                PokemonStats.HP, Map.of(
                        PokemonStatNames.BASE, PokemonData.GENGAR.getHp(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.ATTACK, Map.of(
                        PokemonStatNames.BASE, PokemonData.GENGAR.getAttack(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.DEFENSE, Map.of(
                        PokemonStatNames.BASE, PokemonData.GENGAR.getDefense(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.SPECIALATTACK, Map.of(
                        PokemonStatNames.BASE, PokemonData.GENGAR.getSpecialAttack(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.SPECIALDEFENSE, Map.of(
                        PokemonStatNames.BASE, PokemonData.GENGAR.getSpecialDefense(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.SPEED, Map.of(
                        PokemonStatNames.BASE, PokemonData.GENGAR.getSpeed(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                )
        );

        Map<PokemonStats, Map<PokemonStatNames, Integer>> lilyStats = Map.of(
                PokemonStats.HP, Map.of(
                        PokemonStatNames.BASE, PokemonData.LILY.getHp(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.ATTACK, Map.of(
                        PokemonStatNames.BASE, PokemonData.LILY.getAttack(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.DEFENSE, Map.of(
                        PokemonStatNames.BASE, PokemonData.LILY.getDefense(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.SPECIALATTACK, Map.of(
                        PokemonStatNames.BASE, PokemonData.LILY.getSpecialAttack(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.SPECIALDEFENSE, Map.of(
                        PokemonStatNames.BASE, PokemonData.LILY.getSpecialDefense(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                ),
                PokemonStats.SPEED, Map.of(
                        PokemonStatNames.BASE, PokemonData.LILY.getSpeed(),
                        PokemonStatNames.IV, 0,
                        PokemonStatNames.EV, 0
                )
        );

        LevelCalculatorManager levelCalculatorManager = new LevelCalculatorManager(levelCalculators);

        StatCalculator statCalculator = new StatCalculator();

        LevelUpChecker levelUpChecker = new LevelUpChecker();

        Pokemon gengar1 = new Pokemon(
                PokemonData.GENGAR,
                PokemonOwnership.PLAYER_POKEMON,
                70,
                levelCalculatorManager,
                PokemonGender.FEMALE,
                PokemonNature.MILD,
                statCalculator.calculate(List.of(PokemonStats.values()), gengarStats, 70, PokemonNature.MILD),
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
                gengarAttacks
        );

        Pokemon lily = new Pokemon(
                PokemonData.LILY,
                PokemonOwnership.PLAYER_POKEMON,
                100,
                levelCalculatorManager,
                PokemonGender.FEMALE,
                PokemonNature.QUIRKY,
                statCalculator.calculate(List.of(PokemonStats.values()), lilyStats, 100, PokemonNature.QUIRKY),
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

        Player sarah = new Player("Sarah", new Bag(), new ArrayList<>(List.of(lily)), 100_000);

        levelUpChecker.checkIfEligible(sarah.getParty().get(lily.getId()), levelCalculatorManager, statCalculator);

        System.out.println(sarah);
    }
}