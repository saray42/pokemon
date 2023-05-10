package sarah.thurnwald.ui;

import sarah.thurnwald.data.player.Player;
import sarah.thurnwald.ui.option.OptionOutput;

import java.util.List;
import java.util.Scanner;

public class OptionOutputManager {
    private final List<OptionOutput> optionOutputList;

    private final Player player;

    private final Scanner scanner;

    public OptionOutputManager(List<OptionOutput> optionOutputList, Player player, Scanner scanner) {
        this.optionOutputList = optionOutputList;
        this.player = player;
        this.scanner = scanner;
    }

    public void printSelectedOption() {
        printOptions();
        String command = scanner.nextLine();
        optionOutputList.forEach(option -> {
            if (option.getCommand().equalsIgnoreCase(command)) option.print(player);
        });
    }

    private void printOptions() {
        optionOutputList.forEach(option -> {
            System.out.println((optionOutputList.indexOf(option) + 1) + ". " + option.getCommand());
        });
    }
}
